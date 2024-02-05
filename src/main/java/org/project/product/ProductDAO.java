package org.project.product;

import javax.persistence.*;
import java.util.List;
public class ProductDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vrau");

    public void save(Product product) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar o produto", e);
        } finally {
            entityManager.close();
        }
    }

    public Product findById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    public void update(Product product) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao atualizar o produto", e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao excluir o produto", e);
        } finally {
            entityManager.close();
        }
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

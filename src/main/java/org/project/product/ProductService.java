package org.project.product;

import org.project.exceptions.ErrorMessage;
import org.project.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public class ProductService{

    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Product update(Long id, Product product) {
        Optional<Product> obj = repository.findById(id);
        if (obj.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }else {
            obj.get().setName(product.getName());
            obj.get().setDescription(product.getDescription());
            obj.get().setValue(product.getValue());
        }
        return repository.save(obj.get());
    }
}

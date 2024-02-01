package org.project.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @Column(name = "product_id")
    private Long id;

    //nome não pode ser nulo e é único
    @Column(nullable = false, unique = true, name = "product_name")
    private String name;

    //descrição não pode ser nula e deve ter no mínimo 10 caracteres
    @Column(nullable = false, name = "product_description")
    private String description;

    //valor não pode ser nulo e deve ser positivo
    @Column(nullable = false, name = "product_price", scale = 2)
    private double value;

    public Product(){}

    public Product(String name, String description, double value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return  "{" +
                "id: " + id +
                ",\nname: " + name +
                ",\ndescription: " + description +
                ",\nvalue: " + value +
                '}';
    }
}

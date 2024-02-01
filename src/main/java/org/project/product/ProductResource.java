package org.project.product;

import java.util.List;
import java.util.Optional;

public class ProductResource {

    private static ProductService productService;

    public static List<Product> getProducts() {
        return productService.findAll();
    }

    public static Product getProduct(Long id) {
        return productService.findById(id);
    }

    public static Product insertProduct(Product product) {
        return productService.save(product);
    }

    public static void deleteProduct(Long id) {
        try {
            Product p = productService.findById(id);
            productService.delete(p.getId());
        } catch (Exception e) {
            throw new RuntimeException("Product not found");
        }

    }

    public static Product updateProduct(Long id, Product product) {
        return productService.update(id, product);
    }
}

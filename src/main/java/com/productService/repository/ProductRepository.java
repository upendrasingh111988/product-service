package com.productService.repository;

import com.productService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product>findByProductName(String productName);

    List<Product> findByPrice(double price);

    List<Product> findByProductNameOrPrice(String productName ,Double price);
}

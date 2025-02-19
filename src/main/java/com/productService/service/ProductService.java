package com.productService.service;

import com.productService.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);

    public List<Product> getAllProducts();
    public List<Product>gettByName(String productName);

    public List<Product>getByPrice(double price);
    public  List<Product> getByProductNameOrPrice(String productName ,Double price);

    public List<Product> getByExpiryDate(LocalDate expiryDate);

    public Product getByProductId(String productId);

    public Product updateProduct(Product product);
    public String deleteProduct(String productId);
}

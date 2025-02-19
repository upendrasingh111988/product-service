package com.productService.service.impl;

import com.productService.exception.ProductNotFoundException;
import com.productService.model.Product;
import com.productService.repository.ProductRepository;
import com.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
       //String id= UUID.randomUUID().toString();
       //product.setProductId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> gettByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> getByProductNameOrPrice(String productName, Double price) {
        return productRepository.findByProductNameOrPrice(productName,price);
    }

    @Override
    public List<Product> getByExpiryDate(LocalDate expiryDate) {
        return productRepository.findByExpiryDate(expiryDate);
    }


    @Override
    public Product getByProductId(String productId) {
        return productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("Product not found with ID: " + productId));
    }

    @Override
    public Product updateProduct(Product product) {
       product.setProductId(product.getProductId());
       product.setProductName(product.getProductName());
       product.setPrice(product.getPrice());
       product.setProductDescription(product.getProductDescription());
       product.setExpiryDate(product.getExpiryDate());
       productRepository.save(product);
       return product;
    }

    @Override
    public String deleteProduct(String productId) {
         productRepository.deleteById(productId);
        return "product deleted..";
    }
}

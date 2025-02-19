package com.productService.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "product|_info")

public class Product {
    @Id
    private String productId;
    private String productName;
    private Double price;
    private LocalDate expiryDate;
    private String productDescription;

   public Product() {
    }

    public Product(String productId, String productName, double price, LocalDate expiryDate, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.expiryDate = expiryDate;
        this.productDescription = productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}

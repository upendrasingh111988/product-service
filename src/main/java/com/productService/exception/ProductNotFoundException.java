package com.productService.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ProductNotFoundException extends RuntimeException{
    private String message;

    public ProductNotFoundException(String message) {
        super(message);

    }
}

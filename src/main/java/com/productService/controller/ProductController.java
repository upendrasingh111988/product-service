package com.productService.controller;

import com.productService.exception.ProductNotFoundException;
import com.productService.model.Product;
import com.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return ResponseEntity.ok(product);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductByProductId(@PathVariable("productId") String productId){
        return productService.getByProductId(productId);

    }
    @GetMapping("/products/name/{productName}")
    public List<Product> getProductByproductName(@PathVariable("productName") String productName){

        return  productService.gettByName(productName);
    }

    @GetMapping("/products/Price")
    public List<Product> getProductsByPrice(@RequestParam(required = true) double price){
      return   productService.getByPrice(price);

    }
    @GetMapping("/products/search")

    public List<Product> searchProductByNameOrPrice(@RequestParam(required = false) String productName,
                                                     @RequestParam(required = false) Double price){
    if(productName == null && price == null){
    throw  new ProductNotFoundException("Products not found by id or name.. give correct name or id..");
        }
        return productService.getByProductNameOrPrice(productName,price);
    }

    @PutMapping("/products/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId){
        productService.deleteProduct(productId);
        return "Product deleted..";
    }
}

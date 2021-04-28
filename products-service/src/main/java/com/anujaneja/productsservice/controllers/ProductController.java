package com.anujaneja.productsservice.controllers;

import com.anujaneja.productsservice.models.Category;
import com.anujaneja.productsservice.models.Product;
import com.anujaneja.productsservice.proxies.CategoryProxy;
import com.anujaneja.productsservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired CategoryProxy categoryProxy;

    @GetMapping
    public List<Product> getAll() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable String id) {
        Product product = productService.getById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Category category = categoryProxy.getDetails(product.getCategoryId());
        product.setCategory(category);
        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }
}

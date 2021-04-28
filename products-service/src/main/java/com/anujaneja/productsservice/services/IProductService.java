package com.anujaneja.productsservice.services;

import com.anujaneja.productsservice.models.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getProducts();

    public Product getById(String id);
}

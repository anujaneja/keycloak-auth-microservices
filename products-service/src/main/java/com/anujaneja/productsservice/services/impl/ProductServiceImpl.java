package com.anujaneja.productsservice.services.impl;

import com.anujaneja.productsservice.models.Product;
import com.anujaneja.productsservice.services.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements IProductService {

    private List<Product> products = Stream.of(
            new Product("1", "sku1", "1"),
            new Product("2", "sku2", "1"),
            new Product("3", "sku3", "2")
    )
            .collect(Collectors.toList());

    @Override public List<Product> getProducts() {
        return products;
    }

    @Override public Product getById(String id) {
        Optional<Product> productOptional =  products.stream().filter(product -> id.equals(product.getId())).findFirst();
        return productOptional.isPresent()?productOptional.get():null;
    }

}

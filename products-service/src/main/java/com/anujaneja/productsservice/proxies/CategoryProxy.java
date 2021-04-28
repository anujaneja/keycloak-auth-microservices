package com.anujaneja.productsservice.proxies;

import com.anujaneja.productsservice.configs.ClientConfiguration;
import com.anujaneja.productsservice.models.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categories-service", url = "${microservice.categories.url}", configuration = { ClientConfiguration.class })
public interface CategoryProxy {

    @GetMapping(value = "/categories/{id}")
    public Category getDetails(@PathVariable("id") String id);
}
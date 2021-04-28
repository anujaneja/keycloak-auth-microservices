package com.anujaneja.categoriesservice.controllers;

import com.anujaneja.categoriesservice.models.Category;
import com.anujaneja.categoriesservice.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {
        Category category = categoryService.getById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Category>(category, HttpStatus.ACCEPTED);
    }
}

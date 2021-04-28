package com.anujaneja.categoriesservice.services.impl;

import com.anujaneja.categoriesservice.models.Category;
import com.anujaneja.categoriesservice.services.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private List<Category> categories = Stream.of(
            new Category("1", "TShirt"),
            new Category("2", "KidsWear"),
            new Category("3", "Electronics")
    )
            .collect(Collectors.toList());


    @Override public Category getById(String id) {
        Optional<Category> categoryOptional =  categories.stream().filter(product -> id.equals(product.getId())).findFirst();
        return categoryOptional.isPresent()?categoryOptional.get():null;
    }

}

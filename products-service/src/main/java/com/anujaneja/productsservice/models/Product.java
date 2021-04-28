package com.anujaneja.productsservice.models;

public class Product {
    private String id;
    private String skuCode;
    private String categoryId;
    private Category category;

    public Product() {
    }

    public Product(String id, String skuCode, String categoryId) {
        this.id = id;
        this.skuCode = skuCode;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

package com.ruba.product_manager.services;

import com.ruba.product_manager.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product update(Product product, int productId);

    void delete(int productId);

    Product getById(int productId);

    List<Product> getAll();

}

package com.ruba.product_manager.services;

import com.ruba.product_manager.model.Product;
import com.ruba.product_manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(Product product, int productId) {
        Product product1 =this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        product1.setPrice(product.getPrice());
        product1.setName(product.getName());
        product1.setAbout(product.getAbout());

        Product save = this.productRepository.save(product1);

        return save ;
    }

    @Override
    public void delete(int productId) {
        Product product1 = this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
        this.productRepository.delete(product1);

    }

    @Override
    public Product getById(int productId) {
        Product product1 = this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
        return product1;
    }

    @Override
    public List<Product> getAll() {
        List<Product> all = this.productRepository.findAll();
        return all;
    }
}

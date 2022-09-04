package com.ruba.product_manager.controller;

import com.ruba.product_manager.model.Product;
import com.ruba.product_manager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {



    @Autowired
    private ProductService productService;



    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        Product product1 = this.productService.create(product);
        return  new ResponseEntity<>(product1, HttpStatus.CREATED);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int productId)
    {
        Product product1 = this.productService.update(product, productId);
        return  new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String,String>> deleteProduct(@RequestBody Product product, @PathVariable int productId)
    {
        this.productService.delete(productId);
        Map<String, String > message = Map.of("message","product deleted successfull");
        return  new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId)
    {
        Product product = this.productService.getById(productId);
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<Product>> getAll()
    {
        List<Product> all = this.productService.getAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }



}

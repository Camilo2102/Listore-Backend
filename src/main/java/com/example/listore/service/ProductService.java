package com.example.listore.service;

import com.example.listore.models.Product;
import com.example.listore.repository.GeneralRepository;
import com.example.listore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductService extends GeneralService<Product>{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }


}

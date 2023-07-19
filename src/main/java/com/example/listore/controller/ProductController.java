package com.example.listore.controller;

import com.example.listore.models.Product;
import com.example.listore.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Transactional
public class ProductController extends GeneralController<Product>{

    private final ProductService productService;


    public ProductController(ProductService productService) {
        super(productService);
        this.productService = productService;
    }
}

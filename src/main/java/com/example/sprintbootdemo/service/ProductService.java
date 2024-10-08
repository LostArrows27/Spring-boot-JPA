package com.example.sprintbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.sprintbootdemo.model.Product;
import com.example.sprintbootdemo.repository.ProductRepository;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getProductsByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // PageRequest is 0-based
        return productRepository.findProductByName(name, pageable);
    }
}

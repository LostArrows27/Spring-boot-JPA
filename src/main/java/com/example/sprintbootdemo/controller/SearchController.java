package com.example.sprintbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.sprintbootdemo.model.Product;
import com.example.sprintbootdemo.service.ProductService;
import com.example.sprintbootdemo.util.PaginationHelper;

@Controller
public class SearchController {

    private final ProductService productService;

    @Autowired
    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search-results")
    public ModelAndView searchPage(
        @RequestParam(name = "key", required = false, defaultValue = "") String query,
        @RequestParam(name = "page", required = false, defaultValue = "1") int page
    ) {
        ModelAndView modelAndView = new ModelAndView("screens/products/search");

        int size = 18;

        Page<Product> productPage = productService.getProductsByName(query, page, size);
        int totalItems = (int) productPage.getTotalElements();

        PaginationHelper paginationHelper = new PaginationHelper(
            totalItems,
            size,
            page,
            5, // midRange value
            query
        );

        modelAndView.addObject("paginationHelper", paginationHelper);
        modelAndView.addObject("result_count", productPage.getTotalElements());
        modelAndView.addObject("query", query);
        modelAndView.addObject("page", page);
        modelAndView.addObject("totalPages", productPage.getTotalPages());
        modelAndView.addObject("products", productPage.getContent());

        return modelAndView;
    }
}

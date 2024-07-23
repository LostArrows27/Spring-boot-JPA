package com.example.sprintbootdemo.controller;

import com.example.sprintbootdemo.component.Calculator;
import com.example.sprintbootdemo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {


    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(value = "/bean/calculator/add", params = {"a", "b"})
    public ResponseEntity<Integer> add(
            @RequestParam(value = "a") int a,
            @RequestParam(value = "b") int b
    ) {
        return calculatorService.add(a, b);
    }

    @GetMapping(value = "/bean/calculator/subtract", params = {"a", "b"})
    public ResponseEntity<Integer> subtract(
            @RequestParam(value = "a") int a,
            @RequestParam(value = "b") int b
    ) {
        return calculatorService.subtract(a, b);
    }

}

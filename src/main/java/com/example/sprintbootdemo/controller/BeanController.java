package com.example.sprintbootdemo.controller;

import com.example.sprintbootdemo.component.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

    @Autowired
    private Calculator calculator;

    @GetMapping("/bean/calculator/add")
    public ResponseEntity<Integer> add() {
        return ResponseEntity.ok(calculator.add(10, 5));
    }
}

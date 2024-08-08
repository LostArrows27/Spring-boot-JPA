package com.example.sprintbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sprintbootdemo.model.Constant;

@Repository
public interface ConstantRepository extends JpaRepository<Constant, Integer> {
}

package com.example.demo3.repository;

import com.example.demo3.model.Category;
import com.example.demo3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
   List<Product>findAllByNameContaining(String name);
   List<Product>findAllBySalaryBetween(double lowSalary ,double hightSalary);
   List<Product>findAllByOrderBySalary();

}

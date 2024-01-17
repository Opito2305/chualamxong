package com.example.demo3.controller;

import com.example.demo3.model.Product;
import com.example.demo3.repository.CategoryRepository;
import com.example.demo3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

    @Controller
    @RequestMapping("/products")
    public class ProductController {
        @Autowired
        ProductRepository productRepository;
        @Autowired
        CategoryRepository categoryRepository;
        @GetMapping
        public ModelAndView findAll(){
            ModelAndView modelAndView = new ModelAndView("/product/list");
            modelAndView.addObject("list",productRepository.findAll());
            return modelAndView;
        }
        @GetMapping("/create")
        public String create(Product product){
            productRepository.save(product);
            return "redirect: /products";
        }

        @GetMapping("/edit/{id}")
        public ModelAndView edit(@PathVariable Long id ){
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("edit", productRepository.findById(id).get());
            return modelAndView;
        }
        @GetMapping("/delete/{id}")
        public String delete(@PathVariable Long id){
            productRepository.deleteById( id);
            return "redirect: /products";
        }
}

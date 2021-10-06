package com.tts.ecommerce.controller;


import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
@Controller
@ControllerAdvice
public class MainController {

    // here we are performing dependency injection
    @Autowired
    ProductService productService;

    // whenever we return a string in a vanilla controller
    // class, what happens is we return a reference to a template
    // resolving that path to said template
    @GetMapping("/")
    public String main() {
        return "main";
    }

    @ModelAttribute("products")
    public List<Product> products() {
        return productService.findAll();
    }

    @ModelAttribute("categories")
    public List<String> categories() {
        return productService.findDistinctCategories();
    }

    @ModelAttribute("brands")
    public List<String> brands() {
        return productService.findDistinctBrands();
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(required = false) String category,
                         @RequestParam(required = false) String brand,
                         Model model) {

        List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
        model.addAttribute("products", filtered);
        return "main";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }


}

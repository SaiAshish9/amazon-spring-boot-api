package com.amazon.springapi.controllers.home;

import com.amazon.springapi.repository.home.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:4200","https://amazon-clone-by-sai.vercel.app"})
@RestController
@RequestMapping("/api/public/home")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public ResponseEntity<?> fetchCategories() {
        List categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

}

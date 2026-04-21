package com.retail.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.retail.io.CategoryRequest;
import com.retail.io.CategoryResponse;
import com.retail.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    
    // adding a new category 
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request){
        return categoryService.addCategory(request);
    }

    @GetMapping()
    public List<CategoryResponse> fetchCategories(){
        return categoryService.read();
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId){
        try {
            categoryService.delete(categoryId);
        } catch(Exception ex) { 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}

package com.retail.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.io.CategoryRequest;
import com.retail.io.CategoryResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    
    @PostMapping("categories")
    public CategoryResponse addCategory(@RequestBody CategoryRequest request){
        return null;
    }
}

package com.retail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.io.CategoryRequest;
import com.retail.io.CategoryResponse;

@Service
public interface CategoryService {
    
    CategoryResponse addCategory(CategoryRequest request);
    List<CategoryResponse> read();
    void delete(String categoryId);
}

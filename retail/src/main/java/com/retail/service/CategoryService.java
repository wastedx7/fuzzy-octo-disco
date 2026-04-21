package com.retail.service;

import com.retail.io.CategoryRequest;
import com.retail.io.CategoryResponse;

public interface CategoryService {
    
    CategoryResponse addCategory(CategoryRequest request);
    
}

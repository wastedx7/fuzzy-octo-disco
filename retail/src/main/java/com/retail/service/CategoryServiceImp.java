package com.retail.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.retail.entities.CategoryEntity;
import com.retail.io.CategoryRequest;
import com.retail.io.CategoryResponse;
import com.retail.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImp implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse addCategory(CategoryRequest request){
        CategoryEntity newCategory = convertToEntity(request);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);  
    }

    @Override
    public List<CategoryResponse> read() {
        return categoryRepository.findAll()
            .stream()
            .map(CategoryEntity -> convertToResponse(CategoryEntity))
            .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
            .orElseThrow(() -> new RuntimeException("category not found" + categoryId));
        categoryRepository.delete(existingCategory); 
    }

    // both are private methods
    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
        return CategoryResponse.builder()
            .categoryId(newCategory.getCategoryId())
            .name(newCategory.getName())
            .description(newCategory.getDescription())
            .bgColor(newCategory.getBgColor())
            .imgUrl(newCategory.getImgUrl())
            .createdAt(newCategory.getCreatedAt())
            .updatedAt(newCategory.getUpdatedAt())
            .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
            .categoryId(UUID.randomUUID().toString())
            .name(request.getName())
            .description(request.getDescription())
            .bgColor(request.getBgColor())
            .build();
    }


}

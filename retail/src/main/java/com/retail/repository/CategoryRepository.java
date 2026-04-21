package com.retail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    
    Optional<CategoryEntity> findByCategoryId(String categoryId);
}

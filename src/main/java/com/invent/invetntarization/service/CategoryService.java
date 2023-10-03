package com.invent.invetntarization.service;

import com.invent.invetntarization.dto.CategoryDTO;
import com.invent.invetntarization.entity.Category;
import com.invent.invetntarization.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    public Category addCategory(CategoryDTO categoryDTO) {
        return categoryRepository.save(Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build());
    }

    public Category readById(int id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found - " + id));
    }
}

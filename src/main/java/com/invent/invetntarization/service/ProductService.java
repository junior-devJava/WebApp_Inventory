package com.invent.invetntarization.service;

import com.invent.invetntarization.dto.CategoryDTO;
import com.invent.invetntarization.dto.ProductDTO;
import com.invent.invetntarization.entity.Category;
import com.invent.invetntarization.entity.Product;
import com.invent.invetntarization.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Product create(ProductDTO dto) {
        return productRepository.save(Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .location(dto.getLocation())
                .responsible(dto.getResponsible())
                .serial_number(dto.getSerial_number())
                .category(categoryService.readById(dto.getCategoryId()))
                .build());
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public List<Product> readByCategory(int id) {
        return productRepository.findByCategoryId(id);
    }

    public Category addCategories(CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}

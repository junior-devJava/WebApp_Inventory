package com.invent.invetntarization.controller;


import com.invent.invetntarization.dto.CategoryDTO;
import com.invent.invetntarization.dto.ProductDTO;
import com.invent.invetntarization.entity.Category;
import com.invent.invetntarization.entity.Product;
import com.invent.invetntarization.service.CategoryService;
import com.invent.invetntarization.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/home")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("create", new ProductDTO());
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSubmit(@ModelAttribute ProductDTO productDTO, Model model) {
        model.addAttribute("create", productDTO);
        productService.create(productDTO);
        return "result.html";
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> readAll() {
        return mappingResponseListProduct(productService.readAll());
    }


    @RequestMapping(value = "/categories/create", method = RequestMethod.GET)
    public String createCategoryForm(Model model) {
        model.addAttribute("addCategory", new CategoryDTO());
        return "addCategory";
    }

    @RequestMapping(value = "/categories/create", method = RequestMethod.POST)
    public String createCategorySubmit(@ModelAttribute CategoryDTO categoryDTO, Model model) {
        model.addAttribute("addCategory", categoryDTO);
        productService.addCategories(categoryDTO);
        return "resultCategories.html";
    }

    @GetMapping("/products/category/{id}")
    public ResponseEntity<List<Product>> readByCategory(@PathVariable int id) {
        return mappingResponseListProduct(productService.readByCategory(id));
    }

    @PutMapping("/products")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return mappingResponseProduct(productService.update(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus delete(@PathVariable int id) {
        productService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Product> mappingResponseProduct(Product product) {
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> products) {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

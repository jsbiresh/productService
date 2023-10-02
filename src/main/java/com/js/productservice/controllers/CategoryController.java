package com.js.productservice.controllers;

import com.js.productservice.dtos.GetProductTitlesRequestDto;
import com.js.productservice.dtos.ProductDto;
import com.js.productservice.models.Product;
import com.js.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{uuid}")
    public List<ProductDto> getCategory(@PathVariable("uuid") String uuid) {

        List<Product> products = categoryService.getCategory(uuid).getProducts();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product: products) {
            ProductDto productDto = new ProductDto();
            productDto.setDescription(product.getDescription());
            productDto.setTitle(product.getTitle());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @GetMapping("/titles/")
    public List<String> getProductTitles(@RequestBody GetProductTitlesRequestDto requestDto) {

        System.out.println("getProductTitles() called");
        List<String> uuids = requestDto.getUuids();

        return categoryService.getProductTitles(uuids);
    }

    @GetMapping("/")
    public Set<String> getAllCategories() {
        return categoryService.getAllCategory();
    }

}

package com.js.productservice.services;

import com.js.productservice.dtos.GetProductTitlesRequestDto;
import com.js.productservice.dtos.ProductDto;
import com.js.productservice.models.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);

    Set<String> getAllCategory();

    List<ProductDto> getAllProductsFromCategory(String category);

    List<String> getUuids(GetProductTitlesRequestDto ids);
}
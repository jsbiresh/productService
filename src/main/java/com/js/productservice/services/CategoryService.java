package com.js.productservice.services;

import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Set<String> getAllCategory();

    Category getCategory(String uuid) throws NotFoundException;

    List<String> getProductTitles(List<String> categoryUUIDs);

}
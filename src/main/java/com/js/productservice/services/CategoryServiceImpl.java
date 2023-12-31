package com.js.productservice.services;

import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Category;
import com.js.productservice.models.Product;
import com.js.productservice.repositories.CategoryRepository;
import com.js.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Set<String> getAllCategory() {
        List<Category> category = categoryRepository.findAll();
        Set<String> all_cat = new HashSet<>();
        for (Category cat : category) {
            all_cat.add(cat.getName());
        }
        return all_cat;
    }

    // Get category by String
    @Override
    public Category getCategory(String uuid) throws NotFoundException {

        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            throw new NotFoundException("Category with ID : " + uuid + " NOT FOUND");
        }
        Category category = categoryOptional.get();
        List<Product> products = category.getProducts();
        return category;
    }

    // Get category by UUID
//    @Override
//    public Category getCategory(UUID uuid) {
//
//        System.out.println("***************");
//        System.out.println("getCategory() called UUID");
//        System.out.println("***************");
//        Optional<Category> categoryOptional = categoryRepository.findById(uuid);
//
//        if (categoryOptional.isEmpty()) {
//            return null;
//        }
//        Category category = categoryOptional.get();
//        List<Product> products = category.getProducts();
//        return category;
//    }

    public List<String> getProductTitles(List<String> categoryUUIDs) {
        List<UUID> uuids = new ArrayList<>();

        for (String uuid : categoryUUIDs) {
            uuids.add(UUID.fromString(uuid));
        }
        List<Category> categories = categoryRepository.findAllById(uuids);
        List<Product> products = productRepository.findAllByCategoryIn(categories);
        List<String> titles = new ArrayList<>();
        for (Product p: products) {
            titles.add(p.getTitle());
        }
        return titles;
    }


//    @Override
//    public List<String> getUuids(GetProductTitlesRequestDto ids) {
//        return ids.getUuids();
//    }

}
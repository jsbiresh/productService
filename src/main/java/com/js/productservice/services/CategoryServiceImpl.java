package com.js.productservice.services;

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
        System.out.println("***************");
        System.out.println("getAllCategory() called");
        System.out.println("***************");
        List<Category> category = categoryRepository.findAll();
        Set<String> all_cat = new HashSet<>();
        for (Category cat : category) {
            all_cat.add(cat.getName());
        }
        return all_cat;
    }

    // Get category by String
    @Override
    public Category getCategory(String uuid) {

        System.out.println("***************");
        System.out.println("getCategory() called String");
        System.out.println("***************");
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
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

//
//    @Override
//    public List<Product> getAllProductsFromCategory(UUID uuid) {
//
//        System.out.println("**************************** ");
//        System.out.println("getAllProductsFromCategory() called from Service");
//        System.out.println("**************************** ");
//        // find category by uuid
//        Optional<Category> categoryOptional = categoryRepository.findById(uuid);
//
//        // if category is not found, return null
//        if (categoryOptional.isEmpty()) {
//            return null;
//        }
//
//        System.out.println("Found Category by UUID : " + categoryOptional.get().getName());
//
//        // get the category
//        String category = categoryOptional.get().getName();
//
//        List<String> results = categoryRepository.findAllByCategoryIn(category);
//        List<Product> productList = new ArrayList<>();
//
//        for (String id : results) {
//            System.out.println(id);
////            Optional<Product> productOptional = productRepository.findById(UUID.fromString(result));
////            if (productOptional.isEmpty()) {
////                return null;
////            }
////            productList.add(productOptional.get());
//        }
//
////        for (ProductDto productDto : results) {
////
////            Product product = new Product();
////            product.setTitle(productDto.getTitle());
////            product.setImage(productDto.getImage());
////            product.setDescription(productDto.getDescription());
////            product.setPrice(productDto.getPrice());
////            productList.add(product);
////        }
//
//
//        System.out.println("productList size: " + productList.size());
//        return productList;
//    }


//    @Override
//    public List<String> getUuids(GetProductTitlesRequestDto ids) {
//        return ids.getUuids();
//    }

}
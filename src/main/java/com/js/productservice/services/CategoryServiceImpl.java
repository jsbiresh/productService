package com.js.productservice.services;

import com.js.productservice.dtos.GetProductTitlesRequestDto;
import com.js.productservice.dtos.ProductDto;
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
    public Category getCategory(String uuid) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();

        List<Product> products = category.getProducts();


        return category;
    }

    public List<String> getProductTitles(List<String> categoryUUIDs) {
        List<UUID> uuids = new ArrayList<>();

        for (String uuid: categoryUUIDs) {
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


    @Override
    public Set<String> getAllCategory() {
        List<Category> category = categoryRepository.findAll();
        Set<String> all_cat = new HashSet<>();
        for (Category cat : category) {
            all_cat.add(cat.getName());
        }
        System.out.println("HOLA MUNDOS!!!");
        return all_cat;
    }

    @Override
    public List<ProductDto> getAllProductsFromCategory(String uuid) {

        // function to get all products from a category
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isPresent()) {

            Category category = categoryOptional.get();
            List<Product> products = category.getProducts();

            List<ProductDto> productDtos = new ArrayList<>();

            for (Product product : products) {

                ProductDto productDto = new ProductDto();
                productDto.setDescription(product.getDescription());
                productDto.setTitle(product.getTitle());
                productDto.setImage(product.getImage());
                productDto.setPrice(product.getPrice());
                productDtos.add(productDto);
            }
            return productDtos;
        }

        return null;
    }

    @Override
    public List<String> getUuids(GetProductTitlesRequestDto ids) {
        return ids.getUuids();
    }
}
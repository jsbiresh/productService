package com.js.productservice;

import com.js.productservice.models.Category;
import com.js.productservice.models.Product;
import com.js.productservice.repositories.CategoryRepository;
import com.js.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductserviceApplication(ProductRepository productRepository,
                                     CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
        System.out.println("SERVER RUNNING...");
    }

    //    @Override
    public void run(String... args) throws Exception {

        // A new Category
        Category category = new Category();
        category.setName("Apple Devices");
        Category savedCategory = categoryRepository.save(category);

        // A new Product
        Product product = new Product();
        product.setTitle("iPhone 16 Pro");
        product.setDescription("This is the latest iPhone, and the best One.");
        product.setPrice(1000);
        product.setCategory(savedCategory);
        productRepository.save(product);

        // Add another Category
        category = new Category();
        category.setName("Samsung Devices");
        savedCategory = categoryRepository.save(category);


        // Add another Product
        product = new Product();
        product.setTitle("Samsung Galaxy A50s");
        product.setDescription("This is the best Samsung phone.");
        product.setPrice(700);
        product.setCategory(savedCategory);
        productRepository.save(product);

//        Optional<Category> categoryFound = categoryRepository.findById(UUID.fromString("41038c08-3128-40ea-aa8b-ebac066a48cb"));
//        categoryFound.ifPresent(categoryI -> {
//            System.out.println("Category :- " + categoryI.getName());
//        });


        // Find a Category by id
//        Optional<Category> categoryFound = categoryRepository.findById(UUID.fromString("f9b2b44b-fdfc-4bc4-8100-53fe386e48df"));
////        System.out.println("Category :- " + categoryFound.get().getName());
//        categoryFound.ifPresent(categoryI -> {
//            System.out.println("Category :- " + categoryI.getName());
//        });

//        System.out.println("***********************************************");
//
//        // Find a Product by id
//        Optional<Product> productFound = productRepository.findById(UUID.fromString("41038c08-3128-40ea-aa8b-ebac066a48cb"));
////        System.out.println("Product :- " + productFound.get().getTitle());
//        productFound.ifPresent(productI -> {
//            System.out.println("Product :- " + productI.getTitle());
//        });
//
//        System.out.println("***********************************************");
//        // Find all Products in the database and print them
//        Iterable<Product> products = productRepository.findAll();
//        for (Product p : products) {
//            System.out.println("Product :- " + p.getTitle());
//        }
//        System.out.println("***********************************************");
//        // Find all Categories in the database and print them
//        Iterable<Category> categories = categoryRepository.findAll();
//        for (Category c : categories) {
//            System.out.println("Category :- " + c.getName());
//        }

    }
}


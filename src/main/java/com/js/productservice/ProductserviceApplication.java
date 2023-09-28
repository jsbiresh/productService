package com.js.productservice;

import com.js.productservice.repositories.CategoryRepository;
import com.js.productservice.repositories.PriceRepository;
import com.js.productservice.repositories.ProductRepository;
import com.js.productservice.services.SelfProductServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    private SelfProductServiceImpl selfProductServiceImpl;

    public ProductserviceApplication(ProductRepository productRepository,
                                     CategoryRepository categoryRepository,
                                     PriceRepository priceRepository, SelfProductServiceImpl selfProductServiceImpl) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
        System.out.println("SERVER RUNNING...");
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("This is the command line runner method");
//
//
//    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        System.out.println("From command line runner");

        // Added Apple Devices Category & Price for iPhone 15 Pro Product
//        ***************************************************************
//        Category category = new Category();
//        category.setName("Apple Devices");
////        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Rupee", 100000);
////        Price savedPrice = priceRepository.save(price);
//
//        Product product = new Product();
//        product.setTitle("iPhone 15 Pro");
//        product.setDescription("The best iPhone Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//        ***************************************************************


        // Added Samsung Devices Category & Price for Samsung Galaxy S21 Product
//        ***************************************************************
//        Category category = new Category();
//        category.setName("Samsung Devices");
////        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Rupee", 90000);
////        Price savedPrice = priceRepository.save(price);
//
//        Product product = new Product();
//        product.setTitle("Samsung Galaxy S21");
//        product.setDescription("The best Camera Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//        ***************************************************************

        // Added Samsung Devices Category & Price for Samsung Galaxy A50S Product
//        ***************************************************************
////        Category category = new Category();
//        category.setName("Samsung Devices");
////        Category savedCategory = categoryRepository.save(category);
//
//        price = new Price("Dollar", 800);
////        Price savedPrice = priceRepository.save(price);
//
//        product = new Product();
//        product.setTitle("Samsung Galaxy A50S");
//        product.setDescription("The best Mid Range Phone Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//        ***************************************************************


//        // Added LG Devices Category & Price for LG G8X Product
////        ***************************************************************
//        Category category = new Category();
//        category.setName("LG Devices");
////        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Dirham", 850);
////        Price savedPrice = priceRepository.save(price);
//
//        Product product = new Product();
//        product.setTitle("LG G8X");
//        product.setDescription("The best Dual Screen Phone Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//        ***************************************************************

//        // Added LG Devices Category & Price for LG 55 inch TV Product
////        ***************************************************************
//        Category category = new Category();
//        category.setName("LG Devices");
//
//        Price price = new Price("Yen", 944.50);
//
//        Product product = new Product();
//        product.setTitle("LG 55 inch TV");
//        product.setDescription("The best 4K TV Ever.");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
////        ***************************************************************


//        // Added Price for LG Washing Machine Front Load 6 Kg Product
////        ***************************************************************
//        Category category = new Category();
//        category.setName("LG Devices");
//
//        Price price = new Price("Won", 28599.49);
//
//        Product product = new Product();
//        product.setTitle("LG Washing Machine Front Load 6 Kg");
//        product.setDescription("The best Washing Machine Ever. 6 Kg Front Load. 5 Star Rating.");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
////        ***************************************************************

//        // find product by id
//        Optional<Product> product = productRepository.findById(UUID.fromString("d7cda8c4-14a7-4956-91b0-2015e2514090"));
//        if (product.isPresent()) {
//            System.out.println("Product found:- ");
//            System.out.println("Product Title: " + product.get().getTitle());
//            System.out.println("Product Category: " + product.get().getCategory());
//            System.out.println("Product Description: " + product.get().getDescription());
//            System.out.println("Product Image: " + product.get().getImage());
//        } else {
//            System.out.println("Product not found");
//        }

    }
}


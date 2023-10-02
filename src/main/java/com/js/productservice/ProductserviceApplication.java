package com.js.productservice;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    private SelfProductServiceImpl selfProductServiceImpl;
//
//    public ProductserviceApplication(ProductRepository productRepository,
//                                     CategoryRepository categoryRepository,
//                                     PriceRepository priceRepository, SelfProductServiceImpl selfProductServiceImpl) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//        this.selfProductServiceImpl = selfProductServiceImpl;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
        System.out.println("SERVER RUNNING...");
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        System.out.println("From command line runner");

    }
}


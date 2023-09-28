package com.js.productservice;

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
//    }

//    @Autowired
//    private SelfProductServiceImpl selfProductServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
        System.out.println("SERVER RUNNING...");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("This is the command line runner method");

        // calling SelfProductServiceImpl getAllProducts method
        /*
        List<GenericProductDto> genericProductDtoList = selfProductServiceImpl.getAllProducts();
        if (genericProductDtoList == null) {
            System.out.println("No products found");
            return;
        }
        for (GenericProductDto genericProductDto : genericProductDtoList) {
            System.out.println("*******************************************");
            System.out.println(genericProductDto.getUuid());
            System.out.println(genericProductDto.getTitle());
            System.out.println(genericProductDto.getPrice());
            System.out.println(genericProductDto.getCategory());
            System.out.println(genericProductDto.getDescription());
            System.out.println(genericProductDto.getImage());
            System.out.println("*******************************************");
        }
    */
    }

//    //    @Override
//    public void run(String... args) throws Exception {
//
////        ********* Adding Category, Price and Product   *********************************
//        // A new Category
//        Category category = new Category();
//        category.setName("Apple Devices");
////        Category savedCategory = categoryRepository.save(category);
//        // here no need to save the category because we have used CascadeType.PERSIST in the Product class
//
//        Price price = new Price();
//        price.setCurrency("Rupee");
//        price.setPrice(1000);
////        Price savedPrice = priceRepository.save(price);
//        // here no need to save the price because we have used CascadeType.PERSIST in the Product class
//
//        // A new Product
//        Product product = new Product();
//        product.setTitle("iPhone 16 Pro");
//        product.setDescription("This is the latest iPhone, and the best One.");
//        product.setPrice(price);
//        product.setCategory(category);
//        productRepository.save(product);
//
////        *********** Adding another Category, Price and Product   *********************************
//
//        // Add another Category
//        category = new Category();
//        category.setName("Samsung Devices");
////        savedCategory = categoryRepository.save(category);
//
//        price = new Price();
//        price.setCurrency("Lira");
//        price.setPrice(600);
//
//        // Add another Product
//        product = new Product();
//        product.setTitle("Samsung Galaxy A50s");
//        product.setDescription("This is the best Samsung phone.");
//        product.setPrice(price);
//        product.setCategory(category);
//        productRepository.save(product);
//
//
////        *********** Adding another Category, Price and Product   *********************************
//
//        // Add another Category
//        category = new Category();
//        category.setName("Huawei Devices");
//
//        // Add another Price
//        price = new Price();
//        price.setCurrency("Dinar");
//        price.setPrice(750);
//
//        // Add another Product
//        product = new Product();
//        product.setTitle("Huawei P30 Pro");
//        product.setDescription("This is the best Huawei phone.");
//        product.setPrice(price);
//        product.setCategory(category);
//        productRepository.save(product);
//
////        *********** Adding another Category, Price and Product   *********************************
//
////        // Add another Category
////        Category category = new Category();
////        category.setName("Huawei Devices");
////
////        // Add another Price
////        Price price = new Price();
////        price.setCurrency("Lira");
////        price.setPrice(550);
////
////        // Add another Product
////        Product product = new Product();
////        product.setTitle("LG G8X ThinQ");
////        product.setDescription("This is the best LG phone.");
////        product.setPrice(price);
////        product.setCategory(category);
////        productRepository.save(product);
//
//
////        *********Methods to manipulate on the data*********************************
//
//        // delete a product by id
////        productRepository.deleteById(UUID.fromString("7cc08ace-3b48-4e98-8169-50bd609133fc"));
//
//
////        // find a product by currency
////        List<Product> proList = productRepository.findAllByPrice_Currency("Lira");
////        for (Product p : proList) {
////            System.out.println("Product :- " + p.getTitle() + " Price :- " + p.getPrice().getPrice() + ", " + p.getPrice().getCurrency());
////        }
//
//
////        // find by title equals and price price
////        List<Product> productsList = productRepository.findByTitleEqualsAndPrice_Price("iPhone 16 Pro", 1000);
////
////        List<Product> productFound = productRepository.findAllByTitle("LG G8X ThinQ");
////
////        System.out.println("Product by Title");
////        for (Product p : productFound) {
////            System.out.println("Product :- " + p.getTitle() + " Price :- " + p.getPrice().getPrice() + ", " + p.getPrice().getCurrency());
////        }
////
//        // find product by description contains
//        List<Product> productsList = productRepository.findByDescriptionContains("latest");
//        System.out.println("Product by Description Contains");
//        for (Product p : productsList) {
//            System.out.println("Product :- " + p.getTitle() + " Price :- " + p.getPrice().getPrice() + ", " + p.getPrice().getCurrency());
//        }
//
////        // find all products with a specific title using custom query written by me
////        List<Product> productsList = productRepository.findAllByTitleCustom();
////        System.out.println("Product by Title Custom");
////        for (Product p : productsList) {
////            System.out.println("Product :- " + p.getTitle() + " Price :- " + p.getPrice().getPrice() + ", " + p.getPrice().getCurrency());
////        }
//
//
//    }
}


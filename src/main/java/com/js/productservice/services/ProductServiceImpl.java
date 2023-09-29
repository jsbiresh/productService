package com.js.productservice.services;


import com.js.productservice.dtos.ProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Category;
import com.js.productservice.models.Product;
import com.js.productservice.repositories.CategoryRepository;
import com.js.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("selfProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // working with local database
    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> allproducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : allproducts) {
            ProductDto productDto = new ProductDto();
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDtos.add(productDto);
        }
        System.out.println("**************************");
        System.out.println("getAllProducts() called");
        System.out.println("**************************");
        return productDtos;
    }

    // working with local database
    @Override
    public ProductDto getProductById(String id) throws NotFoundException {
        System.out.println("getProductById() called");
        Optional<Product> product = productRepository.findById(UUID.fromString(id));
        if (product.isEmpty())
            throw new NotFoundException("Product with ID : " + id + " not found");
        Product prod = product.get();
        prod.getPrice();        // this line is added to avoid lazy loading exception
        ProductDto productDto = new ProductDto();
        productDto.setTitle(prod.getTitle());
        productDto.setDescription(prod.getDescription());
        productDto.setPrice(prod.getPrice());
        productDto.setImage(prod.getImage());
        System.out.println("**************************");
        System.out.println("Product found :- " + productDto.getTitle());
        System.out.println("**************************");
        return productDto;
    }

    // working with local database
    @Override
    public ProductDto createProduct(Product product) {

        Optional<Category> categoryOptional = categoryRepository.findByNameIgnoreCase(product.getCategory().getName());

        Category category;
        if (categoryOptional.isPresent()) {
            System.out.println("Category Already Exists");
            // Step 2: If the category exists, use its ID
            category = categoryOptional.get();
        } else {
            System.out.println("Category Doesn't Exist");
            // Step 3: If the category doesn't exist, create a new category
            category = new Category();
            category.setName(product.getCategory().getName());
            category = categoryRepository.save(category);
        }

        // Create a new product using the obtained or created category
        Product newProduct = new Product();
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setImage(product.getImage());
        newProduct.setCategory(category);
        newProduct.setPrice(product.getPrice());
        // Save the new Product
        Product savedProduct = productRepository.save(newProduct);
        // Create a new ProductDto and copy the properties from the savedProduct
        ProductDto newProductDto = copyProductDtoProperties(savedProduct);
        // Print a success message
        System.out.println("**************************");
        System.out.println("Product created successfully :- " + newProductDto.getTitle());
        System.out.println("**************************");
        return newProductDto;
    }

    // Utility method to copy properties from one Product to another
    private Product copyProductProperties(Product source) {
        Product target = new Product();
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setImage(source.getImage());
        target.setPrice(source.getPrice());
        target.setCategory(source.getCategory());
        return target;
    }

    // Utility method to copy properties from a Product to a ProductDto
    private ProductDto copyProductDtoProperties(Product source) {
        ProductDto target = new ProductDto();
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setImage(source.getImage());
        target.setPrice(source.getPrice());
        return target;
    }

    // working with local database
    @Override
    public ProductDto updateProduct(String id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString(id));
        if (optionalProduct.isEmpty())
            throw new RuntimeException();

        Product product = optionalProduct.get();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());

        Product savedProduct = productRepository.save(product);

        // Create a new ProductDto and copy the properties from the savedProduct
        ProductDto newProductDto = copyProductDtoProperties(savedProduct);

        System.out.println("**************************");
        System.out.println("Product updated successfully :- " + newProductDto.getTitle());
        System.out.println("**************************");
        return newProductDto;
    }

    // working with local database
    @Override
    public ProductDto deleteProduct(String id) {
        System.out.println("deleteProduct() called");

        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString(id));
        if (optionalProduct.isEmpty())
            throw new RuntimeException();
        Product product = optionalProduct.get();
        //  Product details to return after DELETE operation
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setPrice(product.getPrice());
        productRepository.delete(product);
        System.out.println("**************************");
        System.out.println("Product deleted successfully :- " + productDto.getTitle());
        System.out.println("**************************");
        return productDto;
    }
}

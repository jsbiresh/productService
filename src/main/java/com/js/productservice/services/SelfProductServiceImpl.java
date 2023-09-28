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
public class SelfProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // working with local database
    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> allproducts = productRepository.findAll();
        System.out.println("from service: ");
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : allproducts) {
            ProductDto productDto = new ProductDto();
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDtos.add(productDto);
        }
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
        return productDto;
    }

    // working with local database
    @Override
    public ProductDto createProduct(Product product) {
        System.out.println("createProduct() called");

        Product newProduct = new Product();

        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setImage(product.getImage());
        newProduct.setPrice(product.getPrice());

        Category category = product.getCategory();
        newProduct.setCategory(category);

        Product savedProduct = productRepository.save(newProduct);
        ProductDto newProductDto = new ProductDto();

        newProductDto.setTitle(savedProduct.getTitle());
        newProductDto.setDescription(savedProduct.getDescription());
        newProductDto.setImage(savedProduct.getImage());
        newProductDto.setPrice(savedProduct.getPrice());

        return newProductDto;
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

        ProductDto newProductDto = new ProductDto();
        newProductDto.setTitle(savedProduct.getTitle());
        newProductDto.setDescription(savedProduct.getDescription());
        newProductDto.setImage(savedProduct.getImage());
        newProductDto.setPrice(savedProduct.getPrice());

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
        return productDto;
    }

}

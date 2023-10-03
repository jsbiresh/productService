package com.js.productservice.services;


import com.js.productservice.dtos.DisplayProductDto;
import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.dtos.ProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Category;
import com.js.productservice.models.Product;
import com.js.productservice.repositories.CategoryRepository;
import com.js.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Primary
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // working with local database
    // *****************************************************************************************************************

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

//    // Utility method to copy properties from a Product to a ProductDto
//    private ProductDto copyProductDtoProperties(Product source) {
//        ProductDto target = new ProductDto();
//        target.setTitle(source.getTitle());
//        target.setDescription(source.getDescription());
//        target.setImage(source.getImage());
//        target.setPrice(source.getPrice());
//        return target;
//    }


    // Utility method to copy properties from a Product to a GenericProductDto
    private GenericProductDto productToGenericProductDtoProperties(Product source) {
        GenericProductDto target = new GenericProductDto();
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setImage(source.getImage());
        target.setPrice(source.getPrice().getPrice());
        target.setCategory(source.getCategory().getName());
        return target;
    }

    @Override
    public GenericProductDto createProduct(Product product) {

        // this should be the structure of the request body
//        {
//            "title": "Dummy Product 1",
//                "price": {
//            "currency": "Dollar",
//                    "price": 1000.55
//        },
//            "description": "Best Dummy Product 1",
//                "image": "Dummy Product 1 Image",
//                "category": {
//            "name": "Dummy Category"
//        }
//        }

        Optional<Category> categoryOptional = categoryRepository.findByNameIgnoreCase(product.getCategory().getName());

        Category category;
        if (categoryOptional.isPresent()) {
            // Step 2: If the category exists, use its ID
            category = categoryOptional.get();
        } else {
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

        // Create a new GenericProductDto and copy the properties from the savedProduct
        return productToGenericProductDtoProperties(savedProduct);
    }

    @Override
    public List<DisplayProductDto> getAllProducts() {

        List<Product> allProducts = productRepository.findAll();

        List<DisplayProductDto> productDtos = new ArrayList<>();

        for (Product product : allProducts) {

            DisplayProductDto productDto = new DisplayProductDto();

//            productDto.setUuid(product.getUuid());
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDto.setCategory(product.getCategory().getName());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public DisplayProductDto getProductById(String id) throws NotFoundException {

        Optional<Product> product = productRepository.findById(UUID.fromString(id));
        if (product.isEmpty())
            throw new NotFoundException("Product with ID : " + id + " not found");
        Product prod = product.get();
//        prod.getPrice().getPrice();        // this line is added to avoid lazy loading exception
        DisplayProductDto productDto = new DisplayProductDto();

//        productDto.setUuid(prod.getUuid());
        productDto.setTitle(prod.getTitle());
        productDto.setDescription(prod.getDescription());
        productDto.setPrice(prod.getPrice());
        productDto.setImage(prod.getImage());
        System.out.println(prod.getCategory().getName());
        productDto.setCategory(prod.getCategory().getName());

        return productDto;
    }

    @Override
    public GenericProductDto updateProduct(String id, ProductDto productDto) throws NotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString(id));
        if (optionalProduct.isEmpty())
            throw new NotFoundException("Product with ID : " + id + " NOT FOUND, Update Failed.");

        Product product = optionalProduct.get();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());

        Product savedProduct = productRepository.save(product);
        // Create a new ProductDto and copy the properties from the savedProduct
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(savedProduct.getTitle());
        genericProductDto.setDescription(savedProduct.getDescription());
        genericProductDto.setImage(savedProduct.getImage());
        genericProductDto.setPrice(savedProduct.getPrice().getPrice());
        genericProductDto.setCategory(savedProduct.getCategory().getName());

        return genericProductDto;

//        return copyProductDtoProperties(savedProduct);
    }

    @Override
    public GenericProductDto deleteProduct(String id) throws NotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString(id));
        if (optionalProduct.isEmpty())
            throw new NotFoundException("Product with ID : " + id + " NOT FOUND, Deletion Failed.");

        Product product = optionalProduct.get();

        GenericProductDto productDto = new GenericProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setPrice(product.getPrice().getPrice());
        productDto.setCategory(product.getCategory().getName());

        productRepository.delete(product);
        return productDto;
    }
}

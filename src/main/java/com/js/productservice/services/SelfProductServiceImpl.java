package com.js.productservice.services;


import com.js.productservice.dtos.ProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Product;
import com.js.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProductById(String id) throws NotFoundException {
        System.out.println("getProductById() called");
        Optional<Product> product = productRepository.findById(UUID.fromString(id));
        if (product.isEmpty())
            throw new RuntimeException();
        Product prod = product.get();
        prod.getPrice();        // this line is added to avoid lazy loading exception
        ProductDto productDto = new ProductDto();
        productDto.setTitle(prod.getTitle());
        productDto.setDescription(prod.getDescription());
        productDto.setPrice(prod.getPrice());
        productDto.setImage(prod.getImage());
        return productDto;
    }

    @Override
    public ProductDto createProduct(Product product) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts(List<String> categories) {
        return null;
    }


    @Override
    public ProductDto updateProduct(String id, ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProduct(String id) {
        return null;
    }

}

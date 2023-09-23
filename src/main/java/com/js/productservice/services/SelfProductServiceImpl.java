package com.js.productservice.services;


import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.repositories.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    //    private final ProductRepository productRepository;
    private ProductRepo productRepo;

    public SelfProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        GenericProductDto genericProductDto = productRepo.getById(id);
        
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(UUID id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }


    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

}

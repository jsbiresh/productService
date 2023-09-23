package com.js.productservice.services;


import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Product;
import com.js.productservice.repositories.SelfProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    private SelfProductRepository selfProductRepository;

    public SelfProductServiceImpl(SelfProductRepository selfProductRepository) {
        this.selfProductRepository = selfProductRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }


    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        // function to get product by id
        System.out.println("getProductById was called from SelfProductServiceImpl with " + id);
        Product product = selfProductRepository.findById(id).orElseThrow(() -> new NotFoundException("Product by id " + id + " was not found"));
        if (product == null) {
            throw new NotFoundException("Product by id " + id + " was not found, coming from SelfProductServiceImpl");
        }

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setPrice(product.getPrice().getPrice());
        genericProductDto.setCategory(product.getCategory().getName());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImage())
        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) throws NotFoundException {
        return null;
    }
}

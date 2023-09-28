package com.js.productservice.services;


import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Product;
import com.js.productservice.repositories.SelfProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() throws NotFoundException {

        System.out.println("getAllProducts was called from SelfProductServiceImpl");
        List<Product> products = selfProductRepository.findAll();
        if (products == null) {
            throw new NotFoundException("Products were not found, coming from SelfProductServiceImpl");
        }
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (Product product : products) {
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setPrice(product.getPrice().getPrice());
            genericProductDto.setCategory(product.getCategory().getName());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setImage(product.getImage());
            genericProductDtos.add(genericProductDto);
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto updateById(GenericProductDto genericProductDto, UUID id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(UUID id) {
        return null;
    }
}

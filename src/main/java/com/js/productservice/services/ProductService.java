package com.js.productservice.services;

import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;

import java.util.List;


public interface ProductService {


    List<GenericProductDto> getAllProducts();

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) throws NotFoundException;

}

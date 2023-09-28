package com.js.productservice.services;

import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//@Primary
@Service("productService")
public interface ProductService {


    // For Local Database
    GenericProductDto createProduct(GenericProductDto genericProductDto);

    List<GenericProductDto> getAllProducts() throws NotFoundException;

    GenericProductDto getProductById(UUID id) throws NotFoundException;

    GenericProductDto updateById(GenericProductDto genericProductDto, UUID id) throws NotFoundException;

    GenericProductDto deleteProductById(UUID id);


    // For API CALLS
//    List<GenericProductDto> getAllProducts() throws NotFoundException;
//    GenericProductDto getProductById(Long id) throws NotFoundException;
//    GenericProductDto findByIdAndUpdate(GenericProductDto genericProductDto, Long id) throws NotFoundException;
//    GenericProductDto deleteProductById(Long id);


}

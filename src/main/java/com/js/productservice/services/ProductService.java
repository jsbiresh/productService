package com.js.productservice.services;

import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//@Primary
@Service("productService")
public interface ProductService {


    List<GenericProductDto> getAllProducts();

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto getProductById(UUID id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) throws NotFoundException;

}

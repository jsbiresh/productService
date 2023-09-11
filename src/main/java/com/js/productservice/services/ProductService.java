package com.js.productservice.services;

import com.js.productservice.dtos.FakeStoreProductDto;
import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {


    //    Product getProductById(Long id);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) throws NotFoundException;

}

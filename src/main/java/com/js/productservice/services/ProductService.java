package com.js.productservice.services;

import com.js.productservice.dtos.FakeStoreProductDto;
import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {


    //    Product getProductById(Long id);


    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    GenericProductDto updateProductById(GenericProductDto genericProductDto);

    List<GenericProductDto> getAllProducts();




}

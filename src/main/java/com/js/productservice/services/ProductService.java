package com.js.productservice.services;

import com.js.productservice.dtos.FakeStoreProductDto;
import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.models.Product;
import org.springframework.stereotype.Service;


public interface ProductService {


    //    Product getProductById(Long id);


    GenericProductDto getProductById(Long id);




}

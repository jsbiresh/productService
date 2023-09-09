package com.js.productservice.services;


import com.js.productservice.dtos.FakeStoreProductDto;
import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}

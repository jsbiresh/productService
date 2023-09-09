package com.js.productservice.services;


import com.js.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    @Override
    public String getProductById(Long id) {
        return "Hola Mundo!";
    }
}

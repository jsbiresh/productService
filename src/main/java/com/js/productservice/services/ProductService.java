package com.js.productservice.services;

import com.js.productservice.dtos.ProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Service("productService")
public interface ProductService {


    // For Local Database
    ProductDto createProduct(Product product);

    List<ProductDto> getAllProducts(List<String> categories);

    ProductDto getProductById(String id) throws NotFoundException;

    ProductDto updateProduct(String id, ProductDto productDto);

    ProductDto deleteProduct(String id);


    // For API CALLS
//    List<GenericProductDto> getAllProducts() throws NotFoundException;
//    GenericProductDto getProductById(Long id) throws NotFoundException;
//    GenericProductDto findByIdAndUpdate(GenericProductDto genericProductDto, Long id) throws NotFoundException;
//    GenericProductDto deleteProductById(Long id);


}

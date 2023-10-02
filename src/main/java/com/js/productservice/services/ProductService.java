package com.js.productservice.services;

import com.js.productservice.dtos.DisplayProductDto;
import com.js.productservice.dtos.ProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Service("productService")
public interface ProductService {


    // use for LOCAL DATABASE
    // ************************************************

    ProductDto createProduct(Product product);

    List<DisplayProductDto> getAllProducts() throws NotFoundException;

    DisplayProductDto getProductById(String id) throws NotFoundException;

    ProductDto updateProduct(String id, ProductDto productDto) throws NotFoundException;

    ProductDto deleteProduct(String id) throws NotFoundException;

    // ****************** END ****************************

    // use for FAKESTORE API
    // ************************************************

//    FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProductDto);
//
//    List<FakeStoreProductDto> getAllProducts() throws NotFoundException;
//
//    FakeStoreProductDto getProductById(String id) throws NotFoundException;
//
//    FakeStoreProductDto updateProduct(String id, FakeStoreProductDto fakeStoreProductDto) throws NotFoundException;
//
//    String deleteProduct(String id) throws NotFoundException;

    // ************************************************


}

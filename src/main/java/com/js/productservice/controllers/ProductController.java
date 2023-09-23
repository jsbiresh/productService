package com.js.productservice.controllers;

import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@Controller
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
//    private SelfProductServiceImpl selfProductServiceImpl;

    //    @Autowired
//    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService, SelfProductServiceImpl selfProductServiceImpl) {
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
//        this.selfProductServiceImpl = selfProductServiceImpl;
    }

    @GetMapping("/")
    public List<GenericProductDto> getAllProducts() {

//        return selfProductServiceImpl.getAllProducts();

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        System.out.println("getProductById was called from ProductController with " + id);

//        GenericProductDto genericProductDto = productService.getProductById(UUID.fromString("e355a3a6-929b-4260-bfa1-606e7f009234"));
        GenericProductDto genericProductDto = productService.getProductById(id);
        if (genericProductDto == null) {
            throw new NotFoundException("Product by id " + id + " was not found, coming from ProductController");
        }
        System.out.println("*******************************************");
        System.out.println(genericProductDto.getUuid());
        System.out.println(genericProductDto.getTitle());
        System.out.println("*******************************************");
        genericProductDto.setUuid(genericProductDto.getUuid());
        genericProductDto.setTitle(genericProductDto.getTitle());
        genericProductDto.setPrice(genericProductDto.getPrice());
        genericProductDto.setCategory(genericProductDto.getCategory());
        genericProductDto.setDescription(genericProductDto.getDescription());
        genericProductDto.setImage(genericProductDto.getImage());

//        GenericProductDto genericProductDto = selfProductServiceImpl.getProductById(id);
//        genericProductDto.setId(genericProductDto.getId());
//        genericProductDto.setTitle(genericProductDto.getTitle());
//        genericProductDto.setPrice(genericProductDto.getPrice());
//        genericProductDto.setCategory(genericProductDto.getCategory());
//        genericProductDto.setDescription(genericProductDto.getDescription());
//        genericProductDto.setImage(genericProductDto.getImage());
//        System.out.println("==>" + genericProductDto);

        return genericProductDto;
    }

    @PostMapping("/")
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {

        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) throws NotFoundException {

        ResponseEntity<GenericProductDto> response = new ResponseEntity<>( productService.deleteProductById(id), HttpStatus.OK );
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto product) throws NotFoundException {

//        ResponseEntity<GenericProductDto> response = new ResponseEntity<>( productService.updateProductById( product, id), HttpStatus.OK);
//        return response;
        return new ResponseEntity<>(productService.updateProductById(product, id), HttpStatus.OK);
    }

}

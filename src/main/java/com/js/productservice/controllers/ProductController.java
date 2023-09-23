package com.js.productservice.controllers;

import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.services.ProductService;
import com.js.productservice.services.SelfProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private SelfProductServiceImpl selfProductServiceImpl;

    //    @Autowired
//    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService, SelfProductServiceImpl selfProductServiceImpl) {
    public ProductController(ProductService productService, SelfProductServiceImpl selfProductServiceImpl) {
        this.productService = productService;
        this.selfProductServiceImpl = selfProductServiceImpl;
    }

    @GetMapping("/")
    public List<GenericProductDto> getAllProducts() {

        return productService.getAllProducts();
//        return selfProductServiceImpl.getAllProducts();
        //        return List.of(
//                new GenericProductDto(),
//                new GenericProductDto()
//        );
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {

        GenericProductDto genericProductDto = productService.getProductById(id);
        genericProductDto.setId(genericProductDto.getId());
        genericProductDto.setTitle(genericProductDto.getTitle());
        genericProductDto.setPrice(genericProductDto.getPrice());
        genericProductDto.setCategory(genericProductDto.getCategory());
        genericProductDto.setDescription(genericProductDto.getDescription());
        genericProductDto.setImage(genericProductDto.getImage());

        return genericProductDto;
        //        return "Here is product id: " + id;
//        model.addAttribute("apiData", )
//        return productService.getProductById(id);
//        GenericProductDto genericProductDto = new GenericProductDto();
//        genericProductDto.setId(productService.);
//        return new GenericProductDto();
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

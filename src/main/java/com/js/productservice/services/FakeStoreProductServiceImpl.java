//package com.js.productservice.services;
//
//import com.js.productservice.dtos.GenericProductDto;
//import com.js.productservice.dtos.ProductDto;
//import com.js.productservice.exceptions.NotFoundException;
//import com.js.productservice.models.Product;
//import com.js.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
//import com.js.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
////@Primary
//@Service("fakeStoreProductServiceImpl")
//public class FakeStoreProductServiceImpl implements ProductService {
//
//    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;
//
//    private GenericProductDto convertFakeToGeneric(FakeStoreProductDto fakeStoreProductDto) {
//        GenericProductDto product = new GenericProductDto();
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setPrice(fakeStoreProductDto.getPrice());
//        product.setCategory(fakeStoreProductDto.getCategory());
//        product.setImage(fakeStoreProductDto.getImage());
//        return product;
//    }
//
//    private FakeStoreProductServiceImpl(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
//        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
//    }
//
//    @Override
//    public GenericProductDto getProductById(Long id) throws NotFoundException {
//        return convertFakeToGeneric(fakeStoreProductServiceClient.getProductById(id));
//    }
//
//    @Override
//    public GenericProductDto getProductById(UUID id) {
//        return null;
//    }
//
//    @Override
//    public GenericProductDto createProduct(GenericProductDto product) {
//
//        return convertFakeToGeneric(fakeStoreProductServiceClient.createProduct(product));
//    }
//
//    @Override
//    public List<GenericProductDto> getAllProducts() {
//
//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts()) {
//            genericProductDtos.add(convertFakeToGeneric(fakeStoreProductDto));
//        }
//        return genericProductDtos;
//    }
//
//
//    @Override
//    public GenericProductDto deleteProductById(Long id) {
//
//        return convertFakeToGeneric(fakeStoreProductServiceClient.deleteProductById(id));
//    }
//
//    @Override
//    public GenericProductDto updateProductById(GenericProductDto genericProductDto, UUID id) throws NotFoundException {
//        return null;
//    }
//
//    @Override
//    public GenericProductDto findByIdAndUpdate(GenericProductDto genericProductDto, UUID id) throws NotFoundException {
//        return null;
//    }
//
//    @Override
//    public GenericProductDto updateProductById(GenericProductDto productRequestBody, Long id) throws NotFoundException {
//
//        if (fakeStoreProductServiceClient.updateProductById(productRequestBody, id) == null) {
//            throw new NotFoundException("Product ID: " + id + " not Found");
//        }
//        return fakeStoreProductServiceClient.updateProductById(productRequestBody, id);
//    }
//
//
//    @Override
//    public ProductDto createProduct(Product product) {
//        return null;
//    }
//
//    @Override
//    public List<ProductDto> getAllProducts(List<String> categories) {
//        return null;
//    }
//
//    @Override
//    public ProductDto getProductById(String id) throws NotFoundException {
//        return null;
//    }
//
//    @Override
//    public ProductDto updateProduct(String id, ProductDto productDto) {
//        return null;
//    }
//
//    @Override
//    public ProductDto deleteProduct(String id) {
//        return null;
//    }
//}

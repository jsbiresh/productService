package com.js.productservice.services;

import com.js.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    private GenericProductDto convertFakeToGeneric(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }

    private FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeToGeneric(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {

        return convertFakeToGeneric(fakeStoreProductServiceClient.createProduct(product));
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productRequestsBaseUrl, product, GenericProductDto.class);
//        return response.getBody();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);
//
//        List<GenericProductDto> answer = new ArrayList<>();
//        for (FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()) {
//            answer.add(convertFakeToGeneric(fakeStoreProductDto));
//        }
//        return answer;
//

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeToGeneric(fakeStoreProductDto));
        }
        return genericProductDtos;
    }


    @Override
    public GenericProductDto deleteProductById(Long id) {

        return convertFakeToGeneric(fakeStoreProductServiceClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto productRequestBody, Long id) throws NotFoundException {

//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        // Construct the URL for the update request, replacing {id} with the actual ID value
//        String updateUrl = UriComponentsBuilder.fromUriString(specificProductRequestUrl)
//                                                                                        .buildAndExpand(id)
//                                                                                        .toUriString();
//        // Create a RequestEntity with the PUT method and the updated product as the request body
//        RequestEntity<GenericProductDto> requestEntity = new RequestEntity<>(productRequestBody, HttpMethod.PUT, URI.create(updateUrl));
//        // Execute the PUT request and handle the response
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(requestEntity, FakeStoreProductDto.class);
//
//        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//
//        if (fakeStoreProductDto == null) {
//            throw new NotFoundException("Product with ID: "+ id +" NOT FOUND.");
//        }
////        if (fakeStoreProductDto != null) {
////            return convertFakeToGeneric(fakeStoreProductDto);
////        }
////        return null;
//        return convertFakeToGeneric(fakeStoreProductDto);

        if (fakeStoreProductServiceClient.updateProductById(productRequestBody, id) == null) {
            throw new NotFoundException("Product ID: "+ id +" not Found");
        }
        return fakeStoreProductServiceClient.updateProductById(productRequestBody, id);
    }


}

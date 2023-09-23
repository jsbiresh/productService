//package com.js.productservice.thirdpartyclients.productsservice.fakestore;
//
//import com.js.productservice.dtos.GenericProductDto;
//import com.js.productservice.exceptions.NotFoundException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.ResponseExtractor;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class FakeStoreProductServiceClient {
//
//    private final RestTemplateBuilder restTemplateBuilder;
//
//    //    @Value("${fakestore.api.url}")
//    @Value("${fakestore.api.url}")
//    private String fakeStoreApiUrl;
//
//    //    @Value("${fakestore.api.paths.product}")
//    @Value("${fakestore.api.paths.product}")
//    private String fakeStoreProductsApiPath;
//    private final String specificProductRequestUrl;
//    private final String productRequestsBaseUrl;
//
//
//    private FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreApiUrl, @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
//        this.restTemplateBuilder = restTemplateBuilder;
//        this.productRequestsBaseUrl = fakeStoreApiUrl + fakeStoreProductsApiPath;
//        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
//    }
//
//    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
//
//        if (response.getBody() == null) {
//            throw new NotFoundException("Product with ID: '"+ id +"' not Found.");
//        }
//        return response.getBody();
//    }
//
//
//    public FakeStoreProductDto createProduct(GenericProductDto product) {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestsBaseUrl, product, FakeStoreProductDto.class);
//        return response.getBody();
//    }
//
//
//    public List<FakeStoreProductDto> getAllProducts() {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);
//        return Arrays.stream(response.getBody()).toList();
//    }
//
//
//    public FakeStoreProductDto deleteProductById(Long id) {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        // METHOD 1
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
//
////        if (fakeStoreProductDto != null) {
////            return convertFakeToGeneric(fakeStoreProductDto);
////        }
////        return null;
//
//        return response.getBody();
////  METHOD 2
//
////        // Create a URI by replacing {id} with the actual ID value
////        URI uri = UriComponentsBuilder.fromUriString(specificProductRequestUrl)
////                .buildAndExpand(id)
////                .toUri();
////
////        // Create a RequestEntity with the DELETE method
////        RequestEntity<Void> requestEntity = new RequestEntity<>(HttpMethod.DELETE, uri);
////
////        // Execute the DELETE request and handle the response
////        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange( requestEntity, FakeStoreProductDto.class );
////        FakeStoreProductDto fakeStoreProductDto = response.getBody();
////        return convertFakeToGeneric(fakeStoreProductDto);
////    }
//    }
//
//
//    public GenericProductDto updateProductById(GenericProductDto productRequestBody, Long id) throws NotFoundException {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        // Construct the URL for the update request, replacing {id} with the actual ID value
//        String updateUrl = UriComponentsBuilder.fromUriString(specificProductRequestUrl)
//                .buildAndExpand(id)
//                .toUriString();
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
//
//        return convertFakeToGeneric(fakeStoreProductDto);
//    }
//
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
//}

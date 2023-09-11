package com.js.productservice.services;

import com.js.productservice.dtos.FakeStoreProductDto;
import com.js.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestsBaseUrl = "https://fakestoreapi.com/products/";


    private FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (fakeStoreProductDto != null) {
            return convertFakeToGeneric(fakeStoreProductDto);
        }
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productRequestsBaseUrl, product, GenericProductDto.class);

        return response.getBody();
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

//        ResponseEntity<List> response = restTemplate.getForEntity(productRequestsBaseUrl, List.class);
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()) {
            answer.add(convertFakeToGeneric(fakeStoreProductDto));
        }
        return answer;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        // METHOD 1
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id) ;

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (fakeStoreProductDto != null) {
            return convertFakeToGeneric(fakeStoreProductDto);
        }
        return null;



//        // METHOD 2
//        // Create a URI by replacing {id} with the actual ID value
//        URI uri = UriComponentsBuilder.fromUriString(specificProductRequestUrl)
//                .buildAndExpand(id)
//                .toUri();
//
//        // Create a RequestEntity with the DELETE method
//        RequestEntity<Void> requestEntity = new RequestEntity<>(HttpMethod.DELETE, uri);
//
//        // Execute the DELETE request and handle the response
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange( requestEntity, FakeStoreProductDto.class );
//        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//        return convertFakeToGeneric(fakeStoreProductDto);
    }

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

}

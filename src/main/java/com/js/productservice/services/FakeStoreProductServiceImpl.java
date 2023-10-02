//package com.js.productservice.services;
//
//import com.js.productservice.dtos.ProductDto;
//import com.js.productservice.exceptions.NotFoundException;
//import com.js.productservice.models.Category;
//import com.js.productservice.models.Price;
//import com.js.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
////@Primary
//@Service("fakeStoreProductServiceImpl")
//public class FakeStoreProductServiceImpl implements ProductService {
//
//    RestTemplateBuilder restTemplateBuilder;
//
//    String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
//    String createProductRequestUrl = "https://fakestoreapi.com/products/";
//
//    @Autowired
//    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplateBuilder = restTemplateBuilder;
//    }
//
//    @Override
//    public FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProductDto) {
//        System.out.println("Create Method Called");
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        // Build the URL for creating a new product
//        String url = createProductRequestUrl;
//
//        // Prepare the request entity
//        RequestEntity<FakeStoreProductDto> requestEntity = RequestEntity
//                .post(url)
//                .body(fakeStoreProductDto);
//
//        // Execute the request
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(requestEntity, FakeStoreProductDto.class);
//
//        // Check the response status code
//        if (response.getStatusCode().is2xxSuccessful()) {
//            // Request was successful, return the created product
//            return response.getBody();
//        } else {
//            // Handle other cases, e.g., 4xx client errors or unexpected errors
//            throw new RuntimeException("Error during product creation. Status code: " + response.getStatusCodeValue());
//        }
//    }
//
//    @Override
//    public List<FakeStoreProductDto> getAllProducts() {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
//        List<FakeStoreProductDto> fakeStoreProductDtoList = new ArrayList<>();
//        for (FakeStoreProductDto fakeStoreProductDto : response.getBody()) {
//            fakeStoreProductDtoList.add(fakeStoreProductDto);
//        }
//        return fakeStoreProductDtoList;
//    }
//
//    @Override
//    public FakeStoreProductDto getProductById(String id) throws NotFoundException {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);
//
//        FakeStoreProductDto fakeStoreProductDto = Optional.ofNullable(response.getBody())
//                .orElseThrow(() -> new NotFoundException("Product with ID: '" + id + "' not found."));
//
//        return fakeStoreProductDto;
//    }
//
//    @Override
//    public FakeStoreProductDto updateProduct(String id, FakeStoreProductDto fakeStoreProductDto) throws NotFoundException {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> productFound = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);
//        if (productFound.getBody() == null) {
//            throw new NotFoundException("Product with ID: " + id + " NOT FOUND. Update Failed.");
//        }
//
//        // Build the URL with the 'id' placeholder
//        String url = UriComponentsBuilder.fromUriString(getProductRequestUrl)
//                .buildAndExpand(id)  // This substitutes the 'id' variable in the URL
//                .toUriString();
//
//        // Prepare the request entity
//        RequestEntity<FakeStoreProductDto> requestEntity = RequestEntity
//                .put(url)
//                .body(fakeStoreProductDto);
//
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(requestEntity, FakeStoreProductDto.class);
//
//        // Check the response status code
//        if (response.getStatusCode().is2xxSuccessful()) {
//            // Request was successful
//            return response.getBody();
//        } else if (response.getStatusCode().is4xxClientError()) {
//            // Client error, possibly the product with the given ID does not exist
//            throw new NotFoundException("Product with ID: " + id + " NOT FOUND. Update Failed.");
//        } else {
//            // Other unexpected errors
//            throw new RuntimeException("Unexpected error during product update. Status code: " + response.getStatusCodeValue());
//        }
//    }
//
//    @Override
//    public String deleteProduct(String id) throws NotFoundException {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseBody = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);
//
//        if (responseBody.getBody() == null) {
//            throw new NotFoundException("Product with ID: " + id + " NOT FOUND. Deletion Failed.");
//        }
//
//        // Build the URL with the 'id' placeholder
//        String url = UriComponentsBuilder.fromUriString(getProductRequestUrl)
//                .buildAndExpand(id)  // This substitutes the 'id' variable in the URL
//                .toUriString();
//
//        // Prepare the request entity (for DELETE, the body can be null)
//        RequestEntity<Void> requestEntity = RequestEntity
//                .method(HttpMethod.DELETE, url)
//                .build();
//
//        // Execute the request
//        ResponseEntity<Void> response = restTemplate.exchange(requestEntity, Void.class);
//
//        // Check the response status code
//        if (response.getStatusCode().is2xxSuccessful()) {
//            // Request was successful
//            return "Product with ID: " + id + " deleted successfully.";
//        } else if (response.getStatusCode().is4xxClientError()) {
//            // Client error, possibly the product with the given ID does not exist
//            throw new NotFoundException("Product with ID: " + id + " NOT FOUND. Deletion Failed.");
//        } else {
//            // Other unexpected errors
//            throw new RuntimeException("Unexpected error during product deletion. Status code: " + response.getStatusCodeValue());
//        }
//    }
//
//    // helper function to map FakeStoreProductDto to ProductDto
//    private ProductDto mapFakeStoreToProductDto(FakeStoreProductDto fakeStoreProductDto) {
//        ProductDto productDto = new ProductDto();
//        productDto.setTitle(fakeStoreProductDto.getTitle());
//        productDto.setDescription(fakeStoreProductDto.getDescription());
//        productDto.setImage(fakeStoreProductDto.getImage());
//        // setting category object
//        Category category = new Category();
//        category.setName(fakeStoreProductDto.getCategory());
//        // setting price object
//        Price price = new Price();
//        price.setPrice(fakeStoreProductDto.getPrice());
//        productDto.setPrice(price);
//        return productDto;
//    }
//
//}

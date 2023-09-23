package com.js.productservice.repositories;

public interface CustomQueries {
    String findAllProductsQuery = "SELECT * FROM product";
    String deleteProductById = "DELETE FROM product WHERE id = :val";
}

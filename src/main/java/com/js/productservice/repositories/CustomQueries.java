package com.js.productservice.repositories;

public interface CustomQueries {
    String findAllProductsQuery = "SELECT * FROM product";
    String deleteProductById = "DELETE FROM product WHERE id = :val";
    String FIND_ALL_BY_TITLE = "select * from product join product_orders " +
            "on product.id = product_orders.product_id where title = :naman";


    String FIND_ALL_PRODUCTS_BY_CATEGORY = "SELECT Product.* " +
            "FROM Product " +
            "JOIN Category ON Product.category_id = Category.category_id" +
            "WHERE Category.category_name = 'Samsung Devices';";


}

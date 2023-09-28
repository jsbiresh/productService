package com.js.productservice.repositories;

import com.js.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, UUID> {


    // find product by id
    Optional<Product> findById(UUID id);

    // find by title
    Product findByTitleEquals(String title);

    // find by title and description
    Product findByTitleAndDescription(String title, String description);

    // find by title or description
    Product findByTitleOrDescription(String title, String description);


    // find all by title
    List<Product> findAllByTitle(String title);

    // find by title equals and price
    List<Product> findByTitleEqualsAndPrice_Price(String title, double price);

    // find all by price currency
    List<Product> findAllByPrice_Currency(String currency);

    // find product by description contains
    List<Product> findByDescriptionContains(String description);


//    // writing a custom query to find all products with a *
//    @Query(value = CustomQueries.findAllProductsQuery, nativeQuery = true)
//    List<Product> findAllByTitleCustom();

//    // writing a custom query to find all products with a specific title
//    @Query(value = "SELECT * FROM product join order_product" + " on product.id=order_product.product_id where title= :val", nativeQuery = true)
//    List<Product> findAllByTitleCustomJoinQuery(String val);

}




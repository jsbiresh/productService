package com.js.productservice.repositories;

import com.js.productservice.models.Category;
import com.js.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    List<Product> findAll();

    Product save(Product product);


    Optional<Product> findById(UUID id);

    Product findByTitleEquals(String title);

    Product findByTitleEqualsAndPrice_PriceOrderByPrice_price(String title, double price);

    List<Product> findAllByPrice_Currency(String currency);

    @Override
    void delete(Product entity);


    long countAllByPrice_Currency(String currency);


    List<Product> findAllByTitleLike(String titleRegex);

    List<Product> readAllByTitleLike(String titleRegex);


    List<Product> findAllByCategoryIn(List<Category> categories);

    //    @Query("select Product  from Product  where Product .category.uuid in :uuids")
//    List<Product> findAllByCategoryIn(List<UUID> uuids);


    @Query(value = CustomQueries.FIND_ALL_BY_TITLE, nativeQuery = true)
    List<Product> findAllByTitle(String naman);

//    @Query("select Product from Product where Product.price.currency = :currency and Product.title = :naman")
//    List<Product> doSomething(String naman, String currency);


//    // find product by id
//    Optional<Product> findById(UUID id);
//
//    // find by title
//    Product findByTitleEquals(String title);
//
//    // find by title and description
//    Product findByTitleAndDescription(String title, String description);
//
//    // find by title or description
//    Product findByTitleOrDescription(String title, String description);
//
//
//    // find all by title
//    List<Product> findAllByTitle(String title);
//
//    // find by title equals and price
//    List<Product> findByTitleEqualsAndPrice_Price(String title, double price);
//
//    // find all by price currency
//    List<Product> findAllByPrice_Currency(String currency);
//
//    // find product by description contains
//    List<Product> findByDescriptionContains(String description);


//    // writing a custom query to find all products with a *
//    @Query(value = CustomQueries.findAllProductsQuery, nativeQuery = true)
//    List<Product> findAllByTitleCustom();

//    // writing a custom query to find all products with a specific title
//    @Query(value = "SELECT * FROM product join order_product" + " on product.id=order_product.product_id where title= :val", nativeQuery = true)
//    List<Product> findAllByTitleCustomJoinQuery(String val);

}




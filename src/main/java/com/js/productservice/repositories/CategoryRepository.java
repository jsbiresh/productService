package com.js.productservice.repositories;

import com.js.productservice.models.Category;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Lazy
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Override
    Optional<Category> findById(UUID uuid);

    @Override
    List<Category> findAllById(Iterable<UUID> uuids);

//    List<ProductDto> findAllByCategoryIn(String category);

    // find all products from product table by category name
//    @Query(value = "SELECT * From Product WHERE category IN (SELECT id FROM Category WHERE name = :category)", nativeQuery = true)
//    List<ProductDto> findAllByCategoryIn(@Param("category") String category);


    @Query(value = "SELECT id FROM Product WHERE category IN (SELECT id FROM Category WHERE name = :category)", nativeQuery = true)
    List<String> findAllByCategoryIn(@Param("category") String category);

//    Optional<Category> findByName(String name);


    @Query("SELECT c FROM category c WHERE LOWER(c.name) = LOWER(:name)")
    Optional<Category> findByNameIgnoreCase(String name);


    // find category by name

//    Optional<String> findByNameIgnoreCase(String name);


//    @Query(value = "SELECT new com.js.productservice.dtos.ProductDto(p.id, p.name) FROM Product p WHERE p.category_id IN (SELECT id FROM Category WHERE name = :category)", nativeQuery = true)
//    List<ProductDto> findAllByCategoryIn(@Param("category") String category);


//    @Query(value = "SELECT p.id, p.name FROM Product p WHERE p.category_id IN (SELECT id FROM Category WHERE name = :category)", nativeQuery = true)
//    List<Object[]> findAllByCategoryIn(@Param("category") String category);

}
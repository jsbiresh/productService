package com.js.productservice.repositories;

import com.js.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository("selfProductRepository")
public interface SelfProductRepository extends JpaRepository<Product, UUID> {


    <S extends Product> S save(Product product);

    List<Product> findAll();

    Optional<Product> findById(UUID uuid);

    Optional<Product> updateById(Product product, UUID uuid);

    void deleteById(UUID uuid);


//    <S extends Product> S save(Product product);
//
//    Optional<Product> findById(UUID uuid);
//
//    List<Product> findAll();
//
//    Optional<Product> findByIdAndUpdate(Product product, UUID uuid);
//
//    void deleteById(UUID uuid);

}

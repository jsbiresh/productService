package com.js.productservice.repositories;

import com.js.productservice.dtos.GenericProductDto;
import com.js.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SelfProductRepository extends JpaRepository<Product, UUID> {

    //    @Override
    Optional<Product> findById(UUID uuid);

    <S extends Product> S save(GenericProductDto entity);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(UUID uuid);

}

package com.js.productservice.repositories;

import com.js.productservice.dtos.GenericProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<GenericProductDto, Long> {
}

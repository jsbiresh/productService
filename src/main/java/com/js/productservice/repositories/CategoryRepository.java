package com.js.productservice.repositories;

import com.js.productservice.models.Category;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Lazy
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Optional<Category> findById(UUID uuid);

//    Optional<Category> findById(String uuid);

    @Override
    List<Category> findAllById(Iterable<UUID> uuids);
}
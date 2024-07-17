package com.github.juli220620.repo;

import com.github.juli220620.model.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductInfoRepo extends JpaRepository<ProductInfoEntity, Integer> {

    Optional<ProductInfoEntity> findFirstByOrderByRatingDesc();
    Optional<ProductInfoEntity> findFirstByOrderByPriceDesc();
    Optional<ProductInfoEntity> findFirstByOrderByPriceAsc();

}

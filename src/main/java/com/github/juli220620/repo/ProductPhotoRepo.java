package com.github.juli220620.repo;

import com.github.juli220620.model.ProductPhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPhotoRepo extends JpaRepository<ProductPhotoEntity, Integer> {
}

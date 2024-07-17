package com.github.juli220620.model;

import com.github.juli220620.model.id.ProductFeatureId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_feature")
public class ProductFeatureEntity {
    @EmbeddedId
    private ProductFeatureId id;
}

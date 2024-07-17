package com.github.juli220620.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProductFeatureId implements Serializable {
    private String feature;

    @Column(name = "product_id", insertable = false, updatable = false)
    private int productId;
}

package com.github.juli220620.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "product_info")
public class ProductInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String brand;
    private String model;
    private int quantityAvailable;
    private String weight;
    private double rating;
    private String category;
    private String description;
    private String colour;
    private double price;
    private String warranty;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private List<ProductFeatureEntity> features;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private List<ProductPhotoEntity> photos;
}

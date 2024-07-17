package com.github.juli220620.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_photo")
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhotoEntity {
    private byte[] data;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}

package com.github.juli220620.utils;

import com.github.juli220620.model.ProductFeatureEntity;
import com.github.juli220620.model.ProductInfoEntity;
import com.github.juli220620.model.ProductPhotoEntity;
import com.github.juli220620.model.dto.ProductCardDto;
import com.github.juli220620.model.dto.ProductPhotoDto;
import com.github.juli220620.model.id.ProductFeatureId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductInfoEntityAssembler {

    //Реализация через дефолтный конструктор и сеттеры для удобства изменения состава полей
    public ProductInfoEntity assemble(ProductInfoEntity entity, ProductCardDto data) {
        entity.setId(data.getId());
        entity.setName(data.getName());
        entity.setBrand(data.getBrand());
        entity.setModel(data.getModel());
        entity.setQuantityAvailable(data.getQuantityAvailable());
        entity.setWeight(data.getWeight());
        entity.setRating(data.getRating());
        entity.setCategory(data.getCategory());
        entity.setColour(data.getColor());
        entity.setPrice(data.getPrice());
        entity.setWarranty(data.getWarranty());

        entity.getFeatures().clear();
        entity.getFeatures().addAll(
                data.getFeatures().stream()
                        .map(it -> new ProductFeatureId(it, entity.getId()))
                        .map(ProductFeatureEntity::new)
                        .toList()
        );

        return entity;
    }

    public ProductCardDto disassemble(ProductInfoEntity entity) {
        var data = new ProductCardDto();

        data.setId(entity.getId());
        data.setName(entity.getName());
        data.setBrand(entity.getBrand());
        data.setModel(entity.getModel());
        data.setQuantityAvailable(entity.getQuantityAvailable());
        data.setWeight(entity.getWeight());
        data.setRating(entity.getRating());
        data.setCategory(entity.getCategory());
        data.setColor(entity.getColour());
        data.setPrice(entity.getPrice());
        data.setDescription(entity.getDescription());
        data.setWarranty(entity.getWarranty());

        data.setPhotos(
                entity.getPhotos().stream()
                    .map(it -> new ProductPhotoDto(it.getId(), it.getName(), getPhotoUrl(it)))
                    .collect(Collectors.toList())
        );

        data.setFeatures(
                entity.getFeatures().stream()
                        .map(it -> it.getId().getFeature())
                        .collect(Collectors.toList())
        );

        return data;
    }

    private String getPhotoUrl(ProductPhotoEntity it) {
        return String.format("/api/photo/%d", it.getId());
    }

}

package com.github.juli220620.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCardDto {

    //id добавлено для облечения операций с КОНКРЕТНОЙ карточкой. А не с НАЙДЕННОЙ по каким-то полям
    //Если его не добавить в дто, то фронт не сможет общаться с нами на уровне КОНКРЕТНЫХ записей
    private Integer id;

    private String name;
    private String description;
    private double price; //В реальном приложении использовала бы BigDecimal для денег, но здесь решила не париться
    private String color;
    private String brand;
    private String category;
    private String model;
    private int quantityAvailable; //Вместо поля availability, очевидно, так больше ситуаций описать можно
    private double rating;
    private String weight;
    private String warranty;

    @JsonProperty("special_features")
    private List<String> features;
    private List<ProductPhotoDto> photos;
}

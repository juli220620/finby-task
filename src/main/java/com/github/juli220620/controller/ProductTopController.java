package com.github.juli220620.controller;

import com.github.juli220620.model.dto.ProductCardDto;
import com.github.juli220620.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/top")
@RequiredArgsConstructor
public class ProductTopController {

    private final ProductInfoService service;

    @GetMapping("/highPrice")
    public ProductCardDto topPrice() {
        return service.getMostExpensiveProduct().orElse(null);
    }

    @GetMapping("/lowPrice")
    public ProductCardDto botPrice() {
        return service.getLeastExpensiveProduct().orElse(null);
    }

    @GetMapping("/rating")
    public ProductCardDto topRating() {
        return service.getBestRatingProduct().orElse(null);
    }
}

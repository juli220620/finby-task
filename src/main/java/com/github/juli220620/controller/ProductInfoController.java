package com.github.juli220620.controller;

import com.github.juli220620.model.dto.ProductCardDto;
import com.github.juli220620.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductInfoController {

    private final ProductInfoService service;

    @PostMapping
    public int addNewProductCard(@RequestBody ProductCardRq rq) {
        return service.addProduct(rq.product);
    }

    @PutMapping
    public void updateProductCard(@RequestBody ProductCardRq rq) {
        service.updateProduct(rq.product);
    }

    @GetMapping("/{productId}")
    public ProductCardDto getProductCardById(@PathVariable int productId) {
        return service.getProductCard(productId).orElseThrow();
    }

    @DeleteMapping("/{productId}")
    public void deleteProductCard(@PathVariable int productId) {
        service.deleteProductCard(productId);
    }

    public record ProductCardRq(ProductCardDto product){}
}

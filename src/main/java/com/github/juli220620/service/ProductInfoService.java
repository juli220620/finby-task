package com.github.juli220620.service;

import com.github.juli220620.model.ProductInfoEntity;
import com.github.juli220620.model.dto.ProductCardDto;
import com.github.juli220620.repo.ProductInfoRepo;
import com.github.juli220620.utils.ProductInfoEntityAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductInfoService {

    private final ProductInfoRepo repo;
    private final ProductInfoEntityAssembler assembler;

    public Optional<ProductCardDto> getBestRatingProduct() {
        return repo.findFirstByOrderByRatingDesc().map(assembler::disassemble);
    }

    public Optional<ProductCardDto> getMostExpensiveProduct() {
        return repo.findFirstByOrderByPriceDesc().map(assembler::disassemble);
    }

    public Optional<ProductCardDto> getLeastExpensiveProduct() {
        return repo.findFirstByOrderByPriceAsc().map(assembler::disassemble);
    }

    public int addProduct(ProductCardDto data) {
        var entity = assembler.assemble(new ProductInfoEntity(), data);
        updateDescription(entity);
        return repo.save(entity).getId();
    }

    public void updateProduct(ProductCardDto dto) {
        var entity = repo.findById(dto.getId()).orElseThrow();
        assembler.assemble(entity, dto);
        updateDescription(entity);
        repo.save(entity);
    }

    public void deleteProductCard(int productId) {
        repo.deleteById(productId);
    }

    public Optional<ProductCardDto> getProductCard(int id) {
        return repo.findById(id).map(assembler::disassemble);
    }

    private void updateDescription(ProductInfoEntity entity) {
        var features = entity.getFeatures().stream()
                .map(it -> it.getId().getFeature())
                .collect(Collectors.joining(", "));

        var description = String.format("%s %s, %s, %s.",
                entity.getName(), entity.getBrand(), entity.getColour(), features);

        entity.setDescription(description);
    }
}

package com.github.juli220620.service;

import com.github.juli220620.model.ProductPhotoEntity;
import com.github.juli220620.repo.ProductInfoRepo;
import com.github.juli220620.repo.ProductPhotoRepo;
import com.github.juli220620.utils.PhotoProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductPhotoService {
    private final ProductInfoRepo cardRepo;
    private final ProductPhotoRepo photoRepo;
    private final PhotoProcessor photoProcessor;

    @Transactional
    public void attach(int productId, String name, byte[] data) {
        var processedImageData = photoProcessor.removeBackground(data);

        var product = cardRepo.findById(productId).orElseThrow();
        var photo = new ProductPhotoEntity(processedImageData, name, null);

        product.getPhotos().add(photo);
        cardRepo.save(product);
    }

    public void detach(int photoId) {
        photoRepo.deleteById(photoId);
    }

    public Optional<byte[]> getBytes(int id) {
        return photoRepo.findById(id).map(ProductPhotoEntity::getData);
    }
}

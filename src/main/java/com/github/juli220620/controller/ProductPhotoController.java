package com.github.juli220620.controller;

import com.github.juli220620.service.ProductPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/photo")
public class ProductPhotoController {
    private final ProductPhotoService photoService;

    @PostMapping()
    public void attachPhoto(@RequestParam("photo") MultipartFile photo,
                            @RequestParam("name") String name,
                            @RequestParam("productId") int productId) {
        try {
            photoService.attach(productId, name, photo.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Без проверок соответсвия id карточки и id фото,
    //подразумевая, что проверка уже сделана до момента запроса
    @DeleteMapping("/{id}")
    public void detachPhoto(@PathVariable int id) {
        photoService.detach(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getPhoto(@PathVariable int id) {
        return new ByteArrayResource(photoService.getBytes(id).orElseThrow());
    }
}

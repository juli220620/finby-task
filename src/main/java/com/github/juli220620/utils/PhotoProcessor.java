package com.github.juli220620.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

@Component

public class PhotoProcessor {
    private static final String BACKGROUND_REMOVE_URL = "https://api.remove.bg/v1.0/removebg";

    @Value("${app.bg-remove.api-key}")
    private String apiKey;

    public byte[] removeBackground(byte[] originalPhoto) {
        RestClient client = RestClient.builder()
                .baseUrl(BACKGROUND_REMOVE_URL)
                .defaultHeader("X-Api-Key", apiKey)
                .build();

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("image_file", originalPhoto);
        parts.add("size", "auto");

        return client.post()
                .body(parts)
                .retrieve()
                .body(byte[].class);
    }
}

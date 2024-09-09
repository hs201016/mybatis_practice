package com.example.dev_coffee.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDTO {
    private byte[] productId;
    private String productName;
    private String category;
    private long price;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

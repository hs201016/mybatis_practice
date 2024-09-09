package com.example.dev_coffee.service;

import com.example.dev_coffee.dto.ProductDTO;
import com.example.dev_coffee.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


/**
 * 상품 서비스를 관리하는 클래스
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    @Transactional
    public void addProduct(@RequestBody ProductDTO product) {
        product.setProductId(uuidToBytes(UUID.randomUUID()));
        product.setCreatedAt(setCurrentDate());

        productMapper.insert(product);
    }

    @Transactional
    public ProductDTO updateProduct(ProductDTO product) {
        product.setUpdatedAt(setCurrentDate());
        productMapper.update(product);
        return product;
    }


    @Transactional
    public List<ProductDTO> readAllProduct() {
        return productMapper.findAll();
    }

    @Transactional
    public void deleteProductById(byte[] id) {
        productMapper.delete(id);
    }

    // 날짜 시간 메소드
    public LocalDateTime setCurrentDate() {
        return LocalDateTime.now();
    }

    private static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }
}

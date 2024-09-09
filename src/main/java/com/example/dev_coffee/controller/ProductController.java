package com.example.dev_coffee.controller;

import com.example.dev_coffee.dto.ProductDTO;
import com.example.dev_coffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/read")
    public ResponseEntity<List<ProductDTO>> readProduct() {
        List<ProductDTO> products = productService.readAllProduct();
        if (products != null && !products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/update")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDTO product) {
        try {
            productService.updateProduct(product);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestParam("productId") String productId) {
        try {
            byte[] decodeId = Base64.getDecoder().decode(productId);
            productService.deleteProductById(decodeId); // 디코딩된 byte[]를 전달
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

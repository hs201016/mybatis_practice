package com.example.dev_coffee.mapper;

import com.example.dev_coffee.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDTO findById(byte[] productId);
    List<ProductDTO> findAll();
    void insert(ProductDTO product);
    void update(ProductDTO product);
   void delete(@Param("productId") byte[] productId);

}

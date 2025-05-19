package com.app.ecom.dto;

import com.app.ecom.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemResponse {
    private Product product;
    private Integer quantity;
    private BigDecimal price;
}

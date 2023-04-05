package com.rest.demo.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private short amount;
    private Long categoryID;
}

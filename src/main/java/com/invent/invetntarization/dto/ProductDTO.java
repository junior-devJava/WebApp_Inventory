package com.invent.invetntarization.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private int id;
    private String name;
    private String location;
    private String responsible;
    private String serial_number;
    private int categoryId;
}

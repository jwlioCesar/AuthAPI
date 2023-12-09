package com.authAPI.AuthAPI.dto.response;

import java.util.UUID;

public class ProductResponseRegisterDTO {

    private UUID id;
    private String name;
    private String price;

    public ProductResponseRegisterDTO(UUID id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


}

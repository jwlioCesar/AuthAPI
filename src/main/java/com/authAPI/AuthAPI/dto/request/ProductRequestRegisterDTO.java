package com.authAPI.AuthAPI.dto.request;

public class ProductRequestRegisterDTO {

    private String name;
    private String price;

    public ProductRequestRegisterDTO(String name, String price) {
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

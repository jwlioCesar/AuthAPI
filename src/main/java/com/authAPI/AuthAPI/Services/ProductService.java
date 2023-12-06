package com.authAPI.AuthAPI.Services;

import com.authAPI.AuthAPI.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.authAPI.AuthAPI.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<ProductModel> getOneProduct(UUID id){
        return productRepository.findById(id);
    }

}

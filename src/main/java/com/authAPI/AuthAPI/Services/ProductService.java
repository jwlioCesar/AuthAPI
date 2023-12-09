package com.authAPI.AuthAPI.Services;

import com.authAPI.AuthAPI.dto.request.ProductRequestRegisterDTO;
import com.authAPI.AuthAPI.dto.response.ProductResponseRegisterDTO;
import com.authAPI.AuthAPI.models.ProductModel;
import com.authAPI.AuthAPI.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ProductModel> getOneProduct(UUID id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductResponseRegisterDTO addProduct(ProductRequestRegisterDTO request) {
        ProductModel entity = productRepository.save(new ProductModel(request.getName(), request.getPrice()));
        return new ProductResponseRegisterDTO(entity.getId(), entity.getName(), entity.getPrice());
    }

}

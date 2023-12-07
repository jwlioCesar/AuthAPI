package com.authAPI.AuthAPI.controllers;

import com.authAPI.AuthAPI.Services.ProductService;
import com.authAPI.AuthAPI.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        List<ProductModel> productList = productService.getAllProducts();

        if (productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable UUID id){
        if (productService.getOneProduct(id).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(productService.getOneProduct(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto com id '"+id+"' não cadastrado");
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable UUID id){
        if (productService.getOneProduct(id).isPresent()){
            productService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("produto deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto com id '"+id+"' não cadastrado");
        }
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(){

    }


}

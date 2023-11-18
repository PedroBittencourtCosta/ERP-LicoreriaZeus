package com.licoreriaZeus.ERPLicoreria.controller;

import com.licoreriaZeus.ERPLicoreria.model.ProductDTO;
import com.licoreriaZeus.ERPLicoreria.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> postProduct(@RequestBody @Valid ProductDTO data){

        ProductDTO newProduct = service.createProduct(data);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(newProduct);
    }
}

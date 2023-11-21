package com.licoreriaZeus.ERPLicoreria.controller;

import com.licoreriaZeus.ERPLicoreria.model.ProductDTO;
import com.licoreriaZeus.ERPLicoreria.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(service.getAllProducts());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String name){

        ProductDTO productDTO = service.getProduct(name);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productDTO);
    }

    @PutMapping("/{name}")
    public ResponseEntity<ProductDTO> putProduct(@PathVariable String name, @RequestBody @Valid ProductDTO data){

        ProductDTO productDTO = service.alterProduct(name, data);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productDTO);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteProduct(@PathVariable String name){

        service.deleteProduct(name);
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
    }
}

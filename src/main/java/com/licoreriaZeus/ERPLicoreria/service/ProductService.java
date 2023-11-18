package com.licoreriaZeus.ERPLicoreria.service;

import com.licoreriaZeus.ERPLicoreria.model.Product;
import com.licoreriaZeus.ERPLicoreria.model.ProductDTO;
import com.licoreriaZeus.ERPLicoreria.model.exception.ProductAlreadyExistsException;
import com.licoreriaZeus.ERPLicoreria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    public ProductDTO createProduct(ProductDTO data){

        Optional<Product> byName = repository.findByName(data.name());

        if(byName.isPresent()) throw new ProductAlreadyExistsException("Product already registered");

        repository.save(new Product(data));
        return data;
    }
}

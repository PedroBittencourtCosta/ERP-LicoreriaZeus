package com.licoreriaZeus.ERPLicoreria.service;

import com.licoreriaZeus.ERPLicoreria.model.Product;
import com.licoreriaZeus.ERPLicoreria.model.ProductDTO;
import com.licoreriaZeus.ERPLicoreria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO createProduct(ProductDTO data){

        repository.save(new Product(data));

        return data;
    }
}

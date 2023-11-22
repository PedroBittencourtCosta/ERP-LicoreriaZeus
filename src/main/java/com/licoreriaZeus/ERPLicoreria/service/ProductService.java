package com.licoreriaZeus.ERPLicoreria.service;

import com.licoreriaZeus.ERPLicoreria.model.Product;
import com.licoreriaZeus.ERPLicoreria.model.ProductDTO;
import com.licoreriaZeus.ERPLicoreria.model.exception.ProductAlreadyExistsException;
import com.licoreriaZeus.ERPLicoreria.model.exception.ProductNotExistsException;
import com.licoreriaZeus.ERPLicoreria.model.exception.SubTypeNotExistsException;
import com.licoreriaZeus.ERPLicoreria.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO createProduct(ProductDTO data){

       if(repository.findByName(data.getName()).isPresent())
           throw new ProductAlreadyExistsException("Product already exists");

       repository.save(new Product(data));
       return data;
    }

    public List<ProductDTO> getAllProducts(){

        List<Product> allProducts = repository.findAll();

        return allProducts.stream().map(ProductDTO::new).toList();

    }

    public ProductDTO getProduct(String name){

        Optional<Product> byName = repository.findByName(name);

        if(byName.isEmpty()) throw new ProductNotExistsException("Product not exists");

        return new ProductDTO(byName.get());
    }

    public ProductDTO alterProduct(String name, ProductDTO data){

        Optional<Product> byName = repository.findByName(name);

        if(byName.isEmpty()) throw new ProductNotExistsException("Product not exists");

        BeanUtils.copyProperties(data, byName.get());

        Product product = repository.save(byName.get());

        return new ProductDTO(product);

    }

    public void  deleteProduct(String name){

        Optional<Product> product = repository.findByName(name);

        if(product.isEmpty()) throw new ProductNotExistsException("Product not exists");

        repository.delete(product.get());

    }

    public List<ProductDTO> getAllBySubType(String subType) {

        Optional<List<Product>> bySubTypeProduct = repository.findAllBySubTypeProduct(subType);

        if (bySubTypeProduct.isEmpty()) throw new SubTypeNotExistsException("SubType not exists");

        List<Product> list = bySubTypeProduct.get();

        return list.stream().map(ProductDTO::new).toList();
    }
}

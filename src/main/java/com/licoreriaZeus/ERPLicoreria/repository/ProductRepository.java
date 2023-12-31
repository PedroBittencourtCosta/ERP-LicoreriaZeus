package com.licoreriaZeus.ERPLicoreria.repository;

import com.licoreriaZeus.ERPLicoreria.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findByName(String name);

    Optional<List<Product>> findAllBySubTypeProduct(String subTypeProduct);
}

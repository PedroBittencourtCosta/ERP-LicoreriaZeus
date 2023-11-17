package com.licoreriaZeus.ERPLicoreria.repository;

import com.licoreriaZeus.ERPLicoreria.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}

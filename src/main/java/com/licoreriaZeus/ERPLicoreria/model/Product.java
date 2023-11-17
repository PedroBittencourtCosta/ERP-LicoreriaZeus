package com.licoreriaZeus.ERPLicoreria.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer amount;
    private String typeProduct;
    private String subTypeProduct;
    private BigDecimal salePrice;
    private BigDecimal purchasePrice;
    private String imageUrl;
    private Integer netWeight;

    public Product(ProductDTO data) {
        this.name = data.name();
        this.amount = data.amount();
        this.typeProduct = data.typeProduct();
        this.subTypeProduct = data.subTypeProduct();
        this.salePrice = data.salePrice();
        this.purchasePrice = data.purchasePrice();
        this.imageUrl = data.imageUrl();
        this.netWeight = data.netWeight();
    }
}

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

}

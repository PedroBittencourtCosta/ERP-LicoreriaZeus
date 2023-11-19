package com.licoreriaZeus.ERPLicoreria.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotBlank
    private String name;

    @NotNull @PositiveOrZero
    private Integer amount;

    @NotBlank
    private String typeProduct;

    @NotBlank
    private String subTypeProduct;

    @NotNull @DecimalMin(value = "0.01")
    private BigDecimal salePrice;

    @NotBlank
    private String imageUrl;

    @NotNull @Positive
    private Integer netWeight;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.amount = product.getAmount();
        this.typeProduct = product.getTypeProduct();
        this.subTypeProduct = product.getSubTypeProduct();
        this.salePrice = product.getSalePrice();
        this.imageUrl = product.getImageUrl();
        this.netWeight = product.getNetWeight();
    }
}
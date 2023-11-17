package com.licoreriaZeus.ERPLicoreria.model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDTO(
        @NotBlank String name,
        @NotNull @PositiveOrZero Integer amount,
        @NotBlank String typeProduct,
        @NotNull @DecimalMin (value = "0.01") BigDecimal salePrice,
        @NotNull @DecimalMin (value = "0.01") BigDecimal purchasePrice,
        @NotBlank String imageUrl,
        @NotNull @Positive Integer netWeight){}
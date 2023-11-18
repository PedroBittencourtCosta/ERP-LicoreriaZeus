package com.licoreriaZeus.ERPLicoreria.model.exception;

public class ProductNotExistsException extends RuntimeException{

    public ProductNotExistsException(String message){
        super(message);
    }
}

package com.licoreriaZeus.ERPLicoreria.model.exception;

public class ProductAlreadyExistsException extends RuntimeException{

    public ProductAlreadyExistsException(String message){
        super(message);
    }
}

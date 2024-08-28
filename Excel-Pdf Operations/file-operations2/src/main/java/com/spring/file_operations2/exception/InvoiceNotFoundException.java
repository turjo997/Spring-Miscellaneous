package com.spring.file_operations2.exception;

public class InvoiceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;


    public InvoiceNotFoundException(){
        super();
    }

    public InvoiceNotFoundException(String message){
        super(message);
    }

}

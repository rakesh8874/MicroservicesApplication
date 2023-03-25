package com.hotelservicedemo.hotelservice.exception;

public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
    public ResourceNotFoundException(){
        super("Resource Not Found On server  !! ");
    }
}

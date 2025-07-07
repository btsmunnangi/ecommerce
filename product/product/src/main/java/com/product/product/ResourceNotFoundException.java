package com.product.product;

public class ResourceNotFoundException extends RuntimeException{
	static final Long serialVersionUID=1L;
    public ResourceNotFoundException(String message) {
	     super(message);
   }
}

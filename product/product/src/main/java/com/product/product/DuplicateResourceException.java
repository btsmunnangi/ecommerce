package com.product.product;

public class DuplicateResourceException extends RuntimeException{
	static final Long serialVersionUID=1L;
	public DuplicateResourceException(String message) {
		super(message);
	}
}

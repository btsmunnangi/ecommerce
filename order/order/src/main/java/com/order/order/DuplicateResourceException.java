package com.order.order;

public class DuplicateResourceException extends RuntimeException{
	static final Long serialVersionUID=1L;
	public DuplicateResourceException(String message) {
		super(message);
	}
}

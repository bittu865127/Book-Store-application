package com.bookstore.validation;

public interface Validation<T> {
	boolean validate(T obj);
}

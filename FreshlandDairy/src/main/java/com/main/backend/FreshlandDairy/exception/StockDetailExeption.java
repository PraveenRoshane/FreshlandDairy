package com.main.backend.FreshlandDairy.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockDetailExeption extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public StockDetailExeption(String message) {
		super(message);
		
	}
}

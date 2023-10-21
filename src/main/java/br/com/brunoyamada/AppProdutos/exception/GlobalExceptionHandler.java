package br.com.brunoyamada.AppProdutos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandler {
	
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}

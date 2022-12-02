package com.ty.hospital_app.Exception;

public class NoSuchIdFoundException extends RuntimeException{
	private String message= "No Such Id Found";

	
	public NoSuchIdFoundException(String message) {
		this.message = message;
	}
	
	public NoSuchIdFoundException() {
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	

}

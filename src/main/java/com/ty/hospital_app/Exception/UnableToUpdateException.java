package com.ty.hospital_app.Exception;

public class UnableToUpdateException extends RuntimeException {

	String message = "No Id Found to Update";

	@Override
	public String getMessage() {

		return message;
	}

	public UnableToUpdateException(String message) {
		this.message = message;
	}

	public UnableToUpdateException() {
	}

}

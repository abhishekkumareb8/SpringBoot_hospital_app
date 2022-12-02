package com.ty.hospital_app.excepton_handler;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.Exception.UnableToUpdateException;
import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<Hospital>> noSuchIdFoundException(NoSuchIdFoundException exception) {
		ResponseStructure responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<>(responseStructure,
				HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("no such id found");
		responseStructure.setData(exception.getMessage());

		return entity;

	}

	@ExceptionHandler(UnableToUpdateException.class)
	public ResponseEntity<ResponseStructure<Hospital>> unableToUpdateException(UnableToUpdateException exception) {
		ResponseStructure responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Hospital>> entity = new ResponseEntity<>(responseStructure,
				HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("no id found to update");
		responseStructure.setData(exception.getMessage());
		return entity;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		for(ObjectError error : errors) {
			String message =error.getDefaultMessage();
			String fieldaName = ((FieldError)error).getField();
			map.put( fieldaName,message);
		}
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("no proper ipnut");
		responseStructure.setData(map);

		return new  ResponseEntity<> (responseStructure,HttpStatus.BAD_REQUEST); 
	}

}

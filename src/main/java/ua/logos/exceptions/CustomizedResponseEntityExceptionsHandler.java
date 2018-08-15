package ua.logos.exceptions;

import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ua.logos.exceptions.models.BookNotFoundException;
import ua.logos.exceptions.models.ExceptonResponse;

@ControllerAdvice

public class CustomizedResponseEntityExceptionsHandler extends ResponseEntityExceptionHandler{

//	@ExceptionHandler(BookNotFoundException.class)
//	public final ResponseEntity<ExceptonResponse> handlerBookNotFoundException(BookNotFoundException e, HttpServletRequest request){
//		ExceptonResponse exceptonResponse = new ExceptonResponse(new Date(), e.getMessage(), request.getRequestURI());
//		return new ResponseEntity<ExceptonResponse>(exceptonResponse, HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptonResponse> handlerException (BookNotFoundException e, HttpServletRequest request){
		ExceptonResponse exceptonResponse = new ExceptonResponse(new Date(), "error", request.getRequestURI());
		return new ResponseEntity<ExceptonResponse>(exceptonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}

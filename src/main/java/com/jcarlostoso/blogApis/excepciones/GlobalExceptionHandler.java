/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcarlostoso.blogApis.excepciones;

import com.jcarlostoso.blogApis.dto.ErrorDetalles;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author bynot
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetalles> manejarResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BlogAppException.class)
	public ResponseEntity<ErrorDetalles> manejarBlogAppException(BlogAppException exception,WebRequest webRequest){
		ErrorDetalles errorDetalles = new ErrorDetalles(new Date(),exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetalles,HttpStatus.BAD_REQUEST);
	}
        
    	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetalles> manejarGlobalException(Exception exception,WebRequest webRequest){
		ErrorDetalles errorDetalles = new ErrorDetalles(new Date(),exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetalles,HttpStatus.INTERNAL_SERVER_ERROR);
	}
        
}

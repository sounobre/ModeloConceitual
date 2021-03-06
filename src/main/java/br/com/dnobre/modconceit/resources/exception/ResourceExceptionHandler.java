/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.resources.exception;

import br.com.dnobre.modconceit.services.exceptions.DataIntegrityException;
import br.com.dnobre.modconceit.services.exceptions.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author souno
 */
@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
            HttpServletRequest request){
    
    StandardError err = new StandardError(HttpStatus.NOT_FOUND.value() 
            , e.getMessage(), System.currentTimeMillis());
    
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
}
    
    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e,
            HttpServletRequest request){
        
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage()
                , System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
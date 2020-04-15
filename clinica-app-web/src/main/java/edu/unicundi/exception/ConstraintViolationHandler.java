/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
@Provider
public class ConstraintViolationHandler implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException e) {
        Response.Status responseCode = Response.Status.BAD_REQUEST;
        String path = "Buscando.....";
        String message = prepareMessage(e);
        ExceptionWrapper wrraper  = new ExceptionWrapper(responseCode.getStatusCode(), responseCode.getReasonPhrase()
                , message, path); 
        return Response.status(responseCode).entity(wrraper).build();
    }
    
     private String prepareMessage(ConstraintViolationException exception) {
        String msg = "";
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            msg+=cv.getPropertyPath()+" "+cv.getMessage()+"\n";
        }
        return msg;
    }    
    
}
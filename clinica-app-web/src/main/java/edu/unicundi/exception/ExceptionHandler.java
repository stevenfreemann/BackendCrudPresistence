/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        e.printStackTrace();
        Response.Status responseCode;
        String message = e.getMessage();
        String path = "Buscando";
        
        if (e instanceof NotFoundModelException) {
            responseCode = Response.Status.NOT_FOUND;
        } else if (e instanceof NotFoundException) {
            responseCode = Response.Status.NOT_FOUND;
        } else if (e instanceof java.text.ParseException) {
            responseCode = Response.Status.NOT_IMPLEMENTED;
        }else if (e instanceof BadRequestException) {
            responseCode = Response.Status.BAD_REQUEST;
        } else if (e instanceof WebApplicationException) {
            WebApplicationException realException = (WebApplicationException) e;
            int response = realException.getResponse().getStatus();
            responseCode = Response.Status.fromStatusCode(response);
        }  else if (e instanceof ObjetcRequiredException) {
            responseCode = Response.Status.BAD_REQUEST;
        }else {
            responseCode = Response.Status.INTERNAL_SERVER_ERROR;
        }        
        ExceptionWrapper wrraper = new ExceptionWrapper(responseCode.getStatusCode(), responseCode.getReasonPhrase()
                , message, path);        
        return Response.status(responseCode).entity(wrraper).build();

    }
    

     private String prepareMessage(ConstraintViolationException exception) {
        String msg = "";
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            msg+=cv.getPropertyPath() + " " + cv.getMessage() + "\n";
        }
        return msg;
    }    
    
}


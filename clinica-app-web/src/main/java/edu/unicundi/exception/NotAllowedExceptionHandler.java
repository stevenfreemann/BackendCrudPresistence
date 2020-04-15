/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author ASUS-PC
 */
public class NotAllowedExceptionHandler implements ExceptionMapper<NotAllowedException> {

    @Override
    public Response toResponse(NotAllowedException e) {
         Response.Status responseCode = Response.Status.METHOD_NOT_ALLOWED;
        String path = "Buscando.....";
        String message = e.getMessage();
        ExceptionWrapper wrraper  = new ExceptionWrapper(responseCode.getStatusCode(), responseCode.getReasonPhrase()
                , message, path);                         
        return Response.status(responseCode).entity(wrraper).build();
    }

}

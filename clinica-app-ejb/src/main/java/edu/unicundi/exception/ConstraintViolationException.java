/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception;

import javax.validation.ValidationException;

/**
 *
 * @author Steven
 */
public class ConstraintViolationException extends ValidationException {
      private static final long serialVersionUID = 1L;

    public ConstraintViolationException(String mensaje) {
        super(mensaje);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception;

/**
 *
 * @author ASUS-PC
 */
public class ObjetcRequiredException extends Exception {

    private static final long serialVersionUID = 1L;

    public ObjetcRequiredException(String mensaje) {
        super(mensaje);
    }

}

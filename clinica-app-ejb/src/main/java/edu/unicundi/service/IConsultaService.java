/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service;

import edu.unicundi.entity.Consulta;
import edu.unicundi.exception.ConstraintViolationException;
import edu.unicundi.exception.NotFoundModelException;
import edu.unicundi.exception.ObjetcRequiredException;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author ASUS-PC
 */
@Local
public interface IConsultaService {
    
    public List<Consulta> listarTodos();
    
    public Consulta listar(int id) throws NotFoundModelException;   
    
    public void guardar(Consulta consulta) throws java.text.ParseException, ObjetcRequiredException;
    
    public void eliminar(int id) throws NotFoundModelException;
    
    public void editar(Consulta consulta) throws NotFoundModelException,java.text.ParseException, ObjetcRequiredException;    
    
}

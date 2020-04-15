/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service;

import edu.unicundi.dto.DetalleConsultaDto;
import edu.unicundi.entity.DetalleConsulta;
import edu.unicundi.exception.NotFoundModelException;
import edu.unicundi.exception.ObjetcRequiredException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ASUS-PC
 */
@Local
public interface IDetalleConsultaService {
    
    public List<DetalleConsulta> listarTodos();
    
    public DetalleConsultaDto listar(int id) throws NotFoundModelException;   
    
    public void guardar(DetalleConsulta detalleConsulta) throws ObjetcRequiredException, NotFoundModelException;
    
    public void eliminar(int id)  throws NotFoundModelException;
    
    public void editar(DetalleConsulta detalleConsulta)throws NotFoundModelException;        
    
}

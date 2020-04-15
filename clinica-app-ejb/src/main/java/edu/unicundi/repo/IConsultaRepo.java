/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo;

import edu.unicundi.entity.Consulta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ASUS-PC
 */
@Local
public interface IConsultaRepo {
    
    public List<Consulta> listarTodos();
    
    public Consulta listar(int id);   
    
    public void guardar(Consulta consulta);
    
    public void eliminar(Consulta consulta);
    
    public void editar(Consulta consulta);
    
}

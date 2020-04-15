/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service.imp;

import edu.unicundi.dto.ConsultaDto;
import edu.unicundi.entity.Consulta;
import edu.unicundi.entity.DetalleConsulta;
import edu.unicundi.exception.ConstraintViolationException;
import edu.unicundi.exception.NotFoundModelException;
import edu.unicundi.exception.ObjetcRequiredException;
import edu.unicundi.exception.ParseException;
import edu.unicundi.repo.IConsultaRepo;
import edu.unicundi.service.IConsultaService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;



/**
 *
 * @author ASUS-PC
 */
@Stateless
public class ConsultaServiceImp implements IConsultaService {
    
    @EJB
    private IConsultaRepo repo;

    @Override
    public List<Consulta> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public Consulta listar(int id) throws NotFoundModelException {
        Consulta consulta = repo.listar(id);
        if (consulta == null) {
            throw new NotFoundModelException("Objeto consulta no encontrado");
        }

        Consulta consultaAux = new Consulta();
        consultaAux.setId(consulta.getId());
        for (DetalleConsulta dc : consulta.getDetalleConsulta()) {
            dc.setConsulta(consultaAux);
        }
        return consulta;
    }

    @Override
    public void guardar(Consulta consulta) throws java.text.ParseException, ObjetcRequiredException{
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("MM/dd/yyyy");
        Date fechaRecibida = formateador.parse(consulta.getFecha());
        if(fechaActual.before(fechaRecibida)){
            throw new ObjetcRequiredException("La fecha tiene que ser menor a la actual");
        }
        if (consulta.getDetalleConsulta() != null) {
            for (DetalleConsulta dc : consulta.getDetalleConsulta()) {
                dc.setConsulta(consulta);
            }
        }
        repo.guardar(consulta);
    }

    @Override
    public void eliminar(int id) throws NotFoundModelException {
        Consulta consulta = repo.listar(id);
        if (consulta == null) 
            throw new NotFoundModelException("Objeto consulta no encontrado");  
        repo.eliminar(consulta);
    }

    @Override
    public void editar(Consulta consulta) throws NotFoundModelException,java.text.ParseException, ObjetcRequiredException{
       Date fechaActual = new Date();
       SimpleDateFormat formateador = new SimpleDateFormat("MM/dd/yyyy");
       Consulta c = repo.listar(consulta.getId());
       if (consulta == null){
            throw new NotFoundModelException("Objeto consulta no encontrado"); 
       }      
        Date fechaRecibida = formateador.parse(consulta.getFecha());
        if(fechaActual.before(fechaRecibida)){
            throw new ObjetcRequiredException("La fecha tiene que ser menor a la actual");
        }
       c.setNombreMedico(consulta.getNombreMedico());
       c.setFecha(consulta.getFecha());
       repo.editar(c);
    }
    
}

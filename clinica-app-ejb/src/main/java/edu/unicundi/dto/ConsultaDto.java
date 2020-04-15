/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.dto;

import edu.unicundi.entity.DetalleConsulta;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * @author ASUS-PC
 */
public class ConsultaDto implements Serializable{
    
    private Integer id;
    
    private String nombreMedico;
       
    private String fecha;
                   
    private List<DetalleConsulta> detalleConsulta;
            
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<DetalleConsulta> getDetalleConsulta() {
        return detalleConsulta;
    }

    public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
        this.detalleConsulta = detalleConsulta;
    }        
    
}

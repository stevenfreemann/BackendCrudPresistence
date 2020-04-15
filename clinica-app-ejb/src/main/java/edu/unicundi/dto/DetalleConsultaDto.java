/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.dto;

import java.io.Serializable;


/**
 *
 * @author ASUS-PC
 */
public class DetalleConsultaDto implements Serializable{
    
    private Integer id;
    
    private String  diagnostico;
    
    private String tratamiento;
    
    private ConsultaDto consulta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    public ConsultaDto getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaDto consulta) {
        this.consulta = consulta;
    }        
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author ASUS-PC
 */
@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "DetalleConsulta.listarTodos", query = "SELECT d FROM DetalleConsulta d")
})
public class DetalleConsulta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Diagnostico es requerido")
    @Size(min = 3, max = 49,  message = "Diagnostico debe estar entre 3 y 49 caracteres")    
    @Column(name = "diagnostico", nullable = false, length = 25)
    private String  diagnostico;
    
    @NotNull(message = "Tratamineto es requerido")
    @Size(min = 3, max = 49,  message = "Tratamineto debe estar entre 3 y 49 caracteres")    
    @Column(name = "tratamiento", nullable = false, length = 50)
    private String tratamiento;
    
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;

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
    
    @JsonIgnore
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }        
    
}

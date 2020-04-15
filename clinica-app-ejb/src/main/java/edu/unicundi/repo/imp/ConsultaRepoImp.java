/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.imp;

import edu.unicundi.entity.Consulta;
import edu.unicundi.entity.DetalleConsulta;
import edu.unicundi.repo.IConsultaRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class ConsultaRepoImp implements IConsultaRepo {

    @PersistenceContext(unitName = "edu.unicundi_clinica-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Consulta> listarTodos() {
        TypedQuery<Consulta> query = em.createNamedQuery("Consulta.listarTodos", Consulta.class);
        List<Consulta> listaConsulta = query.getResultList();
        //Para que no genere bucle infinito, la otra opción es utilizar @JsonIgnore
        for (Consulta cs : listaConsulta) {
         System.out.println("-------------------");   
         //Consulta consultaAuliar = new Consulta();
         //consultaAuliar.setId(cs.getId());
         System.out.println(cs.getId());
         System.out.println(cs.getNombreMedico());
         System.out.println("--DETALLE--");
         for (DetalleConsulta dc : cs.getDetalleConsulta()) {
            System.out.println(dc.getId());
            System.out.println(dc.getTratamiento());
         }            
         }

        //Para que traiga el objeto sin detalleConsulta
        /*for (Consulta con : listaConsulta) {
         con.setDetalleConsulta(null);
         }*/
        return listaConsulta;
    }

    @Override
    public Consulta listar(int id) {
        return em.find(Consulta.class, id);
    }

    @Override
    public void guardar(Consulta consulta) {
        em.persist(consulta);
    }

    @Override
    public void eliminar(Consulta consulta) {
        em.remove(consulta);
    }

    @Override
    public void editar(Consulta consulta) {
        //Consulta consulta = em.find(Consulta.class, 21);
        //consulta.setNombreMedico("Dario Gomez");
        /*consulta.getDetalleConsulta().get(0).setDiagnostico("Diagnostico editado");
        consulta.getDetalleConsulta().remove(1);        */
        em.merge(consulta);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.imp;

import edu.unicundi.entity.DetalleConsulta;
import edu.unicundi.repo.IDetalleConsultaRepo;
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
public class DetalleConsultaRepoImp implements IDetalleConsultaRepo {

    @PersistenceContext(unitName = "edu.unicundi_clinica-app-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<DetalleConsulta> listarTodos() {
        TypedQuery<DetalleConsulta> query = em.createNamedQuery("DetalleConsulta.listarTodos", DetalleConsulta.class);
        List<DetalleConsulta> listaDetalleConsulta = query.getResultList();
        return listaDetalleConsulta;
    }

    @Override
    public DetalleConsulta listar(int id) {
        return em.find(DetalleConsulta.class, id);
    }

    @Override
    public void guardar(DetalleConsulta detalleConsulta) {
        em.persist(detalleConsulta);
    }

    @Override
    public void eliminar(DetalleConsulta detalleConsulta) {
        em.remove(detalleConsulta);
    }

    @Override
    public void editar(DetalleConsulta detalleConsulta) {
        em.merge(detalleConsulta);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.CapacidadesPorEstudios;

/**
 *
 * @author USUARIO
 */
@Stateless
public class CapacidadesPorEstudiosFacade extends AbstractFacade<CapacidadesPorEstudios> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacidadesPorEstudiosFacade() {
        super(CapacidadesPorEstudios.class);
    }
    
}

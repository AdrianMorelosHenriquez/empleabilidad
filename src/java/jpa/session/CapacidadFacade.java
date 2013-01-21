/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Capacidad;

/**
 *
 * @author USUARIO
 */
@Stateless
public class CapacidadFacade extends AbstractFacade<Capacidad> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacidadFacade() {
        super(Capacidad.class);
    }
    
}

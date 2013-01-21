/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.CapacidadesPorOfertas;

/**
 *
 * @author USUARIO
 */
@Stateless
public class CapacidadesPorOfertasFacade extends AbstractFacade<CapacidadesPorOfertas> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacidadesPorOfertasFacade() {
        super(CapacidadesPorOfertas.class);
    }
    
}

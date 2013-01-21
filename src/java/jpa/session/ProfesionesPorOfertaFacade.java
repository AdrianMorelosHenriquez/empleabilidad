/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ProfesionesPorOferta;

/**
 *
 * @author USUARIO
 */
@Stateless
public class ProfesionesPorOfertaFacade extends AbstractFacade<ProfesionesPorOferta> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionesPorOfertaFacade() {
        super(ProfesionesPorOferta.class);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ProfesionesPorAspirante;

/**
 *
 * @author USUARIO
 */
@Stateless
public class ProfesionesPorAspiranteFacade extends AbstractFacade<ProfesionesPorAspirante> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionesPorAspiranteFacade() {
        super(ProfesionesPorAspirante.class);
    }
    
}

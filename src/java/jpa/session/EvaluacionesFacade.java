/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Evaluaciones;

/**
 *
 * @author USUARIO
 */
@Stateless
public class EvaluacionesFacade extends AbstractFacade<Evaluaciones> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionesFacade() {
        super(Evaluaciones.class);
    }
    
}

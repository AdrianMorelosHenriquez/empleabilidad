/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Inscripcion;

/**
 *
 * @author USUARIO
 */
@Stateless
public class InscripcionFacade extends AbstractFacade<Inscripcion> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscripcionFacade() {
        super(Inscripcion.class);
    }
    
}

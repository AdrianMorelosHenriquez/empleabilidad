/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.DatosPersonales;

/**
 *
 * @author USUARIO
 */
@Stateless
public class DatosPersonalesFacade extends AbstractFacade<DatosPersonales> {
    @PersistenceContext(unitName = "empleabilidadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosPersonalesFacade() {
        super(DatosPersonales.class);
    }
    
}

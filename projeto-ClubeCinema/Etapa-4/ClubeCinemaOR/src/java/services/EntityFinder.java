
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntityFinder {
    @PersistenceContext(unitName = "ClubeCinemaORPU")
    private EntityManager em;
    
    public Object find(Class type, Object id) { return em.find(type, id); } 
}

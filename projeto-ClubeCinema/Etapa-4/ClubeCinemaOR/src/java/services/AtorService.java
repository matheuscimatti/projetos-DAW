
package services;

import entities.Ator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class AtorService extends EntityService<Ator> {
    public AtorService() { super(Ator.class); }

    public List<Ator> filter(String prefix) {
        prefix += "%";
        Query query = em.createQuery
            ("SELECT ator from Ator ator WHERE ator.nome LIKE :prefix");
        query.setParameter("prefix", prefix);
        return query.getResultList();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

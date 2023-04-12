
package services;

import entities.Diretor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class DiretorService extends EntityService<Diretor> {
    public DiretorService() { super(Diretor.class); }

    public List<Diretor> filter(String prefix) {
        prefix += "%";
        Query query = em.createQuery
            ("SELECT diretor from Diretor diretor WHERE diretor.nome LIKE :prefix");
        query.setParameter("prefix", prefix);
        return query.getResultList();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

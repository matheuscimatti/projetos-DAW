package services;

import entities.Ingresso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class IngressoService extends EntityService<Ingresso> {
    public IngressoService() { super(Ingresso.class); }
    
    public List<Ingresso> filter(String prefix) {
        prefix += "%";
        Query query = em.createQuery
            ("SELECT ingresso from Ingresso ingresso WHERE ingresso.título LIKE :prefix");
        query.setParameter("prefix", prefix);
        return query.getResultList();
    }
    
}


package services;

import entities.Avaliacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class AvaliacaoService extends EntityService<Avaliacao> {
    public AvaliacaoService() { super(Avaliacao.class); }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

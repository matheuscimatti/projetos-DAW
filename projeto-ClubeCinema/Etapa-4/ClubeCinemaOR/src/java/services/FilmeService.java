
package services;

import entities.Filme;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class FilmeService extends EntityService<Filme> {
    public FilmeService() { super(Filme.class); }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

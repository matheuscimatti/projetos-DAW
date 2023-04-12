
package services;

import entities.Amigo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class AmigoService extends EntityService<Amigo> {
    public AmigoService() { super(Amigo.class); }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package services;

import entities.Ingresso;
import javax.ejb.Stateless;

@Stateless
public class TeatroService extends EntityService<Ingresso> {
    public TeatroService() { super(Ingresso.class); }
}

package services;

import entities.Teatro;
import javax.ejb.Stateless;

@Stateless
public class TeatroService extends EntityService<Teatro> {
    public TeatroService() { super(Teatro.class); }
}

package services;

import entities.Amigo;
import javax.ejb.Stateless;

@Stateless
public class AmigoService extends EntityService<Amigo> {
    public AmigoService() { super(Amigo.class); }
}

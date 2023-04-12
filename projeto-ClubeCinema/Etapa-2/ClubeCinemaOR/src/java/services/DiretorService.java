package services;

import entities.Diretor;
import javax.ejb.Stateless;

@Stateless
public class DiretorService extends EntityService<Diretor> {
    public DiretorService() { super(Diretor.class); }
}

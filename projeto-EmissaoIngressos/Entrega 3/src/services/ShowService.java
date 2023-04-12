package services;

import entities.ClasseShow;
import javax.ejb.Stateless;

@Stateless
public class ShowService extends EntityService<ClasseShow> {
    public ShowService() { super(ClasseShow.class); }
}

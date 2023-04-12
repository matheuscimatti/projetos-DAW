package services;

import entities.Cinema;
import javax.ejb.Stateless;

@Stateless
public class CinemaService extends EntityService<Cinema> {
    public CinemaService() { super(Cinema.class); }
}

package services;

import entities.Venda;
import javax.ejb.Stateless;

@Stateless
public class VendaService extends EntityService<Venda> {
    public VendaService() { super(Venda.class); }
}

package services;

import entities.Cliente;
import javax.ejb.Stateless;

@Stateless
public class ClienteService extends EntityService<Cliente> {
    public ClienteService() { super(Cliente.class); }
}

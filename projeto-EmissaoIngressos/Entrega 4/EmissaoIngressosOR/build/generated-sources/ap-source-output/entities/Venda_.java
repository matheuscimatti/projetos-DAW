package entities;

import entities.Cliente;
import entities.Ingresso;
import entities.Venda.Pagamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2021-11-22T17:16:15")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, String> código;
    public static volatile SingularAttribute<Venda, Long> id;
    public static volatile ListAttribute<Venda, Ingresso> ingressos;
    public static volatile SingularAttribute<Venda, Pagamento> pagamento;
    public static volatile SingularAttribute<Venda, Date> dataHora;
    public static volatile SingularAttribute<Venda, Boolean> meiaEntrada;

}
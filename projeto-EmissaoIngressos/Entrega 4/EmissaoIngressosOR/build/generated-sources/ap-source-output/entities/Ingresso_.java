package entities;

import entities.Ingresso.Tipo;
import entities.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2021-11-22T17:16:15")
@StaticMetamodel(Ingresso.class)
public class Ingresso_ { 

    public static volatile SingularAttribute<Ingresso, String> valorIngresso;
    public static volatile SingularAttribute<Ingresso, Tipo> tipo;
    public static volatile SingularAttribute<Ingresso, String> horário;
    public static volatile SingularAttribute<Ingresso, String> localidade;
    public static volatile SingularAttribute<Ingresso, String> título;
    public static volatile ListAttribute<Ingresso, Venda> vendas;
    public static volatile SingularAttribute<Ingresso, Long> id;
    public static volatile SingularAttribute<Ingresso, String> dia;
    public static volatile SingularAttribute<Ingresso, Boolean> presencial;
    public static volatile SingularAttribute<Ingresso, String> indicativa;

}
package entities;

import entities.Cliente.EstadoCivil;
import entities.Endereço;
import entities.Venda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2021-11-22T17:16:15")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> telefone;
    public static volatile SingularAttribute<Cliente, Endereço> endereço;
    public static volatile ListAttribute<Cliente, Venda> vendas;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, EstadoCivil> estadoCivil;
    public static volatile SingularAttribute<Cliente, Long> id;
    public static volatile SingularAttribute<Cliente, String> sexo;
    public static volatile SingularAttribute<Cliente, Date> dataNascimento;
    public static volatile SingularAttribute<Cliente, String> email;

}
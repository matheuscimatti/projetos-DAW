package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2021-11-22T17:16:15")
@StaticMetamodel(Endereço.class)
public class Endereço_ { 

    public static volatile SingularAttribute<Endereço, String> cidade;
    public static volatile SingularAttribute<Endereço, String> complemento;
    public static volatile SingularAttribute<Endereço, String> logradouro;
    public static volatile SingularAttribute<Endereço, String> bairro;
    public static volatile SingularAttribute<Endereço, String> número;
    public static volatile SingularAttribute<Endereço, Long> id;
    public static volatile SingularAttribute<Endereço, String> cep;

}
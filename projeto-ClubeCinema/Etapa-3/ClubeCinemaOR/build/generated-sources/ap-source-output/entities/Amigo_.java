package entities;

import entities.Amigo.EstadoCivil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2021-09-27T17:36:30")
@StaticMetamodel(Amigo.class)
public class Amigo_ { 

    public static volatile SingularAttribute<Amigo, String> whatsapp;
    public static volatile SingularAttribute<Amigo, String> cidade;
    public static volatile SingularAttribute<Amigo, String> apelido;
    public static volatile SingularAttribute<Amigo, String> facebook;
    public static volatile SingularAttribute<Amigo, String> nome;
    public static volatile SingularAttribute<Amigo, EstadoCivil> estadoCivil;
    public static volatile SingularAttribute<Amigo, Long> id;
    public static volatile SingularAttribute<Amigo, String> instagram;
    public static volatile SingularAttribute<Amigo, String> sexo;
    public static volatile SingularAttribute<Amigo, Date> dataNascimento;
    public static volatile SingularAttribute<Amigo, String> email;

}
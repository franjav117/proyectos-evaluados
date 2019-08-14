package com.esquelas.entities;

import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Cajero;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Usuario;
import com.esquelas.entities.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-08-14T11:01:09")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile ListAttribute<Persona, Usuario> usuarioList;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile SingularAttribute<Persona, String> n3Nombre;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> a3Apellido;
    public static volatile ListAttribute<Persona, Conductor> conductorList;
    public static volatile SingularAttribute<Persona, Integer> edad;
    public static volatile SingularAttribute<Persona, String> n2Nombre;
    public static volatile ListAttribute<Persona, AgenteTransito> agenteTransitoList;
    public static volatile SingularAttribute<Persona, String> n1Nombre;
    public static volatile SingularAttribute<Persona, String> dui;
    public static volatile SingularAttribute<Persona, String> a2Apellido;
    public static volatile ListAttribute<Persona, Cajero> cajeroList;
    public static volatile SingularAttribute<Persona, Integer> idPersona;
    public static volatile ListAttribute<Persona, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<Persona, String> a1Apellido;

}
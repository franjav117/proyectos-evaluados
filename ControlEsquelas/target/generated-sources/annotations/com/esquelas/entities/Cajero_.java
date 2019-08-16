package com.esquelas.entities;

import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-08-16T09:26:26")
@StaticMetamodel(Cajero.class)
public class Cajero_ { 

    public static volatile SingularAttribute<Cajero, String> cac;
    public static volatile ListAttribute<Cajero, Esquela> esquelaList;
    public static volatile SingularAttribute<Cajero, Integer> idCajero;
    public static volatile SingularAttribute<Cajero, String> codCaja;
    public static volatile SingularAttribute<Cajero, Persona> idPersona;

}
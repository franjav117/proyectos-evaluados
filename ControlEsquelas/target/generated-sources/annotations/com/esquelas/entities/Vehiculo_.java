package com.esquelas.entities;

import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.TipoMatricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-08-16T09:26:26")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, Integer> idVehiculo;
    public static volatile SingularAttribute<Vehiculo, String> claseVehiculo;
    public static volatile SingularAttribute<Vehiculo, String> color;
    public static volatile SingularAttribute<Vehiculo, Boolean> extrangera;
    public static volatile SingularAttribute<Vehiculo, String> modelo;
    public static volatile SingularAttribute<Vehiculo, String> pais;
    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile SingularAttribute<Vehiculo, String> codigoRuta;
    public static volatile ListAttribute<Vehiculo, Esquela> esquelaList;
    public static volatile SingularAttribute<Vehiculo, TipoMatricula> tipoPlaca;
    public static volatile SingularAttribute<Vehiculo, String> numeroPlaca;
    public static volatile SingularAttribute<Vehiculo, Integer> anio;
    public static volatile SingularAttribute<Vehiculo, Persona> idPersona;

}
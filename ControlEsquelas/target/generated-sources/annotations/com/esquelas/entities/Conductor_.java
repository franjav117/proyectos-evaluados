package com.esquelas.entities;

import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-26T08:33:03")
@StaticMetamodel(Conductor.class)
public class Conductor_ { 

    public static volatile SingularAttribute<Conductor, Date> vigencia;
    public static volatile SingularAttribute<Conductor, String> licencia;
    public static volatile ListAttribute<Conductor, Esquela> esquelaList;
    public static volatile SingularAttribute<Conductor, Integer> idConductor;
    public static volatile SingularAttribute<Conductor, ClaseLicencia> licenciaTipo;
    public static volatile SingularAttribute<Conductor, Persona> idPersona;

}
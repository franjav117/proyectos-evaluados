package com.esquelas.entities;

import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-27T08:14:28")
=======
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-26T16:58:49")
>>>>>>> develop
@StaticMetamodel(Conductor.class)
public class Conductor_ { 

    public static volatile SingularAttribute<Conductor, Date> vigencia;
    public static volatile SingularAttribute<Conductor, String> licencia;
    public static volatile ListAttribute<Conductor, Esquela> esquelaList;
    public static volatile SingularAttribute<Conductor, Integer> idConductor;
    public static volatile SingularAttribute<Conductor, ClaseLicencia> licenciaTipo;
    public static volatile SingularAttribute<Conductor, Persona> idPersona;

}
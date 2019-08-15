package com.esquelas.entities;

import com.esquelas.entities.Conductor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-08-15T13:49:59")
@StaticMetamodel(ClaseLicencia.class)
public class ClaseLicencia_ { 

    public static volatile SingularAttribute<ClaseLicencia, String> licencia;
    public static volatile SingularAttribute<ClaseLicencia, Integer> idClaseLicencia;
    public static volatile ListAttribute<ClaseLicencia, Conductor> conductorList;

}
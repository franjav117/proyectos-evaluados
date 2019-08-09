package com.esquelas.entities;

import com.esquelas.entities.Esquela;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-08-08T16:15:47")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, Integer> idEstado;
    public static volatile SingularAttribute<Estado, String> estadoMulta;
    public static volatile ListAttribute<Estado, Esquela> esquelaList;

}
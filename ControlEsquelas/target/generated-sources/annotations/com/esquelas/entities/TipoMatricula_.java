package com.esquelas.entities;

import com.esquelas.entities.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-30T15:47:40")
@StaticMetamodel(TipoMatricula.class)
public class TipoMatricula_ { 

    public static volatile SingularAttribute<TipoMatricula, String> codigoMatricula;
    public static volatile SingularAttribute<TipoMatricula, Integer> idTipoMatricula;
    public static volatile ListAttribute<TipoMatricula, Vehiculo> vehiculoList;

}
package com.esquelas.entities;

import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-26T08:33:03")
@StaticMetamodel(TipoPlaca.class)
public class TipoPlaca_ { 

    public static volatile ListAttribute<TipoPlaca, AgenteTransito> agenteTransitoList;
    public static volatile SingularAttribute<TipoPlaca, String> tipoPlaca;
    public static volatile ListAttribute<TipoPlaca, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<TipoPlaca, Integer> idTipoPlaca;

}
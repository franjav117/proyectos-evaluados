package com.esquelas.entities;

import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.TipoPlaca;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-08-14T11:01:09")
@StaticMetamodel(AgenteTransito.class)
public class AgenteTransito_ { 

    public static volatile SingularAttribute<AgenteTransito, TipoPlaca> tipoPlaca;
    public static volatile ListAttribute<AgenteTransito, Esquela> esquelaList;
    public static volatile SingularAttribute<AgenteTransito, String> puestoPolicial;
    public static volatile SingularAttribute<AgenteTransito, Integer> numPlaca;
    public static volatile SingularAttribute<AgenteTransito, Integer> idAgente;
    public static volatile SingularAttribute<AgenteTransito, Persona> idPersona;

}
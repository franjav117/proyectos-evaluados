package com.esquelas.entities;

import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.TipoPlaca;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-27T09:06:24")
@StaticMetamodel(AgenteTransito.class)
public class AgenteTransito_ { 

    public static volatile SingularAttribute<AgenteTransito, TipoPlaca> tipoPlaca;
    public static volatile ListAttribute<AgenteTransito, Esquela> esquelaList;
    public static volatile SingularAttribute<AgenteTransito, String> puestoPolicial;
    public static volatile SingularAttribute<AgenteTransito, Integer> numPlaca;
    public static volatile SingularAttribute<AgenteTransito, Integer> idAgente;
    public static volatile SingularAttribute<AgenteTransito, Persona> idPersona;

}
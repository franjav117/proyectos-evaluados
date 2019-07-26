package com.esquelas.entities;

import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.TipoPlaca;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-26T08:23:18")
=======
@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-26T08:17:05")
>>>>>>> develop
=======
@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-26T10:20:43")
>>>>>>> feature_rogelio
@StaticMetamodel(AgenteTransito.class)
public class AgenteTransito_ { 

    public static volatile SingularAttribute<AgenteTransito, TipoPlaca> tipoPlaca;
    public static volatile ListAttribute<AgenteTransito, Esquela> esquelaList;
    public static volatile SingularAttribute<AgenteTransito, String> puestoPolicial;
    public static volatile SingularAttribute<AgenteTransito, Integer> numPlaca;
    public static volatile SingularAttribute<AgenteTransito, Integer> idAgente;
    public static volatile SingularAttribute<AgenteTransito, Persona> idPersona;

}
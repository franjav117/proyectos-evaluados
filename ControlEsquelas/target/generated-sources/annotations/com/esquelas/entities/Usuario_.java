package com.esquelas.entities;

import com.esquelas.entities.Persona;
import com.esquelas.entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-27T08:14:28")
=======
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-26T16:58:49")
>>>>>>> develop
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, Persona> idPersona;

}
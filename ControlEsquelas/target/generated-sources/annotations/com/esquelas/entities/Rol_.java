package com.esquelas.entities;

import com.esquelas.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-07-27T08:59:37")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> idRol;
    public static volatile SingularAttribute<Rol, String> descripcionRol;
    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile SingularAttribute<Rol, String> rol;

}
package com.esquelas.entities;

import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Clasificacion;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Decomiso;
import com.esquelas.entities.Departamento;
import com.esquelas.entities.Estado;
import com.esquelas.entities.Otros;
import com.esquelas.entities.TipoGravedad;
import com.esquelas.entities.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-07-30T08:37:28")
@StaticMetamodel(Esquela.class)
public class Esquela_ { 

    public static volatile SingularAttribute<Esquela, Estado> estado;
    public static volatile SingularAttribute<Esquela, Double> montoPagar;
    public static volatile SingularAttribute<Esquela, Date> fechaEsquela;
    public static volatile SingularAttribute<Esquela, AgenteTransito> idAgente;
    public static volatile SingularAttribute<Esquela, Integer> idEsquela;
    public static volatile SingularAttribute<Esquela, String> lugarInfraccion;
    public static volatile SingularAttribute<Esquela, Departamento> idDepartamento;
    public static volatile SingularAttribute<Esquela, Otros> idOtros;
    public static volatile SingularAttribute<Esquela, String> codigoFalta;
    public static volatile SingularAttribute<Esquela, Conductor> idConductor;
    public static volatile SingularAttribute<Esquela, String> observaciones;
    public static volatile SingularAttribute<Esquela, Clasificacion> clasificacion;
    public static volatile SingularAttribute<Esquela, TipoGravedad> tipoGravedad;
    public static volatile SingularAttribute<Esquela, Vehiculo> placa;
    public static volatile SingularAttribute<Esquela, Decomiso> idDecomiso;

}
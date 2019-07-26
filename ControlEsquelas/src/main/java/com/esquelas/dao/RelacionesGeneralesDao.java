/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Cajero;
import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Clasificacion;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Decomiso;
import com.esquelas.entities.Departamento;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Estado;
import com.esquelas.entities.Otros;
import com.esquelas.entities.Rol;
import com.esquelas.entities.TipoGravedad;
import com.esquelas.entities.TipoMatricula;
import com.esquelas.entities.TipoPlaca;
import com.esquelas.entities.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author francisco.amayausam
 */
@Stateless
public class RelacionesGeneralesDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private final EntityManager em = emf.createEntityManager();

    private List<Rol> rolList;//1
    private List<ClaseLicencia> ClaseLisenciaList;//2
    private List<TipoMatricula> TipoMatriculaList;//3
    private List<Departamento> DepartamentoList;//4
    private List<Estado> EstadoList;//5
    private List<TipoGravedad> TipoGravedadList;//6
    private List<Decomiso> DecomisoList;//7
    private List<Otros> OtrosList;//8
    private List<Clasificacion> ClasificacionList;//9
    private List<TipoPlaca> TipoPlacaList;//10

    public List<Rol> obtenerRol() { //relacionada a usuarios
        try {
            rolList = new ArrayList<Rol>();
            rolList = em.createNamedQuery("Rol.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rolList;
    }

    public List<ClaseLicencia> obtenerClaseLicencia() {// relacionada a conductor
        try {
            ClaseLisenciaList = new ArrayList<ClaseLicencia>();
            ClaseLisenciaList = em.createNamedQuery("ClaseLicencia.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ClaseLisenciaList;
    }

    public List<TipoMatricula> obtenerTipoMatricula() { //relacionada a vehiculo
        try {
            TipoMatriculaList = new ArrayList<TipoMatricula>();
            TipoMatriculaList = em.createNamedQuery("TipoMatricula.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TipoMatriculaList;
    }

    public List<Departamento> obtenerDepartamento() {//relacionada a esquela
        try {
            DepartamentoList = new ArrayList<Departamento>();
            DepartamentoList = em.createNamedQuery("Departamento.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DepartamentoList;
    }

    public List<Estado> obtenerEstado() { //relacionada a esquela
        try {
            EstadoList = new ArrayList<Estado>();
            EstadoList = em.createNamedQuery("Estado.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EstadoList;
    }

    public List<TipoGravedad> obtenerTipoGravedad() {// relacionada a esquela
        try {
            TipoGravedadList = new ArrayList<TipoGravedad>();
            TipoGravedadList = em.createNamedQuery("TipoGravedad.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TipoGravedadList;
    }

    public List<Decomiso> obtenerDecomiso() {// relacionada a esquela
        try {
            DecomisoList = new ArrayList<Decomiso>();
            DecomisoList = em.createNamedQuery("Decomiso.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DecomisoList;
    }

    public List<Otros> obtenerOtros() {//relacionada a esquela
        try {
            OtrosList = new ArrayList<Otros>();
            OtrosList = em.createNamedQuery("Otros.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OtrosList;
    }

    public List<Clasificacion> obtenerClasificacion() {//relacionada a esquela
        try {
            ClasificacionList = new ArrayList<Clasificacion>();
            ClasificacionList = em.createNamedQuery("Clasificacion.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ClasificacionList;
    }

    public List<TipoPlaca> obtenerTipoPlaca() {//relacionada a agente_transito
        try {
            TipoPlacaList = new ArrayList<TipoPlaca>();
            TipoPlacaList = em.createNamedQuery("TipoPlaca.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TipoPlacaList;
    }

    
    ///****************************Llenado de campos esquela **************************
    
    public Conductor idConductor(Integer esq){ //Integer dentro de obj 
        Conductor obj = new Conductor();
        try {
            obj = (Conductor) em.createNativeQuery("Select id_conductor from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DAO id Conductor "+obj.getIdConductor());
        return obj;
    }
    
    
    public Vehiculo idVehiculo(Integer esq){ //Integer dentro de obj 
        Vehiculo obj = new Vehiculo();
        try {
            obj =  (Vehiculo) em.createNativeQuery("Select placa from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DAO id Vehiculo "+obj.getIdVehiculo());
        return obj;
    }
    
    public AgenteTransito idAgente(Integer esq){
        AgenteTransito obj = new AgenteTransito();
        try {
            obj =  (AgenteTransito) em.createNativeQuery("Select placa from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DAO id Agente "+obj.getIdAgente());
        return obj;
    }
    
    public Clasificacion idClasificacion(Integer esq){
        Clasificacion obj = new Clasificacion();
        try {
            obj =  (Clasificacion) em.createNativeQuery("Select placa from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DAO id Clasificacion "+obj.getIdClasificacion());
        return obj;
    }
    
    public TipoGravedad idTipoGravedad(Integer esq){
        TipoGravedad obj = new TipoGravedad();
        try {
            obj =  (TipoGravedad) em.createNativeQuery("Select placa from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DAO id Gravedad "+obj.getIdGravedad());
        return obj;
    }
    
}

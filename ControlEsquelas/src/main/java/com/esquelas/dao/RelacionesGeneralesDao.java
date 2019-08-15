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
import com.esquelas.entities.Usuario;
import com.esquelas.entities.Vehiculo;
import java.util.ArrayList;
import java.util.Date;
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

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("esquelasPU");
    //esquelasPU com.esquelas_ControlEsquelas_war_1.0_AlphaPU
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
    public Integer Test(){
        Integer i = 0;
        List<Esquela> es = new ArrayList<>();
        try {
            es = em.createNamedQuery("Esquela.findAll", Esquela.class).getResultList();
            i = es.size();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return i;
    }
    
    public Conductor idConductor(Integer esq){ //Integer dentro de obj 
        Conductor obj = new Conductor();
        try {
            obj = (Conductor) em.createNativeQuery("Select id_conductor from esquela where id_esquela = "+esq+"", Conductor.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Conductor "+obj.getIdConductor() +" "+obj.getIdPersona().getN1Nombre() +" "+ obj.getIdPersona().getA1Apellido());
        return obj;
    }

    public Integer idVehiculo(Integer esq){ //Integer dentro de obj 
        Integer obj = 0;
        try {
            obj = (Integer) em.createNativeQuery("Select placa from esquela where id_esquela ="+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Vehiculo "+obj);
        return obj;
    }
    
    public Date fechaPago(Integer i){
        Date pago = new Date();
        try {
            pago = (Date) em.createNativeQuery("Select fecha_pago from esquela where id_esquela = "+i+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pago; 
    }
    
    public AgenteTransito idAgente(Integer esq){
        AgenteTransito obj = new AgenteTransito();
        try {
            obj =  (AgenteTransito) em.createNativeQuery("Select id_agente from esquela where id_esquela = "+esq+"", Esquela.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Agente "+obj.getIdAgente() + obj.getIdPersona().getN1Nombre()+" "+ obj.getIdPersona().getA1Apellido());
        return obj;
    }
    ///////////////
    public Integer idClasificacion(Integer esq){
        Integer obj = 0;
        try {
            obj =  (Integer) em.createNativeQuery("Select clasificacion from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Clasificacion "+obj);
        return obj;
    }
    
    public Integer idTipoGravedad(Integer esq){
        Integer obj = 0;
        try {
            obj =  (Integer) em.createNativeQuery("Select tipo_gravedad from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Gravedad "+obj);
        return obj;
    }
    
    public Esquela esquelaDatosPuros(Integer esq){
        Esquela datos = new Esquela();
        try{
        datos = (Esquela) em.createNativeQuery("Select * from esquela where id_esquela = "+esq+"", Esquela.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("*-*-*-*-*-*- DATOS PUROS "+ datos.getLugarInfraccion() + "Lugar Infraccion");
        return datos;
    }
    
    public Integer idEstado(Integer esq){
        Integer obj = 0;
        try {
            obj =  (Integer) em.createNativeQuery("Select estado from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Estado "+obj);
        return obj;
    }
    
    public Integer idCajero(Usuario u){
     Integer obj = 0;
     Integer i = u.getIdPersona().getIdPersona();
     //System.out.println("Usuario datos DAO ="+ u.getUsuario() +" + "+ u.getIdPersona().getIdPersona()+" ");
   //  Integer query = u.getIdPersona().getIdPersona();
        try {
            obj = (Integer) em.createNativeQuery("Select id_cajero from cajero where id_persona ="+ i+" ").getSingleResult();
            //System.out.println("Select id_cajero from cajero where id_persona ="+ i+" ");
            //System.out.println("*******DAO Id Cajero OBJ "+obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    
    public Departamento idDepartamento(Integer esq){
        Departamento obj = new Departamento();
        try {
            obj =  (Departamento) em.createNativeQuery("Select id_departamento from esquela where id_esquela = "+esq+"", Departamento.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Departamento "+obj.getDepartamento());
        return obj;
    }
    
    public Integer idDecomiso(Integer esq){
        Integer obj = 0;
        try {
            obj =  (Integer) em.createNativeQuery("Select id_decomiso from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Decomiso "+esq);
        //System.out.println("DAO id Decomiso "+obj);
        return obj;
    }
    
    public Integer idOtros(Integer esq){
        Integer obj = 0;
        try {
            obj =  (Integer) em.createNativeQuery("Select id_otros from esquela where id_esquela = "+esq+"").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("DAO id Otros "+obj);
        return obj;
    }
    //
    //**********************************Final de Llenado de campos esquela **************************
}

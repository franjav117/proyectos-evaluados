/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author melvin.madridusam
 */
@Stateless
public class ConsultaDao {

    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private final EntityManager em = emf.createEntityManager();

    private List<Conductor> listConductor;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private List<Esquela> listEsquela;
    private Esquela esquela;
    
//    public List<Conductor> consultaConductores() {
//        try {
//            listConductor = new ArrayList<>();
//            listConductor = em.createNamedQuery("Conductor.findAll", Conductor.class).getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        }
//        return listConductor;
//    }
//    
//    public Conductor consultarIdConductor(Conductor id){
//        try {
//            conductor = new Conductor();
//            conductor = (Conductor) em.createNamedQuery("Conductor.findByIdConductor").setParameter("idConductor", id.getIdConductor()).getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        }
//        return conductor;
//    }
//    
//    public Conductor consultarXLicencia(Conductor lic){
//        try {
//            conductor = (Conductor)em.createNativeQuery("Select * from conductor where licencia = "+lic.getLicencia()+"").getResultList();
//            System.out.println(" ************************ Dao licencia "+lic.getLicencia());
//            System.out.println(" ************************ Dao Get id condutor "+conductor.getIdConductor());
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        }
//        return conductor;
//    }
//    
//    public Vehiculo consultarXPlaca(Vehiculo placa){
//        try {
//            vehiculo = (Vehiculo)em.createNamedQuery("Vehiculo.findByNumeroPlaca", Vehiculo.class).setParameter("numeroPlaca", placa.getNumeroPlaca());
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        }
//        return vehiculo;
//    }
//    
//    public List<Esquela> EsquelaXLicencia(Esquela id){
//            try {
//                listEsquela = new ArrayList<>();
//                listEsquela = em.createNamedQuery("Esquela.findByIdConductor").setParameter("idConductor", id.getIdConductor()).getResultList();
//                System.out.println(" ************************ Dao Get id condutor "+id + "Lista esquela por licencia " + listEsquela.size());
//            } catch (Exception e) {
//                e.printStackTrace();
//                em.getTransaction().rollback();
//            }
//            return listEsquela;
//    }
    
//    public List<Esquela> esquelaXLicencia(Conductor conducor){
//        listEsquela = new ArrayList<Esquela>();
//        try {
//            listEsquela = em.createNativeQuery("select * from esquela e inner join conductor c on c.id_conductor = e.id_conductor where licencia = "+conductor.getLicencia()+"");
//        } catch (Exception e) {
//        }    
//    }
    public List<Esquela> listadoEsquelasNit(Conductor c){
       listEsquela = new ArrayList<>();
       String lic = c.getLicencia();
       try {
           listEsquela = em.createNativeQuery("select * from esquela e inner join conductor c on c.id_conductor = e.id_conductor where licencia = '"+c.getLicencia()+"'").getResultList();
           System.out.println("**** Lista size " + listEsquela.size());
           System.out.println("**** select * from esquela e inner join conductor c on c.id_conductor = e.id_conductor where licencia = '"+lic+"'");
       } catch (Exception e) {
           e.printStackTrace();
           em.getTransaction().rollback();
       }
       
       return listEsquela;
   }
    
    
    public List<Esquela> consultaEsquelas(){
        try {
            listEsquela  = new ArrayList<>();
            listEsquela =  em.createNamedQuery("Esquela.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listEsquela;
    }
}

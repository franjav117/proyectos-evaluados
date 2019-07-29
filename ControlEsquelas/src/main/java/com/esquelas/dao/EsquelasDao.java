/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.Conductor;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rogelio.mejiausam
 */
@Stateless
public class EsquelasDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private EntityManager em = emf.createEntityManager();
    
    private List<Esquela> listEsquelaNit;
    
    
    public List<Esquela> listadoEsquelasNit(Conductor c){
        listEsquelaNit = new ArrayList<>();
        String lic = c.getLicencia();
        try {
            listEsquelaNit = em.createNativeQuery("select * from esquela e inner join conductor c on c.id_conductor = e.id_conductor where licencia = '"+c.getLicencia()+"'").getResultList();
            System.out.println("**** Lista size " + listEsquelaNit.size());
            System.out.println("**** select * from esquela e inner join conductor c on c.id_conductor = e.id_conductor where licencia = '"+lic+"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        listEsquelaNit = em.createNamedQuery("Esquela.findByLicencia", Esquela.class).setParameter("licencia", c.getLicencia()).getResultList();
        
        return listEsquelaNit;
    }
    
    public List<Esquela> listadoEsquelasDUI(Persona p){
        listEsquelaNit = new ArrayList<>();
        try{
        listEsquelaNit = em.createNamedQuery("Esquela.findByDUI", Esquela.class).setParameter("dui", p.getDui()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEsquelaNit;
    }
    
    public List<Esquela> listadoEsquelasDUILicencia(Persona p, Conductor c){
        listEsquelaNit = new ArrayList<>();
        try{
        listEsquelaNit = em.createNamedQuery("Esquela.findByDUILicencia", Esquela.class).setParameter("dui", p.getDui()).setParameter("licencia", c.getLicencia()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEsquelaNit;
    }
    
    
    public List<Esquela> listadoEsquelasPlaca(Vehiculo v){
        listEsquelaNit = new ArrayList<>();
        try{
        listEsquelaNit = em.createNamedQuery("Esquela.findByPlaca", Esquela.class).setParameter("placa", v.getNumeroPlaca()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEsquelaNit;
    }
    
    
}

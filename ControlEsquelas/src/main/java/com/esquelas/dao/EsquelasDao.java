/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.Esquela;
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
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntornoDAOPU");
    private EntityManager em = emf.createEntityManager();
    
    private List<Esquela> listEsquelaNit;
    
    public List<Esquela> listadoEsquelasNit(){
        listEsquelaNit = new ArrayList<>();
        
        listEsquelaNit = em.createNamedQuery("Esquela.findByLicencia", Esquela.class).getResultList();
        
        return listEsquelaNit;
    }
    
    public List<Esquela> listadoEsquelasDUI(){
        listEsquelaNit = new ArrayList<>();
        
        listEsquelaNit = em.createNamedQuery("Esquela.findByLicencia", Esquela.class).getResultList();
        
        return listEsquelaNit;
    }
    
}

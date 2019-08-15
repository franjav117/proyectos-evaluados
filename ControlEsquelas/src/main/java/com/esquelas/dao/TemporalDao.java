/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Conductor;
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
public class TemporalDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("esquelasPU");
    private final EntityManager em = emf.createEntityManager();

    private List<Vehiculo> vehiculoList;
    private List<AgenteTransito> AgenteTransitoList;
    private List<Conductor> conductorList;

    public List<Vehiculo> obtenerVehiculo() { //relacionada a Esquelas
        try {
            vehiculoList = new ArrayList<Vehiculo>();
            vehiculoList = em.createNamedQuery("Vehiculo.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehiculoList;
    }
    
    public List<Conductor> obtenerConductor() { //relacionada a Esquelas
        try {
            conductorList = new ArrayList<Conductor>();
            conductorList = em.createNamedQuery("Conductor.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conductorList;
    }
    
    public List<AgenteTransito> obtenerAgenteTransito() { //relacionada a Esquelas
        try {
            AgenteTransitoList = new ArrayList<AgenteTransito>();
            AgenteTransitoList = em.createNamedQuery("AgenteTransito.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AgenteTransitoList;
    }

}

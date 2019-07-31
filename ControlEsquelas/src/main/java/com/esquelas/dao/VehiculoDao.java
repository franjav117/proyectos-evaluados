/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.Vehiculo;
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

public class VehiculoDao {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private final EntityManager em = emf.createEntityManager();
    
    private List<Vehiculo> listvehiculo;
    private Vehiculo vehiculo;
    
    public List<Vehiculo> consultarVehiculos(){
        try {
            listvehiculo = new ArrayList<>();
            listvehiculo = em.createNamedQuery("Vehiculo.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listvehiculo;
    }
    
    public Vehiculo vehiculoXid(Vehiculo id){
        try {
            vehiculo = new Vehiculo();
            vehiculo = (Vehiculo)em.createNamedQuery("Vehiculo.findByIdVehiculo").setParameter("idVehiculo", id.getIdVehiculo()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehiculo;
    }
    
    public String eliminarVehiculo(Vehiculo id){
        String msj = "";
        try {
            em.getTransaction().begin();
            em.remove(em.find(Vehiculo.class, id.getIdVehiculo()));
            em.getTransaction().commit();
            msj = "Eliminado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            msj = "Error al eliminar";
        }
        return msj;
    }
    
    
}

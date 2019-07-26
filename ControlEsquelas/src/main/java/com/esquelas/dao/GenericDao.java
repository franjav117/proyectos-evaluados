/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rogelio.mejiausam
 */
@Stateless
public class GenericDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private EntityManager em = emf.createEntityManager();
    
     public Object insertarEntidad(Object obj) {

        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } 
        return obj;
    }

    public String actualizarEntidad(Object obj) {
        String mensaje = "";
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            mensaje = "Actualizado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            mensaje = "Error actualizando datos";
        }
        return mensaje;
    }
}

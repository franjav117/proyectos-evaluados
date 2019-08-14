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
 * @author francisco.amayausam
 */
@Stateless
public class EsquelaDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private final EntityManager em = emf.createEntityManager();

    private List<Esquela> esquelasList;
    private Esquela esquelaDao;

    public List<Esquela> consultarEsquela() {
        try {
            esquelasList = new ArrayList<Esquela>();
            esquelasList = em.createNamedQuery("Esquela.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return esquelasList;
    }
    public Esquela findEsquelaById (Esquela esqvist) {
        try {
            esquelaDao = new Esquela();
            esquelaDao = (Esquela) em.createNamedQuery("Esquela.findByIdEsquela").setParameter("idEsquela", esqvist.getIdEsquela()).getSingleResult();
            //System.out.println("ID SELECCIONADO EN LA VISTA ::::::::::::::::::::::::::   <<"+esquelaDao.getIdEsquela()+">>");
            //em.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return esquelaDao;
    }
    public void eliminarEsquela(Esquela esqdel) {
        try {
            //System.out.println("esquela eliminada " + esqdel.getIdEsquela());
            em.getTransaction().begin();
            em.remove(em.find(Esquela.class, esqdel.getIdEsquela()));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }//
}

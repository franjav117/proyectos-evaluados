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

    public List<Esquela> listadoEsquelasNit(Conductor c) {
        listEsquela = new ArrayList<>();
        String lic = c.getLicencia();
        try {
            Integer i = (Integer) em.createNativeQuery("SELECT id_conductor FROM Conductor  WHERE licencia = '" + lic + "'").getSingleResult();
            listEsquela = em.createNamedQuery("Esquela.findByConductor", Esquela.class).setParameter("idConductor", i).getResultList();
            System.out.println("**** Lista size " + listEsquela.size());
            System.out.println("**** select * from esquela e inner join conductor c on c.id_conductor = e.id_conductor where licencia = '" + lic + "'");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listEsquela;
    }

    public List<Esquela> listadoEsquelasPlaca(Vehiculo v) {
        listEsquela = new ArrayList<>();
        String placa = v.getNumeroPlaca();
        try {
            Integer ve = (Integer) em.createNativeQuery("SELECT id_vehiculo  FROM vehiculo WHERE numero_placa = '" + placa + "'").getSingleResult();
            listEsquela = em.createNamedQuery("Esquela.findByVehiculo", Esquela.class).setParameter("idVehiculo", ve).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listEsquela;
    }

    public List<Esquela> consultaEsquelas() {
        try {
            listEsquela = new ArrayList<>();
            listEsquela = em.createNamedQuery("Esquela.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listEsquela;
    }
}

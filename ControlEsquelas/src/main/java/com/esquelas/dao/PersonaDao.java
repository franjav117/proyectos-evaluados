/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Cajero;
import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Persona;
import com.esquelas.entities.TipoPlaca;
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
public class PersonaDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private EntityManager em = emf.createEntityManager();
    
    private List<Persona> listPersona;
    private List<Cajero> listCajero;
    private List<TipoPlaca> listPlaca;
    private List<ClaseLicencia> listClaseLicencias;
    private Persona persona;
    private Cajero cajero;
    private Conductor conductor;

    //--------metodos de personas comunes------//
    public Persona insertPersona(Persona persona) {
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return persona;
    }

    public List<Persona> consultPersona() {
        try {
            listPersona = new ArrayList<>();
            listPersona = em.createNamedQuery("Persona.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listPersona;
    }

    //--------------select * from with criteria------------//
    public List<Persona> findAllPersona() {
        try {
            listPersona = new ArrayList<>();
            javax.persistence.criteria.CriteriaQuery query = em.getCriteriaBuilder().createQuery();
            query.select(query.from(Persona.class));
            listPersona = em.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listPersona;
    }

    public void deletePersona(Persona persona) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Persona.class, persona.getIdPersona()));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Persona updatePersona(Persona per) {
        try {
            em.getTransaction().begin();
            em.merge(per);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return per;
    }

    public Persona selectPersona(Persona perso) {
        try {
            persona = (Persona) em.createNamedQuery("Persona.findByIdPersona").setParameter("idPersona", perso.getIdPersona()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return persona;
    }

    //--------------select with jpa---------------//
    public Persona findPersona(Persona perso) {
        try {
            persona = new Persona();
            persona = em.find(Persona.class, perso.getIdPersona());
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return persona;
    }

    //----------------daos de personas con funciones----------//
    public Cajero insertCajero(Cajero cajero) {
        try {
            em.getTransaction().begin();
            em.persist(cajero);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return cajero;
    }

    public AgenteTransito insertAgente(AgenteTransito agente) {
        try {
            em.getTransaction().begin();
            em.persist(agente);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return agente;
    }

    public Conductor insertConductor(Conductor conductor) {
        try {
            em.getTransaction().begin();
            em.persist(conductor);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return conductor;
    }

    public List<ClaseLicencia> consultLicencia() {
        try {
            listClaseLicencias = new ArrayList<>();
            listClaseLicencias = em.createNamedQuery("ClaseLicencia.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listClaseLicencias;
    }

    public List<TipoPlaca> consultPlaca() {
        try {
            listPlaca = new ArrayList<>();
            listPlaca = em.createNamedQuery("TipoPlaca.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPlaca;
    }//
}

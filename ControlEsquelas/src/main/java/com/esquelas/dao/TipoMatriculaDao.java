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
public class TipoMatriculaDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private final EntityManager em = emf.createEntityManager();

    private TipoMatricula tipomatricula;
    private List<TipoMatricula> listmatricula;

    public List<TipoMatricula> consultarMatriculas() {
        try {
            listmatricula = new ArrayList<TipoMatricula>();
            listmatricula = em.createNamedQuery("TipoMatricula.findAll").getResultList();
            System.out.println("/*/*/*/*/ DAO Lista "+listmatricula.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listmatricula;
    }

    public TipoMatricula consultarXidMat(TipoMatricula id) {
        try {
            tipomatricula = new TipoMatricula();
            tipomatricula = (TipoMatricula) em.createNamedQuery("TipoMatricula.findByIdTipoMatricula").setParameter("idTipoMatricula", id.getIdTipoMatricula()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipomatricula;
    }

}

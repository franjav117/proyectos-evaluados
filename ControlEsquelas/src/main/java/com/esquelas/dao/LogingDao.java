/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rogelio.mejiausam
 */
@Stateless
public class LogingDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private EntityManager em = emf.createEntityManager();
    
    public Usuario usuarioLogin(String user, String pass){
        Usuario usuarioLogueado = null;
        try {
            usuarioLogueado = (Usuario) em.createNamedQuery("Usuario.findByPass").setParameter("pass", pass).setParameter("usuario", user).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioLogueado;
    }
    
   
}

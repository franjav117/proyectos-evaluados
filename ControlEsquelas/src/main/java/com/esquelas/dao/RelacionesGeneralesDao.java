/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.dao;

import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Clasificacion;
import com.esquelas.entities.Decomiso;
import com.esquelas.entities.Departamento;
import com.esquelas.entities.Estado;
import com.esquelas.entities.Otros;
import com.esquelas.entities.Rol;
import com.esquelas.entities.TipoGravedad;
import com.esquelas.entities.TipoMatricula;
import com.esquelas.entities.TipoPlaca;
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
public class RelacionesGeneralesDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.esquelas_ControlEsquelas_war_1.0_AlphaPU");
    private final EntityManager em = emf.createEntityManager();

    private List<Rol> rolList;//1
    private List<ClaseLicencia> ClaseLisenciaList;//2
    private List<TipoMatricula> TipoMatriculaList;//3
    private List<Departamento> DepartamentoList;//4
    private List<Estado> EstadoList;//5
    private List<TipoGravedad> TipoGravedadList;//6
    private List<Decomiso> DecomisoList;//7
    private List<Otros> OtrosList;//8
    private List<Clasificacion> ClasificacionList;//9
    private List<TipoPlaca> TipoPlacaList;//10

    public List<Rol> obtenerRol() {
        try {
            rolList = new ArrayList<Rol>();
            rolList = em.createNamedQuery("Rol.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rolList;
    }

    public List<ClaseLicencia> obtenerClaseLicencia() {
        try {
            ClaseLisenciaList = new ArrayList<ClaseLicencia>();
            ClaseLisenciaList = em.createNamedQuery("ClaseLicencia.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ClaseLisenciaList;
    }

    public List<TipoMatricula> obtenerTipoMatricula() {
        try {
            TipoMatriculaList = new ArrayList<TipoMatricula>();
            TipoMatriculaList = em.createNamedQuery("TipoMatricula.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TipoMatriculaList;
    }

    public List<Departamento> obtenerDepartamento() {
        try {
            DepartamentoList = new ArrayList<Departamento>();
            DepartamentoList = em.createNamedQuery("Departamento.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DepartamentoList;
    }

    public List<Estado> obtenerEstado() {
        try {
            EstadoList = new ArrayList<Estado>();
            EstadoList = em.createNamedQuery("Estado.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EstadoList;
    }

    public List<TipoGravedad> obtenerTipoGravedad() {
        try {
            TipoGravedadList = new ArrayList<TipoGravedad>();
            TipoGravedadList = em.createNamedQuery("TipoGravedad.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TipoGravedadList;
    }

    public List<Decomiso> obtenerDecomiso() {
        try {
            DecomisoList = new ArrayList<Decomiso>();
            DecomisoList = em.createNamedQuery("Decomiso.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DecomisoList;
    }

    public List<Otros> obtenerOtros() {
        try {
            OtrosList = new ArrayList<Otros>();
            OtrosList = em.createNamedQuery("Otros.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OtrosList;
    }

    public List<Clasificacion> obtenerClasificacion() {
        try {
            ClasificacionList = new ArrayList<Clasificacion>();
            ClasificacionList = em.createNamedQuery("Clasificacion.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ClasificacionList;
    }

    public List<TipoPlaca> obtenerTipoPlaca() {
        try {
            TipoPlacaList = new ArrayList<TipoPlaca>();
            TipoPlacaList = em.createNamedQuery("TipoPlaca.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TipoPlacaList;
    }
}

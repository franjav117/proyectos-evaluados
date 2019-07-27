/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.EsquelasDao;
import com.esquelas.dao.GenericDao;
import com.esquelas.dao.RelacionesGeneralesDao;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.Vehiculo;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author rogelio.mejiausam
 */
@ManagedBean
public class EsquelaMb implements Serializable{
    private EsquelasDao esquDAO;
    private GenericDao gd;
    private RelacionesGeneralesDao rgDao;
    private List<Esquela> listEsquela;
    private Esquela esquela;
    
    @PostConstruct
    public void init(){
       esquDAO = new EsquelasDao(); 
       gd = new GenericDao();
       listEsquela = new ArrayList<>();
       esquela = new Esquela();
       conductor = new Conductor();
       rgDao = new RelacionesGeneralesDao();
    }
    
    //*********************************Metodos para Leer *************************
    
    public void listadoEsquelaNit(String licencia){
        Conductor c = new Conductor();
        c.setLicencia(licencia);
        try {
            listEsquela = esquDAO.listadoEsquelasNit(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listadoEsquelaDui(String dui){
        Persona p = new Persona();
        p.setDui(dui);
        try {
            listEsquela = esquDAO.listadoEsquelasDUI(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listadoEsquelaDuiLicencia(String dui, String licencia){
        Persona p = new Persona();
        p.setDui(dui);
        Conductor c = new Conductor();
        c.setLicencia(licencia);
        try {
            listEsquela = esquDAO.listadoEsquelasDUILicencia(p, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listadoEsquelaPlaca(String placa){
        Vehiculo v = new Vehiculo();
        v.setNumeroPlaca(placa);
        try {
            listEsquela = esquDAO.listadoEsquelasPlaca(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //*********************************Metodos para Actualizar *************************
    private Integer idEsquela;
    private Integer idConductor;
    private Conductor conductor;
    
    public void CambiarEstadoPago(){
        
        try {
           
           esquela.setIdConductor(rgDao.idConductor(idEsquela));
           esquela.setPlaca(rgDao.idVehiculo(idEsquela));
           esquela.setIdAgente(rgDao.esquelaDatosPuros(idEsquela).getIdAgente());
           esquela.setCodigoFalta(rgDao.esquelaDatosPuros(idEsquela).getCodigoFalta()); //String
           esquela.setClasificacion(rgDao.idClasificacion(idEsquela));
           esquela.setFechaEsquela(rgDao.esquelaDatosPuros(idEsquela).getFechaEsquela()); //Date
           esquela.setLugarInfraccion(rgDao.esquelaDatosPuros(idEsquela).getLugarInfraccion()); //String
           esquela.setObservaciones(rgDao.esquelaDatosPuros(idEsquela).getObservaciones()); //String
           esquela.setTipoGravedad(rgDao.idTipoGravedad(idEsquela));
           esquela.setMontoPagar(rgDao.esquelaDatosPuros(idEsquela).getMontoPagar()); //Double
           esquela.setEstado(rgDao.idEstado(idEsquela));
           esquela.setIdDepartamento(rgDao.idDepartamento(idEsquela));
           esquela.setIdDecomiso(rgDao.idDecomiso(idEsquela));
           esquela.setIdOtros(rgDao.idOtros(idEsquela));
           esquela.setIdEsquela(idEsquela);
           
           gd.actualizarEntidad(esquela);
           esquela = new Esquela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

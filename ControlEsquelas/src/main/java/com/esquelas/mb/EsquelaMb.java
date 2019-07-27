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
import com.esquelas.entities.Estado;
import com.esquelas.entities.Persona;
import com.esquelas.entities.Vehiculo;
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
    private String licencia;
    
    @PostConstruct
    public void init(){
       esquDAO = new EsquelasDao(); 
       gd = new GenericDao();
       listEsquela = new ArrayList<>();
       esquela = new Esquela();
       conductor = new Conductor();
       rgDao = new RelacionesGeneralesDao();
       Test();
    }
    
    //*********************************Metodos para Leer *************************
    
    public void Test(){
       Integer i= rgDao.Test();
        if (i != 0) {
            System.out.println("*********************Conexion Exitosa NPI del por qué*********************");
        } else {
            System.out.println("*********************NO HAY CONEXION :( *********************");
        }
    }
    
    public void listadoEsquelaNit(){
        Conductor c = new Conductor();
        c.setLicencia(licencia);
        try {
            listEsquela = esquDAO.listadoEsquelasNit(c);
            System.out.println("Licencia de la vista "+c.getLicencia());
            System.out.println("Metodo listadoEsquelaNit funciona # esquelas para este usuario es: " +listEsquela.size());
            System.out.println("**********Ya no lo toqués********");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listadoEsquelaDui(String dui){
        Persona p = new Persona();
        p.setDui(dui);
        try {
            listEsquela = esquDAO.listadoEsquelasDUI(p);
            System.out.println("Metodo listadoEsquelaNit funciona # esquelas para este usuario es: " +listEsquela.size());
            
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
            System.out.println("Metodo listadoEsquelaNit funciona # esquelas para este usuario es: " +listEsquela.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listadoEsquelaPlaca(String placa){
        Vehiculo v = new Vehiculo();
        v.setNumeroPlaca(placa);
        try {
            listEsquela = esquDAO.listadoEsquelasPlaca(v);
            System.out.println("Metodo listadoEsquelaNit funciona # esquelas para este usuario es: " +listEsquela.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //*********************************Metodos para Actualizar *************************
    private Integer idEsquela;
    private Integer idConductor;
    private Conductor conductor;
    
    //Este método ni me lo vayan a tocar  **********************************************
    public void CambiarEstadoPago(){
        Estado estado = new Estado();
        if(rgDao.idEstado(idEsquela).getIdEstado() == 1){
           estado.setIdEstado(2); 
        }else{
            estado.setIdEstado(1);
        }

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
           esquela.setEstado(estado);
           esquela.setIdDepartamento(rgDao.idDepartamento(idEsquela));
           esquela.setIdDecomiso(rgDao.idDecomiso(idEsquela));
           esquela.setIdOtros(rgDao.idOtros(idEsquela));
           esquela.setIdEsquela(idEsquela);
           //Datos seteados
           gd.actualizarEntidad(esquela); //Envio a actualizar
           esquela = new Esquela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Ni siquiera lo volteen a ver ****************************************************
    //Continuan los metodos de actualizar *********************************************

    public List<Esquela> getListEsquela() {
        return listEsquela;
    }

    public void setListEsquela(List<Esquela> listEsquela) {
        this.listEsquela = listEsquela;
    }

    public Esquela getEsquela() {
        return esquela;
    }

    public void setEsquela(Esquela esquela) {
        this.esquela = esquela;
    }

    public Integer getIdEsquela() {
        return idEsquela;
    }

    public void setIdEsquela(Integer idEsquela) {
        this.idEsquela = idEsquela;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
    
    
    
}

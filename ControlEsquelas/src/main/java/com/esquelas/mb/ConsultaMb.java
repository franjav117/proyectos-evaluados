/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.ConsultaDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.esquelas.entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;



/**
 *
 * @author melvin.madridusam
 */
@ManagedBean
@ViewScoped
public class ConsultaMb implements Serializable{
    
    private Vehiculo vehiculo;
    private List<Vehiculo> listVehiculo;
    private Conductor conductor;
    private List<Conductor> listConductor;
    private String licencia;
    private Integer idconductor;
    private List<Esquela> listEsId;
    private ConsultaDao cdao;
    
    
    @PostConstruct
    public void ini(){
        vehiculo = new Vehiculo();
        conductor = new Conductor();
        listVehiculo = new ArrayList<Vehiculo>();
        listConductor = new ArrayList<Conductor>();
        listEsId = new ArrayList<Esquela>();
        cdao = new ConsultaDao();
       
    }
    
    public void esquelasXlicencia(){
        conductor = new Conductor();
        Conductor cond = new Conductor();
        cond.setLicencia(licencia);
        System.out.println("licencia+++++ variable de la vista "+licencia);
        System.out.println("licencia ++++++ desde objeto cond "+cond.getLicencia());
        conductor = cdao.consultarXLicencia(cond);
        System.out.println("*************** Conductor ID "+conductor.getIdConductor());
        idconductor = conductor.getIdConductor();
        System.out.println("IdConductor *******"+idconductor);
        Esquela es = new Esquela();
        Conductor c = new Conductor();
        c.setIdConductor(idconductor);
        es.setIdConductor(c);
        listEsId = cdao.EsquelaXLicencia(es);
        
    }
    

    
    
    public List<Conductor> prueba(){
        listConductor = cdao.consultaConductores();
        return listConductor;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Vehiculo> getListVehiculo() {
        return listVehiculo;
    }

    public void setListVehiculo(List<Vehiculo> listVehiculo) {
        this.listVehiculo = listVehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public List<Conductor> getListConductor() {
        return listConductor;
    }

    public void setListConductor(List<Conductor> listConductor) {
        this.listConductor = listConductor;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Integer getIdconductor() {
        return idconductor;
    }

    public void setIdconductor(Integer idconductor) {
        this.idconductor = idconductor;
    }

    public List<Esquela> getListEsId() {
        return listEsId;
    }

    public void setListEsId(List<Esquela> listEsId) {
        this.listEsId = listEsId;
    }
    
    
    
   
}

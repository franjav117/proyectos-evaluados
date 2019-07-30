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
public class ConsultaMb implements Serializable {

    private Vehiculo vehiculo;
    private List<Vehiculo> listVehiculo;
    private Conductor conductor;
    private List<Conductor> listConductor;
    private String licencia;
    private Integer idconductor;
    private List<Esquela> listEsId, listEsquela;
    private ConsultaDao cdao;

    @PostConstruct
    public void ini() {
        vehiculo = new Vehiculo();
        conductor = new Conductor();
        listVehiculo = new ArrayList<Vehiculo>();
        listConductor = new ArrayList<Conductor>();
        listEsId = new ArrayList<Esquela>();
        listEsquela = new ArrayList<Esquela>();
        cdao = new ConsultaDao();
        consultarEsquelas();    
    }

    public void consultarXEsquela() {
        try {
            conductor = new Conductor();
            Conductor cond = new Conductor();
            cond.setLicencia(licencia);
            listEsId = cdao.listadoEsquelasNit(cond);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void consultarXPlaca(){
        try {
            listEsId = cdao.listadoEsquelasPlaca(vehiculo);
        } catch (Exception e) {
        }
    }

    public void consultarEsquelas() {
        listEsquela = cdao.consultaEsquelas();
        Integer i = listEsquela.size();
        if(i != 0){
            System.out.println("***************CONECION EXITOSA***************");
        }else{
            System.out.println("***************LACA***************");
        }
    }

    public List<Esquela> getListEsquela() {
        return listEsquela;
    }

    public void setListEsquela(List<Esquela> listEsquela) {
        this.listEsquela = listEsquela;
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

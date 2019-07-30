/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.*;
import com.esquelas.entities.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author melvin.madridusam
 */
@ManagedBean
@SessionScoped
public class VehiculoMb implements Serializable {

    private List<Vehiculo> listvehiculo;
    private Vehiculo vehiculo;
    private List<Persona> listpersona;
    private Map<String, String> selectPersona;
    private List<TipoMatricula> listTipoMa;
    private Map<String, String> selectTipoMa;
    private Integer idPersonaView, idTipoMaView;
    private boolean extrView = false;

    private GenericDao gd;
    private VehiculoDao vdao;
    private TipoMatriculaDao tmdao;

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();
        gd = new GenericDao();
        vdao = new VehiculoDao();
        tmdao = new TipoMatriculaDao();
        listvehiculo = new ArrayList<Vehiculo>();
        listTipoMa = new ArrayList<TipoMatricula>();
        listpersona = new ArrayList<Persona>();
        selectPersona = new HashMap<String, String>();
        selectTipoMa = new HashMap<String, String>();
        llenarSelectTipoMatricula();

    }

//***********************************************************Metodo para Guardar******************************************
    public void insertarVehiculo() {
        vehiculo = new Vehiculo();
        Persona idP = new Persona();
        idP.setIdPersona(idPersonaView);

        TipoMatricula idTipo = new TipoMatricula();
        idTipo.setIdTipoMatricula(idTipoMaView);

        //Vehiculo idExtra = new Vehiculo();
        //idExtra.setExtrangera(extrView);
        vehiculo.setIdPersona(idP);
        vehiculo.setTipoPlaca(idTipo);
        vehiculo.setExtrangera(extrView);
        vehiculo = (Vehiculo) gd.insertarEntidad(vehiculo);
        FacesMessage msg;
        if (null != vehiculo) {
            msg = new FacesMessage("Producto Guardado Satisfactoriamente");
        } else {
            msg = new FacesMessage("Error guardando producto");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//**************************************************************Llena el select de Personas******************************************
    public void llenarSelectPersona() {
        //  listpersona = PersonaDao
    }
//System.out.println("+++++++++++++++lista MB"+listTipoMa.size());
//**************************************************************Llena el select de Tipo Matricula*************************************    
    public void llenarSelectTipoMatricula() {
        
            listTipoMa = tmdao.consultarMatriculas();
            for (TipoMatricula tm : listTipoMa) {
                selectTipoMa.put(tm.getCodigoMatricula(), String.valueOf(tm.getIdTipoMatricula()));
            }
    }

//**************************************************************Funcion Actualziar****************************************************  
    public void actualizarVehiculo() {
        vehiculo = new Vehiculo();
        Persona idP = new Persona();
        idP.setIdPersona(idPersonaView);
        TipoMatricula idTipo = new TipoMatricula();
        idTipo.setIdTipoMatricula(idTipoMaView);
        vehiculo.setIdPersona(idP);
        vehiculo.setTipoPlaca(idTipo);
        String mensaje = gd.actualizarEntidad(vehiculo);
        consultarVehiculos();
        FacesMessage msg = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

//**************************************************************Funcion Eliminar*******************************************************  
    public void eliminarVehiculo(Vehiculo alv) {
        String msj = vdao.eliminarVehiculo(alv);
        consultarVehiculos();
        FacesMessage msg = new FacesMessage(msj);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//**************************************************************Consulta Vehiculos*****************************************************    
    public void consultarVehiculos() {
        listvehiculo = vdao.consultarVehiculos();
    }

//**************************************************************Getter and Setter******************************************************    
    public List<Vehiculo> getListvehiculo() {
        return listvehiculo;
    }

    public void setListvehiculo(List<Vehiculo> listvehiculo) {
        this.listvehiculo = listvehiculo;
    }

    public List<Persona> getListpersona() {
        return listpersona;
    }

    public void setListpersona(List<Persona> listpersona) {
        this.listpersona = listpersona;
    }

    public Map<String, String> getSelectPersona() {
        return selectPersona;
    }

    public void setSelectPersona(Map<String, String> selectPersona) {
        this.selectPersona = selectPersona;
    }

    public List<TipoMatricula> getListTipoMa() {
        return listTipoMa;
    }

    public void setListTipoMa(List<TipoMatricula> listTipoMa) {
        this.listTipoMa = listTipoMa;
    }

    public Map<String, String> getSelectTipoMa() {
        return selectTipoMa;
    }

    public void setSelectTipoMa(Map<String, String> selectTipoMa) {
        this.selectTipoMa = selectTipoMa;
    }

    public Integer getIdPersonaView() {
        return idPersonaView;
    }

    public void setIdPersonaView(Integer idPersonaView) {
        this.idPersonaView = idPersonaView;
    }

    public Integer getIdTipoMaView() {
        return idTipoMaView;
    }

    public void setIdTipoMaView(Integer idTipoMaView) {
        this.idTipoMaView = idTipoMaView;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isExtrView() {
        return extrView;
    }

    public void setExtrView(boolean extrView) {
        this.extrView = extrView;
    }

}

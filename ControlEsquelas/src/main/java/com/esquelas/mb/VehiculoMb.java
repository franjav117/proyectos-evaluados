/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.*;
import com.esquelas.entities.*;
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
public class VehiculoMb {

    private List<Vehiculo> listvehiculo;
    private Vehiculo vehiculo;
    private List<Persona> listpersona;
    private Map<String, String> selectPersona;
    private List<TipoMatricula> listTipoMa;
    private Map<String, String> selectTipoMa;
    private Integer idPersonaView, idTipoMaView;

    private GenericDao gd;
    private VehiculoDao vdao;
    private TipoMatriculaDao tmdao;

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();
        gd = new GenericDao();
        vdao = new VehiculoDao();
        listvehiculo = new ArrayList<Vehiculo>();
        listTipoMa = new ArrayList<TipoMatricula>();
        listpersona = new ArrayList<Persona>();
        selectPersona = new HashMap<String, String>();
        selectTipoMa = new HashMap<String, String>();
        llenarSelectTipoMatricula();
    }

    public void insertarVehiculo() {
        vehiculo = new Vehiculo();
        Persona idP = new Persona();
        idP.setIdPersona(idPersonaView);
        TipoMatricula idTipo = new TipoMatricula();
        idTipo.setIdTipoMatricula(idTipoMaView);
        vehiculo.setIdPersona(idP);
        vehiculo.setTipoPlaca(idTipo);
        vehiculo = (Vehiculo) gd.insertarEntidad(vehiculo);
        FacesMessage msg;
        if (null != vehiculo) {
            msg = new FacesMessage("Producto Guardado Satisfactoriamente");
        } else {
            msg = new FacesMessage("Error guardando producto");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void llenarSelectPersona() {
        //  listpersona = PersonaDao
    }

    public void llenarSelectTipoMatricula() {
        listTipoMa = tmdao.consultarMatriculas();
    }

    public void actualizarVehiculo() {
        vehiculo = new Vehiculo();
        Persona idP = new Persona();
        idP.setIdPersona(idPersonaView);
        TipoMatricula idTipo = new TipoMatricula();
        idTipo.setIdTipoMatricula(idTipoMaView);
        vehiculo.setIdPersona(idP);
        vehiculo.setTipoPlaca(idTipo);
        String mensaje = gd.actualizarEntidad(vehiculo);
        
    }
}

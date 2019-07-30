/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.EsquelasDao;
import com.esquelas.dao.GenericDao;
import com.esquelas.dao.RelacionesGeneralesDao;
import com.esquelas.entities.Clasificacion;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Decomiso;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Estado;
import com.esquelas.entities.Otros;
import com.esquelas.entities.Persona;
import com.esquelas.entities.TipoGravedad;
import com.esquelas.entities.Vehiculo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author rogelio.mejiausam
 */
@ManagedBean
@SessionScoped
public class EsquelaMb implements Serializable{
    private EsquelasDao esquDAO;
    private GenericDao gd;
    private RelacionesGeneralesDao rgDao;
    private List<Esquela> listEsquela;
    private Esquela esquela;
    private String licencia;
    private Integer idEsquela;
    private Integer idConductor;
    private Conductor conductor;
    private Integer est;
    
    @PostConstruct
    public void init(){
       esquDAO = new EsquelasDao(); 
       gd = new GenericDao();
       listEsquela = new ArrayList<>();
       esquela = new Esquela();
       conductor = new Conductor();
       rgDao = new RelacionesGeneralesDao();
//       Test();
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
            System.out.println(" MB List por licencia size  " + listEsquela.size());
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
    public void selecIdEstado(Esquela idEsq){
        idEsquela = idEsq.getIdEsquela();
        System.out.println("++++++++ ID ESQUELA ENVIADO " + idEsquela);
        cambiarEstadoPago();
    }
    
    //Este método ni me lo vayan a tocar  **********************************************
    
    public void cambiarEstadoPago(){
        
       // idEsquela = idEsq.getIdEsquela();
        System.out.println("++++++++ ID ESQUELA ENVIADO " + idEsquela);
                
        Estado estado = new Estado();
        estado.setIdEstado(rgDao.idEstado(idEsquela));
        if(estado.getIdEstado() == 1){
           estado.setIdEstado(2); 
        }else if(estado.getIdEstado() == 2) {
            estado.setIdEstado(1);
        }  
            try {
           esquela.setIdConductor(rgDao.idConductor(idEsquela));
           Vehiculo vehiculo = new Vehiculo();
           vehiculo.setIdVehiculo(rgDao.idVehiculo(idEsquela));
           esquela.setPlaca(vehiculo);
           esquela.setIdAgente(rgDao.esquelaDatosPuros(idEsquela).getIdAgente());
           esquela.setCodigoFalta(rgDao.esquelaDatosPuros(idEsquela).getCodigoFalta()); //String
           Clasificacion c = new Clasificacion();
           c.setIdClasificacion(rgDao.idClasificacion(idEsquela));
           esquela.setClasificacion(c);
           esquela.setFechaEsquela(rgDao.esquelaDatosPuros(idEsquela).getFechaEsquela()); //Date
           esquela.setLugarInfraccion(rgDao.esquelaDatosPuros(idEsquela).getLugarInfraccion()); //String
           esquela.setObservaciones(rgDao.esquelaDatosPuros(idEsquela).getObservaciones()); //String
                TipoGravedad tg = new TipoGravedad();
                tg.setIdGravedad(rgDao.idTipoGravedad(idEsquela));
           esquela.setTipoGravedad(tg);
           esquela.setMontoPagar(rgDao.esquelaDatosPuros(idEsquela).getMontoPagar()); //Double
           esquela.setEstado(estado);
           esquela.setIdDepartamento(rgDao.idDepartamento(idEsquela));
                Decomiso de = new Decomiso();
                de.setIdDecomiso(rgDao.idDecomiso(idEsquela));
                System.out.println("************DECOMISO "+ de.getDecomiso());
           esquela.setIdDecomiso(de);
                Otros o = new Otros();
                o.setIdOtro(rgDao.idOtros(idEsquela));
           esquela.setIdOtros(o);
           esquela.setIdEsquela(idEsquela);
           //Datos seteados
           gd.actualizarEntidad(esquela); //Envio a actualizar
           listadoEsquelaNit();
           System.out.println("++++++++++++++" +esquela.getEstado().getEstadoMulta());
//           esquela = new Esquela();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //licencia = esquela.getIdConductor().getLicencia();   //Posible formula para mantener la licencia en memoria
        //en caso que al refrescar la licencia retorne a 0 o a null
           
           System.out.println("++++++++ Estado sin pago " + esquela.getEstado().getIdEstado());
       
        
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

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
    }
    
    
    
    
}

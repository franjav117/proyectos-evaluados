<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

/**
 *
 * @author francisco.amayausam
 */
public class EsquelaMb {
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.EsquelasDao;
import com.esquelas.dao.GenericDao;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author rogelio.mejiausam
 */
@ManagedBean
public class EsquelaMb {
    private EsquelasDao esquDAO;
    private GenericDao gd;
    private List<Esquela> listEsquela;
    
    @PostConstruct
    public void init(){
       esquDAO = new EsquelasDao(); 
       gd = new GenericDao();
       listEsquela = new ArrayList<>();
    }
    
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
}
>>>>>>> feature_rogelio

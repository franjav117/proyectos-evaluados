/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.EsquelaDao;
import com.esquelas.dao.GenericDao;
import com.esquelas.dao.RelacionesGeneralesDao;
import com.esquelas.dao.TemporalDao;
import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Clasificacion;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Decomiso;
import com.esquelas.entities.Departamento;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Estado;
import com.esquelas.entities.Otros;
import com.esquelas.entities.TipoGravedad;
import com.esquelas.entities.Vehiculo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author francisco.amayausam
 */
@ManagedBean
@ViewScoped
public class RegistroEsquelasMb {
    
    private Esquela esquela;
    private List<Esquela> esquelaList; //mostrar de esquelas
    
    private List<Estado> estadoList; //1
    private List<Departamento> departamentoList; //2
    private List<TipoGravedad> tipoGravedadList; //3
    private List<Decomiso> DecomisoList;//4
    private List<Otros> OtrosList;//5
    private List<Clasificacion> clasificacionList;//6
    private List<Conductor> ConductorList;//7
    private List<AgenteTransito> AgenteTransitoList;//8
    private List<Vehiculo> vehiculoList;//9
    
    private Map<String, String> EstadoSelect;//1
    private Map<String, String> DepartamentoSelect;//2
    private Map<String, String> TipoGravedadSelect;//3
    private Map<String, String> DecomisoSelect;//4
    private Map<String, String> OtrosSelect;//5
    private Map<String, String> ClasificacionSelect;//6
    private Map<String, String> ConductorSelect;//7
    private Map<String, String> AgenteTransitoSelect;//8
    private Map<String, String> VehiculoSelect;//9
    
    private Integer Estadoview;//1
    private Integer Departamentoview;//2
    private Integer TipoGravedadview;//3
    private Integer Decomisoview;//4
    private Integer Otrosview;//5
    private Integer Clasificacionview;//6
    private Integer Conductorview;//7
    private Integer AgenteTransitoview;//8
    private Integer Vehiculoview;//9
    
    private GenericDao gd;
    private EsquelaDao ed;
    private RelacionesGeneralesDao rgd;
    private TemporalDao rgd1;
    
    @PostConstruct
    public void  init(){
        esquela = new Esquela();
        esquelaList = new ArrayList<Esquela>();
                
        estadoList = new ArrayList<Estado>();//1
        departamentoList = new ArrayList<Departamento>();//2
        tipoGravedadList = new ArrayList<TipoGravedad>();//3
        DecomisoList = new ArrayList<Decomiso>();//4
        OtrosList = new ArrayList<Otros>();//5
        clasificacionList = new ArrayList<Clasificacion>();//6
        ConductorList = new ArrayList<Conductor>();//7
        AgenteTransitoList = new ArrayList<AgenteTransito>();//8
        vehiculoList = new ArrayList<Vehiculo>();//9
                
        EstadoSelect = new HashMap<String,String>();//1
        DepartamentoSelect = new HashMap<String,String>();//2    
        TipoGravedadSelect = new HashMap<String,String>();//3       
        DecomisoSelect = new HashMap<String,String>();//4       
        OtrosSelect = new HashMap<String,String>();//5       
        ClasificacionSelect = new HashMap<String,String>();//6 
        ConductorSelect = new HashMap<String,String>();//7  
        AgenteTransitoSelect = new HashMap<String,String>();//8       
        VehiculoSelect = new HashMap<String,String>();//9       
        
        gd = new GenericDao();
        ed = new EsquelaDao();
        rgd = new RelacionesGeneralesDao();
        rgd1 = new TemporalDao();
    }
    
    public void obtenerEstado() {//1
        estadoList = rgd.obtenerEstado();
        for (Estado e : estadoList) {
            EstadoSelect.put(e.getEstadoMulta(), String.valueOf(e.getIdEstado()));
        }
    }
    
    public void obtenerDepartamento() {//2
        departamentoList = rgd.obtenerDepartamento();
        for (Departamento d : departamentoList) {
            DepartamentoSelect.put(d.getDepartamento(), String.valueOf(d.getIdDepartamento()));
        }
    }
    
    public void obtenerTipoGravedad() {//3
        tipoGravedadList = rgd.obtenerTipoGravedad();
        for (TipoGravedad td : tipoGravedadList) {
            TipoGravedadSelect.put(td.getGravedad(), String.valueOf(td.getIdGravedad()));
        }
    }
    
    public void obtenerDecomiso() {//4
        DecomisoList = rgd.obtenerDecomiso();
        for (Decomiso dec : DecomisoList) {
            DecomisoSelect.put(dec.getDecomiso(), String.valueOf(dec.getIdDecomiso()));
        }
    }
    
    public void obtenerOtros() {//5
        OtrosList = rgd.obtenerOtros();
        for (Otros o : OtrosList) {
            OtrosSelect.put(o.getEspecificacion(), String.valueOf(o.getIdOtro()));
        }
    }
    
    public void obtenerClasificacion() {//6
        clasificacionList = rgd.obtenerClasificacion();
        for (Clasificacion cl : clasificacionList) {
            ClasificacionSelect.put(cl.getClasificacion(), String.valueOf(cl.getIdClasificacion()));
        }
    }
    
    public void obtenerConductor(){
        ConductorList = rgd1.obtenerConductor();
        for(Conductor con : ConductorList){
            ConductorSelect.put(String.valueOf(con.getIdPersona()), String.valueOf(con.getIdConductor()));
        }
    }
    
}

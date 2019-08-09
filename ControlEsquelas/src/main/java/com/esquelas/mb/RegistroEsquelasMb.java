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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author francisco.amayausam
 */
@ManagedBean
@ViewScoped
public class RegistroEsquelasMb implements Serializable {

    private Esquela esquela;
    private Conductor conductor;
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
    public void init() {
        esquela = new Esquela();
        conductor = new Conductor();
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

        EstadoSelect = new HashMap<String, String>();//1
        DepartamentoSelect = new HashMap<String, String>();//2    
        TipoGravedadSelect = new HashMap<String, String>();//3       
        DecomisoSelect = new HashMap<String, String>();//4       
        OtrosSelect = new HashMap<String, String>();//5       
        ClasificacionSelect = new HashMap<String, String>();//6 
        ConductorSelect = new HashMap<String, String>();//7  
        AgenteTransitoSelect = new HashMap<String, String>();//8       
        VehiculoSelect = new HashMap<String, String>();//9       

        gd = new GenericDao();
        ed = new EsquelaDao();
        rgd = new RelacionesGeneralesDao();
        rgd1 = new TemporalDao();

        mostrarEsquelas();

        obtenerEstado();
        obtenerDepartamento();
        obtenerTipoGravedad();
        obtenerDecomiso();
        obtenerOtros();
        obtenerClasificacion();
        obtenerConductor();
        obtenerAgenteTransito();
        obtenerVehiculo();
    }

    public void guardarEsquela() {
        FacesMessage msg = null;

        Conductor idcon = new Conductor();
        Vehiculo idveh = new Vehiculo();
        AgenteTransito idag = new AgenteTransito();
        Clasificacion idcla = new Clasificacion();
        TipoGravedad idgra = new TipoGravedad();
        Estado ides = new Estado();
        Departamento iddep = new Departamento();
        Decomiso iddec = new Decomiso();
        Otros idot = new Otros();

        idcon.setIdConductor(Conductorview);
        esquela.setIdConductor(idcon);

        idveh.setIdVehiculo(Vehiculoview);
        esquela.setPlaca(idveh);

        idag.setIdAgente(AgenteTransitoview);
        esquela.setIdAgente(idag);

        idcla.setIdClasificacion(Clasificacionview);
        esquela.setClasificacion(idcla);

        idgra.setIdGravedad(TipoGravedadview);
        esquela.setTipoGravedad(idgra);

        ides.setIdEstado(Estadoview);
        esquela.setEstado(ides);

        iddep.setIdDepartamento(Departamentoview);
        esquela.setIdDepartamento(iddep);

        iddec.setIdDecomiso(Decomisoview);
        esquela.setIdDecomiso(iddec);

        idot.setIdOtro(Otrosview);
        esquela.setIdOtros(idot);
        
        esquela.getEstado().setIdEstado(1);

        esquela = (Esquela) gd.insertarEntidad(esquela);
        if (null != esquela) {
            msg = new FacesMessage("Esquela registrada " + esquela.getIdEsquela());
            esquela = new Esquela();
            EstadoSelect = new HashMap<String, String>();//1
            DepartamentoSelect = new HashMap<String, String>();//2    
            TipoGravedadSelect = new HashMap<String, String>();//3       
            DecomisoSelect = new HashMap<String, String>();//4       
            OtrosSelect = new HashMap<String, String>();//5       
            ClasificacionSelect = new HashMap<String, String>();//6 
            ConductorSelect = new HashMap<String, String>();//7  
            AgenteTransitoSelect = new HashMap<String, String>();//8       
            VehiculoSelect = new HashMap<String, String>();//9  
            mostrarEsquelas();

        } else {
            msg = new FacesMessage("Error registrando esquela");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        mostrarEsquelas();

    }

    public void consultById(Esquela ide) {
        esquela = ed.findEsquelaById(ide);
        

        //this.esquela = ide;
    }
    
    public void limpiar() {
        esquela = new Esquela();
        Conductorview = 0;
        AgenteTransitoview = 0;
        Clasificacionview = 0;
        TipoGravedadview = 0;
        Decomisoview = 0;
        Vehiculoview = 0;
        Departamentoview = 0;
        Otrosview = 0;
    }
    
    public void fullConsultById(Esquela esq) {
        esquela = ed.findEsquelaById(esq);
        Conductorview = esq.getIdConductor().getIdConductor();
        AgenteTransitoview = esq.getIdAgente().getIdAgente();
        Clasificacionview = esq.getClasificacion().getIdClasificacion();
        TipoGravedadview = esq.getTipoGravedad().getIdGravedad();
        Decomisoview = esq.getIdDecomiso().getIdDecomiso();
        Vehiculoview = esq.getPlaca().getIdVehiculo();
        Departamentoview = esq.getIdDepartamento().getIdDepartamento();
        Otrosview = esq.getIdOtros().getIdOtro();

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

    public void obtenerConductor() {//7
        ConductorList = rgd1.obtenerConductor();
        for (Conductor con : ConductorList) {
            ConductorSelect.put(String.valueOf(con.getLicencia()), String.valueOf(con.getIdConductor()));
        }
    }

    public void obtenerAgenteTransito() {//8
        AgenteTransitoList = rgd1.obtenerAgenteTransito();
        for (AgenteTransito at : AgenteTransitoList) {
            AgenteTransitoSelect.put(String.valueOf(at.getNumPlaca()), String.valueOf(at.getIdAgente()));
        }
    }

    public void obtenerVehiculo() {//9
        vehiculoList = rgd1.obtenerVehiculo();
        for (Vehiculo v : vehiculoList) {
            VehiculoSelect.put(v.getNumeroPlaca(), String.valueOf(v.getIdVehiculo()));
        }
    }

    public void mostrarEsquelas() {//cargar tabla
        esquelaList = ed.consultarEsquela();
    }

    public Esquela getEsquela() {
        return esquela;
    }

    public void setEsquela(Esquela esquela) {
        this.esquela = esquela;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public List<Esquela> getEsquelaList() {
        return esquelaList;
    }

    public void setEsquelaList(List<Esquela> esquelaList) {
        this.esquelaList = esquelaList;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<TipoGravedad> getTipoGravedadList() {
        return tipoGravedadList;
    }

    public void setTipoGravedadList(List<TipoGravedad> tipoGravedadList) {
        this.tipoGravedadList = tipoGravedadList;
    }

    public List<Decomiso> getDecomisoList() {
        return DecomisoList;
    }

    public void setDecomisoList(List<Decomiso> DecomisoList) {
        this.DecomisoList = DecomisoList;
    }

    public List<Otros> getOtrosList() {
        return OtrosList;
    }

    public void setOtrosList(List<Otros> OtrosList) {
        this.OtrosList = OtrosList;
    }

    public List<Clasificacion> getClasificacionList() {
        return clasificacionList;
    }

    public void setClasificacionList(List<Clasificacion> clasificacionList) {
        this.clasificacionList = clasificacionList;
    }

    public List<Conductor> getConductorList() {
        return ConductorList;
    }

    public void setConductorList(List<Conductor> ConductorList) {
        this.ConductorList = ConductorList;
    }

    public List<AgenteTransito> getAgenteTransitoList() {
        return AgenteTransitoList;
    }

    public void setAgenteTransitoList(List<AgenteTransito> AgenteTransitoList) {
        this.AgenteTransitoList = AgenteTransitoList;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public Map<String, String> getEstadoSelect() {
        return EstadoSelect;
    }

    public void setEstadoSelect(Map<String, String> EstadoSelect) {
        this.EstadoSelect = EstadoSelect;
    }

    public Map<String, String> getDepartamentoSelect() {
        return DepartamentoSelect;
    }

    public void setDepartamentoSelect(Map<String, String> DepartamentoSelect) {
        this.DepartamentoSelect = DepartamentoSelect;
    }

    public Map<String, String> getTipoGravedadSelect() {
        return TipoGravedadSelect;
    }

    public void setTipoGravedadSelect(Map<String, String> TipoGravedadSelect) {
        this.TipoGravedadSelect = TipoGravedadSelect;
    }

    public Map<String, String> getDecomisoSelect() {
        return DecomisoSelect;
    }

    public void setDecomisoSelect(Map<String, String> DecomisoSelect) {
        this.DecomisoSelect = DecomisoSelect;
    }

    public Map<String, String> getOtrosSelect() {
        return OtrosSelect;
    }

    public void setOtrosSelect(Map<String, String> OtrosSelect) {
        this.OtrosSelect = OtrosSelect;
    }

    public Map<String, String> getClasificacionSelect() {
        return ClasificacionSelect;
    }

    public void setClasificacionSelect(Map<String, String> ClasificacionSelect) {
        this.ClasificacionSelect = ClasificacionSelect;
    }

    public Map<String, String> getConductorSelect() {
        return ConductorSelect;
    }

    public void setConductorSelect(Map<String, String> ConductorSelect) {
        this.ConductorSelect = ConductorSelect;
    }

    public Map<String, String> getAgenteTransitoSelect() {
        return AgenteTransitoSelect;
    }

    public void setAgenteTransitoSelect(Map<String, String> AgenteTransitoSelect) {
        this.AgenteTransitoSelect = AgenteTransitoSelect;
    }

    public Map<String, String> getVehiculoSelect() {
        return VehiculoSelect;
    }

    public void setVehiculoSelect(Map<String, String> VehiculoSelect) {
        this.VehiculoSelect = VehiculoSelect;
    }

    public Integer getEstadoview() {
        return Estadoview;
    }

    public void setEstadoview(Integer Estadoview) {
        this.Estadoview = Estadoview;
    }

    public Integer getDepartamentoview() {
        return Departamentoview;
    }

    public void setDepartamentoview(Integer Departamentoview) {
        this.Departamentoview = Departamentoview;
    }

    public Integer getTipoGravedadview() {
        return TipoGravedadview;
    }

    public void setTipoGravedadview(Integer TipoGravedadview) {
        this.TipoGravedadview = TipoGravedadview;
    }

    public Integer getDecomisoview() {
        return Decomisoview;
    }

    public void setDecomisoview(Integer Decomisoview) {
        this.Decomisoview = Decomisoview;
    }

    public Integer getOtrosview() {
        return Otrosview;
    }

    public void setOtrosview(Integer Otrosview) {
        this.Otrosview = Otrosview;
    }

    public Integer getClasificacionview() {
        return Clasificacionview;
    }

    public void setClasificacionview(Integer Clasificacionview) {
        this.Clasificacionview = Clasificacionview;
    }

    public Integer getConductorview() {
        return Conductorview;
    }

    public void setConductorview(Integer Conductorview) {
        this.Conductorview = Conductorview;
    }

    public Integer getAgenteTransitoview() {
        return AgenteTransitoview;
    }

    public void setAgenteTransitoview(Integer AgenteTransitoview) {
        this.AgenteTransitoview = AgenteTransitoview;
    }

    public Integer getVehiculoview() {
        return Vehiculoview;
    }

    public void setVehiculoview(Integer Vehiculoview) {
        this.Vehiculoview = Vehiculoview;
    }

    public GenericDao getGd() {
        return gd;
    }

    public void setGd(GenericDao gd) {
        this.gd = gd;
    }

    public EsquelaDao getEd() {
        return ed;
    }

    public void setEd(EsquelaDao ed) {
        this.ed = ed;
    }

    public RelacionesGeneralesDao getRgd() {
        return rgd;
    }

    public void setRgd(RelacionesGeneralesDao rgd) {
        this.rgd = rgd;
    }

    public TemporalDao getRgd1() {
        return rgd1;
    }

    public void setRgd1(TemporalDao rgd1) {
        this.rgd1 = rgd1;
    }
}

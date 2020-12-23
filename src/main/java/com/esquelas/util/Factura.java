/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.util;

import com.esquelas.dao.EsquelasDao;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.ReporteFactura;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author rogelio.mejiausam
 */
@ManagedBean
@ViewScoped
public class Factura {  //Controlador para manejar los Reportes
   private List<Esquela> listEsquela;
   private List<ReporteFactura> listReporte;
   private JasperPrint jp;
   private String reporteNombre;
   private ReporteFactura reportFac;
   private EsquelasDao esqDao;
   private Esquela esquela;
   
   @PostConstruct
    public void init() {
   esqDao = new EsquelasDao();
   esquela = new Esquela();
    }
    
   
   public void reporte(){
       listEsquela = esqDao.listadoEsquelaId(esquela);
       listReporte = new ArrayList<>();
       
       System.out.println("*********** Tamaño " + listEsquela.size());
       for(Esquela es: listEsquela){
           reportFac = new ReporteFactura();
           reportFac.setIdEsquela(String.valueOf(es.getIdEsquela()));
           
           
//Aqui estoy concatenando los nombres y apellidos con un espacio de por medio y pasandolos a un String Unico
           String nameCon = es.getIdConductor().getIdPersona().getN1Nombre() +" "+ es.getIdConductor().getIdPersona().getN2Nombre() +" "+ es.getIdConductor().getIdPersona().getN3Nombre() +" "+
                   es.getIdConductor().getIdPersona().getA1Apellido() +" "+ es.getIdConductor().getIdPersona().getA2Apellido() +" "+ es.getIdConductor().getIdPersona().getA3Apellido();
           reportFac.setIdConductor(nameCon); //Pasandole el String nameCon al Conductor de la clase espejo
           
           reportFac.setPlaca(es.getPlaca().getNumeroPlaca());
           reportFac.setCodigoFalta(es.getCodigoFalta());
           reportFac.setClasificacion(es.getClasificacion().getClasificacion());
           
           SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); //Instancia de Simple Date Format
           String fechaEs = sdf.format(es.getFechaEsquela()); //Fecha de puesta Esquela a dd/MM/yyyy
           reportFac.setFechaEsquela(fechaEs); //String con los datos de fecha a la entidad espejo
           
           reportFac.setLugarInfraccion(es.getLugarInfraccion());
           reportFac.setObservaciones(es.getObservaciones());
           reportFac.setTipoGravedad(es.getTipoGravedad().getGravedad());
           reportFac.setMontoPagar(String.valueOf(es.getMontoPagar()));
           reportFac.setEstado(es.getEstado().getEstadoMulta());
           

           String fechaP = sdf.format(es.getFechaPago()); //Fecha de pago Esquela a dd/MM/yyyy
           reportFac.setFechaPago(String.valueOf(fechaP)); //String con los datos de fecha a la entidad espejo
           
//Mismo proceso de antes pero con el cajero
           String nameCaj = es.getIdCajero().getIdPersona().getN1Nombre() +" "+ es.getIdCajero().getIdPersona().getN2Nombre() +" "+ es.getIdCajero().getIdPersona().getN3Nombre()+" "+
                   es.getIdCajero().getIdPersona().getA1Apellido() +" "+ es.getIdCajero().getIdPersona().getA2Apellido() +" "+ es.getIdCajero().getIdPersona().getA3Apellido();
           
           
           reportFac.setIdCajero(nameCaj);
           reportFac.setDepartamento(es.getIdDepartamento().getDepartamento());
           reportFac.setDecomiso(es.getIdDecomiso().getDecomiso());
           reportFac.setOtros(es.getIdOtros().getEspecificacion());
           
           
           System.out.println("----------------- ID "+reportFac.getIdEsquela());
           System.out.println("-----------------Nombre conductor " + reportFac.getIdConductor()); //Prueba para ver si concatena bien
           System.out.println("-----------------Fecha esquela " +reportFac.getFechaEsquela()); //impresion de prueba
           System.out.println("-----------------Fecha Pago " +reportFac.getFechaPago()); //impresion de prueba
           System.out.println("----------------- Placa "+reportFac.getPlaca());
           System.out.println("----------------- Falta "+reportFac.getCodigoFalta());
           System.out.println("----------------- Clasificacion "+reportFac.getClasificacion());
           System.out.println("-----------------Lugar Infraccion " +reportFac.getLugarInfraccion());
           System.out.println("-----------------Observaciones " +reportFac.getObservaciones());
           System.out.println("-----------------Tipo Gravedad " +reportFac.getTipoGravedad());
           System.out.println("-----------------Monto " +reportFac.getMontoPagar());
           System.out.println("-----------------Estado " +reportFac.getEstado());
           System.out.println("-----------------Nombre cajero" + reportFac.getIdCajero()); //Prueba para ver si concatena bien
           System.out.println("-----------------Departamento" + reportFac.getDepartamento()); 
           System.out.println("-----------------Decomiso" + reportFac.getDecomiso()); 
           System.out.println("-----------------Otros" + reportFac.getOtros()); 
           listReporte.add(reportFac);
       }
   }
   
   public void createFac() throws IOException, JRException {
        reporte();
        JRBeanCollectionDataSource jbcd = new JRBeanCollectionDataSource(listReporte);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Reportes/Factura.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        jp = JasperFillManager.fillReport(reportPath, map, jbcd);
        toPdf();
    }

    public void toPdf() throws IOException, JRException {
//Obtenenmos el contexto de la aplicacion
        HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//Definimos el de header del response
        hsr.addHeader("Content-dispotition", "attachment; filename= " + "factura.pdf");
//Declaramos un output del reporte
        ServletOutputStream sos = hsr.getOutputStream();
//Exportamos a PDF 
        JasperExportManager.exportReportToPdfStream(jp, sos);
        sos.flush();
//Completamos Response
        FacesContext.getCurrentInstance().responseComplete();
    }
   
    public List<Esquela> getListEsquela() {
        return listEsquela;
    }

    public void setListEsquela(List<Esquela> listEsquela) {
        this.listEsquela = listEsquela;
    }

    public List<ReporteFactura> getListReporte() {
        return listReporte;
    }

    public void setListReporte(List<ReporteFactura> listReporte) {
        this.listReporte = listReporte;
    }

    public JasperPrint getJp() {
        return jp;
    }

    public void setJp(JasperPrint jp) {
        this.jp = jp;
    }

    public String getReporteNombre() {
        return reporteNombre;
    }

    public void setReporteNombre(String reporteNombre) {
        this.reporteNombre = reporteNombre;
    }

    public ReporteFactura getReportFac() {
        return reportFac;
    }

    public void setReportFac(ReporteFactura reportFac) {
        this.reportFac = reportFac;
    }
   
   
   
}
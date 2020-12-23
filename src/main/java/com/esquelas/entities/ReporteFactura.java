/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.entities;

/**
 *
 * @author rogelio.mejiausam
 */
public class ReporteFactura {  //Entidad Espejo para mandar al PDF antes de exportar
    private String idEsquela;
    private String idConductor;
    private String placa;
    private String idAgente;
    private String codigoFalta;
    private String clasificacion;
    private String fechaEsquela;
    private String lugarInfraccion;
    private String observaciones;
    private String tipoGravedad;
    private String montoPagar;
    private String estado;
    private String fechaPago;
    private String idCajero;
    private String departamento;
    private String decomiso;
    private String otros;

    public ReporteFactura() {
    }

    public String getIdEsquela() {
        return idEsquela;
    }

    public void setIdEsquela(String idEsquela) {
        this.idEsquela = idEsquela;
    }

    public String getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public String getCodigoFalta() {
        return codigoFalta;
    }

    public void setCodigoFalta(String codigoFalta) {
        this.codigoFalta = codigoFalta;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getFechaEsquela() {
        return fechaEsquela;
    }

    public void setFechaEsquela(String fechaEsquela) {
        this.fechaEsquela = fechaEsquela;
    }

    public String getLugarInfraccion() {
        return lugarInfraccion;
    }

    public void setLugarInfraccion(String lugarInfraccion) {
        this.lugarInfraccion = lugarInfraccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoGravedad() {
        return tipoGravedad;
    }

    public void setTipoGravedad(String tipoGravedad) {
        this.tipoGravedad = tipoGravedad;
    }

    public String getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(String montoPagar) {
        this.montoPagar = montoPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(String idCajero) {
        this.idCajero = idCajero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDecomiso() {
        return decomiso;
    }

    public void setDecomiso(String decomiso) {
        this.decomiso = decomiso;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }
    
    
}

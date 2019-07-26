/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rogelio.mejiausam
 */
@Entity
@Table(name = "esquela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esquela.findAll", query = "SELECT e FROM Esquela e")
    , @NamedQuery(name = "Esquela.findByIdEsquela", query = "SELECT e FROM Esquela e WHERE e.idEsquela = :idEsquela")
    ,  @NamedQuery(name = "Esquela.findByLicencia", query = "SELECT e FROM Esquela e WHERE e.idConductor.licencia = :licencia")
    , @NamedQuery(name = "Esquela.findByDUI", query = "SELECT e FROM Esquela e WHERE e.idConductor.idPersona.dui = :dui")
    , @NamedQuery(name = "Esquela.findByDUILicencia", query = "SELECT e FROM Esquela e WHERE e.idConductor.idPersona.dui = :dui and e.idConductor.licencia = :licencia")
    , @NamedQuery(name = "Esquela.findByDUILicencia", query = "SELECT e FROM Esquela e WHERE e.placa.numeroPlaca = :placa")
    , @NamedQuery(name = "Esquela.findByCodigoFalta", query = "SELECT e FROM Esquela e WHERE e.codigoFalta = :codigoFalta")
    , @NamedQuery(name = "Esquela.findByFechaEsquela", query = "SELECT e FROM Esquela e WHERE e.fechaEsquela = :fechaEsquela")
    , @NamedQuery(name = "Esquela.findByLugarInfraccion", query = "SELECT e FROM Esquela e WHERE e.lugarInfraccion = :lugarInfraccion")
    , @NamedQuery(name = "Esquela.findByObservaciones", query = "SELECT e FROM Esquela e WHERE e.observaciones = :observaciones")
    , @NamedQuery(name = "Esquela.findByMontoPagar", query = "SELECT e FROM Esquela e WHERE e.montoPagar = :montoPagar")})
public class Esquela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_esquela")
    private Integer idEsquela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_falta")
    private String codigoFalta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_esquela")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEsquela;
    @Size(max = 100)
    @Column(name = "lugar_infraccion")
    private String lugarInfraccion;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_pagar")
    private double montoPagar;
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor")
    @ManyToOne(optional = false)
    private Conductor idConductor;
    @JoinColumn(name = "placa", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo placa;
    @JoinColumn(name = "id_agente", referencedColumnName = "id_agente")
    @ManyToOne(optional = false)
    private AgenteTransito idAgente;
    @JoinColumn(name = "clasificacion", referencedColumnName = "id_clasificacion")
    @ManyToOne
    private Clasificacion clasificacion;
    @JoinColumn(name = "tipo_gravedad", referencedColumnName = "id_gravedad")
    @ManyToOne
    private TipoGravedad tipoGravedad;
    @JoinColumn(name = "estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado estado;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @JoinColumn(name = "id_decomiso", referencedColumnName = "id_decomiso")
    @ManyToOne
    private Decomiso idDecomiso;
    @JoinColumn(name = "id_otros", referencedColumnName = "id_otro")
    @ManyToOne
    private Otros idOtros;

    public Esquela() {
    }

    public Esquela(Integer idEsquela) {
        this.idEsquela = idEsquela;
    }

    public Esquela(Integer idEsquela, String codigoFalta, Date fechaEsquela, double montoPagar) {
        this.idEsquela = idEsquela;
        this.codigoFalta = codigoFalta;
        this.fechaEsquela = fechaEsquela;
        this.montoPagar = montoPagar;
    }

    public Integer getIdEsquela() {
        return idEsquela;
    }

    public void setIdEsquela(Integer idEsquela) {
        this.idEsquela = idEsquela;
    }

    public String getCodigoFalta() {
        return codigoFalta;
    }

    public void setCodigoFalta(String codigoFalta) {
        this.codigoFalta = codigoFalta;
    }

    public Date getFechaEsquela() {
        return fechaEsquela;
    }

    public void setFechaEsquela(Date fechaEsquela) {
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

    public double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }

    public Conductor getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Conductor idConductor) {
        this.idConductor = idConductor;
    }

    public Vehiculo getPlaca() {
        return placa;
    }

    public void setPlaca(Vehiculo placa) {
        this.placa = placa;
    }

    public AgenteTransito getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(AgenteTransito idAgente) {
        this.idAgente = idAgente;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public TipoGravedad getTipoGravedad() {
        return tipoGravedad;
    }

    public void setTipoGravedad(TipoGravedad tipoGravedad) {
        this.tipoGravedad = tipoGravedad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Decomiso getIdDecomiso() {
        return idDecomiso;
    }

    public void setIdDecomiso(Decomiso idDecomiso) {
        this.idDecomiso = idDecomiso;
    }

    public Otros getIdOtros() {
        return idOtros;
    }

    public void setIdOtros(Otros idOtros) {
        this.idOtros = idOtros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsquela != null ? idEsquela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esquela)) {
            return false;
        }
        Esquela other = (Esquela) object;
        if ((this.idEsquela == null && other.idEsquela != null) || (this.idEsquela != null && !this.idEsquela.equals(other.idEsquela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.Esquela[ idEsquela=" + idEsquela + " ]";
    }
    
}

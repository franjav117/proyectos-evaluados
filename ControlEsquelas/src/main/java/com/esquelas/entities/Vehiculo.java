/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author melvin.madridusam
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculo.findByNumeroPlaca", query = "SELECT v FROM Vehiculo v WHERE v.numeroPlaca = :numeroPlaca")
    , @NamedQuery(name = "Vehiculo.findByCodigoRuta", query = "SELECT v FROM Vehiculo v WHERE v.codigoRuta = :codigoRuta")
    , @NamedQuery(name = "Vehiculo.findByExtrangera", query = "SELECT v FROM Vehiculo v WHERE v.extrangera = :extrangera")
    , @NamedQuery(name = "Vehiculo.findByPais", query = "SELECT v FROM Vehiculo v WHERE v.pais = :pais")
    , @NamedQuery(name = "Vehiculo.findByClaseVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.claseVehiculo = :claseVehiculo")
    , @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculo.findByAnio", query = "SELECT v FROM Vehiculo v WHERE v.anio = :anio")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_placa")
    private String numeroPlaca;
    @Size(max = 20)
    @Column(name = "codigo_ruta")
    private String codigoRuta;
    @Column(name = "extrangera")
    private Boolean extrangera;
    @Size(max = 50)
    @Column(name = "pais")
    private String pais;
    @Size(max = 50)
    @Column(name = "clase_vehiculo")
    private String claseVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 15)
    @Column(name = "color")
    private String color;
    @Column(name = "anio")
    private Integer anio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placa")
    private List<Esquela> esquelaList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "tipo_placa", referencedColumnName = "id_tipo_matricula")
    @ManyToOne
    private TipoMatricula tipoPlaca;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(Integer idVehiculo, String numeroPlaca, String marca, String modelo) {
        this.idVehiculo = idVehiculo;
        this.numeroPlaca = numeroPlaca;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(String codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public Boolean getExtrangera() {
        return extrangera;
    }

    public void setExtrangera(Boolean extrangera) {
        this.extrangera = extrangera;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getClaseVehiculo() {
        return claseVehiculo;
    }

    public void setClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo = claseVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @XmlTransient
    public List<Esquela> getEsquelaList() {
        return esquelaList;
    }

    public void setEsquelaList(List<Esquela> esquelaList) {
        this.esquelaList = esquelaList;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public TipoMatricula getTipoPlaca() {
        return tipoPlaca;
    }

    public void setTipoPlaca(TipoMatricula tipoPlaca) {
        this.tipoPlaca = tipoPlaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}

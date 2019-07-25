/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rogelio.mejiausam
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")
    , @NamedQuery(name = "Persona.findByN1Nombre", query = "SELECT p FROM Persona p WHERE p.n1Nombre = :n1Nombre")
    , @NamedQuery(name = "Persona.findByN2Nombre", query = "SELECT p FROM Persona p WHERE p.n2Nombre = :n2Nombre")
    , @NamedQuery(name = "Persona.findByN3Nombre", query = "SELECT p FROM Persona p WHERE p.n3Nombre = :n3Nombre")
    , @NamedQuery(name = "Persona.findByA1Apellido", query = "SELECT p FROM Persona p WHERE p.a1Apellido = :a1Apellido")
    , @NamedQuery(name = "Persona.findByA2Apellido", query = "SELECT p FROM Persona p WHERE p.a2Apellido = :a2Apellido")
    , @NamedQuery(name = "Persona.findByA3Apellido", query = "SELECT p FROM Persona p WHERE p.a3Apellido = :a3Apellido")
    , @NamedQuery(name = "Persona.findByDui", query = "SELECT p FROM Persona p WHERE p.dui = :dui")
    , @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "n1_nombre")
    private String n1Nombre;
    @Size(max = 20)
    @Column(name = "n2_nombre")
    private String n2Nombre;
    @Size(max = 20)
    @Column(name = "n3_nombre")
    private String n3Nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "a1_apellido")
    private String a1Apellido;
    @Size(max = 20)
    @Column(name = "a2_apellido")
    private String a2Apellido;
    @Size(max = 20)
    @Column(name = "a3_apellido")
    private String a3Apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dui")
    private String dui;
    @Column(name = "edad")
    private Integer edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<AgenteTransito> agenteTransitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Vehiculo> vehiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Conductor> conductorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Cajero> cajeroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Usuario> usuarioList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String n1Nombre, String a1Apellido, String dui, Date fechaNacimiento) {
        this.idPersona = idPersona;
        this.n1Nombre = n1Nombre;
        this.a1Apellido = a1Apellido;
        this.dui = dui;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getN1Nombre() {
        return n1Nombre;
    }

    public void setN1Nombre(String n1Nombre) {
        this.n1Nombre = n1Nombre;
    }

    public String getN2Nombre() {
        return n2Nombre;
    }

    public void setN2Nombre(String n2Nombre) {
        this.n2Nombre = n2Nombre;
    }

    public String getN3Nombre() {
        return n3Nombre;
    }

    public void setN3Nombre(String n3Nombre) {
        this.n3Nombre = n3Nombre;
    }

    public String getA1Apellido() {
        return a1Apellido;
    }

    public void setA1Apellido(String a1Apellido) {
        this.a1Apellido = a1Apellido;
    }

    public String getA2Apellido() {
        return a2Apellido;
    }

    public void setA2Apellido(String a2Apellido) {
        this.a2Apellido = a2Apellido;
    }

    public String getA3Apellido() {
        return a3Apellido;
    }

    public void setA3Apellido(String a3Apellido) {
        this.a3Apellido = a3Apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public List<AgenteTransito> getAgenteTransitoList() {
        return agenteTransitoList;
    }

    public void setAgenteTransitoList(List<AgenteTransito> agenteTransitoList) {
        this.agenteTransitoList = agenteTransitoList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<Conductor> getConductorList() {
        return conductorList;
    }

    public void setConductorList(List<Conductor> conductorList) {
        this.conductorList = conductorList;
    }

    @XmlTransient
    public List<Cajero> getCajeroList() {
        return cajeroList;
    }

    public void setCajeroList(List<Cajero> cajeroList) {
        this.cajeroList = cajeroList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.Persona[ idPersona=" + idPersona + " ]";
    }
    
}

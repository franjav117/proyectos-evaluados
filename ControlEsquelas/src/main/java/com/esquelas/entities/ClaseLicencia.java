/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author melvin.madridusam
 */
@Entity
@Table(name = "clase_licencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaseLicencia.findAll", query = "SELECT c FROM ClaseLicencia c")
    , @NamedQuery(name = "ClaseLicencia.findByIdClaseLicencia", query = "SELECT c FROM ClaseLicencia c WHERE c.idClaseLicencia = :idClaseLicencia")
    , @NamedQuery(name = "ClaseLicencia.findByLicencia", query = "SELECT c FROM ClaseLicencia c WHERE c.licencia = :licencia")})
public class ClaseLicencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clase_licencia")
    private Integer idClaseLicencia;
    @Size(max = 20)
    @Column(name = "licencia")
    private String licencia;
    @OneToMany(mappedBy = "licenciaTipo")
    private List<Conductor> conductorList;

    public ClaseLicencia() {
    }

    public ClaseLicencia(Integer idClaseLicencia) {
        this.idClaseLicencia = idClaseLicencia;
    }

    public Integer getIdClaseLicencia() {
        return idClaseLicencia;
    }

    public void setIdClaseLicencia(Integer idClaseLicencia) {
        this.idClaseLicencia = idClaseLicencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @XmlTransient
    public List<Conductor> getConductorList() {
        return conductorList;
    }

    public void setConductorList(List<Conductor> conductorList) {
        this.conductorList = conductorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClaseLicencia != null ? idClaseLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaseLicencia)) {
            return false;
        }
        ClaseLicencia other = (ClaseLicencia) object;
        if ((this.idClaseLicencia == null && other.idClaseLicencia != null) || (this.idClaseLicencia != null && !this.idClaseLicencia.equals(other.idClaseLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.ClaseLicencia[ idClaseLicencia=" + idClaseLicencia + " ]";
    }
    
}

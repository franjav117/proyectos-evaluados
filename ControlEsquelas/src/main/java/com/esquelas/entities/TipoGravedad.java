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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author melvin.madridusam
 */
@Entity
@Table(name = "tipo_gravedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoGravedad.findAll", query = "SELECT t FROM TipoGravedad t")
    , @NamedQuery(name = "TipoGravedad.findByIdGravedad", query = "SELECT t FROM TipoGravedad t WHERE t.idGravedad = :idGravedad")
    , @NamedQuery(name = "TipoGravedad.findByGravedad", query = "SELECT t FROM TipoGravedad t WHERE t.gravedad = :gravedad")})
public class TipoGravedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gravedad")
    private Integer idGravedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gravedad")
    private String gravedad;
    @OneToMany(mappedBy = "tipoGravedad")
    private List<Esquela> esquelaList;

    public TipoGravedad() {
    }

    public TipoGravedad(Integer idGravedad) {
        this.idGravedad = idGravedad;
    }

    public TipoGravedad(Integer idGravedad, String gravedad) {
        this.idGravedad = idGravedad;
        this.gravedad = gravedad;
    }

    public Integer getIdGravedad() {
        return idGravedad;
    }

    public void setIdGravedad(Integer idGravedad) {
        this.idGravedad = idGravedad;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    @XmlTransient
    public List<Esquela> getEsquelaList() {
        return esquelaList;
    }

    public void setEsquelaList(List<Esquela> esquelaList) {
        this.esquelaList = esquelaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGravedad != null ? idGravedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGravedad)) {
            return false;
        }
        TipoGravedad other = (TipoGravedad) object;
        if ((this.idGravedad == null && other.idGravedad != null) || (this.idGravedad != null && !this.idGravedad.equals(other.idGravedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.TipoGravedad[ idGravedad=" + idGravedad + " ]";
    }
    
}

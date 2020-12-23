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
 * @author rogelio.mejiausam
 */
@Entity
@Table(name = "otros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otros.findAll", query = "SELECT o FROM Otros o")
    , @NamedQuery(name = "Otros.findByIdOtro", query = "SELECT o FROM Otros o WHERE o.idOtro = :idOtro")
    , @NamedQuery(name = "Otros.findByEspecificacion", query = "SELECT o FROM Otros o WHERE o.especificacion = :especificacion")})
public class Otros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_otro")
    private Integer idOtro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especificacion")
    private String especificacion;
    @OneToMany(mappedBy = "idOtros")
    private List<Esquela> esquelaList;

    public Otros() {
    }

    public Otros(Integer idOtro) {
        this.idOtro = idOtro;
    }

    public Otros(Integer idOtro, String especificacion) {
        this.idOtro = idOtro;
        this.especificacion = especificacion;
    }

    public Integer getIdOtro() {
        return idOtro;
    }

    public void setIdOtro(Integer idOtro) {
        this.idOtro = idOtro;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
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
        hash += (idOtro != null ? idOtro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otros)) {
            return false;
        }
        Otros other = (Otros) object;
        if ((this.idOtro == null && other.idOtro != null) || (this.idOtro != null && !this.idOtro.equals(other.idOtro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.Otros[ idOtro=" + idOtro + " ]";
    }
    
}

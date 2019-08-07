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
@Table(name = "decomiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Decomiso.findAll", query = "SELECT d FROM Decomiso d")
    , @NamedQuery(name = "Decomiso.findByIdDecomiso", query = "SELECT d FROM Decomiso d WHERE d.idDecomiso = :idDecomiso")
    , @NamedQuery(name = "Decomiso.findByDecomiso", query = "SELECT d FROM Decomiso d WHERE d.decomiso = :decomiso")})
public class Decomiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_decomiso")
    private Integer idDecomiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "decomiso")
    private String decomiso;
    @OneToMany(mappedBy = "idDecomiso")
    private List<Esquela> esquelaList;

    public Decomiso() {
    }

    public Decomiso(Integer idDecomiso) {
        this.idDecomiso = idDecomiso;
    }

    public Decomiso(Integer idDecomiso, String decomiso) {
        this.idDecomiso = idDecomiso;
        this.decomiso = decomiso;
    }

    public Integer getIdDecomiso() {
        return idDecomiso;
    }

    public void setIdDecomiso(Integer idDecomiso) {
        this.idDecomiso = idDecomiso;
    }

    public String getDecomiso() {
        return decomiso;
    }

    public void setDecomiso(String decomiso) {
        this.decomiso = decomiso;
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
        hash += (idDecomiso != null ? idDecomiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decomiso)) {
            return false;
        }
        Decomiso other = (Decomiso) object;
        if ((this.idDecomiso == null && other.idDecomiso != null) || (this.idDecomiso != null && !this.idDecomiso.equals(other.idDecomiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.Decomiso[ idDecomiso=" + idDecomiso + " ]";
    }
    
}

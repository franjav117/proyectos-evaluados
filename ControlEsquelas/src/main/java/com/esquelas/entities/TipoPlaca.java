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
@Table(name = "tipo_placa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPlaca.findAll", query = "SELECT t FROM TipoPlaca t")
    , @NamedQuery(name = "TipoPlaca.findByIdTipoPlaca", query = "SELECT t FROM TipoPlaca t WHERE t.idTipoPlaca = :idTipoPlaca")
    , @NamedQuery(name = "TipoPlaca.findByTipoPlaca", query = "SELECT t FROM TipoPlaca t WHERE t.tipoPlaca = :tipoPlaca")})
public class TipoPlaca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_placa")
    private Integer idTipoPlaca;
    @Size(max = 25)
    @Column(name = "tipo_placa")
    private String tipoPlaca;
    @OneToMany(mappedBy = "tipoPlaca")
    private List<AgenteTransito> agenteTransitoList;

    public TipoPlaca() {
    }

    public TipoPlaca(Integer idTipoPlaca) {
        this.idTipoPlaca = idTipoPlaca;
    }

    public Integer getIdTipoPlaca() {
        return idTipoPlaca;
    }

    public void setIdTipoPlaca(Integer idTipoPlaca) {
        this.idTipoPlaca = idTipoPlaca;
    }

    public String getTipoPlaca() {
        return tipoPlaca;
    }

    public void setTipoPlaca(String tipoPlaca) {
        this.tipoPlaca = tipoPlaca;
    }

    @XmlTransient
    public List<AgenteTransito> getAgenteTransitoList() {
        return agenteTransitoList;
    }

    public void setAgenteTransitoList(List<AgenteTransito> agenteTransitoList) {
        this.agenteTransitoList = agenteTransitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPlaca != null ? idTipoPlaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlaca)) {
            return false;
        }
        TipoPlaca other = (TipoPlaca) object;
        if ((this.idTipoPlaca == null && other.idTipoPlaca != null) || (this.idTipoPlaca != null && !this.idTipoPlaca.equals(other.idTipoPlaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.TipoPlaca[ idTipoPlaca=" + idTipoPlaca + " ]";
    }
    
}

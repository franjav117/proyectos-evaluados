/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rogelio.mejiausam
 */
@Entity
@Table(name = "tipo_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMatricula.findAll", query = "SELECT t FROM TipoMatricula t")
    , @NamedQuery(name = "TipoMatricula.findByIdTipoMatricula", query = "SELECT t FROM TipoMatricula t WHERE t.idTipoMatricula = :idTipoMatricula")
    , @NamedQuery(name = "TipoMatricula.findByCodigoMatricula", query = "SELECT t FROM TipoMatricula t WHERE t.codigoMatricula = :codigoMatricula")})
public class TipoMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_matricula")
    private Integer idTipoMatricula;
    @Size(max = 6)
    @Column(name = "codigo_matricula")
    private String codigoMatricula;

    public TipoMatricula() {
    }

    public TipoMatricula(Integer idTipoMatricula) {
        this.idTipoMatricula = idTipoMatricula;
    }

    public Integer getIdTipoMatricula() {
        return idTipoMatricula;
    }

    public void setIdTipoMatricula(Integer idTipoMatricula) {
        this.idTipoMatricula = idTipoMatricula;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMatricula != null ? idTipoMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMatricula)) {
            return false;
        }
        TipoMatricula other = (TipoMatricula) object;
        if ((this.idTipoMatricula == null && other.idTipoMatricula != null) || (this.idTipoMatricula != null && !this.idTipoMatricula.equals(other.idTipoMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.TipoMatricula[ idTipoMatricula=" + idTipoMatricula + " ]";
    }
    
}

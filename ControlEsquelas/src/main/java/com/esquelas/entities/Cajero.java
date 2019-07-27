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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author melvin.madridusam
 */
@Entity
@Table(name = "cajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cajero.findAll", query = "SELECT c FROM Cajero c")
    , @NamedQuery(name = "Cajero.findByIdCajero", query = "SELECT c FROM Cajero c WHERE c.idCajero = :idCajero")})
public class Cajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cajero")
    private Integer idCajero;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Cajero() {
    }

    public Cajero(Integer idCajero) {
        this.idCajero = idCajero;
    }

    public Integer getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Integer idCajero) {
        this.idCajero = idCajero;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCajero != null ? idCajero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cajero)) {
            return false;
        }
        Cajero other = (Cajero) object;
        if ((this.idCajero == null && other.idCajero != null) || (this.idCajero != null && !this.idCajero.equals(other.idCajero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.Cajero[ idCajero=" + idCajero + " ]";
    }
    
}

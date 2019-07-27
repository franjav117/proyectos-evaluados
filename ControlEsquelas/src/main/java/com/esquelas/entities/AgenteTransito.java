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
@Table(name = "agente_transito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgenteTransito.findAll", query = "SELECT a FROM AgenteTransito a")
    , @NamedQuery(name = "AgenteTransito.findByIdAgente", query = "SELECT a FROM AgenteTransito a WHERE a.idAgente = :idAgente")
    , @NamedQuery(name = "AgenteTransito.findByNumPlaca", query = "SELECT a FROM AgenteTransito a WHERE a.numPlaca = :numPlaca")
    , @NamedQuery(name = "AgenteTransito.findByPuestoPolicial", query = "SELECT a FROM AgenteTransito a WHERE a.puestoPolicial = :puestoPolicial")})
public class AgenteTransito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_agente")
    private Integer idAgente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_placa")
    private int numPlaca;
    @Size(max = 50)
    @Column(name = "puesto_policial")
    private String puestoPolicial;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "tipo_placa", referencedColumnName = "id_tipo_placa")
    @ManyToOne
    private TipoPlaca tipoPlaca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAgente")
    private List<Esquela> esquelaList;

    public AgenteTransito() {
    }

    public AgenteTransito(Integer idAgente) {
        this.idAgente = idAgente;
    }

    public AgenteTransito(Integer idAgente, int numPlaca) {
        this.idAgente = idAgente;
        this.numPlaca = numPlaca;
    }

    public Integer getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Integer idAgente) {
        this.idAgente = idAgente;
    }

    public int getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(int numPlaca) {
        this.numPlaca = numPlaca;
    }

    public String getPuestoPolicial() {
        return puestoPolicial;
    }

    public void setPuestoPolicial(String puestoPolicial) {
        this.puestoPolicial = puestoPolicial;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public TipoPlaca getTipoPlaca() {
        return tipoPlaca;
    }

    public void setTipoPlaca(TipoPlaca tipoPlaca) {
        this.tipoPlaca = tipoPlaca;
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
        hash += (idAgente != null ? idAgente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgenteTransito)) {
            return false;
        }
        AgenteTransito other = (AgenteTransito) object;
        if ((this.idAgente == null && other.idAgente != null) || (this.idAgente != null && !this.idAgente.equals(other.idAgente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.esquelas.entities.AgenteTransito[ idAgente=" + idAgente + " ]";
    }
    
}

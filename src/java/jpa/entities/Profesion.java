/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "profesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p"),
    @NamedQuery(name = "Profesion.findById", query = "SELECT p FROM Profesion p WHERE p.id = :id"),
    @NamedQuery(name = "Profesion.findByCategoria", query = "SELECT p FROM Profesion p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Profesion.findByNombre", query = "SELECT p FROM Profesion p WHERE p.nombre = :nombre")})
public class Profesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesion")
    private Collection<ProfesionesPorAspirante> profesionesPorAspiranteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesion")
    private Collection<Ofertas> ofertasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesion")
    private Collection<ProfesionesPorOferta> profesionesPorOfertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesion")
    private Collection<Area> areaCollection;

    public Profesion() {
    }

    public Profesion(Integer id) {
        this.id = id;
    }

    public Profesion(Integer id, String categoria, String nombre) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<ProfesionesPorAspirante> getProfesionesPorAspiranteCollection() {
        return profesionesPorAspiranteCollection;
    }

    public void setProfesionesPorAspiranteCollection(Collection<ProfesionesPorAspirante> profesionesPorAspiranteCollection) {
        this.profesionesPorAspiranteCollection = profesionesPorAspiranteCollection;
    }

    @XmlTransient
    public Collection<Ofertas> getOfertasCollection() {
        return ofertasCollection;
    }

    public void setOfertasCollection(Collection<Ofertas> ofertasCollection) {
        this.ofertasCollection = ofertasCollection;
    }

    @XmlTransient
    public Collection<ProfesionesPorOferta> getProfesionesPorOfertaCollection() {
        return profesionesPorOfertaCollection;
    }

    public void setProfesionesPorOfertaCollection(Collection<ProfesionesPorOferta> profesionesPorOfertaCollection) {
        this.profesionesPorOfertaCollection = profesionesPorOfertaCollection;
    }

    @XmlTransient
    public Collection<Area> getAreaCollection() {
        return areaCollection;
    }

    public void setAreaCollection(Collection<Area> areaCollection) {
        this.areaCollection = areaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Profesion[ id=" + id + " ]";
    }
    
}

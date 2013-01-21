/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "ofertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofertas.findAll", query = "SELECT o FROM Ofertas o"),
    @NamedQuery(name = "Ofertas.findByIdofertas", query = "SELECT o FROM Ofertas o WHERE o.idofertas = :idofertas"),
    @NamedQuery(name = "Ofertas.findByFechaStart", query = "SELECT o FROM Ofertas o WHERE o.fechaStart = :fechaStart"),
    @NamedQuery(name = "Ofertas.findByFechaEnd", query = "SELECT o FROM Ofertas o WHERE o.fechaEnd = :fechaEnd"),
    @NamedQuery(name = "Ofertas.findByCargo", query = "SELECT o FROM Ofertas o WHERE o.cargo = :cargo"),
    @NamedQuery(name = "Ofertas.findBySalario", query = "SELECT o FROM Ofertas o WHERE o.salario = :salario"),
    @NamedQuery(name = "Ofertas.findByDescripcion", query = "SELECT o FROM Ofertas o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Ofertas.findByNivelEstudiosMin", query = "SELECT o FROM Ofertas o WHERE o.nivelEstudiosMin = :nivelEstudiosMin"),
    @NamedQuery(name = "Ofertas.findByNivelEstudiosMax", query = "SELECT o FROM Ofertas o WHERE o.nivelEstudiosMax = :nivelEstudiosMax")})
public class Ofertas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idofertas")
    private Integer idofertas;
    @Basic(optional = false)
    @Column(name = "fecha_start")
    @Temporal(TemporalType.DATE)
    private Date fechaStart;
    @Basic(optional = false)
    @Column(name = "fecha_end")
    @Temporal(TemporalType.DATE)
    private Date fechaEnd;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "salario")
    private long salario;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "nivel_estudios_min")
    private String nivelEstudiosMin;
    @Basic(optional = false)
    @Column(name = "nivel_estudios_max")
    private String nivelEstudiosMax;
    @JoinColumn(name = "profesion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profesion profesion;
    @JoinColumn(name = "nit", referencedColumnName = "nit")
    @ManyToOne(optional = false)
    private Empresas nit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<ProfesionesPorOferta> profesionesPorOfertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<CapacidadesPorOfertas> capacidadesPorOfertasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<Inscripcion> inscripcionCollection;

    public Ofertas() {
    }

    public Ofertas(Integer idofertas) {
        this.idofertas = idofertas;
    }

    public Ofertas(Integer idofertas, Date fechaStart, Date fechaEnd, String cargo, long salario, String descripcion, String nivelEstudiosMin, String nivelEstudiosMax) {
        this.idofertas = idofertas;
        this.fechaStart = fechaStart;
        this.fechaEnd = fechaEnd;
        this.cargo = cargo;
        this.salario = salario;
        this.descripcion = descripcion;
        this.nivelEstudiosMin = nivelEstudiosMin;
        this.nivelEstudiosMax = nivelEstudiosMax;
    }

    public Integer getIdofertas() {
        return idofertas;
    }

    public void setIdofertas(Integer idofertas) {
        this.idofertas = idofertas;
    }

    public Date getFechaStart() {
        return fechaStart;
    }

    public void setFechaStart(Date fechaStart) {
        this.fechaStart = fechaStart;
    }

    public Date getFechaEnd() {
        return fechaEnd;
    }

    public void setFechaEnd(Date fechaEnd) {
        this.fechaEnd = fechaEnd;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivelEstudiosMin() {
        return nivelEstudiosMin;
    }

    public void setNivelEstudiosMin(String nivelEstudiosMin) {
        this.nivelEstudiosMin = nivelEstudiosMin;
    }

    public String getNivelEstudiosMax() {
        return nivelEstudiosMax;
    }

    public void setNivelEstudiosMax(String nivelEstudiosMax) {
        this.nivelEstudiosMax = nivelEstudiosMax;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public Empresas getNit() {
        return nit;
    }

    public void setNit(Empresas nit) {
        this.nit = nit;
    }

    @XmlTransient
    public Collection<ProfesionesPorOferta> getProfesionesPorOfertaCollection() {
        return profesionesPorOfertaCollection;
    }

    public void setProfesionesPorOfertaCollection(Collection<ProfesionesPorOferta> profesionesPorOfertaCollection) {
        this.profesionesPorOfertaCollection = profesionesPorOfertaCollection;
    }

    @XmlTransient
    public Collection<CapacidadesPorOfertas> getCapacidadesPorOfertasCollection() {
        return capacidadesPorOfertasCollection;
    }

    public void setCapacidadesPorOfertasCollection(Collection<CapacidadesPorOfertas> capacidadesPorOfertasCollection) {
        this.capacidadesPorOfertasCollection = capacidadesPorOfertasCollection;
    }

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idofertas != null ? idofertas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertas)) {
            return false;
        }
        Ofertas other = (Ofertas) object;
        if ((this.idofertas == null && other.idofertas != null) || (this.idofertas != null && !this.idofertas.equals(other.idofertas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ofertas[ idofertas=" + idofertas + " ]";
    }
    
}

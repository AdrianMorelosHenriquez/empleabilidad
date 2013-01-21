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
@Table(name = "experiencia_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e"),
    @NamedQuery(name = "ExperienciaLaboral.findById", query = "SELECT e FROM ExperienciaLaboral e WHERE e.id = :id"),
    @NamedQuery(name = "ExperienciaLaboral.findByNombreEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "ExperienciaLaboral.findByCargo", query = "SELECT e FROM ExperienciaLaboral e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "ExperienciaLaboral.findByFechaIn", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaIn = :fechaIn"),
    @NamedQuery(name = "ExperienciaLaboral.findByFechaOu", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaOu = :fechaOu"),
    @NamedQuery(name = "ExperienciaLaboral.findByActividadEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.actividadEmpresa = :actividadEmpresa"),
    @NamedQuery(name = "ExperienciaLaboral.findByTipoCargo", query = "SELECT e FROM ExperienciaLaboral e WHERE e.tipoCargo = :tipoCargo"),
    @NamedQuery(name = "ExperienciaLaboral.findByDescripcionTarea", query = "SELECT e FROM ExperienciaLaboral e WHERE e.descripcionTarea = :descripcionTarea"),
    @NamedQuery(name = "ExperienciaLaboral.findByExperienciaLaboralcol", query = "SELECT e FROM ExperienciaLaboral e WHERE e.experienciaLaboralcol = :experienciaLaboralcol")})
public class ExperienciaLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "fecha_in")
    @Temporal(TemporalType.DATE)
    private Date fechaIn;
    @Column(name = "fecha_ou")
    @Temporal(TemporalType.DATE)
    private Date fechaOu;
    @Basic(optional = false)
    @Column(name = "actividad_empresa")
    private String actividadEmpresa;
    @Basic(optional = false)
    @Column(name = "tipo_cargo")
    private String tipoCargo;
    @Basic(optional = false)
    @Column(name = "descripcion_tarea")
    private String descripcionTarea;
    @Column(name = "experiencia_laboralcol")
    private String experienciaLaboralcol;
    @JoinColumn(name = "area", referencedColumnName = "idarea")
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "aspirante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DatosPersonales aspirante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "experiencia")
    private Collection<CapacidadesPorExperiencias> capacidadesPorExperienciasCollection;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Integer id) {
        this.id = id;
    }

    public ExperienciaLaboral(Integer id, String nombreEmpresa, String cargo, Date fechaIn, String actividadEmpresa, String tipoCargo, String descripcionTarea) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.cargo = cargo;
        this.fechaIn = fechaIn;
        this.actividadEmpresa = actividadEmpresa;
        this.tipoCargo = tipoCargo;
        this.descripcionTarea = descripcionTarea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Date getFechaOu() {
        return fechaOu;
    }

    public void setFechaOu(Date fechaOu) {
        this.fechaOu = fechaOu;
    }

    public String getActividadEmpresa() {
        return actividadEmpresa;
    }

    public void setActividadEmpresa(String actividadEmpresa) {
        this.actividadEmpresa = actividadEmpresa;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public String getExperienciaLaboralcol() {
        return experienciaLaboralcol;
    }

    public void setExperienciaLaboralcol(String experienciaLaboralcol) {
        this.experienciaLaboralcol = experienciaLaboralcol;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public DatosPersonales getAspirante() {
        return aspirante;
    }

    public void setAspirante(DatosPersonales aspirante) {
        this.aspirante = aspirante;
    }

    @XmlTransient
    public Collection<CapacidadesPorExperiencias> getCapacidadesPorExperienciasCollection() {
        return capacidadesPorExperienciasCollection;
    }

    public void setCapacidadesPorExperienciasCollection(Collection<CapacidadesPorExperiencias> capacidadesPorExperienciasCollection) {
        this.capacidadesPorExperienciasCollection = capacidadesPorExperienciasCollection;
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
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ExperienciaLaboral[ id=" + id + " ]";
    }
    
}

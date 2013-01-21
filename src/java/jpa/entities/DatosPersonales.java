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
@Table(name = "datos_personales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosPersonales.findAll", query = "SELECT d FROM DatosPersonales d"),
    @NamedQuery(name = "DatosPersonales.findById", query = "SELECT d FROM DatosPersonales d WHERE d.id = :id"),
    @NamedQuery(name = "DatosPersonales.findByNombres", query = "SELECT d FROM DatosPersonales d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "DatosPersonales.findByApellido1", query = "SELECT d FROM DatosPersonales d WHERE d.apellido1 = :apellido1"),
    @NamedQuery(name = "DatosPersonales.findBySexo", query = "SELECT d FROM DatosPersonales d WHERE d.sexo = :sexo"),
    @NamedQuery(name = "DatosPersonales.findByEstadoCivil", query = "SELECT d FROM DatosPersonales d WHERE d.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "DatosPersonales.findByLugarNacimiento", query = "SELECT d FROM DatosPersonales d WHERE d.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "DatosPersonales.findByFechaNacimiento", query = "SELECT d FROM DatosPersonales d WHERE d.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "DatosPersonales.findByDireccion", query = "SELECT d FROM DatosPersonales d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DatosPersonales.findByBarrio", query = "SELECT d FROM DatosPersonales d WHERE d.barrio = :barrio"),
    @NamedQuery(name = "DatosPersonales.findByCudad", query = "SELECT d FROM DatosPersonales d WHERE d.cudad = :cudad"),
    @NamedQuery(name = "DatosPersonales.findByTelefono", query = "SELECT d FROM DatosPersonales d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "DatosPersonales.findByCelular", query = "SELECT d FROM DatosPersonales d WHERE d.celular = :celular"),
    @NamedQuery(name = "DatosPersonales.findByEmail", query = "SELECT d FROM DatosPersonales d WHERE d.email = :email"),
    @NamedQuery(name = "DatosPersonales.findByDescripcion", query = "SELECT d FROM DatosPersonales d WHERE d.descripcion = :descripcion")})
public class DatosPersonales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellido1")
    private String apellido1;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "barrio")
    private String barrio;
    @Basic(optional = false)
    @Column(name = "cudad")
    private String cudad;
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspirante")
    private Collection<ProfesionesPorAspirante> profesionesPorAspiranteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspirante")
    private Collection<Referencias> referenciasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspirante")
    private Collection<Inscripcion> inscripcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspirante")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspirante")
    private Collection<Estudios> estudiosCollection;

    public DatosPersonales() {
    }

    public DatosPersonales(Integer id) {
        this.id = id;
    }

    public DatosPersonales(Integer id, String nombres, String apellido1, String sexo, String estadoCivil, String lugarNacimiento, Date fechaNacimiento, String direccion, String barrio, String cudad, String celular, String email, String descripcion) {
        this.id = id;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.barrio = barrio;
        this.cudad = cudad;
        this.celular = celular;
        this.email = email;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCudad() {
        return cudad;
    }

    public void setCudad(String cudad) {
        this.cudad = cudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<ProfesionesPorAspirante> getProfesionesPorAspiranteCollection() {
        return profesionesPorAspiranteCollection;
    }

    public void setProfesionesPorAspiranteCollection(Collection<ProfesionesPorAspirante> profesionesPorAspiranteCollection) {
        this.profesionesPorAspiranteCollection = profesionesPorAspiranteCollection;
    }

    @XmlTransient
    public Collection<Referencias> getReferenciasCollection() {
        return referenciasCollection;
    }

    public void setReferenciasCollection(Collection<Referencias> referenciasCollection) {
        this.referenciasCollection = referenciasCollection;
    }

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    @XmlTransient
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    @XmlTransient
    public Collection<Estudios> getEstudiosCollection() {
        return estudiosCollection;
    }

    public void setEstudiosCollection(Collection<Estudios> estudiosCollection) {
        this.estudiosCollection = estudiosCollection;
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
        if (!(object instanceof DatosPersonales)) {
            return false;
        }
        DatosPersonales other = (DatosPersonales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.DatosPersonales[ id=" + id + " ]";
    }
    
}

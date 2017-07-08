/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobd;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author jordicastillo
 */
@Entity
@Table(name = "empleados", catalog = "proyecto", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByIdEmpl", query = "SELECT e FROM Empleados e WHERE e.idEmpl = :idEmpl")
    , @NamedQuery(name = "Empleados.findByNomEmpl", query = "SELECT e FROM Empleados e WHERE e.nomEmpl = :nomEmpl")
    , @NamedQuery(name = "Empleados.findByCargo", query = "SELECT e FROM Empleados e WHERE e.cargo = :cargo")
    , @NamedQuery(name = "Empleados.findBySueldo", query = "SELECT e FROM Empleados e WHERE e.sueldo = :sueldo")
    , @NamedQuery(name = "Empleados.findByIdSuc", query = "SELECT e FROM Empleados e WHERE e.idSuc = :idSuc")})
public class Empleados implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_empl")
    private Integer idEmpl;
    @Column(name = "nom_empl")
    private String nomEmpl;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "sueldo")
    private Integer sueldo;
    @Column(name = "id_suc")
    private Integer idSuc;

    public Empleados() {
    }

    public Empleados(Integer idEmpl) {
        this.idEmpl = idEmpl;
    }

    public Integer getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(Integer idEmpl) {
        Integer oldIdEmpl = this.idEmpl;
        this.idEmpl = idEmpl;
        changeSupport.firePropertyChange("idEmpl", oldIdEmpl, idEmpl);
    }

    public String getNomEmpl() {
        return nomEmpl;
    }

    public void setNomEmpl(String nomEmpl) {
        String oldNomEmpl = this.nomEmpl;
        this.nomEmpl = nomEmpl;
        changeSupport.firePropertyChange("nomEmpl", oldNomEmpl, nomEmpl);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        String oldCargo = this.cargo;
        this.cargo = cargo;
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        Integer oldSueldo = this.sueldo;
        this.sueldo = sueldo;
        changeSupport.firePropertyChange("sueldo", oldSueldo, sueldo);
    }

    public Integer getIdSuc() {
        return idSuc;
    }

    public void setIdSuc(Integer idSuc) {
        Integer oldIdSuc = this.idSuc;
        this.idSuc = idSuc;
        changeSupport.firePropertyChange("idSuc", oldIdSuc, idSuc);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpl != null ? idEmpl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpl == null && other.idEmpl != null) || (this.idEmpl != null && !this.idEmpl.equals(other.idEmpl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectobd.Empleados[ idEmpl=" + idEmpl + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

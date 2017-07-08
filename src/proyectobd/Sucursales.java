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
@Table(name = "sucursales", catalog = "proyecto", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s")
    , @NamedQuery(name = "Sucursales.findByIdSuc", query = "SELECT s FROM Sucursales s WHERE s.idSuc = :idSuc")
    , @NamedQuery(name = "Sucursales.findByDirSuc", query = "SELECT s FROM Sucursales s WHERE s.dirSuc = :dirSuc")
    , @NamedQuery(name = "Sucursales.findByTelefono", query = "SELECT s FROM Sucursales s WHERE s.telefono = :telefono")})
public class Sucursales implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_suc")
    private Integer idSuc;
    @Column(name = "dir_suc")
    private String dirSuc;
    @Column(name = "telefono")
    private Integer telefono;

    public Sucursales() {
    }

    public Sucursales(Integer idSuc) {
        this.idSuc = idSuc;
    }

    public Integer getIdSuc() {
        return idSuc;
    }

    public void setIdSuc(Integer idSuc) {
        Integer oldIdSuc = this.idSuc;
        this.idSuc = idSuc;
        changeSupport.firePropertyChange("idSuc", oldIdSuc, idSuc);
    }

    public String getDirSuc() {
        return dirSuc;
    }

    public void setDirSuc(String dirSuc) {
        String oldDirSuc = this.dirSuc;
        this.dirSuc = dirSuc;
        changeSupport.firePropertyChange("dirSuc", oldDirSuc, dirSuc);
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        Integer oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuc != null ? idSuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.idSuc == null && other.idSuc != null) || (this.idSuc != null && !this.idSuc.equals(other.idSuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectobd.Sucursales[ idSuc=" + idSuc + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

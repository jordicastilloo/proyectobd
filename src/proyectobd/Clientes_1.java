/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobd;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author jordicastillo
 */
@Entity
@Table(name = "clientes", catalog = "proyecto", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Clientes_1.findAll", query = "SELECT c FROM Clientes_1 c")
    , @NamedQuery(name = "Clientes_1.findByIdCl", query = "SELECT c FROM Clientes_1 c WHERE c.idCl = :idCl")
    , @NamedQuery(name = "Clientes_1.findByNomCl", query = "SELECT c FROM Clientes_1 c WHERE c.nomCl = :nomCl")
    , @NamedQuery(name = "Clientes_1.findByApeCl", query = "SELECT c FROM Clientes_1 c WHERE c.apeCl = :apeCl")
    , @NamedQuery(name = "Clientes_1.findByDirCl", query = "SELECT c FROM Clientes_1 c WHERE c.dirCl = :dirCl")
    , @NamedQuery(name = "Clientes_1.findByFecReg", query = "SELECT c FROM Clientes_1 c WHERE c.fecReg = :fecReg")
    , @NamedQuery(name = "Clientes_1.findByIdSuc", query = "SELECT c FROM Clientes_1 c WHERE c.idSuc = :idSuc")})
public class Clientes_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cl")
    private Integer idCl;
    @Column(name = "nom_cl")
    private String nomCl;
    @Column(name = "ape_cl")
    private String apeCl;
    @Column(name = "dir_cl")
    private String dirCl;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.DATE)
    private Date fecReg;
    @Column(name = "id_suc")
    private Integer idSuc;

    public Clientes_1() {
    }

    public Clientes_1(Integer idCl) {
        this.idCl = idCl;
    }

    public Integer getIdCl() {
        return idCl;
    }

    public void setIdCl(Integer idCl) {
        Integer oldIdCl = this.idCl;
        this.idCl = idCl;
        changeSupport.firePropertyChange("idCl", oldIdCl, idCl);
    }

    public String getNomCl() {
        return nomCl;
    }

    public void setNomCl(String nomCl) {
        String oldNomCl = this.nomCl;
        this.nomCl = nomCl;
        changeSupport.firePropertyChange("nomCl", oldNomCl, nomCl);
    }

    public String getApeCl() {
        return apeCl;
    }

    public void setApeCl(String apeCl) {
        String oldApeCl = this.apeCl;
        this.apeCl = apeCl;
        changeSupport.firePropertyChange("apeCl", oldApeCl, apeCl);
    }

    public String getDirCl() {
        return dirCl;
    }

    public void setDirCl(String dirCl) {
        String oldDirCl = this.dirCl;
        this.dirCl = dirCl;
        changeSupport.firePropertyChange("dirCl", oldDirCl, dirCl);
    }

    public Date getFecReg() {
        return fecReg;
    }

    public void setFecReg(Date fecReg) {
        Date oldFecReg = this.fecReg;
        this.fecReg = fecReg;
        changeSupport.firePropertyChange("fecReg", oldFecReg, fecReg);
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
        hash += (idCl != null ? idCl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes_1)) {
            return false;
        }
        Clientes_1 other = (Clientes_1) object;
        if ((this.idCl == null && other.idCl != null) || (this.idCl != null && !this.idCl.equals(other.idCl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectobd.Clientes_1[ idCl=" + idCl + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

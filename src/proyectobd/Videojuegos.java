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
@Table(name = "videojuegos", catalog = "proyecto", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Videojuegos.findAll", query = "SELECT v FROM Videojuegos v")
    , @NamedQuery(name = "Videojuegos.findByIdVj", query = "SELECT v FROM Videojuegos v WHERE v.idVj = :idVj")
    , @NamedQuery(name = "Videojuegos.findByNumVj", query = "SELECT v FROM Videojuegos v WHERE v.numVj = :numVj")
    , @NamedQuery(name = "Videojuegos.findByTitulo", query = "SELECT v FROM Videojuegos v WHERE v.titulo = :titulo")
    , @NamedQuery(name = "Videojuegos.findByGenero", query = "SELECT v FROM Videojuegos v WHERE v.genero = :genero")
    , @NamedQuery(name = "Videojuegos.findByValArr", query = "SELECT v FROM Videojuegos v WHERE v.valArr = :valArr")
    , @NamedQuery(name = "Videojuegos.findByCostVj", query = "SELECT v FROM Videojuegos v WHERE v.costVj = :costVj")
    , @NamedQuery(name = "Videojuegos.findByDesarrollador", query = "SELECT v FROM Videojuegos v WHERE v.desarrollador = :desarrollador")
    , @NamedQuery(name = "Videojuegos.findByNumCopias", query = "SELECT v FROM Videojuegos v WHERE v.numCopias = :numCopias")})
public class Videojuegos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_vj")
    private Integer idVj;
    @Column(name = "num_vj")
    private Integer numVj;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "genero")
    private String genero;
    @Column(name = "val_arr")
    private Integer valArr;
    @Column(name = "cost_vj")
    private Integer costVj;
    @Column(name = "desarrollador")
    private String desarrollador;
    @Column(name = "num_copias")
    private Integer numCopias;

    public Videojuegos() {
    }

    public Videojuegos(Integer idVj) {
        this.idVj = idVj;
    }

    public Integer getIdVj() {
        return idVj;
    }

    public void setIdVj(Integer idVj) {
        Integer oldIdVj = this.idVj;
        this.idVj = idVj;
        changeSupport.firePropertyChange("idVj", oldIdVj, idVj);
    }

    public Integer getNumVj() {
        return numVj;
    }

    public void setNumVj(Integer numVj) {
        Integer oldNumVj = this.numVj;
        this.numVj = numVj;
        changeSupport.firePropertyChange("numVj", oldNumVj, numVj);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        changeSupport.firePropertyChange("titulo", oldTitulo, titulo);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        String oldGenero = this.genero;
        this.genero = genero;
        changeSupport.firePropertyChange("genero", oldGenero, genero);
    }

    public Integer getValArr() {
        return valArr;
    }

    public void setValArr(Integer valArr) {
        Integer oldValArr = this.valArr;
        this.valArr = valArr;
        changeSupport.firePropertyChange("valArr", oldValArr, valArr);
    }

    public Integer getCostVj() {
        return costVj;
    }

    public void setCostVj(Integer costVj) {
        Integer oldCostVj = this.costVj;
        this.costVj = costVj;
        changeSupport.firePropertyChange("costVj", oldCostVj, costVj);
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        String oldDesarrollador = this.desarrollador;
        this.desarrollador = desarrollador;
        changeSupport.firePropertyChange("desarrollador", oldDesarrollador, desarrollador);
    }

    public Integer getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(Integer numCopias) {
        Integer oldNumCopias = this.numCopias;
        this.numCopias = numCopias;
        changeSupport.firePropertyChange("numCopias", oldNumCopias, numCopias);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVj != null ? idVj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videojuegos)) {
            return false;
        }
        Videojuegos other = (Videojuegos) object;
        if ((this.idVj == null && other.idVj != null) || (this.idVj != null && !this.idVj.equals(other.idVj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectobd.Videojuegos[ idVj=" + idVj + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

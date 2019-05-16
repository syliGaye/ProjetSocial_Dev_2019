/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "sig_parametre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigParametre.findAll", query = "SELECT s FROM SigParametre s")
    , @NamedQuery(name = "SigParametre.findByCodParam", query = "SELECT s FROM SigParametre s WHERE s.codParam = :codParam")
    , @NamedQuery(name = "SigParametre.findByValLibelle", query = "SELECT s FROM SigParametre s WHERE s.valLibelle = :valLibelle")
    , @NamedQuery(name = "SigParametre.findByValChaine", query = "SELECT s FROM SigParametre s WHERE s.valChaine = :valChaine")
    , @NamedQuery(name = "SigParametre.findByValNumeric", query = "SELECT s FROM SigParametre s WHERE s.valNumeric = :valNumeric")
    , @NamedQuery(name = "SigParametre.findByValDate", query = "SELECT s FROM SigParametre s WHERE s.valDate = :valDate")})
public class SigParametre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_param")
    private String codParam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "val_libelle")
    private String valLibelle;
    @Size(max = 100)
    @Column(name = "val_chaine")
    private String valChaine;
    @Column(name = "val_numeric")
    private BigInteger valNumeric;
    @Column(name = "val_date")
    @Temporal(TemporalType.DATE)
    private Date valDate;

    public SigParametre() {
    }

    public SigParametre(String codParam) {
        this.codParam = codParam;
    }

    public SigParametre(String codParam, String valLibelle) {
        this.codParam = codParam;
        this.valLibelle = valLibelle;
    }

    public String getCodParam() {
        return codParam;
    }

    public void setCodParam(String codParam) {
        this.codParam = codParam;
    }

    public String getValLibelle() {
        return valLibelle;
    }

    public void setValLibelle(String valLibelle) {
        this.valLibelle = valLibelle;
    }

    public String getValChaine() {
        return valChaine;
    }

    public void setValChaine(String valChaine) {
        this.valChaine = valChaine;
    }

    public BigInteger getValNumeric() {
        return valNumeric;
    }

    public void setValNumeric(BigInteger valNumeric) {
        this.valNumeric = valNumeric;
    }

    public Date getValDate() {
        return valDate;
    }

    public void setValDate(Date valDate) {
        this.valDate = valDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codParam != null ? codParam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigParametre)) {
            return false;
        }
        SigParametre other = (SigParametre) object;
        if ((this.codParam == null && other.codParam != null) || (this.codParam != null && !this.codParam.equals(other.codParam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigParametre[ codParam=" + codParam + " ]";
    }
    
}

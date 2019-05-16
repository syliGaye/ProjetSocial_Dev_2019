/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "sig_localite_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigLocaliteView.findAll", query = "SELECT s FROM SigLocaliteView s")
    , @NamedQuery(name = "SigLocaliteView.findByCodRegion", query = "SELECT s FROM SigLocaliteView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigLocaliteView.findByNomRegion", query = "SELECT s FROM SigLocaliteView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigLocaliteView.findByCodDepartement", query = "SELECT s FROM SigLocaliteView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigLocaliteView.findByNomDepartement", query = "SELECT s FROM SigLocaliteView s WHERE s.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "SigLocaliteView.findByCodSPref", query = "SELECT s FROM SigLocaliteView s WHERE s.codSPref = :codSPref")
    , @NamedQuery(name = "SigLocaliteView.findByNomSPref", query = "SELECT s FROM SigLocaliteView s WHERE s.nomSPref = :nomSPref")
    , @NamedQuery(name = "SigLocaliteView.findByCodLocalite", query = "SELECT s FROM SigLocaliteView s WHERE s.codLocalite = :codLocalite")
    , @NamedQuery(name = "SigLocaliteView.findByNomLocalite", query = "SELECT s FROM SigLocaliteView s WHERE s.nomLocalite = :nomLocalite")})
public class SigLocaliteView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;
    @Size(max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
	@Id
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;

    public SigLocaliteView() {
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public String getCodDepartement() {
        return codDepartement;
    }

    public void setCodDepartement(String codDepartement) {
        this.codDepartement = codDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getCodSPref() {
        return codSPref;
    }

    public void setCodSPref(String codSPref) {
        this.codSPref = codSPref;
    }

    public String getNomSPref() {
        return nomSPref;
    }

    public void setNomSPref(String nomSPref) {
        this.nomSPref = nomSPref;
    }

    public String getCodLocalite() {
        return codLocalite;
    }

    public void setCodLocalite(String codLocalite) {
        this.codLocalite = codLocalite;
    }

    public String getNomLocalite() {
        return nomLocalite;
    }

    public void setNomLocalite(String nomLocalite) {
        this.nomLocalite = nomLocalite;
    }
    
}

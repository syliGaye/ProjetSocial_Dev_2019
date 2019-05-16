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
@Table(name = "sig_departement_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigDepartementView.findAll", query = "SELECT s FROM SigDepartementView s")
    , @NamedQuery(name = "SigDepartementView.findByCodRegion", query = "SELECT s FROM SigDepartementView s WHERE s.codRegion = :codRegion")
    , @NamedQuery(name = "SigDepartementView.findByNomRegion", query = "SELECT s FROM SigDepartementView s WHERE s.nomRegion = :nomRegion")
    , @NamedQuery(name = "SigDepartementView.findByCodDepartement", query = "SELECT s FROM SigDepartementView s WHERE s.codDepartement = :codDepartement")
    , @NamedQuery(name = "SigDepartementView.findByNomDepartement", query = "SELECT s FROM SigDepartementView s WHERE s.nomDepartement = :nomDepartement")})
public class SigDepartementView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "cod_region")
    private String codRegion;
    @Size(max = 100)
    @Column(name = "nom_region")
    private String nomRegion;
	@Id
    @Size(max = 10)
    @Column(name = "cod_departement")
    private String codDepartement;
    @Size(max = 100)
    @Column(name = "nom_departement")
    private String nomDepartement;

    public SigDepartementView() {
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
    
}

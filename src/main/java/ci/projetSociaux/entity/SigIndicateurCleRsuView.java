/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Immutable;

/**
 *
 * @author RADEON
 */
@Entity
@Immutable
@Table(name = "sig_indicateur_cle_rsu_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigIndicateurCleRsuView.findAll", query = "SELECT s FROM SigIndicateurCleRsuView s")
    , @NamedQuery(name = "SigIndicateurCleRsuView.findByIdIndicateur", query = "SELECT s FROM SigIndicateurCleRsuView s WHERE s.idIndicateur = :idIndicateur")
    , @NamedQuery(name = "SigIndicateurCleRsuView.findByGrpIndicateur GrpIndicateur", query = "SELECT s FROM SigIndicateurCleRsuView s WHERE s.grpIndicateur = :grpIndicateur")
    , @NamedQuery(name = "SigIndicateurCleRsuView.findByLibIndicateur", query = "SELECT s FROM SigIndicateurCleRsuView s WHERE s.libIndicateur = :libIndicateur")
    , @NamedQuery(name = "SigIndicateurCleRsuView.findByNombreMenage", query = "SELECT s FROM SigIndicateurCleRsuView s WHERE s.nombreMenage = :nombreMenage")
    , @NamedQuery(name = "SigIndicateurCleRsuView.findByEffectifTotal", query = "SELECT s FROM SigIndicateurCleRsuView s WHERE s.effectifTotal = :effectifTotal")	
    , @NamedQuery(name = "SigIndicateurCleRsuView.findByEffectifHomme", query = "SELECT s FROM SigIndicateurCleRsuView s WHERE s.effectifHomme = :effectifHomme")	
    , @NamedQuery(name = "SigIndicateurCleRsuView.findByEffectiffemme", query = "SELECT s FROM SigIndicateurCleRsuView s WHERE s.effectifFemme = :effectifFemme")	
	})
public class SigIndicateurCleRsuView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 2147483647)
    @Column(name = "id_indicateur")
    private String idIndicateur;
    @Size(max = 2147483647)
    @Column(name = "grp_indicateur")
    private String grpIndicateur;	
    @Size(max = 2147483647)
    @Column(name = "lib_indicateur")
    private String libIndicateur;	
    @Column(name = "nombre_menage")
    private BigInteger nombreMenage;
    @Column(name = "effectif_total")
    private BigInteger effectifTotal;
    @Column(name = "effectif_homme")
    private BigInteger effectifHomme;
    @Column(name = "effectif_femme")
    private BigInteger effectifFemme;
	
    public SigIndicateurCleRsuView() {
    }

    public String getIdIndicateur() {
        return idIndicateur;
    }

    public void setIdIndicateur(String idIndicateur) {
        this.idIndicateur = idIndicateur;
    }

    public String getLibIndicateur() {
        return libIndicateur;
    }

    public void setLibIndicateur(String libIndicateur) {
        this.libIndicateur = libIndicateur;
    }

	public String getGrpIndicateur() {
		return grpIndicateur;
	}

	public void setGrpIndicateur(String grpIndicateur) {
		this.grpIndicateur = grpIndicateur;
	}

	public BigInteger getNombreMenage() {
		return nombreMenage;
	}

	public void setNombreMenage(BigInteger nombreMenage) {
		this.nombreMenage = nombreMenage;
	}

	public BigInteger getEffectifTotal() {
		return effectifTotal;
	}

	public void setEffectifTotal(BigInteger effectifTotal) {
		this.effectifTotal = effectifTotal;
	}

	public BigInteger getEffectifHomme() {
		return effectifHomme;
	}

	public void setEffectifHomme(BigInteger effectifHomme) {
		this.effectifHomme = effectifHomme;
	}

	public BigInteger getEffectifFemme() {
		return effectifFemme;
	}

	public void setEffectifFemme(BigInteger effectifFemme) {
		this.effectifFemme = effectifFemme;
	}

 
}

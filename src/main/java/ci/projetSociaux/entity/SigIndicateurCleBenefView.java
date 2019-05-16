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
@Table(name = "sig_indicateur_cle_benef_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigIndicateurCleBenefView.findAll", query = "SELECT s FROM SigIndicateurCleBenefView s")
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByIdIndicateur", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.idIndicateur = :idIndicateur")
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByOrdreIndicateur", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.idIndicateur = :ordreIndicateur")    
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByIdSelection", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.idSelection = :idSelection")
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByLibelleSelection", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.libelleSelection = :libelleSelection")    
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByLibIndicateur", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.libIndicateur = :libIndicateur")
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByNombreMenage", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.nombreMenage = :nombreMenage")
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByEffectifTotal", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.effectifTotal = :effectifTotal")	
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByEffectifHomme", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.effectifHomme = :effectifHomme")	
    , @NamedQuery(name = "SigIndicateurCleBenefView.findByEffectiffemme", query = "SELECT s FROM SigIndicateurCleBenefView s WHERE s.effectifFemme = :effectifFemme")	
	})
public class SigIndicateurCleBenefView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 2147483647)
    @Column(name = "id_indicateur")
    private String idIndicateur;
    @Size(max = 2147483647)
    @Column(name = "ordre_indicateur")
    private String ordreIndicateur;	
    @Size(max = 2147483647)
    @Column(name = "id_selection")
    private String idSelection;	    
    @Size(max = 2147483647)
    @Column(name = "libelle_selection")
    private String libelleSelection;	    
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
	
    public SigIndicateurCleBenefView() {
    }

    public String getIdIndicateur() {
        return idIndicateur;
    }

    public String getIdSelection() {
		return idSelection;
	}

	public void setIdSelection(String idSelection) {
		this.idSelection = idSelection;
	}

	public String getOrdreIndicateur() {
		return ordreIndicateur;
	}

	public void setOrdreIndicateur(String ordreIndicateur) {
		this.ordreIndicateur = ordreIndicateur;
	}

	public String getLibelleSelection() {
		return libelleSelection;
	}

	public void setLibelleSelection(String libelleSelection) {
		this.libelleSelection = libelleSelection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

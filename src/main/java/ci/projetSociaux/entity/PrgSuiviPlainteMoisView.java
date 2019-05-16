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
@Table(name = "prg_suivi_plainte_mois_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviPlainteMoisView.findAll", query = "SELECT p FROM PrgSuiviPlainteMoisView p")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByAnnee", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByCodMois", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.codMois = :codMois")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByLibelleMois", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.libelleMois = :libelleMois")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainte", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainte = :nbPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlaintePaiement", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlaintePaiement = :nbPlaintePaiement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteNonPaiement", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteNonPaiement = :nbPlainteNonPaiement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteEffFemme", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteEffFemme = :nbPlainteEffFemme")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteEffHomme", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteEffHomme = :nbPlainteEffHomme")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbConfidentiel", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbConfidentiel = :nbConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbNonConfidentiel", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbNonConfidentiel = :nbNonConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteMineur", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteMineur = :nbPlainteMineur")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteMajeur", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteMajeur = :nbPlainteMajeur")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteCiblage", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteCiblage = :nbPlainteCiblage")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteTransfertMonetaire", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteTransfertMonetaire = :nbPlainteTransfertMonetaire")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteMesureAccompagnement", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteMesureAccompagnement = :nbPlainteMesureAccompagnement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteResolue", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteResolue = :nbPlainteResolue")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByTauxResolutionPlainte", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.tauxResolutionPlainte = :tauxResolutionPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteCloture", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteCloture = :nbPlainteCloture")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteEnCours", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteEnCours = :nbPlainteEnCours")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteTraitN1", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteTraitN1 = :nbPlainteTraitN1")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteTraitN2", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteTraitN2 = :nbPlainteTraitN2")
    , @NamedQuery(name = "PrgSuiviPlainteMoisView.findByNbPlainteNTraitN3", query = "SELECT p FROM PrgSuiviPlainteMoisView p WHERE p.nbPlainteNTraitN3 = :nbPlainteNTraitN3")})
public class PrgSuiviPlainteMoisView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "annee")
    private BigInteger annee;
    @Id
    @Column(name = "cod_mois")
    private BigInteger codMois;
    @Size(max = 2147483647)
    @Column(name = "libelle_mois")
    private String libelleMois;
    @Column(name = "nb_plainte")
    private Integer nbPlainte;
    @Column(name = "nb_plainte_paiement")
    private Integer nbPlaintePaiement;
    @Column(name = "nb_plainte_non_paiement")
    private Integer nbPlainteNonPaiement;
    @Column(name = "nb_plainte_eff_femme")
    private Integer nbPlainteEffFemme;
    @Column(name = "nb_plainte_eff_homme")
    private Integer nbPlainteEffHomme;
    @Column(name = "nb_confidentiel")
    private Integer nbConfidentiel;
    @Column(name = "nb_non_confidentiel")
    private Integer nbNonConfidentiel;
    @Column(name = "nb_plainte_mineur")
    private Integer nbPlainteMineur;
    @Column(name = "nb_plainte_majeur")
    private Integer nbPlainteMajeur;
    @Column(name = "nb_plainte_ciblage")
    private Integer nbPlainteCiblage;
    @Column(name = "nb_plainte_transfert_monetaire")
    private Integer nbPlainteTransfertMonetaire;
    @Column(name = "nb_plainte_mesure_accompagnement")
    private Integer nbPlainteMesureAccompagnement;
    @Column(name = "nb_plainte_resolue")
    private Integer nbPlainteResolue;
    @Column(name = "taux_resolution_plainte")
    private Integer tauxResolutionPlainte;
    @Column(name = "nb_plainte_cloture")
    private Integer nbPlainteCloture;
    @Column(name = "nb_plainte_en_cours")
    private Integer nbPlainteEnCours;
    @Column(name = "nb_plainte_trait_n1")
    private Integer nbPlainteTraitN1;
    @Column(name = "nb_plainte_trait_n2")
    private Integer nbPlainteTraitN2;
    @Column(name = "nb_plainte_n_trait_n3")
    private Integer nbPlainteNTraitN3;

    public PrgSuiviPlainteMoisView() {
    }

    public BigInteger getAnnee() {
        return annee;
    }

    public void setAnnee(BigInteger annee) {
        this.annee = annee;
    }

    public BigInteger getCodMois() {
        return codMois;
    }

    public void setCodMois(BigInteger codMois) {
        this.codMois = codMois;
    }

    public String getLibelleMois() {
        return libelleMois;
    }

    public void setLibelleMois(String libelleMois) {
        this.libelleMois = libelleMois;
    }

    public Integer getNbPlainte() {
        return nbPlainte;
    }

    public void setNbPlainte(Integer nbPlainte) {
        this.nbPlainte = nbPlainte;
    }

    public Integer getNbPlaintePaiement() {
        return nbPlaintePaiement;
    }

    public void setNbPlaintePaiement(Integer nbPlaintePaiement) {
        this.nbPlaintePaiement = nbPlaintePaiement;
    }

    public Integer getNbPlainteNonPaiement() {
        return nbPlainteNonPaiement;
    }

    public void setNbPlainteNonPaiement(Integer nbPlainteNonPaiement) {
        this.nbPlainteNonPaiement = nbPlainteNonPaiement;
    }

    public Integer getNbPlainteEffFemme() {
        return nbPlainteEffFemme;
    }

    public void setNbPlainteEffFemme(Integer nbPlainteEffFemme) {
        this.nbPlainteEffFemme = nbPlainteEffFemme;
    }

    public Integer getNbPlainteEffHomme() {
        return nbPlainteEffHomme;
    }

    public void setNbPlainteEffHomme(Integer nbPlainteEffHomme) {
        this.nbPlainteEffHomme = nbPlainteEffHomme;
    }

    public Integer getNbConfidentiel() {
        return nbConfidentiel;
    }

    public void setNbConfidentiel(Integer nbConfidentiel) {
        this.nbConfidentiel = nbConfidentiel;
    }

    public Integer getNbNonConfidentiel() {
        return nbNonConfidentiel;
    }

    public void setNbNonConfidentiel(Integer nbNonConfidentiel) {
        this.nbNonConfidentiel = nbNonConfidentiel;
    }

    public Integer getNbPlainteMineur() {
        return nbPlainteMineur;
    }

    public void setNbPlainteMineur(Integer nbPlainteMineur) {
        this.nbPlainteMineur = nbPlainteMineur;
    }

    public Integer getNbPlainteMajeur() {
        return nbPlainteMajeur;
    }

    public void setNbPlainteMajeur(Integer nbPlainteMajeur) {
        this.nbPlainteMajeur = nbPlainteMajeur;
    }

    public Integer getNbPlainteCiblage() {
        return nbPlainteCiblage;
    }

    public void setNbPlainteCiblage(Integer nbPlainteCiblage) {
        this.nbPlainteCiblage = nbPlainteCiblage;
    }

    public Integer getNbPlainteTransfertMonetaire() {
        return nbPlainteTransfertMonetaire;
    }

    public void setNbPlainteTransfertMonetaire(Integer nbPlainteTransfertMonetaire) {
        this.nbPlainteTransfertMonetaire = nbPlainteTransfertMonetaire;
    }

    public Integer getNbPlainteMesureAccompagnement() {
        return nbPlainteMesureAccompagnement;
    }

    public void setNbPlainteMesureAccompagnement(Integer nbPlainteMesureAccompagnement) {
        this.nbPlainteMesureAccompagnement = nbPlainteMesureAccompagnement;
    }

    public Integer getNbPlainteResolue() {
        return nbPlainteResolue;
    }

    public void setNbPlainteResolue(Integer nbPlainteResolue) {
        this.nbPlainteResolue = nbPlainteResolue;
    }

    public Integer getTauxResolutionPlainte() {
        return tauxResolutionPlainte;
    }

    public void setTauxResolutionPlainte(Integer tauxResolutionPlainte) {
        this.tauxResolutionPlainte = tauxResolutionPlainte;
    }

    public Integer getNbPlainteCloture() {
        return nbPlainteCloture;
    }

    public void setNbPlainteCloture(Integer nbPlainteCloture) {
        this.nbPlainteCloture = nbPlainteCloture;
    }

    public Integer getNbPlainteEnCours() {
        return nbPlainteEnCours;
    }

    public void setNbPlainteEnCours(Integer nbPlainteEnCours) {
        this.nbPlainteEnCours = nbPlainteEnCours;
    }

    public Integer getNbPlainteTraitN1() {
        return nbPlainteTraitN1;
    }

    public void setNbPlainteTraitN1(Integer nbPlainteTraitN1) {
        this.nbPlainteTraitN1 = nbPlainteTraitN1;
    }

    public Integer getNbPlainteTraitN2() {
        return nbPlainteTraitN2;
    }

    public void setNbPlainteTraitN2(Integer nbPlainteTraitN2) {
        this.nbPlainteTraitN2 = nbPlainteTraitN2;
    }

    public Integer getNbPlainteNTraitN3() {
        return nbPlainteNTraitN3;
    }

    public void setNbPlainteNTraitN3(Integer nbPlainteNTraitN3) {
        this.nbPlainteNTraitN3 = nbPlainteNTraitN3;
    }
    
}

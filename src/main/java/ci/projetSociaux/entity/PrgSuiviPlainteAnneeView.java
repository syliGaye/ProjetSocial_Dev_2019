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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Immutable;

/**
 *
 * @author RADEON
 */
@Entity
@Table(name = "prg_suivi_plainte_annee_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviPlainteAnneeView.findAll", query = "SELECT p FROM PrgSuiviPlainteAnneeView p")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByAnnee", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainte", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainte = :nbPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlaintePaiement", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlaintePaiement = :nbPlaintePaiement")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteNonPaiement", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteNonPaiement = :nbPlainteNonPaiement")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteEffFemme", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteEffFemme = :nbPlainteEffFemme")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteEffHomme", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteEffHomme = :nbPlainteEffHomme")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbConfidentiel", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbConfidentiel = :nbConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbNonConfidentiel", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbNonConfidentiel = :nbNonConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteMineur", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteMineur = :nbPlainteMineur")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteMajeur", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteMajeur = :nbPlainteMajeur")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteCiblage", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteCiblage = :nbPlainteCiblage")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteTransfertMonetaire", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteTransfertMonetaire = :nbPlainteTransfertMonetaire")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteMesureAccompagnement", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteMesureAccompagnement = :nbPlainteMesureAccompagnement")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteResolue", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteResolue = :nbPlainteResolue")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByTauxResolutionPlainte", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.tauxResolutionPlainte = :tauxResolutionPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteCloture", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteCloture = :nbPlainteCloture")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteEnCours", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteEnCours = :nbPlainteEnCours")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteTraitN1", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteTraitN1 = :nbPlainteTraitN1")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteTraitN2", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteTraitN2 = :nbPlainteTraitN2")
    , @NamedQuery(name = "PrgSuiviPlainteAnneeView.findByNbPlainteNTraitN3", query = "SELECT p FROM PrgSuiviPlainteAnneeView p WHERE p.nbPlainteNTraitN3 = :nbPlainteNTraitN3")})
public class PrgSuiviPlainteAnneeView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "annee")
    private BigInteger annee;
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

    public PrgSuiviPlainteAnneeView() {
    }

    public BigInteger getAnnee() {
        return annee;
    }

    public void setAnnee(BigInteger annee) {
        this.annee = annee;
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

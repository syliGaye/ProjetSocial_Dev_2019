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

/**
 *
 * @author DONALD
 */
@Entity
@Table(name = "prg_suivi_plainte_mois_departement_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findAll", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByIdSuivi", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.idSuivi = :idSuivi")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByAnnee", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByCodMois", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.codMois = :codMois")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByLibelleMois", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.libelleMois = :libelleMois")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByCodRegion", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNomRegion", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByCodDepartement", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNomDepartement", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainte", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainte = :nbPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlaintePaiement", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlaintePaiement = :nbPlaintePaiement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteNonPaiement", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteNonPaiement = :nbPlainteNonPaiement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteEffFemme", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteEffFemme = :nbPlainteEffFemme")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteEffHomme", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteEffHomme = :nbPlainteEffHomme")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbConfidentiel", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbConfidentiel = :nbConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbNonConfidentiel", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbNonConfidentiel = :nbNonConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteMineur", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteMineur = :nbPlainteMineur")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteMajeur", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteMajeur = :nbPlainteMajeur")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteCiblage", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteCiblage = :nbPlainteCiblage")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteTransfertMonetaire", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteTransfertMonetaire = :nbPlainteTransfertMonetaire")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteMesureAccompagnement", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteMesureAccompagnement = :nbPlainteMesureAccompagnement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteResolue", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteResolue = :nbPlainteResolue")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByTauxResolutionPlainte", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.tauxResolutionPlainte = :tauxResolutionPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteCloture", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteCloture = :nbPlainteCloture")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteEnCours", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteEnCours = :nbPlainteEnCours")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteTraitN1", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteTraitN1 = :nbPlainteTraitN1")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteTraitN2", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteTraitN2 = :nbPlainteTraitN2")
    , @NamedQuery(name = "PrgSuiviPlainteMoisDepartementView.findByNbPlainteNTraitN3", query = "SELECT p FROM PrgSuiviPlainteMoisDepartementView p WHERE p.nbPlainteNTraitN3 = :nbPlainteNTraitN3")})
public class PrgSuiviPlainteMoisDepartementView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "id_suivi")
    @Id
    private String idSuivi;
    @Column(name = "annee")
    private BigInteger annee;
    @Column(name = "cod_mois")
    private BigInteger codMois;
    @Size(max = 2147483647)
    @Column(name = "libelle_mois")
    private String libelleMois;
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
    @Column(name = "nb_plainte")
    private BigInteger nbPlainte;
    @Column(name = "nb_plainte_paiement")
    private BigInteger nbPlaintePaiement;
    @Column(name = "nb_plainte_non_paiement")
    private BigInteger nbPlainteNonPaiement;
    @Column(name = "nb_plainte_eff_femme")
    private BigInteger nbPlainteEffFemme;
    @Column(name = "nb_plainte_eff_homme")
    private BigInteger nbPlainteEffHomme;
    @Column(name = "nb_confidentiel")
    private BigInteger nbConfidentiel;
    @Column(name = "nb_non_confidentiel")
    private BigInteger nbNonConfidentiel;
    @Column(name = "nb_plainte_mineur")
    private BigInteger nbPlainteMineur;
    @Column(name = "nb_plainte_majeur")
    private BigInteger nbPlainteMajeur;
    @Column(name = "nb_plainte_ciblage")
    private BigInteger nbPlainteCiblage;
    @Column(name = "nb_plainte_transfert_monetaire")
    private BigInteger nbPlainteTransfertMonetaire;
    @Column(name = "nb_plainte_mesure_accompagnement")
    private BigInteger nbPlainteMesureAccompagnement;
    @Column(name = "nb_plainte_resolue")
    private BigInteger nbPlainteResolue;
    @Column(name = "taux_resolution_plainte")
    private BigInteger tauxResolutionPlainte;
    @Column(name = "nb_plainte_cloture")
    private BigInteger nbPlainteCloture;
    @Column(name = "nb_plainte_en_cours")
    private BigInteger nbPlainteEnCours;
    @Column(name = "nb_plainte_trait_n1")
    private BigInteger nbPlainteTraitN1;
    @Column(name = "nb_plainte_trait_n2")
    private BigInteger nbPlainteTraitN2;
    @Column(name = "nb_plainte_n_trait_n3")
    private BigInteger nbPlainteNTraitN3;

    public PrgSuiviPlainteMoisDepartementView() {
    }

    public String getIdSuivi() {
        return idSuivi;
    }

    public void setIdSuivi(String idSuivi) {
        this.idSuivi = idSuivi;
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

    public BigInteger getNbPlainte() {
        return nbPlainte;
    }

    public void setNbPlainte(BigInteger nbPlainte) {
        this.nbPlainte = nbPlainte;
    }

    public BigInteger getNbPlaintePaiement() {
        return nbPlaintePaiement;
    }

    public void setNbPlaintePaiement(BigInteger nbPlaintePaiement) {
        this.nbPlaintePaiement = nbPlaintePaiement;
    }

    public BigInteger getNbPlainteNonPaiement() {
        return nbPlainteNonPaiement;
    }

    public void setNbPlainteNonPaiement(BigInteger nbPlainteNonPaiement) {
        this.nbPlainteNonPaiement = nbPlainteNonPaiement;
    }

    public BigInteger getNbPlainteEffFemme() {
        return nbPlainteEffFemme;
    }

    public void setNbPlainteEffFemme(BigInteger nbPlainteEffFemme) {
        this.nbPlainteEffFemme = nbPlainteEffFemme;
    }

    public BigInteger getNbPlainteEffHomme() {
        return nbPlainteEffHomme;
    }

    public void setNbPlainteEffHomme(BigInteger nbPlainteEffHomme) {
        this.nbPlainteEffHomme = nbPlainteEffHomme;
    }

    public BigInteger getNbConfidentiel() {
        return nbConfidentiel;
    }

    public void setNbConfidentiel(BigInteger nbConfidentiel) {
        this.nbConfidentiel = nbConfidentiel;
    }

    public BigInteger getNbNonConfidentiel() {
        return nbNonConfidentiel;
    }

    public void setNbNonConfidentiel(BigInteger nbNonConfidentiel) {
        this.nbNonConfidentiel = nbNonConfidentiel;
    }

    public BigInteger getNbPlainteMineur() {
        return nbPlainteMineur;
    }

    public void setNbPlainteMineur(BigInteger nbPlainteMineur) {
        this.nbPlainteMineur = nbPlainteMineur;
    }

    public BigInteger getNbPlainteMajeur() {
        return nbPlainteMajeur;
    }

    public void setNbPlainteMajeur(BigInteger nbPlainteMajeur) {
        this.nbPlainteMajeur = nbPlainteMajeur;
    }

    public BigInteger getNbPlainteCiblage() {
        return nbPlainteCiblage;
    }

    public void setNbPlainteCiblage(BigInteger nbPlainteCiblage) {
        this.nbPlainteCiblage = nbPlainteCiblage;
    }

    public BigInteger getNbPlainteTransfertMonetaire() {
        return nbPlainteTransfertMonetaire;
    }

    public void setNbPlainteTransfertMonetaire(BigInteger nbPlainteTransfertMonetaire) {
        this.nbPlainteTransfertMonetaire = nbPlainteTransfertMonetaire;
    }

    public BigInteger getNbPlainteMesureAccompagnement() {
        return nbPlainteMesureAccompagnement;
    }

    public void setNbPlainteMesureAccompagnement(BigInteger nbPlainteMesureAccompagnement) {
        this.nbPlainteMesureAccompagnement = nbPlainteMesureAccompagnement;
    }

    public BigInteger getNbPlainteResolue() {
        return nbPlainteResolue;
    }

    public void setNbPlainteResolue(BigInteger nbPlainteResolue) {
        this.nbPlainteResolue = nbPlainteResolue;
    }

    public BigInteger getTauxResolutionPlainte() {
        return tauxResolutionPlainte;
    }

    public void setTauxResolutionPlainte(BigInteger tauxResolutionPlainte) {
        this.tauxResolutionPlainte = tauxResolutionPlainte;
    }

    public BigInteger getNbPlainteCloture() {
        return nbPlainteCloture;
    }

    public void setNbPlainteCloture(BigInteger nbPlainteCloture) {
        this.nbPlainteCloture = nbPlainteCloture;
    }

    public BigInteger getNbPlainteEnCours() {
        return nbPlainteEnCours;
    }

    public void setNbPlainteEnCours(BigInteger nbPlainteEnCours) {
        this.nbPlainteEnCours = nbPlainteEnCours;
    }

    public BigInteger getNbPlainteTraitN1() {
        return nbPlainteTraitN1;
    }

    public void setNbPlainteTraitN1(BigInteger nbPlainteTraitN1) {
        this.nbPlainteTraitN1 = nbPlainteTraitN1;
    }

    public BigInteger getNbPlainteTraitN2() {
        return nbPlainteTraitN2;
    }

    public void setNbPlainteTraitN2(BigInteger nbPlainteTraitN2) {
        this.nbPlainteTraitN2 = nbPlainteTraitN2;
    }

    public BigInteger getNbPlainteNTraitN3() {
        return nbPlainteNTraitN3;
    }

    public void setNbPlainteNTraitN3(BigInteger nbPlainteNTraitN3) {
        this.nbPlainteNTraitN3 = nbPlainteNTraitN3;
    }
    
}
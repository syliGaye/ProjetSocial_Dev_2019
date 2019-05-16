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
@Table(name = "prg_suivi_plainte_mois_localite_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findAll", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByIdSuivi", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.idSuivi = :idSuivi")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByAnnee", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.annee = :annee")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByCodMois", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.codMois = :codMois")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByLibelleMois", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.libelleMois = :libelleMois")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByCodRegion", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNomRegion", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByCodDepartement", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNomDepartement", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByCodSPref", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNomSPref", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByCodLocalite", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNomLocalite", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainte", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainte = :nbPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlaintePaiement", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlaintePaiement = :nbPlaintePaiement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteNonPaiement", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteNonPaiement = :nbPlainteNonPaiement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteEffFemme", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteEffFemme = :nbPlainteEffFemme")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteEffHomme", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteEffHomme = :nbPlainteEffHomme")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbConfidentiel", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbConfidentiel = :nbConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbNonConfidentiel", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbNonConfidentiel = :nbNonConfidentiel")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteMineur", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteMineur = :nbPlainteMineur")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteMajeur", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteMajeur = :nbPlainteMajeur")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteCiblage", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteCiblage = :nbPlainteCiblage")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteTransfertMonetaire", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteTransfertMonetaire = :nbPlainteTransfertMonetaire")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteMesureAccompagnement", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteMesureAccompagnement = :nbPlainteMesureAccompagnement")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteResolue", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteResolue = :nbPlainteResolue")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByTauxResolutionPlainte", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.tauxResolutionPlainte = :tauxResolutionPlainte")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteCloture", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteCloture = :nbPlainteCloture")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteEnCours", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteEnCours = :nbPlainteEnCours")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteTraitN1", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteTraitN1 = :nbPlainteTraitN1")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteTraitN2", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteTraitN2 = :nbPlainteTraitN2")
    , @NamedQuery(name = "PrgSuiviPlainteMoisLocaliteView.findByNbPlainteNTraitN3", query = "SELECT p FROM PrgSuiviPlainteMoisLocaliteView p WHERE p.nbPlainteNTraitN3 = :nbPlainteNTraitN3")})
public class PrgSuiviPlainteMoisLocaliteView implements Serializable {

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
    @Size(max = 10)
    @Column(name = "cod_s_pref")
    private String codSPref;
    @Size(max = 100)
    @Column(name = "nom_s_pref")
    private String nomSPref;
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
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

    public PrgSuiviPlainteMoisLocaliteView() {
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

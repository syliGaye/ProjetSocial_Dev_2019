/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_plainte_cons_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPlainteConsView.findAll", query = "SELECT p FROM PrgPlainteConsView p")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodRegion", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codRegion = :codRegion")
    , @NamedQuery(name = "PrgPlainteConsView.findByNomRegion", query = "SELECT p FROM PrgPlainteConsView p WHERE p.nomRegion = :nomRegion")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodDepartement", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codDepartement = :codDepartement")
    , @NamedQuery(name = "PrgPlainteConsView.findByNomDepartement", query = "SELECT p FROM PrgPlainteConsView p WHERE p.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodSPref", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codSPref = :codSPref")
    , @NamedQuery(name = "PrgPlainteConsView.findByNomSPref", query = "SELECT p FROM PrgPlainteConsView p WHERE p.nomSPref = :nomSPref")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodLocalite", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codLocalite = :codLocalite")
    , @NamedQuery(name = "PrgPlainteConsView.findByNomLocalite", query = "SELECT p FROM PrgPlainteConsView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgPlainteConsView.findByNumPlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.numPlainte = :numPlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodePlaignant", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codePlaignant = :codePlaignant")
    , @NamedQuery(name = "PrgPlainteConsView.findByNomPlaingnant", query = "SELECT p FROM PrgPlainteConsView p WHERE p.nomPlaingnant = :nomPlaingnant")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodAgCol", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codAgCol = :codAgCol")
    , @NamedQuery(name = "PrgPlainteConsView.findByNomAgCol", query = "SELECT p FROM PrgPlainteConsView p WHERE p.nomAgCol = :nomAgCol")
    , @NamedQuery(name = "PrgPlainteConsView.findByDescription", query = "SELECT p FROM PrgPlainteConsView p WHERE p.description = :description")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodMenage", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codMenage = :codMenage")
    , @NamedQuery(name = "PrgPlainteConsView.findByIdPaiement", query = "SELECT p FROM PrgPlainteConsView p WHERE p.idPaiement = :idPaiement")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateEnregis", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateEnregis = :dateEnregis")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateSignal", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateSignal = :dateSignal")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodTypologie", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codTypologie = :codTypologie")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleTypologie", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleTypologie = :libelleTypologie")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodForeGeste", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codForeGeste = :codForeGeste")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleFormGeste", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleFormGeste = :libelleFormGeste")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodLieu", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codLieu = :codLieu")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleLieu", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleLieu = :libelleLieu")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodModeSaisie", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codModeSaisie = :codModeSaisie")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleModeSaisi", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleModeSaisi = :libelleModeSaisi")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodTypGeste", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codTypGeste = :codTypGeste")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleTyeGeste", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleTyeGeste = :libelleTyeGeste")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodMoment", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codMoment = :codMoment")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleMoment", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleMoment = :libelleMoment")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodObjetDiscr", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codObjetDiscr = :codObjetDiscr")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleObjetDiscr", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleObjetDiscr = :libelleObjetDiscr")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodCatPlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codCatPlainte = :codCatPlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleCatPlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleCatPlainte = :libelleCatPlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodNatGest", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codNatGest = :codNatGest")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibelleNatGest", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libelleNatGest = :libelleNatGest")
    , @NamedQuery(name = "PrgPlainteConsView.findByConfidPlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.confidPlainte = :confidPlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibConfidPlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libConfidPlainte = :libConfidPlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateEvent", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateEvent = :dateEvent")
    , @NamedQuery(name = "PrgPlainteConsView.findByRefCourrier", query = "SELECT p FROM PrgPlainteConsView p WHERE p.refCourrier = :refCourrier")
    , @NamedQuery(name = "PrgPlainteConsView.findByGravitePlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.gravitePlainte = :gravitePlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibGravitePlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libGravitePlainte = :libGravitePlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByStatutPlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.statutPlainte = :statutPlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByLibStatutPlainte", query = "SELECT p FROM PrgPlainteConsView p WHERE p.libStatutPlainte = :libStatutPlainte")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodeValid1", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codeValid1 = :codeValid1")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateValid1", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateValid1 = :dateValid1")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateTrans1", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateTrans1 = :dateTrans1")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodeValid2", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codeValid2 = :codeValid2")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateValid2", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateValid2 = :dateValid2")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateTrans2", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateTrans2 = :dateTrans2")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodeValid3", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codeValid3 = :codeValid3")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateValid3", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateValid3 = :dateValid3")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateTrans3", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateTrans3 = :dateTrans3")
    , @NamedQuery(name = "PrgPlainteConsView.findByCodeValid4", query = "SELECT p FROM PrgPlainteConsView p WHERE p.codeValid4 = :codeValid4")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateValid4", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateValid4 = :dateValid4")
    , @NamedQuery(name = "PrgPlainteConsView.findByDateCloture", query = "SELECT p FROM PrgPlainteConsView p WHERE p.dateCloture = :dateCloture")})
public class PrgPlainteConsView implements Serializable {

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
    @Size(max = 10)
    @Column(name = "cod_localite")
    private String codLocalite;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
    @Size(max = 25)
    @Id
    @Column(name = "num_plainte")
    private String numPlainte;
    @Size(max = 25)
    @Column(name = "code_plaignant")
    private String codePlaignant;
    @Size(max = 2147483647)
    @Column(name = "nom_plaingnant")
    private String nomPlaingnant;
    @Size(max = 25)
    @Column(name = "genre_plaingnant")
    private String genrePlaingnant;
    @Size(max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Size(max = 2147483647)
    @Column(name = "nom_ag_col")
    private String nomAgCol;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Size(max = 25)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 25)
    @Column(name = "id_paiement")
    private String idPaiement;
    @Column(name = "date_enregis")
    @Temporal(TemporalType.DATE)
    private Date dateEnregis;
    @Column(name = "date_signal")
    @Temporal(TemporalType.DATE)
    private Date dateSignal;
    @Size(max = 10)
    @Column(name = "cod_typologie")
    private String codTypologie;
    @Size(max = 100)
    @Column(name = "libelle_typologie")
    private String libelleTypologie;
    @Size(max = 10)
    @Column(name = "cod_fore_geste")
    private String codForeGeste;
    @Size(max = 100)
    @Column(name = "libelle_form_geste")
    private String libelleFormGeste;
    @Size(max = 10)
    @Column(name = "cod_lieu")
    private String codLieu;
    @Size(max = 100)
    @Column(name = "libelle_lieu")
    private String libelleLieu;
    @Size(max = 10)
    @Column(name = "cod_mode_saisie")
    private String codModeSaisie;
    @Size(max = 100)
    @Column(name = "libelle_mode_saisi")
    private String libelleModeSaisi;
    @Size(max = 10)
    @Column(name = "cod_typ_geste")
    private String codTypGeste;
    @Size(max = 100)
    @Column(name = "libelle_tye_geste")
    private String libelleTyeGeste;
    @Size(max = 10)
    @Column(name = "cod_moment")
    private String codMoment;
    @Size(max = 100)
    @Column(name = "libelle_moment")
    private String libelleMoment;
    @Size(max = 10)
    @Column(name = "cod_objet_discr")
    private String codObjetDiscr;
    @Size(max = 100)
    @Column(name = "libelle_objet_discr")
    private String libelleObjetDiscr;
    @Size(max = 10)
    @Column(name = "cod_cat_plainte")
    private String codCatPlainte;
    @Size(max = 100)
    @Column(name = "libelle_cat_plainte")
    private String libelleCatPlainte;
    @Size(max = 10)
    @Column(name = "cod_nat_gest")
    private String codNatGest;
    @Size(max = 100)
    @Column(name = "libelle_nat_gest")
    private String libelleNatGest;
    @Size(max = 5)
    @Column(name = "confid_plainte")
    private String confidPlainte;
    @Size(max = 2147483647)
    @Column(name = "lib_confid_plainte")
    private String libConfidPlainte;
    @Column(name = "date_event")
    @Temporal(TemporalType.DATE)
    private Date dateEvent;
    @Size(max = 50)
    @Column(name = "ref_courrier")
    private String refCourrier;
    @Size(max = 5)
    @Column(name = "gravite_plainte")
    private String gravitePlainte;
    @Size(max = 2147483647)
    @Column(name = "lib_gravite_plainte")
    private String libGravitePlainte;
    @Size(max = 5)
    @Column(name = "statut_plainte")
    private String statutPlainte;
    @Size(max = 2147483647)
    @Column(name = "lib_statut_plainte")
    private String libStatutPlainte;
    @Size(max = 10)
    @Column(name = "code_valid1")
    private String codeValid1;
    @Column(name = "date_valid1")
    @Temporal(TemporalType.DATE)
    private Date dateValid1;
    @Column(name = "date_trans1")
    @Temporal(TemporalType.DATE)
    private Date dateTrans1;
    @Size(max = 10)
    @Column(name = "code_valid2")
    private String codeValid2;
    @Column(name = "date_valid2")
    @Temporal(TemporalType.DATE)
    private Date dateValid2;
    @Column(name = "date_trans2")
    @Temporal(TemporalType.DATE)
    private Date dateTrans2;
    @Size(max = 10)
    @Column(name = "code_valid3")
    private String codeValid3;
    @Column(name = "date_valid3")
    @Temporal(TemporalType.DATE)
    private Date dateValid3;
    @Column(name = "date_trans3")
    @Temporal(TemporalType.DATE)
    private Date dateTrans3;
    @Size(max = 10)
    @Column(name = "code_valid4")
    private String codeValid4;
    @Column(name = "date_valid4")
    @Temporal(TemporalType.DATE)
    private Date dateValid4;
    @Column(name = "date_cloture")
    @Temporal(TemporalType.DATE)
    private Date dateCloture;

    public PrgPlainteConsView() {
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

    public String getNumPlainte() {
        return numPlainte;
    }

    public void setNumPlainte(String numPlainte) {
        this.numPlainte = numPlainte;
    }

    public String getCodePlaignant() {
        return codePlaignant;
    }

    public void setCodePlaignant(String codePlaignant) {
        this.codePlaignant = codePlaignant;
    }

    public String getNomPlaingnant() {
        return nomPlaingnant;
    }

    public void setNomPlaingnant(String nomPlaingnant) {
        this.nomPlaingnant = nomPlaingnant;
    }

    public String getGenrePlaingnant() {
        return genrePlaingnant;
    }

    public void setGenrePlaingnant(String genrePlaingnant) {
        this.genrePlaingnant = genrePlaingnant;
    }

    public String getCodAgCol() {
        return codAgCol;
    }

    public void setCodAgCol(String codAgCol) {
        this.codAgCol = codAgCol;
    }

    public String getNomAgCol() {
        return nomAgCol;
    }

    public void setNomAgCol(String nomAgCol) {
        this.nomAgCol = nomAgCol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Date getDateEnregis() {
        return dateEnregis;
    }

    public void setDateEnregis(Date dateEnregis) {
        this.dateEnregis = dateEnregis;
    }

    public Date getDateSignal() {
        return dateSignal;
    }

    public void setDateSignal(Date dateSignal) {
        this.dateSignal = dateSignal;
    }

    public String getCodTypologie() {
        return codTypologie;
    }

    public void setCodTypologie(String codTypologie) {
        this.codTypologie = codTypologie;
    }

    public String getLibelleTypologie() {
        return libelleTypologie;
    }

    public void setLibelleTypologie(String libelleTypologie) {
        this.libelleTypologie = libelleTypologie;
    }

    public String getCodForeGeste() {
        return codForeGeste;
    }

    public void setCodForeGeste(String codForeGeste) {
        this.codForeGeste = codForeGeste;
    }

    public String getLibelleFormGeste() {
        return libelleFormGeste;
    }

    public void setLibelleFormGeste(String libelleFormGeste) {
        this.libelleFormGeste = libelleFormGeste;
    }

    public String getCodLieu() {
        return codLieu;
    }

    public void setCodLieu(String codLieu) {
        this.codLieu = codLieu;
    }

    public String getLibelleLieu() {
        return libelleLieu;
    }

    public void setLibelleLieu(String libelleLieu) {
        this.libelleLieu = libelleLieu;
    }

    public String getCodModeSaisie() {
        return codModeSaisie;
    }

    public void setCodModeSaisie(String codModeSaisie) {
        this.codModeSaisie = codModeSaisie;
    }

    public String getLibelleModeSaisi() {
        return libelleModeSaisi;
    }

    public void setLibelleModeSaisi(String libelleModeSaisi) {
        this.libelleModeSaisi = libelleModeSaisi;
    }

    public String getCodTypGeste() {
        return codTypGeste;
    }

    public void setCodTypGeste(String codTypGeste) {
        this.codTypGeste = codTypGeste;
    }

    public String getLibelleTyeGeste() {
        return libelleTyeGeste;
    }

    public void setLibelleTyeGeste(String libelleTyeGeste) {
        this.libelleTyeGeste = libelleTyeGeste;
    }

    public String getCodMoment() {
        return codMoment;
    }

    public void setCodMoment(String codMoment) {
        this.codMoment = codMoment;
    }

    public String getLibelleMoment() {
        return libelleMoment;
    }

    public void setLibelleMoment(String libelleMoment) {
        this.libelleMoment = libelleMoment;
    }

    public String getCodObjetDiscr() {
        return codObjetDiscr;
    }

    public void setCodObjetDiscr(String codObjetDiscr) {
        this.codObjetDiscr = codObjetDiscr;
    }

    public String getLibelleObjetDiscr() {
        return libelleObjetDiscr;
    }

    public void setLibelleObjetDiscr(String libelleObjetDiscr) {
        this.libelleObjetDiscr = libelleObjetDiscr;
    }

    public String getCodCatPlainte() {
        return codCatPlainte;
    }

    public void setCodCatPlainte(String codCatPlainte) {
        this.codCatPlainte = codCatPlainte;
    }

    public String getLibelleCatPlainte() {
        return libelleCatPlainte;
    }

    public void setLibelleCatPlainte(String libelleCatPlainte) {
        this.libelleCatPlainte = libelleCatPlainte;
    }

    public String getCodNatGest() {
        return codNatGest;
    }

    public void setCodNatGest(String codNatGest) {
        this.codNatGest = codNatGest;
    }

    public String getLibelleNatGest() {
        return libelleNatGest;
    }

    public void setLibelleNatGest(String libelleNatGest) {
        this.libelleNatGest = libelleNatGest;
    }

    public String getConfidPlainte() {
        return confidPlainte;
    }

    public void setConfidPlainte(String confidPlainte) {
        this.confidPlainte = confidPlainte;
    }

    public String getLibConfidPlainte() {
        return libConfidPlainte;
    }

    public void setLibConfidPlainte(String libConfidPlainte) {
        this.libConfidPlainte = libConfidPlainte;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getRefCourrier() {
        return refCourrier;
    }

    public void setRefCourrier(String refCourrier) {
        this.refCourrier = refCourrier;
    }

    public String getGravitePlainte() {
        return gravitePlainte;
    }

    public void setGravitePlainte(String gravitePlainte) {
        this.gravitePlainte = gravitePlainte;
    }

    public String getLibGravitePlainte() {
        return libGravitePlainte;
    }

    public void setLibGravitePlainte(String libGravitePlainte) {
        this.libGravitePlainte = libGravitePlainte;
    }

    public String getStatutPlainte() {
        return statutPlainte;
    }

    public void setStatutPlainte(String statutPlainte) {
        this.statutPlainte = statutPlainte;
    }

    public String getLibStatutPlainte() {
        return libStatutPlainte;
    }

    public void setLibStatutPlainte(String libStatutPlainte) {
        this.libStatutPlainte = libStatutPlainte;
    }

    public String getCodeValid1() {
        return codeValid1;
    }

    public void setCodeValid1(String codeValid1) {
        this.codeValid1 = codeValid1;
    }

    public Date getDateValid1() {
        return dateValid1;
    }

    public void setDateValid1(Date dateValid1) {
        this.dateValid1 = dateValid1;
    }

    public Date getDateTrans1() {
        return dateTrans1;
    }

    public void setDateTrans1(Date dateTrans1) {
        this.dateTrans1 = dateTrans1;
    }

    public String getCodeValid2() {
        return codeValid2;
    }

    public void setCodeValid2(String codeValid2) {
        this.codeValid2 = codeValid2;
    }

    public Date getDateValid2() {
        return dateValid2;
    }

    public void setDateValid2(Date dateValid2) {
        this.dateValid2 = dateValid2;
    }

    public Date getDateTrans2() {
        return dateTrans2;
    }

    public void setDateTrans2(Date dateTrans2) {
        this.dateTrans2 = dateTrans2;
    }

    public String getCodeValid3() {
        return codeValid3;
    }

    public void setCodeValid3(String codeValid3) {
        this.codeValid3 = codeValid3;
    }

    public Date getDateValid3() {
        return dateValid3;
    }

    public void setDateValid3(Date dateValid3) {
        this.dateValid3 = dateValid3;
    }

    public Date getDateTrans3() {
        return dateTrans3;
    }

    public void setDateTrans3(Date dateTrans3) {
        this.dateTrans3 = dateTrans3;
    }

    public String getCodeValid4() {
        return codeValid4;
    }

    public void setCodeValid4(String codeValid4) {
        this.codeValid4 = codeValid4;
    }

    public Date getDateValid4() {
        return dateValid4;
    }

    public void setDateValid4(Date dateValid4) {
        this.dateValid4 = dateValid4;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }
    
}

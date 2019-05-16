/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.math.BigInteger;
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

import org.springframework.format.annotation.DateTimeFormat;
 
/**
 *
 * @author hp
 */
@Entity
@Table(name = "rsu_menage_potentiel_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RsuMenagePotentielView.findAll", query = "SELECT r FROM RsuMenagePotentielView r")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffMenage", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effMenage = :effMenage")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffHomme", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effHomme = :effHomme")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffFemme", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effFemme = :effFemme")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffEnceinte", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effEnceinte = :effEnceinte")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffMineur", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effMineur = :effMineur")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffSup", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effSup = :effSup")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffModel1", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effModel1 = :effModel1")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffModel2", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effModel2 = :effModel2")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffModel3", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effModel3 = :effModel3")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffModel4", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effModel4 = :effModel4")
    , @NamedQuery(name = "RsuMenagePotentielView.findByEffModel5", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.effModel5 = :effModel5")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodRegion", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codRegion = :codRegion")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNomRegion", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.nomRegion = :nomRegion")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodDepartement", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codDepartement = :codDepartement")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNomDepartement", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.nomDepartement = :nomDepartement")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodSPref", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codSPref = :codSPref")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNomSPref", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.nomSPref = :nomSPref")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLocalite", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLocalite = :codLocalite")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNomLocalite", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodMenage", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codMenage = :codMenage")
    , @NamedQuery(name = "RsuMenagePotentielView.findByIdChefMenage", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.idChefMenage = :idChefMenage")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNomChefMenage", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.nomChefMenage = :nomChefMenage")
    , @NamedQuery(name = "RsuMenagePotentielView.findByTelChefMenage", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.telChefMenage = :telChefMenage")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLogMur", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLogMur = :codLogMur")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibelleLogMur", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libelleLogMur = :libelleLogMur")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodAgCol", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codAgCol = :codAgCol")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNomAgCol", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.nomAgCol = :nomAgCol")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLogOrdure", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLogOrdure = :codLogOrdure")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibelleLogOrdure", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libelleLogOrdure = :libelleLogOrdure")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLogSol", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLogSol = :codLogSol")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibelleLogSol", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libelleLogSol = :libelleLogSol")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLogEau", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLogEau = :codLogEau")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibelleLogEau", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libelleLogEau = :libelleLogEau")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLogDouche", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLogDouche = :codLogDouche")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibelleLogDouche", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libelleLogDouche = :libelleLogDouche")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLogToilette", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLogToilette = :codLogToilette")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibelleLogToilette", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libelleLogToilette = :libelleLogToilette")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCodLogToit", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.codLogToit = :codLogToit")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibelleLogToit", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libelleLogToit = :libelleLogToit")
    , @NamedQuery(name = "RsuMenagePotentielView.findByDateHeurDebut", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.dateHeurDebut = :dateHeurDebut")
    , @NamedQuery(name = "RsuMenagePotentielView.findByDateHeurFin", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.dateHeurFin = :dateHeurFin")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNumAppareil", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.numAppareil = :numAppareil")
    , @NamedQuery(name = "RsuMenagePotentielView.findByIduser", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.iduser = :iduser")
    , @NamedQuery(name = "RsuMenagePotentielView.findByIdsim", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.idsim = :idsim")
    , @NamedQuery(name = "RsuMenagePotentielView.findByNumeroTelephone", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.numeroTelephone = :numeroTelephone")
    , @NamedQuery(name = "RsuMenagePotentielView.findByVillageQuartier", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.villageQuartier = :villageQuartier")
    , @NamedQuery(name = "RsuMenagePotentielView.findByIlot", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.ilot = :ilot")
    , @NamedQuery(name = "RsuMenagePotentielView.findByBatiment", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.batiment = :batiment")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLogement", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.logement = :logement")
    , @NamedQuery(name = "RsuMenagePotentielView.findByGpsLatitude", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.gpsLatitude = :gpsLatitude")
    , @NamedQuery(name = "RsuMenagePotentielView.findByGpsLongitude", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.gpsLongitude = :gpsLongitude")
    , @NamedQuery(name = "RsuMenagePotentielView.findByGpsAltitude", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.gpsAltitude = :gpsAltitude")
    , @NamedQuery(name = "RsuMenagePotentielView.findByGpsAccuracy", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.gpsAccuracy = :gpsAccuracy")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLTabouret", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.lTabouret = :lTabouret")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibLTabouret", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libLTabouret = :libLTabouret")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLTable", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.lTable = :lTable")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibLlTable", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libLlTable = :libLlTable")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLFauteuil", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.lFauteuil = :lFauteuil")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibLFauteuil", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libLFauteuil = :libLFauteuil")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAPortable", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aPortable = :aPortable")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAPortable", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAPortable = :libAPortable")
    , @NamedQuery(name = "RsuMenagePotentielView.findByATv", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aTv = :aTv")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibATv", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libATv = :libATv")
    , @NamedQuery(name = "RsuMenagePotentielView.findByARadio", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aRadio = :aRadio")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibARadio", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libARadio = :libARadio")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAOrdinateur", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aOrdinateur = :aOrdinateur")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAOrdinateur", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAOrdinateur = :libAOrdinateur")
    , @NamedQuery(name = "RsuMenagePotentielView.findByACuisiniere", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aCuisiniere = :aCuisiniere")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibACuisiniere", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libACuisiniere = :libACuisiniere")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAAntenneParabolique", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aAntenneParabolique = :aAntenneParabolique")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAAntenneParabolique", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAAntenneParabolique = :libAAntenneParabolique")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAAppPhotoNum", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aAppPhotoNum = :aAppPhotoNum")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAAppPhotoNum", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAAppPhotoNum = :libAAppPhotoNum")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAVoiture", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aVoiture = :aVoiture")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAVoiture", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAVoiture = :libAVoiture")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAVelomoteur", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aVelomoteur = :aVelomoteur")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAVelomoteur", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAVelomoteur = :libAVelomoteur")
    , @NamedQuery(name = "RsuMenagePotentielView.findByABrouette", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aBrouette = :aBrouette")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibABrouette", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libABrouette = :libABrouette")
    , @NamedQuery(name = "RsuMenagePotentielView.findByABateauDePeche", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aBateauDePeche = :aBateauDePeche")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibABateauDePeche", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libABateauDePeche = :libABateauDePeche")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAFerARepasser", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aFerARepasser = :aFerARepasser")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAFerARepasser", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAFerARepasser = :libAFerARepasser")
    , @NamedQuery(name = "RsuMenagePotentielView.findByASalonOrdinaire", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aSalonOrdinaire = :aSalonOrdinaire")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibASalonOrdinaire", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libASalonOrdinaire = :libASalonOrdinaire")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAChaiseAutre", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aChaiseAutre = :aChaiseAutre")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAChaiseAutre", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAChaiseAutre = :libAChaiseAutre")
    , @NamedQuery(name = "RsuMenagePotentielView.findByALit", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aLit = :aLit")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibALit", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libALit = :libALit")
    , @NamedQuery(name = "RsuMenagePotentielView.findByADrapEtCouverture", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aDrapEtCouverture = :aDrapEtCouverture")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibADrapEtCouverture", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libADrapEtCouverture = :libADrapEtCouverture")
    , @NamedQuery(name = "RsuMenagePotentielView.findByANatte", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aNatte = :aNatte")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibANatte", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libANatte = :libANatte")
    , @NamedQuery(name = "RsuMenagePotentielView.findByASceau", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aSceau = :aSceau")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibASceau", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libASceau = :libASceau")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAPilonEtMortier", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aPilonEtMortier = :aPilonEtMortier")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAPilonEtMortier", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAPilonEtMortier = :libAPilonEtMortier")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAMoto", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.aMoto = :aMoto")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAMoto", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAMoto = :libAMoto")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLogemementChambres", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.logemementChambres = :logemementChambres")
    , @NamedQuery(name = "RsuMenagePotentielView.findByMilieuResidence", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.milieuResidence = :milieuResidence")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibMilieuResidence", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libMilieuResidence = :libMilieuResidence")
    , @NamedQuery(name = "RsuMenagePotentielView.findByAppelTelephonique", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.appelTelephonique = :appelTelephonique")
    , @NamedQuery(name = "RsuMenagePotentielView.findByLibAppelTelephonique", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.libAppelTelephonique = :libAppelTelephonique")
    , @NamedQuery(name = "RsuMenagePotentielView.findByDistanceHopital", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.distanceHopital = :distanceHopital")
    , @NamedQuery(name = "RsuMenagePotentielView.findByInstanceId", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.instanceId = :instanceId")
    , @NamedQuery(name = "RsuMenagePotentielView.findByInstancename", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.instancename = :instancename")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCreerPar", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.creerPar = :creerPar")
    , @NamedQuery(name = "RsuMenagePotentielView.findByCreerLe", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.creerLe = :creerLe")
    , @NamedQuery(name = "RsuMenagePotentielView.findByModifierPar", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.modifierPar = :modifierPar")
    , @NamedQuery(name = "RsuMenagePotentielView.findByModifierLe", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.modifierLe = :modifierLe")
    , @NamedQuery(name = "RsuMenagePotentielView.findByPmtScore", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.pmtScore = :pmtScore")
    , @NamedQuery(name = "RsuMenagePotentielView.findByDateCreation", query = "SELECT r FROM RsuMenagePotentielView r WHERE r.dateCreation = :dateCreation")})
public class RsuMenagePotentielView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "eff_menage")
    private BigInteger effMenage;
    @Column(name = "eff_homme")
    private BigInteger effHomme;
    @Column(name = "eff_femme")
    private BigInteger effFemme;
    @Column(name = "eff_enceinte")
    private BigInteger effEnceinte;
    @Column(name = "eff_mineur")
    private BigInteger effMineur;
    @Column(name = "eff_sup")
    private BigInteger effSup;
    @Column(name = "eff_model1")
    private Double effModel1;
    @Column(name = "eff_model2")
    private Double effModel2;
    @Column(name = "eff_model3")
    private Double effModel3;
    @Column(name = "eff_model4")
    private Double effModel4;
    @Column(name = "eff_model5")
    private Double effModel5;
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
    @Id
    @Size(max = 30)
    @Column(name = "cod_menage")
    private String codMenage;
    @Size(max = 50)
    @Column(name = "id_chef_menage")
    private String idChefMenage;
    @Size(max = 2147483647)
    @Column(name = "nom_chef_menage")
    private String nomChefMenage;
    @Size(max = 2147483647)
    @Column(name = "tel_chef_menage")
    private String telChefMenage;
    @Size(max = 10)
    @Column(name = "cod_log_mur")
    private String codLogMur;
    @Size(max = 2147483647)
    @Column(name = "libelle_log_mur")
    private String libelleLogMur;
    @Size(max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Size(max = 2147483647)
    @Column(name = "nom_ag_col")
    private String nomAgCol;
    @Size(max = 10)
    @Column(name = "cod_log_ordure")
    private String codLogOrdure;
    @Size(max = 2147483647)
    @Column(name = "libelle_log_ordure")
    private String libelleLogOrdure;
    @Size(max = 10)
    @Column(name = "cod_log_sol")
    private String codLogSol;
    @Size(max = 2147483647)
    @Column(name = "libelle_log_sol")
    private String libelleLogSol;
    @Size(max = 10)
    @Column(name = "cod_log_eau")
    private String codLogEau;
    @Size(max = 2147483647)
    @Column(name = "libelle_log_eau")
    private String libelleLogEau;
    @Size(max = 10)
    @Column(name = "cod_log_douche")
    private String codLogDouche;
    @Size(max = 2147483647)
    @Column(name = "libelle_log_douche")
    private String libelleLogDouche;
    @Size(max = 10)
    @Column(name = "cod_log_toilette")
    private String codLogToilette;
    @Size(max = 2147483647)
    @Column(name = "libelle_log_toilette")
    private String libelleLogToilette;
    @Size(max = 10)
    @Column(name = "cod_log_toit")
    private String codLogToit;
    @Size(max = 2147483647)
    @Column(name = "libelle_log_toit")
    private String libelleLogToit;
    @Size(max = 2147483647)
    @Column(name = "date_heur_debut")
    private String dateHeurDebut;
    @Size(max = 2147483647)
    @Column(name = "date_heur_fin")
    private String dateHeurFin;
    @Size(max = 50)
    @Column(name = "num_appareil")
    private String numAppareil;
    @Size(max = 50)
    @Column(name = "iduser")
    private String iduser;
    @Size(max = 50)
    @Column(name = "idsim")
    private String idsim;
    @Size(max = 25)
    @Column(name = "numero_telephone")
    private String numeroTelephone;
    @Size(max = 200)
    @Column(name = "village_quartier")
    private String villageQuartier;
    @Size(max = 5)
    @Column(name = "ilot")
    private String ilot;
    @Size(max = 10)
    @Column(name = "batiment")
    private String batiment;
    @Size(max = 5)
    @Column(name = "logement")
    private String logement;
    @Size(max = 20)
    @Column(name = "gps_latitude")
    private String gpsLatitude;
    @Size(max = 20)
    @Column(name = "gps_longitude")
    private String gpsLongitude;
    @Size(max = 20)
    @Column(name = "gps_altitude")
    private String gpsAltitude;
    @Size(max = 20)
    @Column(name = "gps_accuracy")
    private String gpsAccuracy;
    @Size(max = 5)
    @Column(name = "l_tabouret")
    private String lTabouret;
    @Size(max = 2147483647)
    @Column(name = "lib_l_tabouret")
    private String libLTabouret;
    @Size(max = 5)
    @Column(name = "l_table")
    private String lTable;
    @Size(max = 2147483647)
    @Column(name = "lib_ll_table")
    private String libLlTable;
    @Size(max = 5)
    @Column(name = "l_fauteuil")
    private String lFauteuil;
    @Size(max = 2147483647)
    @Column(name = "lib_l_fauteuil")
    private String libLFauteuil;
    @Size(max = 5)
    @Column(name = "a_portable")
    private String aPortable;
    @Size(max = 2147483647)
    @Column(name = "lib_a_portable")
    private String libAPortable;
    @Size(max = 5)
    @Column(name = "a_tv")
    private String aTv;
    @Size(max = 2147483647)
    @Column(name = "lib_a_tv")
    private String libATv;
    @Size(max = 5)
    @Column(name = "a_radio")
    private String aRadio;
    @Size(max = 2147483647)
    @Column(name = "lib_a_radio")
    private String libARadio;
    @Size(max = 5)
    @Column(name = "a_ordinateur")
    private String aOrdinateur;
    @Size(max = 2147483647)
    @Column(name = "lib_a_ordinateur")
    private String libAOrdinateur;
    @Size(max = 5)
    @Column(name = "a_cuisiniere")
    private String aCuisiniere;
    @Size(max = 2147483647)
    @Column(name = "lib_a_cuisiniere")
    private String libACuisiniere;
    @Size(max = 5)
    @Column(name = "a_antenne_parabolique")
    private String aAntenneParabolique;
    @Size(max = 2147483647)
    @Column(name = "lib_a_antenne_parabolique")
    private String libAAntenneParabolique;
    @Size(max = 5)
    @Column(name = "a_app_photo_num")
    private String aAppPhotoNum;
    @Size(max = 2147483647)
    @Column(name = "lib_a_app_photo_num")
    private String libAAppPhotoNum;
    @Size(max = 5)
    @Column(name = "a_voiture")
    private String aVoiture;
    @Size(max = 2147483647)
    @Column(name = "lib_a_voiture")
    private String libAVoiture;
    @Size(max = 5)
    @Column(name = "a_velomoteur")
    private String aVelomoteur;
    @Size(max = 2147483647)
    @Column(name = "lib_a_velomoteur")
    private String libAVelomoteur;
    @Size(max = 5)
    @Column(name = "a_brouette")
    private String aBrouette;
    @Size(max = 2147483647)
    @Column(name = "lib_a_brouette")
    private String libABrouette;
    @Size(max = 5)
    @Column(name = "a_bateau_de_peche")
    private String aBateauDePeche;
    @Size(max = 2147483647)
    @Column(name = "lib_a_bateau_de_peche")
    private String libABateauDePeche;
    @Size(max = 5)
    @Column(name = "a_fer_a_repasser")
    private String aFerARepasser;
    @Size(max = 2147483647)
    @Column(name = "lib_a_fer_a_repasser")
    private String libAFerARepasser;
    @Size(max = 5)
    @Column(name = "a_salon_ordinaire")
    private String aSalonOrdinaire;
    @Size(max = 2147483647)
    @Column(name = "lib_a_salon_ordinaire")
    private String libASalonOrdinaire;
    @Size(max = 5)
    @Column(name = "a_chaise_autre")
    private String aChaiseAutre;
    @Size(max = 2147483647)
    @Column(name = "lib_a_chaise_autre")
    private String libAChaiseAutre;
    @Size(max = 5)
    @Column(name = "a_lit")
    private String aLit;
    @Size(max = 2147483647)
    @Column(name = "lib_a_lit")
    private String libALit;
    @Size(max = 5)
    @Column(name = "a_drap_et_couverture")
    private String aDrapEtCouverture;
    @Size(max = 2147483647)
    @Column(name = "lib_a_drap_et_couverture")
    private String libADrapEtCouverture;
    @Size(max = 5)
    @Column(name = "a_natte")
    private String aNatte;
    @Size(max = 2147483647)
    @Column(name = "lib_a_natte")
    private String libANatte;
    @Size(max = 5)
    @Column(name = "a_sceau")
    private String aSceau;
    @Size(max = 2147483647)
    @Column(name = "lib_a_sceau")
    private String libASceau;
    @Size(max = 5)
    @Column(name = "a_pilon_et_mortier")
    private String aPilonEtMortier;
    @Size(max = 2147483647)
    @Column(name = "lib_a_pilon_et_mortier")
    private String libAPilonEtMortier;
    @Size(max = 5)
    @Column(name = "a_moto")
    private String aMoto;
    @Size(max = 2147483647)
    @Column(name = "lib_a_moto")
    private String libAMoto;
    @Size(max = 5)
    @Column(name = "logemement_chambres")
    private String logemementChambres;
    @Size(max = 5)
    @Column(name = "milieu_residence")
    private String milieuResidence;
    @Size(max = 2147483647)
    @Column(name = "lib_milieu_residence")
    private String libMilieuResidence;
    @Size(max = 5)
    @Column(name = "appel_telephonique")
    private String appelTelephonique;
    @Size(max = 2147483647)
    @Column(name = "lib_appel_telephonique")
    private String libAppelTelephonique;
    @Size(max = 5)
    @Column(name = "distance_hopital")
    private String distanceHopital;
    @Size(max = 255)
    @Column(name = "instance_id")
    private String instanceId;
    @Size(max = 25)
    @Column(name = "instancename")
    private String instancename;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Size(max = 2147483647)
    @Column(name = "creer_le")
    private String creerLe;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Size(max = 2147483647)
    @Column(name = "modifier_le")
    private String modifierLe;
    @Column(name = "pmt_score")
    private Double pmtScore;
    @DateTimeFormat(pattern = "dd-mm-yyyy" )
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    public RsuMenagePotentielView() {
    }

    public BigInteger getEffMenage() {
        return effMenage;
    }

    public void setEffMenage(BigInteger effMenage) {
        this.effMenage = effMenage;
    }

    public BigInteger getEffHomme() {
        return effHomme;
    }

    public void setEffHomme(BigInteger effHomme) {
        this.effHomme = effHomme;
    }

    public BigInteger getEffFemme() {
        return effFemme;
    }

    public void setEffFemme(BigInteger effFemme) {
        this.effFemme = effFemme;
    }

    public BigInteger getEffEnceinte() {
        return effEnceinte;
    }

    public void setEffEnceinte(BigInteger effEnceinte) {
        this.effEnceinte = effEnceinte;
    }

    public BigInteger getEffMineur() {
        return effMineur;
    }

    public void setEffMineur(BigInteger effMineur) {
        this.effMineur = effMineur;
    }

    public BigInteger getEffSup() {
        return effSup;
    }

    public void setEffSup(BigInteger effSup) {
        this.effSup = effSup;
    }

    public Double getEffModel1() {
        return effModel1;
    }

    public void setEffModel1(Double effModel1) {
        this.effModel1 = effModel1;
    }

    public Double getEffModel2() {
        return effModel2;
    }

    public void setEffModel2(Double effModel2) {
        this.effModel2 = effModel2;
    }

    public Double getEffModel3() {
        return effModel3;
    }

    public void setEffModel3(Double effModel3) {
        this.effModel3 = effModel3;
    }

    public Double getEffModel4() {
        return effModel4;
    }

    public void setEffModel4(Double effModel4) {
        this.effModel4 = effModel4;
    }

    public Double getEffModel5() {
        return effModel5;
    }

    public void setEffModel5(Double effModel5) {
        this.effModel5 = effModel5;
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

    public String getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(String codMenage) {
        this.codMenage = codMenage;
    }

    public String getIdChefMenage() {
        return idChefMenage;
    }

    public void setIdChefMenage(String idChefMenage) {
        this.idChefMenage = idChefMenage;
    }

    public String getNomChefMenage() {
        return nomChefMenage;
    }

    public void setNomChefMenage(String nomChefMenage) {
        this.nomChefMenage = nomChefMenage;
    }

    public String getTelChefMenage() {
        return telChefMenage;
    }

    public void setTelChefMenage(String telChefMenage) {
        this.telChefMenage = telChefMenage;
    }

    public String getCodLogMur() {
        return codLogMur;
    }

    public void setCodLogMur(String codLogMur) {
        this.codLogMur = codLogMur;
    }

    public String getLibelleLogMur() {
        return libelleLogMur;
    }

    public void setLibelleLogMur(String libelleLogMur) {
        this.libelleLogMur = libelleLogMur;
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

    public String getCodLogOrdure() {
        return codLogOrdure;
    }

    public void setCodLogOrdure(String codLogOrdure) {
        this.codLogOrdure = codLogOrdure;
    }

    public String getLibelleLogOrdure() {
        return libelleLogOrdure;
    }

    public void setLibelleLogOrdure(String libelleLogOrdure) {
        this.libelleLogOrdure = libelleLogOrdure;
    }

    public String getCodLogSol() {
        return codLogSol;
    }

    public void setCodLogSol(String codLogSol) {
        this.codLogSol = codLogSol;
    }

    public String getLibelleLogSol() {
        return libelleLogSol;
    }

    public void setLibelleLogSol(String libelleLogSol) {
        this.libelleLogSol = libelleLogSol;
    }

    public String getCodLogEau() {
        return codLogEau;
    }

    public void setCodLogEau(String codLogEau) {
        this.codLogEau = codLogEau;
    }

    public String getLibelleLogEau() {
        return libelleLogEau;
    }

    public void setLibelleLogEau(String libelleLogEau) {
        this.libelleLogEau = libelleLogEau;
    }

    public String getCodLogDouche() {
        return codLogDouche;
    }

    public void setCodLogDouche(String codLogDouche) {
        this.codLogDouche = codLogDouche;
    }

    public String getLibelleLogDouche() {
        return libelleLogDouche;
    }

    public void setLibelleLogDouche(String libelleLogDouche) {
        this.libelleLogDouche = libelleLogDouche;
    }

    public String getCodLogToilette() {
        return codLogToilette;
    }

    public void setCodLogToilette(String codLogToilette) {
        this.codLogToilette = codLogToilette;
    }

    public String getLibelleLogToilette() {
        return libelleLogToilette;
    }

    public void setLibelleLogToilette(String libelleLogToilette) {
        this.libelleLogToilette = libelleLogToilette;
    }

    public String getCodLogToit() {
        return codLogToit;
    }

    public void setCodLogToit(String codLogToit) {
        this.codLogToit = codLogToit;
    }

    public String getLibelleLogToit() {
        return libelleLogToit;
    }

    public void setLibelleLogToit(String libelleLogToit) {
        this.libelleLogToit = libelleLogToit;
    }

    public String getDateHeurDebut() {
        return dateHeurDebut;
    }

    public void setDateHeurDebut(String dateHeurDebut) {
        this.dateHeurDebut = dateHeurDebut;
    }

    public String getDateHeurFin() {
        return dateHeurFin;
    }

    public void setDateHeurFin(String dateHeurFin) {
        this.dateHeurFin = dateHeurFin;
    }

    public String getNumAppareil() {
        return numAppareil;
    }

    public void setNumAppareil(String numAppareil) {
        this.numAppareil = numAppareil;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdsim() {
        return idsim;
    }

    public void setIdsim(String idsim) {
        this.idsim = idsim;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getVillageQuartier() {
        return villageQuartier;
    }

    public void setVillageQuartier(String villageQuartier) {
        this.villageQuartier = villageQuartier;
    }

    public String getIlot() {
        return ilot;
    }

    public void setIlot(String ilot) {
        this.ilot = ilot;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getLogement() {
        return logement;
    }

    public void setLogement(String logement) {
        this.logement = logement;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(String gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public String getGpsAccuracy() {
        return gpsAccuracy;
    }

    public void setGpsAccuracy(String gpsAccuracy) {
        this.gpsAccuracy = gpsAccuracy;
    }

    public String getLTabouret() {
        return lTabouret;
    }

    public void setLTabouret(String lTabouret) {
        this.lTabouret = lTabouret;
    }

    public String getLibLTabouret() {
        return libLTabouret;
    }

    public void setLibLTabouret(String libLTabouret) {
        this.libLTabouret = libLTabouret;
    }

    public String getLTable() {
        return lTable;
    }

    public void setLTable(String lTable) {
        this.lTable = lTable;
    }

    public String getLibLlTable() {
        return libLlTable;
    }

    public void setLibLlTable(String libLlTable) {
        this.libLlTable = libLlTable;
    }

    public String getLFauteuil() {
        return lFauteuil;
    }

    public void setLFauteuil(String lFauteuil) {
        this.lFauteuil = lFauteuil;
    }

    public String getLibLFauteuil() {
        return libLFauteuil;
    }

    public void setLibLFauteuil(String libLFauteuil) {
        this.libLFauteuil = libLFauteuil;
    }

    public String getAPortable() {
        return aPortable;
    }

    public void setAPortable(String aPortable) {
        this.aPortable = aPortable;
    }

    public String getLibAPortable() {
        return libAPortable;
    }

    public void setLibAPortable(String libAPortable) {
        this.libAPortable = libAPortable;
    }

    public String getATv() {
        return aTv;
    }

    public void setATv(String aTv) {
        this.aTv = aTv;
    }

    public String getLibATv() {
        return libATv;
    }

    public void setLibATv(String libATv) {
        this.libATv = libATv;
    }

    public String getARadio() {
        return aRadio;
    }

    public void setARadio(String aRadio) {
        this.aRadio = aRadio;
    }

    public String getLibARadio() {
        return libARadio;
    }

    public void setLibARadio(String libARadio) {
        this.libARadio = libARadio;
    }

    public String getAOrdinateur() {
        return aOrdinateur;
    }

    public void setAOrdinateur(String aOrdinateur) {
        this.aOrdinateur = aOrdinateur;
    }

    public String getLibAOrdinateur() {
        return libAOrdinateur;
    }

    public void setLibAOrdinateur(String libAOrdinateur) {
        this.libAOrdinateur = libAOrdinateur;
    }

    public String getACuisiniere() {
        return aCuisiniere;
    }

    public void setACuisiniere(String aCuisiniere) {
        this.aCuisiniere = aCuisiniere;
    }

    public String getLibACuisiniere() {
        return libACuisiniere;
    }

    public void setLibACuisiniere(String libACuisiniere) {
        this.libACuisiniere = libACuisiniere;
    }

    public String getAAntenneParabolique() {
        return aAntenneParabolique;
    }

    public void setAAntenneParabolique(String aAntenneParabolique) {
        this.aAntenneParabolique = aAntenneParabolique;
    }

    public String getLibAAntenneParabolique() {
        return libAAntenneParabolique;
    }

    public void setLibAAntenneParabolique(String libAAntenneParabolique) {
        this.libAAntenneParabolique = libAAntenneParabolique;
    }

    public String getAAppPhotoNum() {
        return aAppPhotoNum;
    }

    public void setAAppPhotoNum(String aAppPhotoNum) {
        this.aAppPhotoNum = aAppPhotoNum;
    }

    public String getLibAAppPhotoNum() {
        return libAAppPhotoNum;
    }

    public void setLibAAppPhotoNum(String libAAppPhotoNum) {
        this.libAAppPhotoNum = libAAppPhotoNum;
    }

    public String getAVoiture() {
        return aVoiture;
    }

    public void setAVoiture(String aVoiture) {
        this.aVoiture = aVoiture;
    }

    public String getLibAVoiture() {
        return libAVoiture;
    }

    public void setLibAVoiture(String libAVoiture) {
        this.libAVoiture = libAVoiture;
    }

    public String getAVelomoteur() {
        return aVelomoteur;
    }

    public void setAVelomoteur(String aVelomoteur) {
        this.aVelomoteur = aVelomoteur;
    }

    public String getLibAVelomoteur() {
        return libAVelomoteur;
    }

    public void setLibAVelomoteur(String libAVelomoteur) {
        this.libAVelomoteur = libAVelomoteur;
    }

    public String getABrouette() {
        return aBrouette;
    }

    public void setABrouette(String aBrouette) {
        this.aBrouette = aBrouette;
    }

    public String getLibABrouette() {
        return libABrouette;
    }

    public void setLibABrouette(String libABrouette) {
        this.libABrouette = libABrouette;
    }

    public String getABateauDePeche() {
        return aBateauDePeche;
    }

    public void setABateauDePeche(String aBateauDePeche) {
        this.aBateauDePeche = aBateauDePeche;
    }

    public String getLibABateauDePeche() {
        return libABateauDePeche;
    }

    public void setLibABateauDePeche(String libABateauDePeche) {
        this.libABateauDePeche = libABateauDePeche;
    }

    public String getAFerARepasser() {
        return aFerARepasser;
    }

    public void setAFerARepasser(String aFerARepasser) {
        this.aFerARepasser = aFerARepasser;
    }

    public String getLibAFerARepasser() {
        return libAFerARepasser;
    }

    public void setLibAFerARepasser(String libAFerARepasser) {
        this.libAFerARepasser = libAFerARepasser;
    }

    public String getASalonOrdinaire() {
        return aSalonOrdinaire;
    }

    public void setASalonOrdinaire(String aSalonOrdinaire) {
        this.aSalonOrdinaire = aSalonOrdinaire;
    }

    public String getLibASalonOrdinaire() {
        return libASalonOrdinaire;
    }

    public void setLibASalonOrdinaire(String libASalonOrdinaire) {
        this.libASalonOrdinaire = libASalonOrdinaire;
    }

    public String getAChaiseAutre() {
        return aChaiseAutre;
    }

    public void setAChaiseAutre(String aChaiseAutre) {
        this.aChaiseAutre = aChaiseAutre;
    }

    public String getLibAChaiseAutre() {
        return libAChaiseAutre;
    }

    public void setLibAChaiseAutre(String libAChaiseAutre) {
        this.libAChaiseAutre = libAChaiseAutre;
    }

    public String getALit() {
        return aLit;
    }

    public void setALit(String aLit) {
        this.aLit = aLit;
    }

    public String getLibALit() {
        return libALit;
    }

    public void setLibALit(String libALit) {
        this.libALit = libALit;
    }

    public String getADrapEtCouverture() {
        return aDrapEtCouverture;
    }

    public void setADrapEtCouverture(String aDrapEtCouverture) {
        this.aDrapEtCouverture = aDrapEtCouverture;
    }

    public String getLibADrapEtCouverture() {
        return libADrapEtCouverture;
    }

    public void setLibADrapEtCouverture(String libADrapEtCouverture) {
        this.libADrapEtCouverture = libADrapEtCouverture;
    }

    public String getANatte() {
        return aNatte;
    }

    public void setANatte(String aNatte) {
        this.aNatte = aNatte;
    }

    public String getLibANatte() {
        return libANatte;
    }

    public void setLibANatte(String libANatte) {
        this.libANatte = libANatte;
    }

    public String getASceau() {
        return aSceau;
    }

    public void setASceau(String aSceau) {
        this.aSceau = aSceau;
    }

    public String getLibASceau() {
        return libASceau;
    }

    public void setLibASceau(String libASceau) {
        this.libASceau = libASceau;
    }

    public String getAPilonEtMortier() {
        return aPilonEtMortier;
    }

    public void setAPilonEtMortier(String aPilonEtMortier) {
        this.aPilonEtMortier = aPilonEtMortier;
    }

    public String getLibAPilonEtMortier() {
        return libAPilonEtMortier;
    }

    public void setLibAPilonEtMortier(String libAPilonEtMortier) {
        this.libAPilonEtMortier = libAPilonEtMortier;
    }

    public String getAMoto() {
        return aMoto;
    }

    public void setAMoto(String aMoto) {
        this.aMoto = aMoto;
    }

    public String getLibAMoto() {
        return libAMoto;
    }

    public void setLibAMoto(String libAMoto) {
        this.libAMoto = libAMoto;
    }

    public String getLogemementChambres() {
        return logemementChambres;
    }

    public void setLogemementChambres(String logemementChambres) {
        this.logemementChambres = logemementChambres;
    }

    public String getMilieuResidence() {
        return milieuResidence;
    }

    public void setMilieuResidence(String milieuResidence) {
        this.milieuResidence = milieuResidence;
    }

    public String getLibMilieuResidence() {
        return libMilieuResidence;
    }

    public void setLibMilieuResidence(String libMilieuResidence) {
        this.libMilieuResidence = libMilieuResidence;
    }

    public String getAppelTelephonique() {
        return appelTelephonique;
    }

    public void setAppelTelephonique(String appelTelephonique) {
        this.appelTelephonique = appelTelephonique;
    }

    public String getLibAppelTelephonique() {
        return libAppelTelephonique;
    }

    public void setLibAppelTelephonique(String libAppelTelephonique) {
        this.libAppelTelephonique = libAppelTelephonique;
    }

    public String getDistanceHopital() {
        return distanceHopital;
    }

    public void setDistanceHopital(String distanceHopital) {
        this.distanceHopital = distanceHopital;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstancename() {
        return instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename;
    }

    public String getCreerPar() {
        return creerPar;
    }

    public void setCreerPar(String creerPar) {
        this.creerPar = creerPar;
    }

    public String getCreerLe() {
        return creerLe;
    }

    public void setCreerLe(String creerLe) {
        this.creerLe = creerLe;
    }

    public String getModifierPar() {
        return modifierPar;
    }

    public void setModifierPar(String modifierPar) {
        this.modifierPar = modifierPar;
    }

    public String getModifierLe() {
        return modifierLe;
    }

    public void setModifierLe(String modifierLe) {
        this.modifierLe = modifierLe;
    }

    public Double getPmtScore() {
        return pmtScore;
    }

    public void setPmtScore(Double pmtScore) {
        this.pmtScore = pmtScore;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
}

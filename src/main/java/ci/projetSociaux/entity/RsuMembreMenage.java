/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author soumabkar
 */
@Entity
@Table(name = "rsu_membre_menage")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_membre",
        procedureName = "f_sequence_rsu_membre" ,
        parameters = {
   		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_menage" , type = String.class)}
                 
)
@NamedQueries({
    @NamedQuery(name = "RsuMembreMenage.findAll", query = "SELECT r FROM RsuMembreMenage r")
    , @NamedQuery(name = "RsuMembreMenage.findByIdMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.idMembre = :idMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByNomMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.nomMembre = :nomMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByPrenomMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.prenomMembre = :prenomMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByTelMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.telMembre = :telMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByLieuNaisMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.lieuNaisMembre = :lieuNaisMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByLieuResidMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.lieuResidMembre = :lieuResidMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByDateNaisMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.dateNaisMembre = :dateNaisMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByPhotoMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.photoMembre = :photoMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByGenre", query = "SELECT r FROM RsuMembreMenage r WHERE r.genre = :genre")
    , @NamedQuery(name = "RsuMembreMenage.findByNationalite", query = "SELECT r FROM RsuMembreMenage r WHERE r.nationalite = :nationalite")
    , @NamedQuery(name = "RsuMembreMenage.findBySurnomMembre", query = "SELECT r FROM RsuMembreMenage r WHERE r.surnomMembre = :surnomMembre")
    , @NamedQuery(name = "RsuMembreMenage.findByNomPere", query = "SELECT r FROM RsuMembreMenage r WHERE r.nomPere = :nomPere")
    , @NamedQuery(name = "RsuMembreMenage.findByNomMere", query = "SELECT r FROM RsuMembreMenage r WHERE r.nomMere = :nomMere")
    , @NamedQuery(name = "RsuMembreMenage.findByEtreVacciner", query = "SELECT r FROM RsuMembreMenage r WHERE r.etreVacciner = :etreVacciner")
    , @NamedQuery(name = "RsuMembreMenage.findByAvoirCarnet", query = "SELECT r FROM RsuMembreMenage r WHERE r.avoirCarnet = :avoirCarnet")
    , @NamedQuery(name = "RsuMembreMenage.findByTravIndependant", query = "SELECT r FROM RsuMembreMenage r WHERE r.travIndependant = :travIndependant")
    , @NamedQuery(name = "RsuMembreMenage.findByNumPieceIdent", query = "SELECT r FROM RsuMembreMenage r WHERE r.numPieceIdent = :numPieceIdent")
    , @NamedQuery(name = "RsuMembreMenage.findByCodTypePieceid", query = "SELECT r FROM RsuMembreMenage r WHERE r.codTypePieceid = :codTypePieceid")
    , @NamedQuery(name = "RsuMembreMenage.findByCapaciteSms", query = "SELECT r FROM RsuMembreMenage r WHERE r.capaciteSms = :capaciteSms")
    , @NamedQuery(name = "RsuMembreMenage.findByEcoleActuelle", query = "SELECT r FROM RsuMembreMenage r WHERE r.ecoleActuelle = :ecoleActuelle")
    , @NamedQuery(name = "RsuMembreMenage.findByTomberMalade", query = "SELECT r FROM RsuMembreMenage r WHERE r.tomberMalade = :tomberMalade")
    , @NamedQuery(name = "RsuMembreMenage.findByConsulterPersonnel", query = "SELECT r FROM RsuMembreMenage r WHERE r.consulterPersonnel = :consulterPersonnel")
    , @NamedQuery(name = "RsuMembreMenage.findByAvoirMaladieChronique", query = "SELECT r FROM RsuMembreMenage r WHERE r.avoirMaladieChronique = :avoirMaladieChronique")
    , @NamedQuery(name = "RsuMembreMenage.findByDetailMaladieChronique", query = "SELECT r FROM RsuMembreMenage r WHERE r.detailMaladieChronique = :detailMaladieChronique")
    , @NamedQuery(name = "RsuMembreMenage.findByEtreEnceinte", query = "SELECT r FROM RsuMembreMenage r WHERE r.etreEnceinte = :etreEnceinte")})
public class RsuMembreMenage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_membre")
    private String idMembre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_membre")
    private String nomMembre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prenom_membre")
    private String prenomMembre;
    @Size(max = 25)
    @Column(name = "tel_membre")
    private String telMembre;
    @Size(max = 100)
    @Column(name = "lieu_nais_membre")
    private String lieuNaisMembre;
    @Size(max = 100)
    @Column(name = "lieu_resid_membre")
    private String lieuResidMembre;
    @Column(name = "date_nais_membre")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaisMembre;
    @Size(max = 254)
    @Column(name = "photo_membre")
    private String photoMembre;
    @Size(max = 5)
    @Column(name = "genre")
    private String genre;
    @Size(max = 10)
    @Column(name = "nationalite")
    private String nationalite;
    @Size(max = 150)
    @Column(name = "surnom_membre")
    private String surnomMembre;
    @Size(max = 150)
    @Column(name = "nom_pere")
    private String nomPere;
    @Size(max = 150)
    @Column(name = "nom_mere")
    private String nomMere;
    @Size(max = 5)
    @Column(name = "etre_vacciner")
    private String etreVacciner;
    @Size(max = 5)
    @Column(name = "avoir_carnet")
    private String avoirCarnet;
    @Size(max = 150)
    @Column(name = "trav_independant")
    private String travIndependant;
    @Size(max = 50)
    @Column(name = "num_piece_ident")
    private String numPieceIdent;
    @Size(max = 10)
    @Column(name = "cod_type_pieceid")
    private String codTypePieceid;
    @Size(max = 5)
    @Column(name = "capacite_sms")
    private String capaciteSms;
    @Size(max = 5)
    @Column(name = "ecole_actuelle")
    private String ecoleActuelle;
    @Size(max = 5)
    @Column(name = "tomber_malade")
    private String tomberMalade;
    @Size(max = 5)
    @Column(name = "consulter_personnel")
    private String consulterPersonnel;
    @Size(max = 5)
    @Column(name = "avoir_maladie_chronique")
    private String avoirMaladieChronique;
    @Size(max = 150)
    @Column(name = "detail_maladie_chronique")
    private String detailMaladieChronique;
    @Size(max = 5)
    @Column(name = "etre_enceinte")
    private String etreEnceinte;
    @Size(max = 100)
    @Column(name = "creer_par")
    private String creerPar;
    @Column(name = "creer_le")
    @Temporal(TemporalType.DATE)
    private Date creerLe;
    @Size(max = 100)
    @Column(name = "modifier_par")
    private String modifierPar;
    @Column(name = "modifier_le")
    @Temporal(TemporalType.DATE)
    private Date modifierLe;    
    public String getCreerPar() {
		return creerPar;
	}

	public void setCreerPar(String creerPar) {
		this.creerPar = creerPar;
	}

	public Date getCreerLe() {
		return creerLe;
	}

	public void setCreerLe(Date creerLe) {
		this.creerLe = creerLe;
	}

	public String getModifierPar() {
		return modifierPar;
	}

	public void setModifierPar(String modifierPar) {
		this.modifierPar = modifierPar;
	}

	public Date getModifierLe() {
		return modifierLe;
	}

	public void setModifierLe(Date modifierLe) {
		this.modifierLe = modifierLe;
	}

	@JoinColumn(name = "cod_activite_cm", referencedColumnName = "cod_activite_cm")
    @ManyToOne(optional = false)
    private PmtActiviteCm codActiviteCm;
    @JoinColumn(name = "cod_lien", referencedColumnName = "cod_lien")
    @ManyToOne(optional = false)
    private PmtLienMenage codLien;
    @JoinColumn(name = "cod_paie_soin", referencedColumnName = "cod_paie_soin")
    @ManyToOne
    private PmtModePaiementSoin codPaieSoin;
    @JoinColumn(name = "cod_niveau_etude", referencedColumnName = "cod_niveau_etude")
    @ManyToOne
    private PmtNiveauEtude codNiveauEtude;
    @JoinColumn(name = "cod_statu_mat", referencedColumnName = "cod_statu_mat")
    @ManyToOne(optional = false)
    private PmtStatutMatrimonial codStatuMat;
    @JoinColumn(name = "cod_statut_res", referencedColumnName = "cod_statut_res")
    @ManyToOne(optional = false)
    private PmtStatutResidence codStatutRes;
    @JoinColumn(name = "cod_menage", referencedColumnName = "cod_menage")
    @ManyToOne(optional = false)
    private RsuMenage codMenage;

    public RsuMembreMenage() {
    }

    public RsuMembreMenage(String idMembre) {
        this.idMembre = idMembre;
    }

    public RsuMembreMenage(String idMembre, String nomMembre, String prenomMembre) {
        this.idMembre = idMembre;
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(String idMembre) {
        this.idMembre = idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getTelMembre() {
        return telMembre;
    }

    public void setTelMembre(String telMembre) {
        this.telMembre = telMembre;
    }

    public String getLieuNaisMembre() {
        return lieuNaisMembre;
    }

    public void setLieuNaisMembre(String lieuNaisMembre) {
        this.lieuNaisMembre = lieuNaisMembre;
    }

    public String getLieuResidMembre() {
        return lieuResidMembre;
    }

    public void setLieuResidMembre(String lieuResidMembre) {
        this.lieuResidMembre = lieuResidMembre;
    }

    public Date getDateNaisMembre() {
        return dateNaisMembre;
    }

    public void setDateNaisMembre(Date dateNaisMembre) {
        this.dateNaisMembre = dateNaisMembre;
    }

    public String getPhotoMembre() {
        return photoMembre;
    }

    public void setPhotoMembre(String photoMembre) {
        this.photoMembre = photoMembre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getSurnomMembre() {
        return surnomMembre;
    }

    public void setSurnomMembre(String surnomMembre) {
        this.surnomMembre = surnomMembre;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getEtreVacciner() {
        return etreVacciner;
    }

    public void setEtreVacciner(String etreVacciner) {
        this.etreVacciner = etreVacciner;
    }

    public String getAvoirCarnet() {
        return avoirCarnet;
    }

    public void setAvoirCarnet(String avoirCarnet) {
        this.avoirCarnet = avoirCarnet;
    }

    public String getTravIndependant() {
        return travIndependant;
    }

    public void setTravIndependant(String travIndependant) {
        this.travIndependant = travIndependant;
    }

    public String getNumPieceIdent() {
        return numPieceIdent;
    }

    public void setNumPieceIdent(String numPieceIdent) {
        this.numPieceIdent = numPieceIdent;
    }

    public String getCodTypePieceid() {
        return codTypePieceid;
    }

    public void setCodTypePieceid(String codTypePieceid) {
        this.codTypePieceid = codTypePieceid;
    }

    public String getCapaciteSms() {
        return capaciteSms;
    }

    public void setCapaciteSms(String capaciteSms) {
        this.capaciteSms = capaciteSms;
    }

    public String getEcoleActuelle() {
        return ecoleActuelle;
    }

    public void setEcoleActuelle(String ecoleActuelle) {
        this.ecoleActuelle = ecoleActuelle;
    }

    public String getTomberMalade() {
        return tomberMalade;
    }

    public void setTomberMalade(String tomberMalade) {
        this.tomberMalade = tomberMalade;
    }

    public String getConsulterPersonnel() {
        return consulterPersonnel;
    }

    public void setConsulterPersonnel(String consulterPersonnel) {
        this.consulterPersonnel = consulterPersonnel;
    }

    public String getAvoirMaladieChronique() {
        return avoirMaladieChronique;
    }

    public void setAvoirMaladieChronique(String avoirMaladieChronique) {
        this.avoirMaladieChronique = avoirMaladieChronique;
    }

    public String getDetailMaladieChronique() {
        return detailMaladieChronique;
    }

    public void setDetailMaladieChronique(String detailMaladieChronique) {
        this.detailMaladieChronique = detailMaladieChronique;
    }

    public String getEtreEnceinte() {
        return etreEnceinte;
    }

    public void setEtreEnceinte(String etreEnceinte) {
        this.etreEnceinte = etreEnceinte;
    }

    public PmtActiviteCm getCodActiviteCm() {
        return codActiviteCm;
    }

    public void setCodActiviteCm(PmtActiviteCm codActiviteCm) {
        this.codActiviteCm = codActiviteCm;
    }

    public PmtLienMenage getCodLien() {
        return codLien;
    }

    public void setCodLien(PmtLienMenage codLien) {
        this.codLien = codLien;
    }

    public PmtModePaiementSoin getCodPaieSoin() {
        return codPaieSoin;
    }

    public void setCodPaieSoin(PmtModePaiementSoin codPaieSoin) {
        this.codPaieSoin = codPaieSoin;
    }

    public PmtNiveauEtude getCodNiveauEtude() {
        return codNiveauEtude;
    }

    public void setCodNiveauEtude(PmtNiveauEtude codNiveauEtude) {
        this.codNiveauEtude = codNiveauEtude;
    }

    public PmtStatutMatrimonial getCodStatuMat() {
        return codStatuMat;
    }

    public void setCodStatuMat(PmtStatutMatrimonial codStatuMat) {
        this.codStatuMat = codStatuMat;
    }

    public PmtStatutResidence getCodStatutRes() {
        return codStatutRes;
    }

    public void setCodStatutRes(PmtStatutResidence codStatutRes) {
        this.codStatutRes = codStatutRes;
    }

    public RsuMenage getCodMenage() {
        return codMenage;
    }

    public void setCodMenage(RsuMenage codMenage) {
        this.codMenage = codMenage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembre != null ? idMembre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RsuMembreMenage)) {
            return false;
        }
        RsuMembreMenage other = (RsuMembreMenage) object;
        if ((this.idMembre == null && other.idMembre != null) || (this.idMembre != null && !this.idMembre.equals(other.idMembre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.RsuMembreMenage[ idMembre=" + idMembre + " ]";
    }
    
}

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "prg_recipiendaire_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgRecipiendaireView.findAll", query = "SELECT p FROM PrgRecipiendaireView p")
    , @NamedQuery(name = "PrgRecipiendaireView.findByIdRecipiendaire", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.idRecipiendaire = :idRecipiendaire")
    , @NamedQuery(name = "PrgRecipiendaireView.findByCodRecipiendaire", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.codRecipiendaire = :codRecipiendaire")
    , @NamedQuery(name = "PrgRecipiendaireView.findByNomRecipiendaire", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.nomRecipiendaire = :nomRecipiendaire")
    , @NamedQuery(name = "PrgRecipiendaireView.findByCodAp", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgRecipiendaireView.findByRaisonSocialAp", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgRecipiendaireView.findByNomLocalite", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.nomLocalite = :nomLocalite")
    , @NamedQuery(name = "PrgRecipiendaireView.findByTelRecipiendaire", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgRecipiendaireView.findByPhotoRecip", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.photoRecip = :photoRecip")
    , @NamedQuery(name = "PrgRecipiendaireView.findByEmpruntDig", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.empruntDig = :empruntDig")
    , @NamedQuery(name = "PrgRecipiendaireView.findByCoorgeorecip", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.coorgeorecip = :coorgeorecip")
    , @NamedQuery(name = "PrgRecipiendaireView.findByCodBarRecip", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.codBarRecip = :codBarRecip")
    , @NamedQuery(name = "PrgRecipiendaireView.findByCreerPar", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.creerPar = :creerPar")
    , @NamedQuery(name = "PrgRecipiendaireView.findByCreerLe", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.creerLe = :creerLe")
    , @NamedQuery(name = "PrgRecipiendaireView.findByModifierPar", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.modifierPar = :modifierPar")
    , @NamedQuery(name = "PrgRecipiendaireView.findByModifierLe", query = "SELECT p FROM PrgRecipiendaireView p WHERE p.modifierLe = :modifierLe")})
public class PrgRecipiendaireView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @NotNull
    @Size(max = 50)
    @Column(name = "id_recipiendaire")
    private String idRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "cod_recipiendaire")
    private String codRecipiendaire;
    @Size(max = 2147483647)
    @Column(name = "nom_recipiendaire")
    private String nomRecipiendaire;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Size(max = 100)
    @Column(name = "nom_localite")
    private String nomLocalite;
    @Size(max = 25)
    @Column(name = "tel_recipiendaire")
    private String telRecipiendaire;
    @Size(max = 100)
    @Column(name = "photo_recip")
    private String photoRecip;
    @Size(max = 100)
    @Column(name = "emprunt_dig")
    private String empruntDig;
    @Size(max = 150)
    @Column(name = "coorgeorecip")
    private String coorgeorecip;
    @Size(max = 100)
    @Column(name = "cod_bar_recip")
    private String codBarRecip;
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

    public PrgRecipiendaireView() {
    }

    public String getIdRecipiendaire() {
        return idRecipiendaire;
    }

    public void setIdRecipiendaire(String idRecipiendaire) {
        this.idRecipiendaire = idRecipiendaire;
    }

    public String getCodRecipiendaire() {
        return codRecipiendaire;
    }

    public void setCodRecipiendaire(String codRecipiendaire) {
        this.codRecipiendaire = codRecipiendaire;
    }

    public String getNomRecipiendaire() {
        return nomRecipiendaire;
    }

    public void setNomRecipiendaire(String nomRecipiendaire) {
        this.nomRecipiendaire = nomRecipiendaire;
    }

    public String getCodAp() {
        return codAp;
    }

    public void setCodAp(String codAp) {
        this.codAp = codAp;
    }

    public String getRaisonSocialAp() {
        return raisonSocialAp;
    }

    public void setRaisonSocialAp(String raisonSocialAp) {
        this.raisonSocialAp = raisonSocialAp;
    }

    public String getNomLocalite() {
        return nomLocalite;
    }

    public void setNomLocalite(String nomLocalite) {
        this.nomLocalite = nomLocalite;
    }

    public String getTelRecipiendaire() {
        return telRecipiendaire;
    }

    public void setTelRecipiendaire(String telRecipiendaire) {
        this.telRecipiendaire = telRecipiendaire;
    }

    public String getPhotoRecip() {
        return photoRecip;
    }

    public void setPhotoRecip(String photoRecip) {
        this.photoRecip = photoRecip;
    }

    public String getEmpruntDig() {
        return empruntDig;
    }

    public void setEmpruntDig(String empruntDig) {
        this.empruntDig = empruntDig;
    }

    public String getCoorgeorecip() {
        return coorgeorecip;
    }

    public void setCoorgeorecip(String coorgeorecip) {
        this.coorgeorecip = coorgeorecip;
    }

    public String getCodBarRecip() {
        return codBarRecip;
    }

    public void setCodBarRecip(String codBarRecip) {
        this.codBarRecip = codBarRecip;
    }

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
    
}

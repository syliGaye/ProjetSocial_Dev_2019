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

import groovy.transform.Immutable;

/**
 *
 * @author ZAKARIA
 */
@Entity
@Table(name = "prg_emmission_attente_view")
@Immutable
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgEmmissionAttenteView.findAll", query = "SELECT p FROM PrgEmmissionAttenteView p")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByCodPeriode", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.codPeriode = :codPeriode")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByLibellePeriode", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.libellePeriode = :libellePeriode")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByIdOrdreEmmis", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.idOrdreEmmis = :idOrdreEmmis")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByTelRecipiendaire", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.telRecipiendaire = :telRecipiendaire")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByMontantEmis", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.montantEmis = :montantEmis")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByCodAp", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByRaisonSocialAp", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgEmmissionAttenteView.findByStatutEmmision", query = "SELECT p FROM PrgEmmissionAttenteView p WHERE p.statutEmmision = :statutEmmision")})
public class PrgEmmissionAttenteView implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @Size(max = 10)
    @Column(name = "cod_periode")
    private String codPeriode;
    @Size(max = 100)
    @Column(name = "libelle_periode")
    private String libellePeriode;
    @Id
    @Size(max = 50)
    @Column(name = "id_ordre_emmis")
    private String idOrdreEmmis;
    @Size(max = 25)
    @Column(name = "tel_recipiendaire")
    private String telRecipiendaire;
    @Column(name = "montant_emis")
    private BigInteger montantEmis;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Size(max = 5)
    @Column(name = "statut_emmision")
    private String statutEmmision;

    public PrgEmmissionAttenteView() {
    }

    public String getCodPeriode() {
        return codPeriode;
    }

    public void setCodPeriode(String codPeriode) {
        this.codPeriode = codPeriode;
    }

    public String getLibellePeriode() {
        return libellePeriode;
    }

    public void setLibellePeriode(String libellePeriode) {
        this.libellePeriode = libellePeriode;
    }

    public String getIdOrdreEmmis() {
        return idOrdreEmmis;
    }

    public void setIdOrdreEmmis(String idOrdreEmmis) {
        this.idOrdreEmmis = idOrdreEmmis;
    }

    public String getTelRecipiendaire() {
        return telRecipiendaire;
    }

    public void setTelRecipiendaire(String telRecipiendaire) {
        this.telRecipiendaire = telRecipiendaire;
    }

    public BigInteger getMontantEmis() {
        return montantEmis;
    }

    public void setMontantEmis(BigInteger montantEmis) {
        this.montantEmis = montantEmis;
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

    public String getStatutEmmision() {
        return statutEmmision;
    }

    public void setStatutEmmision(String statutEmmision) {
        this.statutEmmision = statutEmmision;
    }
    
}

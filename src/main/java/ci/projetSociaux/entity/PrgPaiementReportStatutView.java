/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
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
 * @author TOSHIBA
 */
@Entity
@Table(name = "prg_paiement_report_statut_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPaiementReportStatutView.findAll", query = "SELECT p FROM PrgPaiementReportStatutView p")
    , @NamedQuery(name = "PrgPaiementReportStatutView.findByIdPaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatutView p WHERE p.idPaiementReportStatut = :idPaiementReportStatut")
    , @NamedQuery(name = "PrgPaiementReportStatutView.findByCodAp", query = "SELECT p FROM PrgPaiementReportStatutView p WHERE p.codAp = :codAp")
    , @NamedQuery(name = "PrgPaiementReportStatutView.findByRaisonSocialAp", query = "SELECT p FROM PrgPaiementReportStatutView p WHERE p.raisonSocialAp = :raisonSocialAp")
    , @NamedQuery(name = "PrgPaiementReportStatutView.findByCodPaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatutView p WHERE p.codPaiementReportStatut = :codPaiementReportStatut")
    , @NamedQuery(name = "PrgPaiementReportStatutView.findByLibellePaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatutView p WHERE p.libellePaiementReportStatut = :libellePaiementReportStatut")
    , @NamedQuery(name = "PrgPaiementReportStatutView.findByEtatPaiementReportStatut", query = "SELECT p FROM PrgPaiementReportStatutView p WHERE p.etatPaiementReportStatut = :etatPaiementReportStatut")})
public class PrgPaiementReportStatutView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "id_paiement_report_statut")
    @Id
    private String idPaiementReportStatut;
    @Size(max = 10)
    @Column(name = "cod_ap")
    private String codAp;
    @Size(max = 100)
    @Column(name = "raison_social_ap")
    private String raisonSocialAp;
    @Size(max = 10)
    @Column(name = "cod_paiement_report_statut")
    private String codPaiementReportStatut;
    @Size(max = 200)
    @Column(name = "libelle_paiement_report_statut")
    private String libellePaiementReportStatut;
    @Size(max = 5)
    @Column(name = "etat_paiement_report_statut")
    private String etatPaiementReportStatut;

    public PrgPaiementReportStatutView() {
    }

    public String getIdPaiementReportStatut() {
        return idPaiementReportStatut;
    }

    public void setIdPaiementReportStatut(String idPaiementReportStatut) {
        this.idPaiementReportStatut = idPaiementReportStatut;
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

    public String getCodPaiementReportStatut() {
        return codPaiementReportStatut;
    }

    public void setCodPaiementReportStatut(String codPaiementReportStatut) {
        this.codPaiementReportStatut = codPaiementReportStatut;
    }

    public String getLibellePaiementReportStatut() {
        return libellePaiementReportStatut;
    }

    public void setLibellePaiementReportStatut(String libellePaiementReportStatut) {
        this.libellePaiementReportStatut = libellePaiementReportStatut;
    }

    public String getEtatPaiementReportStatut() {
        return etatPaiementReportStatut;
    }

    public void setEtatPaiementReportStatut(String etatPaiementReportStatut) {
        this.etatPaiementReportStatut = etatPaiementReportStatut;
    }
    
}

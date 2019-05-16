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
 * @author toshiba
 */
@Entity
@Table(name = "sig_financement_prg_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigFinancementPrgView.findAll", query = "SELECT s FROM SigFinancementPrgView s")
    , @NamedQuery(name = "SigFinancementPrgView.findByIdPrgFinancement", query = "SELECT s FROM SigFinancementPrgView s WHERE s.idPrgFinancement = :idPrgFinancement")
    , @NamedQuery(name = "SigFinancementPrgView.findByMontantInvesti", query = "SELECT s FROM SigFinancementPrgView s WHERE s.montantInvesti = :montantInvesti")
    , @NamedQuery(name = "SigFinancementPrgView.findByCodBailleur", query = "SELECT s FROM SigFinancementPrgView s WHERE s.codBailleur = :codBailleur")
    , @NamedQuery(name = "SigFinancementPrgView.findByNomBailleur", query = "SELECT s FROM SigFinancementPrgView s WHERE s.nomBailleur = :nomBailleur")
    , @NamedQuery(name = "SigFinancementPrgView.findByCodProgramme", query = "SELECT s FROM SigFinancementPrgView s WHERE s.codProgramme = :codProgramme")
    , @NamedQuery(name = "SigFinancementPrgView.findByLibProgramme", query = "SELECT s FROM SigFinancementPrgView s WHERE s.libProgramme = :libProgramme")})
public class SigFinancementPrgView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "id_prg_financement")
    private String idPrgFinancement;
    @Column(name = "montant_investi")
    private BigInteger montantInvesti;
    @Size(max = 10)
    @Column(name = "cod_bailleur")
    private String codBailleur;
    @Size(max = 2147483647)
    @Column(name = "nom_bailleur")
    private String nomBailleur;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 2147483647)
    @Column(name = "lib_programme")
    private String libProgramme;

    public SigFinancementPrgView() {
    }

    public String getIdPrgFinancement() {
        return idPrgFinancement;
    }

    public void setIdPrgFinancement(String idPrgFinancement) {
        this.idPrgFinancement = idPrgFinancement;
    }

    public BigInteger getMontantInvesti() {
        return montantInvesti;
    }

    public void setMontantInvesti(BigInteger montantInvesti) {
        this.montantInvesti = montantInvesti;
    }

    public String getCodBailleur() {
        return codBailleur;
    }

    public void setCodBailleur(String codBailleur) {
        this.codBailleur = codBailleur;
    }

    public String getNomBailleur() {
        return nomBailleur;
    }

    public void setNomBailleur(String nomBailleur) {
        this.nomBailleur = nomBailleur;
    }

    public String getCodProgramme() {
        return codProgramme;
    }

    public void setCodProgramme(String codProgramme) {
        this.codProgramme = codProgramme;
    }

    public String getLibProgramme() {
        return libProgramme;
    }

    public void setLibProgramme(String libProgramme) {
        this.libProgramme = libProgramme;
    }
    
}

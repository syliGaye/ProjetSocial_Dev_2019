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
@Table(name = "prg_prestation_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrgPrestationView.findAll", query = "SELECT p FROM PrgPrestationView p")
    , @NamedQuery(name = "PrgPrestationView.findByIdPrgPrestation", query = "SELECT p FROM PrgPrestationView p WHERE p.idPrgPrestation = :idPrgPrestation")
    , @NamedQuery(name = "PrgPrestationView.findByPeriodicite", query = "SELECT p FROM PrgPrestationView p WHERE p.periodicite = :periodicite")
    , @NamedQuery(name = "PrgPrestationView.findByPrestationNature", query = "SELECT p FROM PrgPrestationView p WHERE p.prestationNature = :prestationNature")
    , @NamedQuery(name = "PrgPrestationView.findByMontantEspece", query = "SELECT p FROM PrgPrestationView p WHERE p.montantEspece = :montantEspece")
    , @NamedQuery(name = "PrgPrestationView.findByCodTypPrestation", query = "SELECT p FROM PrgPrestationView p WHERE p.codTypPrestation = :codTypPrestation")
    , @NamedQuery(name = "PrgPrestationView.findByLibTypPrest", query = "SELECT p FROM PrgPrestationView p WHERE p.libTypPrest = :libTypPrest")
    , @NamedQuery(name = "PrgPrestationView.findByCodProgramme", query = "SELECT p FROM PrgPrestationView p WHERE p.codProgramme = :codProgramme")
    , @NamedQuery(name = "PrgPrestationView.findByLibProgramme", query = "SELECT p FROM PrgPrestationView p WHERE p.libProgramme = :libProgramme")})
public class PrgPrestationView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "id_prg_prestation")
    private String idPrgPrestation;
    @Size(max = 20)
    @Column(name = "periodicite")
    private String periodicite;
    @Size(max = 200)
    @Column(name = "prestation_nature")
    private String prestationNature;
    @Column(name = "montant_espece")
    private BigInteger montantEspece;
    @Size(max = 10)
    @Column(name = "cod_typ_prestation")
    private String codTypPrestation;
    @Size(max = 2147483647)
    @Column(name = "lib_typ_prest")
    private String libTypPrest;
    @Size(max = 10)
    @Column(name = "cod_programme")
    private String codProgramme;
    @Size(max = 2147483647)
    @Column(name = "lib_programme")
    private String libProgramme;

    public PrgPrestationView() {
    }

    public String getIdPrgPrestation() {
        return idPrgPrestation;
    }

    public void setIdPrgPrestation(String idPrgPrestation) {
        this.idPrgPrestation = idPrgPrestation;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public String getPrestationNature() {
        return prestationNature;
    }

    public void setPrestationNature(String prestationNature) {
        this.prestationNature = prestationNature;
    }

    public BigInteger getMontantEspece() {
        return montantEspece;
    }

    public void setMontantEspece(BigInteger montantEspece) {
        this.montantEspece = montantEspece;
    }

    public String getCodTypPrestation() {
        return codTypPrestation;
    }

    public void setCodTypPrestation(String codTypPrestation) {
        this.codTypPrestation = codTypPrestation;
    }

    public String getLibTypPrest() {
        return libTypPrest;
    }

    public void setLibTypPrest(String libTypPrest) {
        this.libTypPrest = libTypPrest;
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

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

import org.hibernate.annotations.Immutable;

/**
 *
 * @author RADEON
 */
@Entity
@Immutable
@Table(name = "sig_indicateur_cle_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigIndicateurCleView.findAll", query = "SELECT s FROM SigIndicateurCleView s")
    , @NamedQuery(name = "SigIndicateurCleView.findByIdIndicateur", query = "SELECT s FROM SigIndicateurCleView s WHERE s.idIndicateur = :idIndicateur")
    , @NamedQuery(name = "SigIndicateurCleView.findByLibIndicateur", query = "SELECT s FROM SigIndicateurCleView s WHERE s.libIndicateur = :libIndicateur")
    , @NamedQuery(name = "SigIndicateurCleView.findByValIndicaleur", query = "SELECT s FROM SigIndicateurCleView s WHERE s.valIndicaleur = :valIndicaleur")})
public class SigIndicateurCleView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 2147483647)
    @Column(name = "id_indicateur")
    private String idIndicateur;
    @Size(max = 2147483647)
    @Column(name = "lib_indicateur")
    private String libIndicateur;
    @Column(name = "val_indicaleur")
    private BigInteger valIndicaleur;

    public SigIndicateurCleView() {
    }

    public String getIdIndicateur() {
        return idIndicateur;
    }

    public void setIdIndicateur(String idIndicateur) {
        this.idIndicateur = idIndicateur;
    }

    public String getLibIndicateur() {
        return libIndicateur;
    }

    public void setLibIndicateur(String libIndicateur) {
        this.libIndicateur = libIndicateur;
    }

    public BigInteger getValIndicaleur() {
        return valIndicaleur;
    }

    public void setValIndicaleur(BigInteger valIndicaleur) {
        this.valIndicaleur = valIndicaleur;
    }
    
}

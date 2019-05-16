/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.projetSociaux.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ORA PLUS
 */
@Entity
@Table(name = "sig_agent_collecte")
@XmlRootElement
@NamedStoredProcedureQuery(
name = "generer_sigAgentCollecte",
        procedureName = "f_sequence_sig_agent_collecte" ,       
        		        		 parameters = {
   	          		       @StoredProcedureParameter(mode = ParameterMode.IN , name ="p_equipe" , type = String.class)}
        		                           )

@NamedQueries({
    @NamedQuery(name = "SigAgentCollecte.findAll", query = "SELECT s FROM SigAgentCollecte s")
    , @NamedQuery(name = "SigAgentCollecte.findByCodAgCol", query = "SELECT s FROM SigAgentCollecte s WHERE s.codAgCol = :codAgCol")
    , @NamedQuery(name = "SigAgentCollecte.findByNomAgCol", query = "SELECT s FROM SigAgentCollecte s WHERE s.nomAgCol = :nomAgCol")
    , @NamedQuery(name = "SigAgentCollecte.findByPrenomAgentCol", query = "SELECT s FROM SigAgentCollecte s WHERE s.prenomAgentCol = :prenomAgentCol")
    , @NamedQuery(name = "SigAgentCollecte.findByDateDebutAffectation", query = "SELECT s FROM SigAgentCollecte s WHERE s.dateDebutAffectation = :dateDebutAffectation")
    , @NamedQuery(name = "SigAgentCollecte.findByDateFinAffectation", query = "SELECT s FROM SigAgentCollecte s WHERE s.dateFinAffectation = :dateFinAffectation")
    , @NamedQuery(name = "SigAgentCollecte.findByCreerPar", query = "SELECT s FROM SigAgentCollecte s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigAgentCollecte.findByCreerLe", query = "SELECT s FROM SigAgentCollecte s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigAgentCollecte.findByModifierPar", query = "SELECT s FROM SigAgentCollecte s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigAgentCollecte.findByModifierLe", query = "SELECT s FROM SigAgentCollecte s WHERE s.modifierLe = :modifierLe")
    , @NamedQuery(name = "SigAgentCollecte.findByContactTel", query = "SELECT s FROM SigAgentCollecte s WHERE s.contactTel = :contactTel")
    , @NamedQuery(name = "SigAgentCollecte.findByAdresseMail", query = "SELECT s FROM SigAgentCollecte s WHERE s.adresseMail = :adresseMail")
    , @NamedQuery(name = "SigAgentCollecte.findByCodeStructure", query = "SELECT s FROM SigAgentCollecte s WHERE s.codeStructure = :codeStructure")
    })

public class SigAgentCollecte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_ag_col")
    private String codAgCol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_ag_col")
    private String nomAgCol;
    
    @Size(max = 255)
    @Column(name = "pwd_agent")
    private String pwdAgent;
    
	@Size(max = 100)
    @Column(name = "prenom_agent_col")
    private String prenomAgentCol;
    
    @Column(name = "date_debut_affectation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateDebutAffectation;
  
    @Column(name = "date_fin_affectation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateFinAffectation;
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
    
    @Size(min = 1, max = 50)
    @Column(name = "contact_tel")
    private String contactTel;
    
    @Size(min = 1, max = 100)
    @Column(name = "adresse_mail")
    private String adresseMail;
    
    @Size(min = 1, max = 10)
    @Column(name = "code_structure")
    private String codeStructure;
    
    @JoinColumn(name = "cod_equipe", referencedColumnName = "cod_equipe")
    @ManyToOne
    private SigEquipeCollecte codEquipe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAgCol")
    private Collection<SigEquipeMembre> sigEquipeMembreCollection;

    public SigAgentCollecte() {
    }

    public SigAgentCollecte(String codAgCol) {
        this.codAgCol = codAgCol;
    }

    public SigAgentCollecte(String codAgCol, String nomAgCol) {
        this.codAgCol = codAgCol;
        this.nomAgCol = nomAgCol;
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

    public String getPrenomAgentCol() {
        return prenomAgentCol;
    }

    public void setPrenomAgentCol(String prenomAgentCol) {
        this.prenomAgentCol = prenomAgentCol;
    }

    public Date getDateDebutAffectation() {
        return dateDebutAffectation;
    }

    public void setDateDebutAffectation(Date dateDebutAffectation) {
        this.dateDebutAffectation = dateDebutAffectation;
    }

    public Date getDateFinAffectation() {
        return dateFinAffectation;
    }

    public void setDateFinAffectation(Date dateFinAffectation) {
        this.dateFinAffectation = dateFinAffectation;
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

    public SigEquipeCollecte getCodEquipe() {
        return codEquipe;
    }

    public void setCodEquipe(SigEquipeCollecte codEquipe) {
        this.codEquipe = codEquipe;
    }
    
     
     public String getContactTel () {
         return contactTel;
     }

     public void setContactTel(String contactTel) {
         this.contactTel = contactTel;
     }

     public String getAdresseMail() {
         return adresseMail;
     }

     public void setAdresseMail(String adresseMail) {
         this.adresseMail = adresseMail;
     }
     
     public String getCodeStructure() {
         return codeStructure;
     }

     public void setCodeStructure(String codeStructure) {
         this.codeStructure = codeStructure;
     }
	 
	 	public String getPwdAgent() {
		return pwdAgent;
	}

	public void setPwdAgent(String pwdAgent) {
		this.pwdAgent = pwdAgent;
	}


     
    @XmlTransient
    public Collection<SigEquipeMembre> getSigEquipeMembreCollection() {
        return sigEquipeMembreCollection;
    }

    public void setSigEquipeMembreCollection(Collection<SigEquipeMembre> sigEquipeMembreCollection) {
        this.sigEquipeMembreCollection = sigEquipeMembreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAgCol != null ? codAgCol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigAgentCollecte)) {
            return false;
        }
        SigAgentCollecte other = (SigAgentCollecte) object;
        if ((this.codAgCol == null && other.codAgCol != null) || (this.codAgCol != null && !this.codAgCol.equals(other.codAgCol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ci.projetSociaux.entity.SigAgentCollecte[ codAgCol=" + codAgCol + " ]";
    }
    
}

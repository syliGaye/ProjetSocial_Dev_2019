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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *
 */
@Entity
@Table(name = "sig_structure_agent_collecte") 
@XmlRootElement

@NamedStoredProcedureQuery(
name = "generer_sigStructureAgentCollecte",
        procedureName = "f_sequence_sig_structure_agent_collecte" 
)



@NamedQueries({  
    @NamedQuery(name = "SigStructureAgentCollecte.findAll", query = "SELECT s FROM SigStructureAgentCollecte s")
    , @NamedQuery(name = "SigStructureAgentCollecte.findByCodeStructure", query = "SELECT s FROM SigStructureAgentCollecte s WHERE s.codeStructure = :codeStructure")
    , @NamedQuery(name = "SigStructureAgentCollecte.findByNomStructure", query = "SELECT s FROM SigStructureAgentCollecte s WHERE s.nomStructure = :nomStructure")
    , @NamedQuery(name = "SigStructureAgentCollecte.findByCreerPar", query = "SELECT s FROM SigStructureAgentCollecte s WHERE s.creerPar = :creerPar")
    , @NamedQuery(name = "SigStructureAgentCollecte.findByCreerLe", query = "SELECT s FROM SigStructureAgentCollecte s WHERE s.creerLe = :creerLe")
    , @NamedQuery(name = "SigStructureAgentCollecte.findByModifierPar", query = "SELECT s FROM SigStructureAgentCollecte s WHERE s.modifierPar = :modifierPar")
    , @NamedQuery(name = "SigStructureAgentCollecte.findByModifierLe", query = "SELECT s FROM SigStructureAgentCollecte s WHERE s.modifierLe = :modifierLe")})
public class SigStructureAgentCollecte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code_structure")
    private String codeStructure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_structure")
    private String nomStructure;
    @Size(max = 50)
    @Column(name = "contact_structure")
    private String contactStructure;
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


    public SigStructureAgentCollecte() {
    }

    public SigStructureAgentCollecte(String codeStructure) {
        this.codeStructure = codeStructure;
    }

    public SigStructureAgentCollecte(String codeStructure, String nomStructure) {
        this.codeStructure = codeStructure;
        this.nomStructure = nomStructure;
    }

    public String getCodeStructure() {
        return codeStructure;
    }

    public void setCodeStructure(String codeStructure) {
        this.codeStructure = codeStructure;
    }

    public String getNomStructure() {
        return nomStructure;
    }

    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }
    
   
    public String getContactStructure() {
		return contactStructure;
	}

	public void setContactStructure(String contactStructure) {
		this.contactStructure = contactStructure;
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

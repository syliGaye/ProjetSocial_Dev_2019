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
 * @author ORA PLUS
 */
@Entity
@Table(name = "sig_parametre_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SigParametreView.findAll", query = "SELECT s FROM SigParametreView s")
    , @NamedQuery(name = "SigParametreView.findByCodParam", query = "SELECT s FROM SigParametreView s WHERE s.codParam = :codParam")
    , @NamedQuery(name = "SigParametreView.findByValLibelle", query = "SELECT s FROM SigParametreView s WHERE s.valLibelle = :valLibelle")
    , @NamedQuery(name = "SigParametreView.findByValParam", query = "SELECT s FROM SigParametreView s WHERE s.valParam = :valParam")
    , @NamedQuery(name = "SigParametreView.findByTypParam", query = "SELECT s FROM SigParametreView s WHERE s.typParam = :typParam")})
public class SigParametreView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 10)
    @Column(name = "cod_param")
    private String codParam;
    @Size(max = 50)
    @Column(name = "val_libelle")
    private String valLibelle;
    @Size(max = 2147483647)
    @Column(name = "val_param")
    private String valParam;
    @Size(max = 2147483647)
    @Column(name = "typ_param")
    private String typParam;

    public SigParametreView() {
    }

    public String getCodParam() {
        return codParam;
    }

    public void setCodParam(String codParam) {
        this.codParam = codParam;
    }

    public String getValLibelle() {
        return valLibelle;
    }

    public void setValLibelle(String valLibelle) {
        this.valLibelle = valLibelle;
    }

    public String getValParam() {
        return valParam;
    }

    public void setValParam(String valParam) {
        this.valParam = valParam;
    }

    public String getTypParam() {
        return typParam;
    }

    public void setTypParam(String typParam) {
        this.typParam = typParam;
    }
    
}

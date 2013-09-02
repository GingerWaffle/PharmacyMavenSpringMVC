/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.pharmacymavenspringmvc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Svitlana_Kuznietsova
 */
@Entity
@Table(name = "pharmacyschema.pmedicine")
@XmlRootElement
public class Medicine implements Serializable, Comparable<Medicine> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_seq")
    @SequenceGenerator(name = "med_seq", sequenceName = "pharmacyschema.pmedicine_mid_seq", allocationSize = 1)
    @Column(name = "mid")
    private Integer id;
    @Column(name = "mname")
    private String name;
    @Column(name = "mreleaseform")
    private String releaseForm;
    @Column(name = "mquantityperpack")
    private String quantityPerPack;
    @Column(name = "mcomposition")
    private String composition;
    @Column(name = "mindication")
    private String indication;
    @Column(name = "mcontraindication")
    private String contraindication;
    @Column(name = "mages")
    private String ages;
    @Column(name = "mactualquantity")
    private Integer actualQuantity;

    public Medicine() {
    }

    public Medicine(Integer id) {
        this.id = id;
    }

    public Medicine(Integer id, String name, String releaseForm, String quantityPerPack, String ages) {
        this.id = id;
        this.name = name;
        this.releaseForm = releaseForm;
        this.quantityPerPack = quantityPerPack;
        this.ages = ages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseForm() {
        return releaseForm;
    }

    public void setReleaseForm(String releaseForm) {
        this.releaseForm = releaseForm;
    }

    public String getQuantityPerPack() {
        return quantityPerPack;
    }

    public void setQuantityPerPack(String quantityPerPack) {
        this.quantityPerPack = quantityPerPack;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getContraindication() {
        return contraindication;
    }

    public void setContraindication(String contraindication) {
        this.contraindication = contraindication;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public Integer getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Integer actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0)
                + (releaseForm != null ? releaseForm.hashCode() : 0)
                + (ages != null ? ages.hashCode() : 0)
                + (quantityPerPack != null ? quantityPerPack.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine other = (Medicine) object;
        if ((this.name == null && other.name != null)
                || (this.name != null && !this.name.equals(other.name))
                || (this.releaseForm == null && other.releaseForm != null)
                || (this.releaseForm != null && !this.releaseForm.equals(other.releaseForm))
                || (this.quantityPerPack == null && other.quantityPerPack != null)
                || (this.quantityPerPack != null && !this.quantityPerPack.equals(other.quantityPerPack))
                || (this.ages == null && other.ages != null)
                || (this.ages != null && !this.ages.equals(other.ages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + name + " (" + releaseForm + "; " + quantityPerPack + " per pack; " + ages + ")";
    }

    @Override
    public int compareTo(Medicine t) {
        return this.name.compareTo(t.name);
    }
}

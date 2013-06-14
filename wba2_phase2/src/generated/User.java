//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.11 um 03:58:25 PM CEST 
//


package generated;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import generated.Abonemments;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Uname" minOccurs="0"/>
 *         &lt;element ref="{}Ualter" minOccurs="0"/>
 *         &lt;element ref="{}Ugeschlecht" minOccurs="0"/>
 *         &lt;element ref="{}Abonemments" minOccurs="0"/>
 *         &lt;element ref="{}Ukanal" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}Uid use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "uname",
    "ualter",
    "ugeschlecht",
    "abonemments",
    "ukanal"
})
@XmlRootElement(name = "User")
public class User {

    @XmlElement(name = "Uname")
    protected String uname;
    @XmlElement(name = "Ualter")
    protected int ualter;
    @XmlElement(name = "Ugeschlecht")
    protected String ugeschlecht;
    @XmlElement(name = "Abonemments")
    protected List<Abonemments> abonemments;
    @XmlElement(name = "Ukanal")
    protected int ukanal;
    @XmlAttribute(name = "Uid", required = true)
    protected int uid;

    /**
     * Ruft den Wert der uname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUname() {
        return uname;
    }

    /**
     * Legt den Wert der uname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUname(String value) {
        this.uname = value;
    }

    /**
     * Ruft den Wert der ualter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getUalter() {
        return ualter;
    }

    /**
     * Legt den Wert der ualter-Eigenschaft fest.
     * 
     * @param i
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setUalter(int i) {
        this.ualter = i;
    }

    /**
     * Ruft den Wert der ugeschlecht-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUgeschlecht() {
        return ugeschlecht;
    }

    /**
     * Legt den Wert der ugeschlecht-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUgeschlecht(String value) {
        this.ugeschlecht = value;
    }

    /**
     * Gets the value of the abonemments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abonemments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbonemments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Abonemments }
     * 
     * 
     */
    public List<Abonemments> getAbonemments() {
        if (abonemments == null) {
            abonemments = new ArrayList<Abonemments>();
        }
        return this.abonemments;
    }

    /**
     * Ruft den Wert der ukanal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getUkanal() {
        return ukanal;
    }

    /**
     * Legt den Wert der ukanal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setUkanal(int value) {
        this.ukanal = value;
    }

    /**
     * Ruft den Wert der uid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getUid() {
        return uid;
    }

    /**
     * Legt den Wert der uid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setUid(int value) {
        this.uid = value;
    }

}

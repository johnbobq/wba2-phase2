//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.12 um 06:31:57 PM CEST 
//


package tmp;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}Kname"/>
 *         &lt;element ref="{}Kbeschreibung" minOccurs="0"/>
 *         &lt;element ref="{}Kbild" minOccurs="0"/>
 *         &lt;element ref="{}Kkommentare" minOccurs="0"/>
 *         &lt;element ref="{}Kbetreiber"/>
 *         &lt;element ref="{}Beitraege" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}Kid use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kname",
    "kbeschreibung",
    "kbild",
    "kkommentare",
    "kbetreiber",
    "beitraege"
})
@XmlRootElement(name = "Kanal")
public class Kanal {

    @XmlElement(name = "Kname", required = true)
    protected String kname;
    @XmlElement(name = "Kbeschreibung")
    protected String kbeschreibung;
    @XmlElement(name = "Kbild")
    @XmlSchemaType(name = "anyURI")
    protected String kbild;
    @XmlElement(name = "Kkommentare")
    protected Kommentare kkommentare;
    @XmlElement(name = "Kbetreiber", required = true)
    protected BigInteger kbetreiber;
    @XmlElement(name = "Beitraege")
    protected Beitraege beitraege;
    @XmlAttribute(name = "Kid", required = true)
    protected BigInteger kid;

    /**
     * Ruft den Wert der kname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKname() {
        return kname;
    }

    /**
     * Legt den Wert der kname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKname(String value) {
        this.kname = value;
    }

    /**
     * Ruft den Wert der kbeschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKbeschreibung() {
        return kbeschreibung;
    }

    /**
     * Legt den Wert der kbeschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKbeschreibung(String value) {
        this.kbeschreibung = value;
    }

    /**
     * Ruft den Wert der kbild-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKbild() {
        return kbild;
    }

    /**
     * Legt den Wert der kbild-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKbild(String value) {
        this.kbild = value;
    }

    /**
     * Ruft den Wert der kkommentare-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Kommentare }
     *     
     */
    public Kommentare getKkommentare() {
        return kkommentare;
    }

    /**
     * Legt den Wert der kkommentare-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Kommentare }
     *     
     */
    public void setKkommentare(Kommentare value) {
        this.kkommentare = value;
    }

    /**
     * Ruft den Wert der kbetreiber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getKbetreiber() {
        return kbetreiber;
    }

    /**
     * Legt den Wert der kbetreiber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setKbetreiber(BigInteger value) {
        this.kbetreiber = value;
    }

    /**
     * Ruft den Wert der beitraege-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Beitraege }
     *     
     */
    public Beitraege getBeitraege() {
        return beitraege;
    }

    /**
     * Legt den Wert der beitraege-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Beitraege }
     *     
     */
    public void setBeitraege(Beitraege value) {
        this.beitraege = value;
    }

    /**
     * Ruft den Wert der kid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getKid() {
        return kid;
    }

    /**
     * Legt den Wert der kid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setKid(BigInteger value) {
        this.kid = value;
    }

}

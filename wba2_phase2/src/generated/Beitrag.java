//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.06.02 um 09:22:23 PM CEST 
//


package generated;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Btitel"/>
 *         &lt;element ref="{}Bkommentare"/>
 *         &lt;element ref="{}Bbild" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Bcontent"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}Bnr use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "btitel",
    "bkommentare",
    "bbild",
    "bcontent"
})
@XmlRootElement(name = "Beitrag")
public class Beitrag {

    @XmlElement(name = "Btitel", required = true)
    protected String btitel;
    @XmlElement(name = "Bkommentare", required = true)
    protected Kommentare bkommentare;
    @XmlElement(name = "Bbild")
    @XmlSchemaType(name = "anyURI")
    protected List<String> bbild;
    @XmlElement(name = "Bcontent", required = true)
    protected String bcontent;
    @XmlAttribute(name = "Bnr", required = true)
    protected int bnr;

    /**
     * Ruft den Wert der btitel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBtitel() {
        return btitel;
    }

    /**
     * Legt den Wert der btitel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBtitel(String value) {
        this.btitel = value;
    }

    /**
     * Ruft den Wert der bkommentare-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Kommentare }
     *     
     */
    public Kommentare getBkommentare() {
        return bkommentare;
    }

    /**
     * Legt den Wert der bkommentare-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Kommentare }
     *     
     */
    public void setBkommentare(Kommentare value) {
        this.bkommentare = value;
    }

    /**
     * Gets the value of the bbild property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bbild property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBbild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBbild() {
        if (bbild == null) {
            bbild = new ArrayList<String>();
        }
        return this.bbild;
    }

    /**
     * Ruft den Wert der bcontent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBcontent() {
        return bcontent;
    }

    /**
     * Legt den Wert der bcontent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBcontent(String value) {
        this.bcontent = value;
    }

    /**
     * Ruft den Wert der bnr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public int getBnr() {
        return bnr;
    }

    /**
     * Legt den Wert der bnr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBnr(int value) {
        this.bnr = value;
    }

}

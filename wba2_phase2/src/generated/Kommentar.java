//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.11 um 08:51:31 PM CEST 
//


package generated;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute ref="{}Kuser"/>
 *       &lt;attribute ref="{}Knr"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "Kommentar")
public class Kommentar {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Kuser")
    protected int kuser;
    @XmlAttribute(name = "Knr")
    protected int knr;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der kuser-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getKuser() {
        return kuser;
    }

    /**
     * Legt den Wert der kuser-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setKuser(int value) {
        this.kuser = value;
    }

    /**
     * Ruft den Wert der knr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getKnr() {
        return knr;
    }

    /**
     * Legt den Wert der knr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setKnr(int value) {
        this.knr = value;
    }

}

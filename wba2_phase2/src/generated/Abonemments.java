//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.11 um 03:58:25 PM CEST 
//


package generated;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{}Auid"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "auid"
})
@XmlRootElement(name = "Abonemments")
public class Abonemments {

    @XmlElement(name = "Auid", required = true)
    protected int auid;

    /**
     * Ruft den Wert der auid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getAuid() {
        return auid;
    }

    /**
     * Legt den Wert der auid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setAuid(int value) {
        this.auid = value;
    }

}

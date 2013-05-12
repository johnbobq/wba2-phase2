//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.05.12 um 06:31:57 PM CEST 
//


package tmp;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tmp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Auid_QNAME = new QName("", "Auid");
    private final static QName _Kname_QNAME = new QName("", "Kname");
    private final static QName _Bbild_QNAME = new QName("", "Bbild");
    private final static QName _Ualter_QNAME = new QName("", "Ualter");
    private final static QName _Ugeschlecht_QNAME = new QName("", "Ugeschlecht");
    private final static QName _Ukanal_QNAME = new QName("", "Ukanal");
    private final static QName _Bkommentare_QNAME = new QName("", "Bkommentare");
    private final static QName _Uname_QNAME = new QName("", "Uname");
    private final static QName _Kbetreiber_QNAME = new QName("", "Kbetreiber");
    private final static QName _Kkommentare_QNAME = new QName("", "Kkommentare");
    private final static QName _Btitel_QNAME = new QName("", "Btitel");
    private final static QName _Kbeschreibung_QNAME = new QName("", "Kbeschreibung");
    private final static QName _Kbild_QNAME = new QName("", "Kbild");
    private final static QName _Bcontent_QNAME = new QName("", "Bcontent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tmp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Kommentar }
     * 
     */
    public Kommentar createKommentar() {
        return new Kommentar();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Abonemments }
     * 
     */
    public Abonemments createAbonemments() {
        return new Abonemments();
    }

    /**
     * Create an instance of {@link Beitrag }
     * 
     */
    public Beitrag createBeitrag() {
        return new Beitrag();
    }

    /**
     * Create an instance of {@link Kommentare }
     * 
     */
    public Kommentare createKommentare() {
        return new Kommentare();
    }

    /**
     * Create an instance of {@link Beitraege }
     * 
     */
    public Beitraege createBeitraege() {
        return new Beitraege();
    }

    /**
     * Create an instance of {@link Kanal }
     * 
     */
    public Kanal createKanal() {
        return new Kanal();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Auid")
    public JAXBElement<BigInteger> createAuid(BigInteger value) {
        return new JAXBElement<BigInteger>(_Auid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Kname")
    public JAXBElement<String> createKname(String value) {
        return new JAXBElement<String>(_Kname_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Bbild")
    public JAXBElement<String> createBbild(String value) {
        return new JAXBElement<String>(_Bbild_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ualter")
    public JAXBElement<BigInteger> createUalter(BigInteger value) {
        return new JAXBElement<BigInteger>(_Ualter_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ugeschlecht")
    public JAXBElement<String> createUgeschlecht(String value) {
        return new JAXBElement<String>(_Ugeschlecht_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ukanal")
    public JAXBElement<BigInteger> createUkanal(BigInteger value) {
        return new JAXBElement<BigInteger>(_Ukanal_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Kommentare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Bkommentare")
    public JAXBElement<Kommentare> createBkommentare(Kommentare value) {
        return new JAXBElement<Kommentare>(_Bkommentare_QNAME, Kommentare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Uname")
    public JAXBElement<String> createUname(String value) {
        return new JAXBElement<String>(_Uname_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Kbetreiber")
    public JAXBElement<BigInteger> createKbetreiber(BigInteger value) {
        return new JAXBElement<BigInteger>(_Kbetreiber_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Kommentare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Kkommentare")
    public JAXBElement<Kommentare> createKkommentare(Kommentare value) {
        return new JAXBElement<Kommentare>(_Kkommentare_QNAME, Kommentare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Btitel")
    public JAXBElement<String> createBtitel(String value) {
        return new JAXBElement<String>(_Btitel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Kbeschreibung")
    public JAXBElement<String> createKbeschreibung(String value) {
        return new JAXBElement<String>(_Kbeschreibung_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Kbild")
    public JAXBElement<String> createKbild(String value) {
        return new JAXBElement<String>(_Kbild_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Bcontent")
    public JAXBElement<String> createBcontent(String value) {
        return new JAXBElement<String>(_Bcontent_QNAME, String.class, null, value);
    }

}

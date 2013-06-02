package generated;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Einleser {

	private static final String User_xml = "src/Testuser.xml";
	private static final String Kanal_xml = "src/Testkanal.xml";

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		int w = 0;

		
		// Gleiche wie testdaten() s.U.
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst user = (Dienst) um.unmarshal(new FileReader(User_xml));
		Dienst kanal = (Dienst) um.unmarshal(new FileReader(Kanal_xml));

		while (w == 0) {
			System.out.println("1. Testdaten einfuügen");
			System.out.println("2. Daten anzeigen");
			w = sc.nextInt();

			switch (w) {
			case 1:
				testdaten();
				w = 0;
				break;
			case 2:
				// Liste aller Benutzer
				List<User> ulist = user.getUser();

				// Liste aller Kanäle
				List<Kanal> klist = kanal.getKanal();

				// Gib die Benutzer aus User_xml
				System.out.println("--------------------------------------BENUTZER--------------------------------------");
				for (User u : ulist) {
					System.out.println("\t Name: " + u.getUname() + "\t Alter: " + u.getUalter() + "\t" + "Geschlecht: "
					+ u.getUgeschlecht() + "\t betreibt den Kanal mit der ID: " + u.getUkanal());
				}
				// Kanal_xml Ausgabe
				System.out.println("--------------------------------------KANÄLE--------------------------------------");
				for (Kanal k : klist) {
					System.out.println("Kanal:" + "\t`" +k.getKname()+"`" +" hat die Kanal-ID: " + k.getKid()
					+ " Und wird geleitet von User ID: " + k.getKbetreiber());
					System.out.println("\t Beschreibung: " + k.getKbeschreibung());
					System.out.println("\t\t----------------------------");
					System.out.println("\t Kanalkommentare: ");
					// Kanalkommentar holen
					List<Kommentar> kkliste =k.getKkommentare().getKommentar();
					for(Kommentar kk : kkliste) {
						System.out.println("\t\t KommentarNr:" + kk.getKnr() + "\t Benutzer: " +kk.getKuser());
						System.out.println("\t\tSchrieb: " +kk.getValue());
					}
					System.out.println("");
					System.out.println("\t\tBeiträge: ");
					// Beiträge mit Content und seinen kOmmentaren holen holen
					List<Beitrag> bliste = k.getBeitraege().getBeitrag();
					for (Beitrag b : bliste) {
						System.out.println("\t Titel: " + b.getBtitel()  + "BeitragNr: " + b.getBnr() );
						System.out.println("\t \t " + b.getBcontent());
						System.out.println("\t \t \t ---------- KOMMENTARE ---------");
						// Beitragskommentare holen
						List<Kommentar> bkliste = b.getBkommentare().getKommentar();
						for(Kommentar bk : bkliste) {
							System.out.println("\t \t \t Beitragsnummer: " +bk.getKnr() + "Von Benutzer mit der ID:" + bk.getKuser()
							+ "Hat geschrieben: " + bk.getValue()); 
						}
						
					}
					
				}
				w = 0;
				break;
			default:
				System.out.println("Ungueltig");
				w = 0;
			}
		}

	}

	
	/** Falls Testkanal.xml oder Testuser.xml leer sein solle, hier Daten einfügen */
	
	public static void testdaten() throws JAXBException, FileNotFoundException {

		System.out.println("HALLO");

		// Marshaller
		JAXBContext context = JAXBContext.newInstance("generated");
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Unmarshaller: Holt Benutzer aus User_xml
		Unmarshaller um = context.createUnmarshaller();
		Dienst user = (Dienst) um.unmarshal(new FileReader(User_xml));
		// Gleiche für Kanal_xml
		Dienst kanal = (Dienst) um.unmarshal(new FileReader(Kanal_xml));

		// Test Benutzer anlegen
		User user1 = new User();
		user1.setUalter(23);
		user1.setUgeschlecht("m");
		user1.setUid(1);
		user1.setUname("Nigel");
		user1.setUkanal(1);

		User user2 = new User();
		user2.setUalter(5);
		user2.setUgeschlecht("w");
		user2.setUid(2);
		user2.setUname("Test");

		// Test Kanal anlegen
		// KanalID=1, Name="MeinUrlaub", Betreiber UID = 1 (Nigel)
		Kanal kanal1 = new Kanal();
		kanal1.setKid(1);
		kanal1.setKname("Meinurlaub");
		kanal1.setKbeschreibung("Ein Kanal der von Nigel geführt wird");
		kanal1.setKbetreiber(1);
		
		// Kommentar anlegen um ihn den KanalKommentaren hinzuzufügen
		// KommentarNr=1, Erstelle UID=1 (Nigel)
		Kommentar komm1 = new Kommentar();
		komm1.setKnr(1);
		komm1.setKuser(1);
		komm1.setValue("Der erste Kommentar zum Kanal");
		// Kommentare Menge wo Kommentare angehängt werden.
//		Kommentare kanalkommentare = new Kommentare();
//		kanalkommentare.getKommentar().add(komm1);
//		kanal1.getKkommentare().add(kanalkommentare);
		kanal1.getKkommentare().getKommentar().add(komm1);
		
		Beitraege bt1 = new Beitraege();
		Beitrag beitrag1 = new Beitrag();
		beitrag1.setBnr(1);
		beitrag1.setBcontent("Das ist der erste Beitrag, das ist eintoller Urlaub");
//		beitrag1.getBtitel().add("ERSTER");
		
		// Beitragskommentar
		// Erster Kommentar zum ersten Beitrag von UID = 1 (Nigel)
		Kommentar kommentar2 = new Kommentar();
		kommentar2.setKnr(1);
		kommentar2.setKuser(1);
		kommentar2.setValue("SCHÖNER BERICHT");
		// Beitragskommentare erstellen um Kommentare anzuhängen
		Kommentare beitragskommentare = new Kommentare();
		beitragskommentare.getKommentar().add(kommentar2);
		beitrag1.setBkommentare(beitragskommentare);
		
		// Beitrag zu "Beiträge" hinzufügen
//		bt1.getBeitrag().add(beitrag1);
		
		// Beiträge zu Kanal hinzufügen
//		kanal1.getBeitraege().add(bt1);
		kanal1.getBeitraege().getBeitrag().add(beitrag1);
		
		// Nigel wird nun in in die Userliste von Dienst geshrieben.
		user.getUser().add(user1);
		user.getUser().add(user2);

		kanal.getKanal().add(kanal1);

		// Die User List in Testuser.xml schreiben
		m.marshal(user, new File(User_xml));
		// Kanaäle in Testkanal.xml schreiben
		m.marshal(kanal, new File(Kanal_xml));

		System.out.println("Fehlerfrei");
	}
	
	
	

}

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
				for (User u : ulist) {
					System.out.println("Alter: " + u.getUalter() + "\t" + "Name:" + u.getUname());
				}
				// Kanal_xml
				for (Kanal k : klist) {
					System.out.println("Kanäle: ");
					System.out.println(k.getKname());
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
		User u1 = new User();
		u1.setUalter(23);
		u1.setUgeschlecht("m");
		u1.setUid(1);
		u1.setUname("Nigel");
		u1.setUkanal(1);

		User u2 = new User();
		u2.setUalter(5);
		u2.setUgeschlecht("w");
		u2.setUid(2);
		u2.setUname("Test");

		// Test Kanal anlegen
		Kanal k1 = new Kanal();
		k1.setKid(1);
		k1.setKname("Meinurlaub");
		k1.setKbeschreibung("Ein Kanal der von Nigel geführt wird");
		k1.setKbetreiber(1);
		// Kommentar anlegen um ihn den KanalKommentaren hinzuzufügen
		Kommentar kom1 = new Kommentar();
		kom1.setKnr(1);
		kom1.setKuser(1);
		kom1.setValue("Der erste Kommentar zum Kanal");
		//
		k1.getKkommentare().getKommentar().add(kom1);
		// Beitrag zum Kanal hinzufügen
		Beitraege bt1 = new Beitraege();
		Beitrag b1 = new Beitrag();
		b1.setBnr(1);
		/** DÄMLICHER SCHEISS */
		
		// Nigel wird nun in in die Userliste von Dienst geshrieben.
		user.getUser().add(u1);
		user.getUser().add(u2);

		kanal.getKanal().add(k1);

		// Die User List in Testuser.xml schreiben
		m.marshal(user, new File(User_xml));
		// Kanaäle in Testkanal.xml schreiben
		m.marshal(kanal, new File(Kanal_xml));

		System.out.println("Fehlerfrei");
	}
	
	
	

}

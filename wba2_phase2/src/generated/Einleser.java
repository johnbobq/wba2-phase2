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
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
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
		
		User u2 = new User();
		u2.setUalter(5);
		u2.setUgeschlecht("w");
		u2.setUid(2);
		u2.setUname("Test");
		// Liste aller Benutzer
		List<User> ulist = user.getUser();
		
		// Test Kanal anlegen
		Kanal k1 = new Kanal();
		k1.setKid(0);
		k1.setKname("Meinurlaub");
		k1.setKbetreiber(1);
		// Liste aller Kanäle
		List<Kanal> klist = kanal.getKanal();
		
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

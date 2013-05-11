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
	    Dienst dienst = (Dienst) um.unmarshal(new FileReader(User_xml));
//	    List<User> list = dienst.getUser();

		
		// Test Benutzer anlegen
		User u = new User();
		u.setUalter(23);
		u.setUgeschlecht("m");
		u.setUid(1);
		u.setUname("Nigel");
		
		// Nigel wird nun in in die Userliste von Dienst geshrieben.
		dienst.getUser().add(u);
		
		// Die User List in Testuser.xml schreiben
		m.marshal(dienst.user, new File(User_xml));
		
		System.out.println("Fehlerfrei");
		
	}

}

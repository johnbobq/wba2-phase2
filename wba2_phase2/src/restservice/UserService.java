package restservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import generated.*;

import javax.ws.rs.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@Path("/user")
public class UserService {

	/**
	 * Wegen der Hierachie Dienst->User ist der Rückgabewert vom Typ Dienst, da
	 * dieser die User enthält
	 */
	@GET
	@Produces("application/xml")
	public Dienst getUsers() throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst users = (Dienst) um.unmarshal(new FileReader("src/Testuser.xml"));
		System.out.println("Alle User");
		return users;
	}

	@GET
	@Path("/{Uid}")
	@Produces("application/xml")
	public Dienst getUser(@PathParam("Uid") int i) throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst users = (Dienst) um.unmarshal(new FileReader("src/Testuser.xml"));

		ObjectFactory of = new ObjectFactory();
		Dienst user = of.createDienst();
		user.getUser().add(users.getUser().get(i));
		System.out.println("Bestimmter User");
		return user;

	}

	@DELETE
	@Path("/{Uid}")
	@Produces("application/xml")
	public Dienst deleteUser(@PathParam("Uid") int i) throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst users = (Dienst) um.unmarshal(new FileReader("src/Testuser.xml"));

		// users in user kopieren
		ObjectFactory of = new ObjectFactory();
		Dienst user = of.createDienst();

		// i-ten Benutzer aus user löschen
		user.getUser().addAll(users.getUser());
		user.getUser().remove(i);

		// user "aktualisieren" und zurückgeben
		// Marshaller
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(user, new File("src/Testuser.xml"));
		System.out.println("User gelöscht");
		return user;
	}

	/** Neuen Benutzer anlegen mit Name und Alter, ID wird berechnet durch länge der Nutzerliste + 1 */
	@POST
	@Path("/{Uid}")
	@Produces("application/xml")
	public Dienst postUser(@FormParam("Uname") String Name, @FormParam("Ualter") int Alter) throws JAXBException, FileNotFoundException {

		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst users = (Dienst) um.unmarshal(new FileReader("src/Testuser.xml"));
		

		User newUser = new User();
		newUser.setUname(Name);
		newUser.setUalter(Alter);
		newUser.setUid(users.getUser().size()+1);
		
		users.getUser().add(newUser);

		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(users, new File("src/Testuser.xml"));
		System.out.println("User hinzugefügt");
		return users;

	}

}
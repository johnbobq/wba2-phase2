package restservice;

import generated.Dienst;
import generated.ObjectFactory;
import generated.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ws.rs.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import generated.*;

@Path( "/channels" )
public class ChannelService
{
   
	@GET
	@Produces("application/xml")
	public Dienst getChannels() throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst channels = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		System.out.println("ALLE KAN�LE");
		return channels;
	}
	
	@GET
	@Path("/{Kid}")
	@Produces("application/xml")
	public Dienst getChannel(@PathParam("Kid") int i) throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst channels = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));

		ObjectFactory of = new ObjectFactory();
		Dienst channel = of.createDienst();
		channel.getKanal().add(channels.getKanal().get(i));
		System.out.println("KANAL DURCH ID");
		return channel;

	}
	
	@DELETE
	@Path("/{Kid}")
	@Produces("application/xml")
	public Dienst deleteChannel(@PathParam("Kid") int i) throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst channels = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));

		// users in user kopieren
		ObjectFactory of = new ObjectFactory();
		Dienst channel = of.createDienst();

		// i-ten Benutzer aus user l�schen
		channel.getKanal().addAll(channels.getKanal());
		channel.getKanal().remove(i);

		// user "aktualisieren" und zur�ckgeben
		// Marshaller
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(channel, new File("src/Testkanal.xml"));
		
		System.out.println("KANAL MIT ID GEL�SCHT");
		
		return channel;
	}
	
	@POST
	@Path("/{Kid}")
	@Produces("application/xml")
	public Dienst postChannel(@FormParam("Kname") String name, @FormParam("Beschreibung") String beschreibung, @FormParam("Betreiber") int betreiber) throws JAXBException, FileNotFoundException {

		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst channels = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		

		Kanal newKanal = new Kanal();
		newKanal.setKname(name);
		newKanal.setKbeschreibung(beschreibung);
		newKanal.setKid(channels.getKanal().size()+1);
		newKanal.setKbetreiber(betreiber);
		
		channels.getKanal().add(newKanal);

		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(channels, new File("src/Testkanal.xml"));
		
		System.out.println("KANAL MIT ID HINZUGEF�GT");
		
		return channels;

	}
	
}
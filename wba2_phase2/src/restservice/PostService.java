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


@Path( "/channels/{Kid}/posts" )
public class PostService {
	
	@GET
	@Produces("application/xml")
	public Beitraege getPosts(@PathParam("Kid") int i) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst posts = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));

		ObjectFactory of = new ObjectFactory();
		Beitraege postsNew = of.createBeitraege();
		
		postsNew = posts.getKanal().get(i).getBeitraege();
		System.out.println("Alle Posts von Kanal");
		return postsNew;
		
	}
	
	@GET
	@Path("/{Pid}")
	@Produces("application/xml")
	public Beitrag getPost(@PathParam("Kid") int i, @PathParam("Pid") int j) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst posts = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		
		ObjectFactory of = new ObjectFactory();
		Beitrag post = of.createBeitrag();
		// Holt den j-ten Beitrag
		post = posts.getKanal().get(i).getBeitraege().getBeitrag().get(j);
		System.out.println("Hole bestimmten Post von Kanal");
		return post;
		
	}
	
	@DELETE
	@Path("/{Pid}")
	@Produces("application/xml")
	public void deletePost(@PathParam("Kid") int i, @PathParam("Pid") int j) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst posts = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		
		posts.getKanal().get(i).getBeitraege().getBeitrag().remove(j);
		
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(posts, new File("src/Testkanal.xml"));
		System.out.println("Ein Post wurde gelöscht");
	}
	
	@POST
	@Path("/{Pid}")
	@Produces("application/xml")
	public void postPost(@PathParam("Kid") int i, @FormParam("Titel") String titel, @FormParam("Inhalt") String inhalt) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst posts = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		
		Beitrag post = new Beitrag();
		post.setBcontent(inhalt);
		post.setBtitel(titel);
		post.setBnr(posts.getKanal().get(i).getBeitraege().getBeitrag().size()+1);
		post.setBkommentare(new Kommentare());
		
		posts.getKanal().get(i).getBeitraege().getBeitrag().add(post);
		
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(posts, new File("src/Testkanal.xml"));
		System.out.println("Posts hinzugefügt");
	}

}

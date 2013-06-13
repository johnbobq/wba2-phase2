package restservice;

import generated.Beitraege;
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

@Path( "/channels/{Kid}/posts/{Pid}/comments" )
public class CommentService {

	@GET
	@Produces("application/xml")
	public Kommentare getComments(@PathParam("Kid") int i, @PathParam("Pid") int j) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst comments = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		
		ObjectFactory of = new ObjectFactory();
		Kommentare commentsNew = of.createKommentare();
		
		commentsNew = comments.getKanal().get(i).getBeitraege().getBeitrag().get(j).getBkommentare();
		
		return commentsNew;
	}
	
	@GET
	@Path("/{Cid}")
	@Produces("application/xml")
	public Kommentar getComment(@PathParam("Kid") int i, @PathParam("Pid") int j, @PathParam("Cid") int k) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst comments = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		
		ObjectFactory of = new ObjectFactory();
		Kommentar comment = of.createKommentar();
		
		comment = comments.getKanal().get(i).getBeitraege().getBeitrag().get(j).getBkommentare().getKommentar().get(k);
		return comment;
		
	}
	
	@DELETE
	@Path("/{Cid}")
	@Produces("application/xml")
	public void deleteComment(@PathParam("Kid") int i, @PathParam("Pid") int j, @PathParam("Cid") int k) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst comments = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		
		comments.getKanal().get(i).getBeitraege().getBeitrag().get(j).getBkommentare().getKommentar().remove(k);
		
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(comments, new File("src/Testkanal.xml"));
		
	}
	@POST
	@Path("/{Cid}")
	@Produces("application/xml")
	public void deleteComment(@PathParam("Kid") int i, @PathParam("Pid") int j, @FormParam("Verfasser") int user, @FormParam("Komm") String inhalt) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance("generated");
		Unmarshaller um = context.createUnmarshaller();
		Dienst comments = (Dienst) um.unmarshal(new FileReader("src/Testkanal.xml"));
		
		Kommentar comment = new Kommentar();
		comment.setKnr(comments.getKanal().get(i).getBeitraege().getBeitrag().get(j).getBkommentare().getKommentar().size()+1);
		comment.setKuser(user);
		comment.setValue(inhalt);
		
		comments.getKanal().get(i).getBeitraege().getBeitrag().get(j).getBkommentare().getKommentar().add(comment);
		
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(comments, new File("src/Testkanal.xml"));
	}
	
}

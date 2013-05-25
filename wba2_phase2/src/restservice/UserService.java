package restservice;

import javax.ws.rs.*;

@Path( "/user" )
public class UserService
{
   @GET @Produces( "text/plain" )
   public String halloText( @QueryParam("name") String name )
   {
      return "Hier Liste der Benutzer ";
   }

   @GET @Produces( "text/html" )
   public String halloHtml( @QueryParam("name") String name )
   {
      return "<html><title>HelloWorld</title><body><h2>Html: Hier Liste der Benutzer</h2></body></html>";
   }
}
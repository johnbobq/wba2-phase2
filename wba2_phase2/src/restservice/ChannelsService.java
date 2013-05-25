package restservice;

import javax.ws.rs.*;

@Path( "/channels" )
public class ChannelsService
{
   @GET @Produces( "text/plain" )
   public String halloText( @QueryParam("name") String name )
   {
      return "Hier Liste der Kanäle ";
   }

   @GET @Produces( "text/html" )
   public String halloHtml( @QueryParam("name") String name )
   {
      return "<html><title>HelloWorld</title><body><h2>Html: Hier Liste der Kanäle</h2></body></html>";
   }
}
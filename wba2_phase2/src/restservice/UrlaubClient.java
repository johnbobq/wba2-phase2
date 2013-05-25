package restservice;

import com.sun.jersey.api.client.*;

public class UrlaubClient
{
   public static void main( String[] args )
   {
      String url = ( args.length > 0 ) ? args[0] : "http://localhost:4434";
//      String nam = ( args.length > 1 ) ? args[1] : "ich";
      
      String urlUsers;
//      String urlUser;
      String urlChannels;
//      String urlChannel;
//      String urlComment;
//      String urlComments;
//      String urlPost;
//      String urlPosts;
      
      // Nutzer
      urlUsers = url + "/user/";
      System.out.println( "URL der Nutzer: " + urlUsers );
      
      // Kanal
      urlChannels = url + "/channels/";
      System.out.println( "URL der Kanäle: " + urlChannels );

      WebResource Users = Client.create().resource( urlUsers );
      WebResource Channels = Client.create().resource( urlChannels );
      
      System.out.println( "\nTextausgabe:" );
      System.out.println( Users.accept( "text/plain" ).get( String.class ) );
      System.out.println( Channels.accept( "text/plain" ).get( String.class ) );
      System.out.println( "\nHTML-Ausgabe:" );
      System.out.println( Users.accept( "text/html"  ).get( String.class ) );
      System.out.println( Channels.accept( "text/html"  ).get( String.class ) );
   }
}
package restservice;


import xmpp.*;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

public class UrlaubServer
{
   public static void main( String[] args ) throws Exception
   {
      String url = ( args.length > 0 ) ? args[0] : "http://localhost:4434";
      String sec = ( args.length > 1 ) ? args[1] : "10";

      SelectorThread srv = GrizzlyServerFactory.create( url );

      System.out.println( "URL: " + url+"\n" );
      System.out.println("Channels");
      System.out.println( "URL: " + url + "/channels" );
      System.out.println( "URL: " + url + "/channels/{Kid}\n" );
      System.out.println("Posts");
      System.out.println( "URL: " + url + "/channels/{Kid}/posts" );
      System.out.println( "URL: " + url + "/channels/{Kid}/posts/{Pid}\n" );
      System.out.println("Comments");
      System.out.println( "URL: " + url + "/channels/{Kid}/posts/{Pid}/comments" );
      System.out.println( "URL: " + url + "/channels/{Kid}/posts/{Pid}/comments/{Cid}\n" );
      
      Testklasse test1 = new Testklasse();
      test1.benutzerErstellen();
      test1.benutzerConnect();
      test1.nodesErstellen();
      test1.subscribe();
      test1.publish();
      test1.publishPayload();
//      test1.benutzRegist();

      Thread.sleep(10000);
      test1.benutzerAusloggen();
      test1.b2ausloggen();
      
      
      Thread.sleep( 60000 * Integer.parseInt( sec ) );
      srv.stopEndpoint();
   }
}
/*
 *  A datagram client to send and receive UDP packets in Java.
 *
 *  Instructions to run:
 *  Pass the host address and the port as command line arguments.
 *  Eg: >>javac UDPClient.java
 *      >>java UDPClient hostaddress portNo
 */

 //import network and input output packages
 import java.net.* ;


public class UDPClient
{
   //Give a standard packet size. 
   private final static int packetsize = 100 ;
   private static DatagramSocket socket;
   
   public static void main( String args[] )
   {
       // Check the whether the arguments are given
      if( args.length != 2 )
      {
         System.out.println( "usage: java DatagramClient host port" ) ;
         return ;
      }

      //Q1: Create a datagram socket object here
      DatagramSocket socket=null;

	 
	  
      try
      {
          // Convert the arguments to ensure that they are valid
         InetAddress host = InetAddress.getByName( args[0] ) ;
         int port         = Integer.parseInt( args[1] ) ;

         //Q1: Construct the socket
         socket = new DatagramSocket() ;
         //Client does not need to provide the port number. Server will recieve the port number by the packet sent from the client
    

         byte [] data = "The message wants to pass".getBytes() ;
		 
         //Q2: Construct the datagram packet
         DatagramPacket packet=new DatagramPacket(data,data.length,host,port);

         //Here the datagram sent from the client should contain data host address and port of the client because socket does not contain the port number nad the server should identify the client
		 
         // Send the packet
         socket.send( packet ) ;
        

         // Prepare the packet for receive
         packet.setData( new byte[packetsize] ) ;

         // Wait for a response from the server
         socket.receive( packet ) ;

         // Print the response
         System.out.println( new String(packet.getData()) ) ;

      }
      catch( Exception e )
      {
         System.out.println( e ) ;
      }
      //Exersice 5
      //socket should be closed after a successfull connection and also if there was a exception
      //therefore close should be added inthe finnaly block so it will run after any of the possibility
      finally {
         socket.close() ;

      }
     
   }
}
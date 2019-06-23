/*
 *  A datagram client to send and receive UDP packets in Java.
 *
 *  Instructions to run:
 *  Pass the port as command line arguments.
 *  Eg: >>javac UDPClient portNo
 */
 
 import java.net.* ;
public class UDPServer
{
   //Give a standard packet size
   private final static int packetsize = 100 ;

   public static void main( String args[] )
   {
      // Check the whether the arguments are given
      if( args.length != 1 )
      {
         System.out.println( "usage: DatagramServer port" ) ;
         return ;
      }

      //Exersice 3

      //Considering server code in this try catch block
       //server should be only down when there is no port no socket(Non -recoverable errors)
       //server should not be down when there is inturruption in a packet
       //packets are from clients,so server should not be down when there is packet lost(recoverable error)

       //so for loop should be implemented in a way to recover the error without server down

       //Exersice 4
       //when code is like this server gets down when there is exception in recieving packet
       //this structure is not suitable so we should implement the code in a way that the server will not get down n case of exception a packet

      try
      {
         // Convert the argument to ensure that is it valid
         int port = Integer.parseInt( args[0] ) ;

         // Construct the socket
         DatagramSocket socket = new DatagramSocket( port ) ;

         System.out.println( "The server is ready..." ) ;
		
		 // Create a packet
         DatagramPacket packet = new DatagramPacket( new byte[packetsize], packetsize ) ;


         /*Exercise 4: The server receives one packet and sends one packet at each
          iteration of the „for‟ loop. If the program throws an exception at receiving a packet,
          what will happen to the „for‟ loop?
           For loop will stop */
         /*
         * If this error might be temporary and could affect only one or few packets received,
          * do you think that this is the suitable behavior for the server?
          * No this throwing exception would cause server to stop*/

         /*If not, modify the server code such that the server deals with such problems.
             //Solution is to use seperate try catch blocks for server part and clinet associated part
        */

         try {
             for (; ; ) {

                 // Receive a packet (blocking)
                 socket.receive(packet);

                 // Print the packet
                 System.out.println(packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()));

                 // Return the packet to the sender
                 socket.send(packet);
             }
         }
         catch (Exception  e){

         }
     }
     catch( Exception e )
     {
        System.out.println( e ) ;
		
     }
  }
}
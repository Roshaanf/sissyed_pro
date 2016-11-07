import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;


public class Is_bk_UDP {

	   DatagramSocket clientSocketbid, clientSocketusername,  clientSocketuid,clientSocketdate ;
	      InetAddress IPAddress ;
	     byte[] sendbid = new byte[1024];
	      byte[] senduid = new byte[1024];
	      byte[] sendusername = new byte[1024];
	      byte[] senddate = new byte[1024];
	     // byte[] receiveData = new byte[1024];
	      public Is_bk_UDP(String bookid,String username,String userid,String date) throws UnknownHostException, SocketException, IOException{
	          //bookid
	    	  IPAddress = InetAddress.getByName("localhost");
	          clientSocketbid = new DatagramSocket();
	          sendbid = bookid.getBytes();
	          DatagramPacket sendPacket = new DatagramPacket(sendbid, sendbid.length, IPAddress, 9877);
	          clientSocketbid.send(sendPacket);
	    
	          	//user name
	          clientSocketusername = new DatagramSocket();
	          sendusername = username.getBytes();
	          DatagramPacket sendPacket1 = new DatagramPacket(sendusername, sendusername.length, IPAddress, 9877);
	          clientSocketusername.send(sendPacket1);
	          
	          //userid
	          IPAddress = InetAddress.getByName("localhost");
	          clientSocketuid = new DatagramSocket();
	          senduid = userid.getBytes();
	          DatagramPacket sendPacket2 = new DatagramPacket(senduid, senduid.length, IPAddress, 9877);
	          clientSocketuid.send(sendPacket2);
	          //date
	          IPAddress = InetAddress.getByName("localhost");
	          clientSocketdate = new DatagramSocket();
	          senddate = date.getBytes();
	          DatagramPacket sendPacket3 = new DatagramPacket(senddate, senddate.length, IPAddress, 9877);
	          clientSocketdate.send(sendPacket3);
	          
	       //  JOptionPane.showMessageDialog(null, ""+username);
	     // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	     // clientSocket.receive(receivePacket);
	      //String modifiedSentence = new String(receivePacket.getData());
	      //System.out.println("FROM SERVER:" + modifiedSentence);
	      //clientSocket.close();
	      }
	     
	}

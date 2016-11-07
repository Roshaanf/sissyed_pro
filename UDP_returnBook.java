import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

//-----------------import Server.DbConnect;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class UDP_returnBook {
	 Connection connect = null;
	 DatagramSocket clientSocketbid, clientSocketbookname,   clientSocketcheck ;
     InetAddress IPAddress ;
    byte[] sendbid = new byte[1024];
    byte[] sendcheck = new byte[1024];
     byte[] sendbookname = new byte[1024];
 
     public UDP_returnBook(String bookid,String bookname,String check) throws UnknownHostException, SocketException, IOException{
         //bookid
   	  IPAddress = InetAddress.getByName("localhost");
         clientSocketbid = new DatagramSocket();
         sendbid = bookid.getBytes();
         DatagramPacket sendPacket = new DatagramPacket(sendbid, sendbid.length, IPAddress, 9878);
        
   
         	//user name
         clientSocketbookname = new DatagramSocket();
         sendbookname = bookname.getBytes();
         DatagramPacket sendPacket1 = new DatagramPacket(sendbookname, sendbookname.length, IPAddress, 9878);
        
         //check
         clientSocketcheck = new DatagramSocket();
         sendcheck = check.getBytes();
         DatagramPacket sendPacket2 = new DatagramPacket(sendcheck, sendcheck.length, IPAddress, 9878);
   
         
         
         
         
         
         
         String bookid1="";
		 String bookname1="";
		 String check1="";
		
		 byte[] msg_s_recieve_bookid,msg_s_recieve_bookname;
		try
		{
			 javax.swing.JTable bill_table = null;
			 System.out.println("Server Started");
			 int port=9878;
		
				DatagramSocket ds = new DatagramSocket(port);
				byte[] msg_bookid =new byte[100];
				byte[] msg_bookname=new byte[100];
				byte[] msg_check=new byte[100];
				
				/* *	bookid */
				DatagramPacket s_dp=new DatagramPacket(msg_bookid,msg_bookid.length);
				 clientSocketbid.send(sendPacket);
				ds.receive(s_dp);
				bookid1=new String(msg_bookid);
				bookid1=bookid1.trim();
				
				/*	username */
				 s_dp=new DatagramPacket(msg_bookname,msg_bookname.length);
				 clientSocketbookname.send(sendPacket1);			 
				 ds.receive(s_dp);
				 bookname1=new String(msg_bookname);
				 bookname1=bookname1.trim();
				 
				 //check
				 s_dp=new DatagramPacket(msg_check,msg_check.length);
			      clientSocketcheck.send(sendPacket2);
				 ds.receive(s_dp);
				 check1=new String(msg_check);
				 check1=check1.trim();
				 if(check1.equals("2"))
				 {
					 Calendar cal = new GregorianCalendar();
				        int day = cal.get(Calendar.DATE);
				        
				        int month = cal.get(Calendar.MONTH);
				        month++;
				        int year = cal.get(Calendar.YEAR);
				       String date=("" + day + "/" + month + "/" + year);
					 JOptionPane.showMessageDialog(null,bookid1+","+bookname1+",'"+date+"'");
					 
			
						
		//-----				 connect = (Connection) DbConnect.connectDb();
									
									String Sql = "call pr_returnBook("+bookid1+",'"+bookname1+"','"+date+"')";
							        try {
							        	PreparedStatement  pst = (PreparedStatement) connect.prepareStatement(Sql);
				               			pst.execute();
							    
							        } 
							        catch (Exception e)
							        {
							            JOptionPane.showMessageDialog(null,"Errors");
							        }	 

				 }
				 if(check1.equals("1"))
				 {

						
						
	//----				 connect = (Connection) DbConnect.connectDb();
								
								String Sql = "call pr_updateFine("+bookid1+",'"+bookname1+"')"; //userid==bookid
						        try {
						        	PreparedStatement  pst = (PreparedStatement) connect.prepareStatement(Sql);
			               			pst.execute();
			               			JOptionPane.showMessageDialog(null,"("+bookid1+",'"+bookname1+"'");
						        } 
						        catch (Exception e)
						        {
						            JOptionPane.showMessageDialog(null,"Errors");
						        }	 

				 }
	}
		catch(Exception e)
		{
			
		}
		finally
		{
		
		}


         
         
         
         
         
         
         
         
         
         
         
         
         
     }
}

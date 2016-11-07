package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ReturnBook_Server {


		static Connection connect = null;
		
		
	public static void main(String[] args) 
	{
		 String bookid="";
		 String bookname="";
		 String check="";
		
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
				ds.receive(s_dp);
				bookid=new String(msg_bookid);
				bookid=bookid.trim();
				
				/*	username */
				 s_dp=new DatagramPacket(msg_bookname,msg_bookname.length);
				 ds.receive(s_dp);
				 bookname=new String(msg_bookname);
				 bookname=bookname.trim();
				 
				 //check
				 s_dp=new DatagramPacket(msg_check,msg_check.length);
				 ds.receive(s_dp);
				 check=new String(msg_check);
				 check=check.trim();
				 if(check.equals("2"))
				 {
					 Calendar cal = new GregorianCalendar();
				        int day = cal.get(Calendar.DATE);
				        
				        int month = cal.get(Calendar.MONTH);
				        month++;
				        int year = cal.get(Calendar.YEAR);
				       String date=("" + day + "/" + month + "/" + year);
					 JOptionPane.showMessageDialog(null,bookid+","+bookname+",'"+date+"'");
					 
			
						
						 connect = (Connection) DbConnect.connectDb();
									
									String Sql = "call pr_returnBook("+bookid+",'"+bookname+"','"+date+"')";
							        try {
							        	PreparedStatement  pst = (PreparedStatement) connect.prepareStatement(Sql);
				               			pst.execute();
							    
							        } 
							        catch (Exception e)
							        {
							            JOptionPane.showMessageDialog(null,"Errors");
							        }	 

				 }
				 if(check.equals("1"))
				 {

						
						
					 connect = (Connection) DbConnect.connectDb();
								
								String Sql = "call pr_updateFine("+bookid+",'"+bookname+"')"; //userid==bookid
						        try {
						        	PreparedStatement  pst = (PreparedStatement) connect.prepareStatement(Sql);
			               			pst.execute();
			               			JOptionPane.showMessageDialog(null,"("+bookid+",'"+bookname+"'");
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
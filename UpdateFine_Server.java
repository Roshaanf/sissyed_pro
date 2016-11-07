package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class UpdateFine_Server {


		static Connection connect = null;
		
	
		
	public static void main(String[] args) 
	{
		 
		 String userid="";
		 String bookname="";

		 
		
		try
		{
			 javax.swing.JTable bill_table = null;
			 System.out.println("Server Started");
			 int port=9879;
		
				DatagramSocket ds = new DatagramSocket(port);
				byte[] msg_bookid =new byte[100];
				byte[] msg_bookname=new byte[100];
				
				
				/* *	bookid */
				DatagramPacket s_dp=new DatagramPacket(msg_bookid,msg_bookid.length);
				ds.receive(s_dp);
				userid=new String(msg_bookid);
				userid=userid.trim();
				
				/*	username */
				 s_dp=new DatagramPacket(msg_bookname,msg_bookname.length);
				 ds.receive(s_dp);
				 bookname=new String(msg_bookname);
				 bookname=bookname.trim();
				    
		
				 
		
					
					 connect = (Connection) DbConnect.connectDb();
								
								String Sql = "call pr_updateFine("+userid+",'"+bookname+"')";
						        try {
						        	PreparedStatement  pst = (PreparedStatement) connect.prepareStatement(Sql);
			               			pst.execute();
			               			JOptionPane.showMessageDialog(null,"("+userid+",'"+bookname+"'");
						        } 
						        catch (Exception e)
						        {
						            JOptionPane.showMessageDialog(null,"Errors");
						        }	 

	}
		catch(Exception e)
		{
			
		}
		finally
		{
		
		}

	} }
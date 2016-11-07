package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class IssueBook_Server {

	static Connection connect = null;
	
	
public static void main(String[] args) 
{
	 
	 String bookid="";
	 String username="";
	 String userid="";
	 String date="";
	 
	 byte[] msg_s_recieve_bookid,msg_s_recieve_username;
	try
	{
		 javax.swing.JTable bill_table = null;
		 System.out.println("Server Started");
		 int port=9877;
	
			DatagramSocket ds = new DatagramSocket(port);
			byte[] msg_bookid =new byte[100];
			byte[] msg_username =new byte[100];
			byte[] msg_userid =new byte[100];
			byte[] msg_date =new byte[100];
			
			/* *	bookid */
			DatagramPacket s_dp=new DatagramPacket(msg_bookid,msg_bookid.length);
			ds.receive(s_dp);
			bookid=new String(msg_bookid);
			bookid=bookid.trim();
			
			/*	username */
			 s_dp=new DatagramPacket(msg_username,msg_username.length);
			 ds.receive(s_dp);
			 username=new String(msg_username);
			 username=username.trim();
			 
			 /* *	userid */
				s_dp=new DatagramPacket(msg_userid,msg_userid.length);
				ds.receive(s_dp);
				userid=new String(msg_userid);
				userid=userid.trim();
				
				/*	date */
				 s_dp=new DatagramPacket(msg_date,msg_date.length);
				 ds.receive(s_dp);
				 date=new String(msg_date);
				 date=date.trim();
	
				 	//date =issue date hai
				 
				 connect = DbConnect.connectDb();
//yahan pe ek variable banao expected date ka and us issue date mey 7 days add kar ke expected date ke variable mey save kar ke dey do
							String Sql = "call pr_insert_issueDate("+bookid+","+userid+",'"+username+"','"+date+"')";
					        try {
					        	PreparedStatement  pst = connect.prepareStatement(Sql);
		               			pst.execute();
					    
					        } 
					        catch (Exception e)
					        {
					            //JOptionPane.showMessageDialog(null,bookid+","+userid+",'"+username+"','"+date);
					        }	
					        String Sql1 = "call pr_insertfine("+userid+")";
					        try {
					        	PreparedStatement  pst = connect.prepareStatement(Sql1);
		               			pst.execute();
					    
					        } 
					        catch (Exception e)
					        {
					            JOptionPane.showMessageDialog(null,bookid+","+userid+",'"+username+"','"+date);
					        }	
 //  Sql = "UPDATE bookissuereturntable SET bookissuereturntable.FineID=MAX(finetable.FineID) WHERE bookissuereturntable.BorowerID="+userid+")";
	//				        try {
		//			        	PreparedStatement  pst = connect.prepareStatement(Sql);
		  //             			pst.execute();
			//		    
				//	        } 
					//        catch (Exception e)
					  //      {
					    //        JOptionPane.showMessageDialog(null,bookid+","+userid+",'"+username+"','"+date);
					      //  }	

}
	catch(Exception e)
	{
		
	}
	finally
	{
	
	}

} }
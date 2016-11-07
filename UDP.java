
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

//--------import Server.DbConnect;
//---------import Server.SellBook_Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Osama Khalid
 */
public class UDP {
      DatagramSocket clientSocket ;
      InetAddress IPAddress ;
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      public UDP(String value) throws UnknownHostException, SocketException, IOException{
          IPAddress = InetAddress.getByName("localhost");
          
        //String sentence = value;
      sendData = value.getBytes();
    
     // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
     // clientSocket.receive(receivePacket);
      //String modifiedSentence = new String(receivePacket.getData());
      //System.out.println("FROM SERVER:" + modifiedSentence);
      //clientSocket.close();
      }
      void send()
      {
    	  try {
			clientSocket = new DatagramSocket();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			
            
	          
	        
	          {
	      		Connection connect = null;
	      		 String msg="";
	      		try
	      		{
	      			javax.swing.JTable bill_table = null;
	      			System.out.println("Server Started");
	      			int port=9876;
	      			 DatagramSocket ds_recieve = new DatagramSocket(port);
	      			 byte[] msg_b =new byte[100];
	      			 DatagramPacket s_recieve_dp=new DatagramPacket(msg_b,msg_b.length);
	      			clientSocket.send(sendPacket);
	      			 ds_recieve.receive(s_recieve_dp);
	      			 msg=new String(msg_b);
	      			 msg=msg.trim();
	      			 
	      			 System.out.println("msg trimed");	
	      			if(msg.charAt(0)=='1')
	      			{
	      				try
	      				{
	      						msg=msg.replaceFirst("1", "");
	      						System.out.println(msg);
	//-------      						connect = (Connection) DbConnect.connectDb();
	      						String Sql = "SELECT * FROM `bookinfotable` WHERE `AurthorName`= '"+msg+"'";
	      				        try {
	      				        	PreparedStatement  pst = (PreparedStatement) connect.prepareStatement(Sql);
	      				    		ResultSet rs=pst.executeQuery();
	      				    		ResultSetMetaData RsMD =(ResultSetMetaData) rs.getMetaData();
	      				    		int Columns =RsMD.getColumnCount();
	      				    		DefaultTableModel dtm= new DefaultTableModel();
	      				    		Vector Col_names =new Vector();
	      				    		Vector Data_rows =new Vector();
	      				    		for(int i=1;i<=Columns;i++)
	      				    		{
	      				    			Col_names.addElement(RsMD.getColumnName(i));
	      				    		}
	      				    		dtm.setColumnIdentifiers(Col_names);
	      				    		while(rs.next())
	      				    		{
	      				    			Data_rows= new Vector();
	      				    			for(int i=1;i<=Columns;i++)
	      				    			{
	      				    				Data_rows.addElement(rs.getString(i));
	      				    			}
	      				    			dtm.addRow(Data_rows);	
	      				    		
	      				    		}
	      				    
	      				    	   JOptionPane.showMessageDialog(null,dtm.getValueAt(0, 1));
	      				        } 
	      				        catch (Exception e)
	      				        {
	      				            JOptionPane.showMessageDialog(null, e);
	      				        }	 
	      				}
	      				catch(Exception e)
	      				{
	      					
	      				}
	      				
	      			}
	      			else if(msg.charAt(0)=='2')
	      			{
	      				try
	      				{
	      						msg=msg.replaceFirst("2", "");
	      						System.out.println(msg);
	 //---------     						connect = (Connection) DbConnect.connectDb();
	      						String Sql = "SELECT * FROM `bookinfotable` JOIN category on category.Category_ID =bookinfotable.CategoryLinked where category.Title='"+msg+"'";
	      				        try {
	      				        	PreparedStatement  pst = (PreparedStatement) connect.prepareStatement(Sql);
	      				    		ResultSet rs=pst.executeQuery();
	      				    		ResultSetMetaData RsMD =(ResultSetMetaData) rs.getMetaData();
	      				    		int Columns =RsMD.getColumnCount();
	      				    		DefaultTableModel dtm= new DefaultTableModel();
	      				    		Vector Col_names =new Vector();
	      				    		Vector Data_rows =new Vector();
	      				    		for(int i=1;i<=Columns;i++)
	      				    		{
	      				    			Col_names.addElement(RsMD.getColumnName(i));
	      				    		}
	      				    		dtm.setColumnIdentifiers(Col_names);
	      				    		while(rs.next())
	      				    		{
	      				    			Data_rows= new Vector();
	      				    			for(int i=1;i<=Columns;i++)
	      				    			{
	      				    				Data_rows.addElement(rs.getString(i));
	      				    			}
	      				    			dtm.addRow(Data_rows);	
	      				    		
	      				    		}
	      				    
	      				    	   JOptionPane.showMessageDialog(null,dtm.getValueAt(0, 1));
	      				        } 
	      				        catch (Exception e)
	      				        {
	      				            JOptionPane.showMessageDialog(null, e);
	      				        }	 
	      				}
	      				catch(Exception e)
	      				{
	      					
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
	          
	          
	          
	          
				
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
      }
     
}

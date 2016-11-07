package Server;

import java.awt.EventQueue;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class SellBook_Server {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellBook_Server window = new SellBook_Server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SellBook_Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public void testS()
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
						connect = DbConnect.connectDb();
						String Sql = "SELECT * FROM `bookinfotable` WHERE `AurthorName`= '"+msg+"'";
				        try {
				        	PreparedStatement  pst = connect.prepareStatement(Sql);
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
						connect = DbConnect.connectDb();
						String Sql = "SELECT * FROM `bookinfotable` JOIN category on category.Category_ID =bookinfotable.CategoryLinked where category.Title='"+msg+"'";
				        try {
				        	PreparedStatement  pst = connect.prepareStatement(Sql);
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
}

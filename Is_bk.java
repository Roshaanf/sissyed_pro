
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

//------import Server.IssueBook_Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Is_bk extends javax.swing.JFrame {
    String Bookid;
    String Username;
    String Userid;
    String todays;
    String previous;
    /**
     * Creates new form Is_bk
     */
//-----    static IssueBook_Server sb_s =new  IssueBook_Server();
    public Is_bk() {
        initComponents();
        this.setLocation(325, 150);
        this.setResizable(false);
        todays_date.setEnabled(false);
        pv_date.setEnabled(false);
        
         ImageIcon i=new ImageIcon("bk.jpg");
       JLabel l=new JLabel(i);
       l.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());
        
        
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(tdate);
        bg.add(pdate);
        
        
        
          JButton back=new JButton();
        back.setBounds(10,10,70,30);
        back.setText("Back");
        this.add(back);
        this.add(l);
        back.addActionListener(new ActionListener(){
            

            @Override
            public void actionPerformed(ActionEvent e) {
              o();
                /*menu m=new menu();
             Is_bk b=new Is_bk();
               b.setVisible(false);
               b.setVisible(false);
                m.setVisible(true);*/
            }
        });
        
       
        
    }

    
    public void o(){
        menu m=new menu();
             
               this.setVisible(false);
               
                m.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        book_id = new javax.swing.JTextField();
        tdate = new javax.swing.JRadioButton();
        issue_book = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        user_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        todays_date = new javax.swing.JTextField();
        pv_date = new javax.swing.JTextField();
        pdate = new javax.swing.JRadioButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Book id");

        tdate.setText("Today's date");
        tdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdateActionPerformed(evt);
            }
        });

        issue_book.setText("Issue book");
        issue_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue_bookActionPerformed(evt);
            }
        });

        jLabel2.setText("User id");

        jLabel3.setText("User name");

        jLabel4.setText("Today's date");

        jLabel5.setText("Previous date");

        pv_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pv_dateActionPerformed(evt);
            }
        });

        pdate.setText("Previous date");
        pdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(issue_book)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(todays_date, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pv_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(book_id, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addComponent(user_id))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tdate)
                        .addGap(18, 18, 18)
                        .addComponent(pdate)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tdate)
                    .addComponent(pdate))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(todays_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pv_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(issue_book)
                .addContainerGap())
        );

        pack();
        
    }// </editor-fold>                        

    private void issue_bookActionPerformed(java.awt.event.ActionEvent evt) {                                           
       Bookid=book_id.getText();
       /* try {
            UDP udp= new UDP (Bookid);
        } catch (SocketException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        }*/
      Username=user_name.getText();
   /*     try {
        	
        } catch (SocketException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        } */
       Userid=user_id.getText();
    /*    try {
            UDP udp3 = new UDP(Userid);
        } catch (SocketException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        } */
       todays=todays_date.getText();
       previous=pv_date.getText();
       if(!todays.equals(""))
       {
    	   try {
           	Is_bk_UDP udp4= new Is_bk_UDP(Bookid,Username,Userid, todays);
           } catch (SocketException ex) {
               Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else if(!previous.equals(""))
       {
    	   try {
           	Is_bk_UDP udp4= new Is_bk_UDP(Bookid,Username,Userid,  previous);
           } catch (SocketException ex) {
               Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
/*
     
        try {
        	Is_bk_UDP udp4= new Is_bk_UDP(Bookid,Username,Userid,previous);
        } catch (SocketException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Is_bk.class.getName()).log(Level.SEVERE, null, ex);
        } */ 
    }                                          

    private void tdateActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
         pv_date.setText("");
        pv_date.setEnabled(false);
        todays_date.setEnabled(true);
    }                                     

    private void pdateActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
         todays_date.setText("");
        todays_date.setEnabled(false);
        pv_date.setEnabled(true);
    }                                     

    private void pv_dateActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Is_bk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Is_bk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Is_bk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Is_bk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Is_bk().setVisible(true);
            }
        });
 //-----       sb_s.main(null);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField book_id;
    private javax.swing.JButton issue_book;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton pdate;
    private javax.swing.JTextField pv_date;
    private javax.swing.JRadioButton tdate;
    private javax.swing.JTextField todays_date;
    private javax.swing.JTextField user_id;
    private javax.swing.JTextField user_name;
    // End of variables declaration                   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inua_mkulima;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author georgiegegoh
 */
public class farmer1 extends javax.swing.JFrame {

    
    private JLabel statusbar;
    private JLabel messageLabel;
    private JButton btnSubmit;
    private JTextField txtField ;
    // Message arraylist
    ArrayList<String> posts = new ArrayList<String>();
    ArrayList<String> officerMessages = new ArrayList<String>();
    public farmer1() {
        //define a menu bar,a menu and menu items
        JMenuBar menubar = new JMenuBar();
        JMenu post = new JMenu("Post");
        post.addMenuListener(new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e) {
                postNewMessage();
                System.out.println("message is  "+ posts);
            }
            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("menuDeselected");
        
            }
            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("menuCanceled");

            }
        });
        JMenu inbox = new JMenu("Inbox");
        inbox.addMenuListener(new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e){
                loadInbox();
            }
            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("menuDeselected");
        
            }
            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("menuCanceled");

            }

        });
        JMenu talkToOfficer = new JMenu("Talk to Officer");
        talkToOfficer.addMenuListener(new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e){
                talkToOfficer();
            }
            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("menuDeselected");
        
            }
            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("menuCanceled");

            }
        });
        JMenu market = new JMenu("market");
        market.addMenuListener(new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e){
                fetchMarket();
            }
            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("menuDeselected");
        
            }
            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("menuCanceled");

            }
        });
        JMenu Home = new JMenu("Home");
        market.addMenuListener(new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e){
                new home().setVisible(true);
                setVisible(false);
            }
            @Override
            public void menuDeselected(MenuEvent e) {
                new farmer1().setVisible(false);
        
            }
            @Override
            public void menuCanceled(MenuEvent e) {
                new farmer1().setVisible(false);

            }
        });





        //add the menu to the menu bar and set the menubar for this frame
        menubar.add(post);
        menubar.add(inbox);
        menubar.add(talkToOfficer);
        menubar.add(market);
        menubar.add(Home);
        setJMenuBar(menubar);

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        
        //statusbar = new JLabel("Statusbar");
        //statusbar.setPreferredSize(new Dimension(-1, 22));
        //add(statusbar, BorderLayout.SOUTH);

        setSize(500, 500);
        setTitle("Farmer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    


    //Post new message 
    public void postNewMessage(){
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        messageLabel = new JLabel("Enter Message to post");
        
        txtField = new JTextField("Andika hapa",20);
        
        txtField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.out.println("receiving message");
                txtField.setText("");
                String message = txtField.getText();
                posts.add(message);
            }
        });
  

        btnSubmit = new JButton("Submit ");
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent submitClicked) {
                posts.add(txtField.getText());
        
                Component frame = new JFrame();
                JOptionPane.showMessageDialog(frame , "Your message has been saved.Thanks" );
                System.out.println(posts);
            }
        
        });
        container.add(messageLabel);
        container.add(txtField);
        container.add(btnSubmit);
        setSize(600,500);
        setVisible(true);

    }
    //Load Inbox
    public void loadInbox(){
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        // Call the messages array to view messages.
        System.out.println("Loading inbox");
     
    }

    //Talk to officer method
    public void talkToOfficer(){
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        messageLabel = new JLabel("Enter Message for Officer.");
        
        txtField = new JTextField("Message..",20);
        
        txtField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.out.println("receiving message");
                txtField.setText("");
                String message = txtField.getText();
                officerMessages.add(message);
            }
        });
  

        btnSubmit = new JButton("Submit ");
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent submitClicked) {
                officerMessages.add(txtField.getText());
        
                Component frame = new JFrame();
                JOptionPane.showMessageDialog(frame , "Your message has been saved.Thanks" );
                System.out.println(officerMessages);
            }
        
        });
        container.add(messageLabel);
        container.add(txtField);
        container.add(btnSubmit);
        setSize(600,500);
        setVisible(true);

    }

    //Fetch market
    public void fetchMarket(){
        // Load market array
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(60, 60, 60))
        );

        jButton1.setText("BACK TO HOME");
        jButton1.setVisible(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        home backHome = new home();
        backHome.show();
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(farmer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(farmer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(farmer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(farmer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new farmer1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}

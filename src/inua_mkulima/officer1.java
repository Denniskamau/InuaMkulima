/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inua_mkulima;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author georgiegegoh
 */
public class officer1 extends javax.swing.JFrame {

    java.sql.Connection conn = null;
    ResultSet rs = null;
    Statement st;
    PreparedStatement pst;
    String name = null;
    String type = null;
    String query = null;
    String message = null;
    String date = null;
    
    public officer1() {
        initComponents();
       
        setSize(new Dimension(getWidth(),getHeight()));
        setTitle("OFFICER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        jPanel4.setVisible(false);
        jPanel6.setVisible(false);
        jPanel9.setVisible(false);
        jPanel10.setVisible(false);
        
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/inuaMkulima", "inuaMkulima", "admin");
            String query = ("SELECT * FROM INUAMKULIMA.USERS where Status = ? and Type = ? ");
            pst = conn.prepareStatement(query);
            pst.setString(1, "online");
            pst.setString(2, "Agricultural Officer");
            rs = pst.executeQuery();
            if (rs.next()) {
                name = (rs.getString(1));
            }
            query = ("SELECT * FROM INUAMKULIMA.TRENDS where Name = ? ORDER BY Date DESC ");
            pst = conn.prepareStatement(query);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.next() && !jPanel4.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel13);
                jLabel2.setText(name);
                jLabel4.setText(type);
                jLabel3.setText(message);
                jLabel5.setText(date);
                jPanel4.setVisible(true);
            }
            if (rs.next() && !jPanel6.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel14);
                jLabel6.setText(name);
                jLabel7.setText(type);
                jLabel8.setText(message);
                jLabel9.setText(date);
                jPanel6.setVisible(true);
            }
            if (rs.next() && !jPanel9.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel25);
                jLabel21.setText(name);
                jLabel22.setText(type);
                jLabel23.setText(message);
                jLabel24.setText(date.toString());
                jPanel9.setVisible(true);
            }
            if (rs.next() && !jPanel10.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel30);
                jLabel26.setText(name);
                jLabel27.setText(type);
                jLabel28.setText(message);
                jLabel29.setText(date.toString());
                jPanel10.setVisible(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }    
    public void getImage(byte[] photo, javax.swing.JLabel labelImage) {
        ImageIcon image = new ImageIcon(photo);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        labelImage.setIcon(newImage);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 102));

        jPanel1.setBackground(new java.awt.Color(190, 156, 60));

        jButton1.setText("POST");
        jButton1.setName("post"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postActionHandler(evt);
            }
        });

        jButton2.setText("INBOX");
        jButton2.setName("inbox"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inboxActionPerfomed(evt);
            }
        });

        jButton3.setText("HOME");
        jButton3.setName("home"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionHandler(evt);
            }
        });

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1107, 55, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 250, 250));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Label");
        jLabel2.setName("name"); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 12, -1, -1));

        jLabel3.setText("message");
        jLabel3.setName("message"); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 47, -1, -1));

        jLabel4.setText("(market)");
        jLabel4.setName("user"); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel5.setText("jLabel5");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 220, -1));

        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 83, 74));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, 726, 100));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(851, 209, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 250, 250));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("jLabel6");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 12, -1, -1));

        jLabel7.setText("(farmer)");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 12, -1, -1));

        jLabel8.setText("jLabel8");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 57, -1, -1));

        jLabel9.setText("jLabel9");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 220, -1));

        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 83, 74));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 147, 726, -1));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setText("RECENT POSTS");
        jLabel1.setName("RECENT POSTS"); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 0, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 250, 250));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("jLabel6");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 12, -1, -1));

        jLabel22.setText("(farmer)");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 12, -1, -1));

        jLabel23.setText("jLabel8");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 57, -1, -1));

        jLabel24.setText("jLabel9");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 220, -1));

        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 83, 74));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 262, 726, -1));

        jPanel10.setBackground(new java.awt.Color(255, 250, 250));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setText("jLabel6");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 12, -1, -1));

        jLabel27.setText("(farmer)");
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 12, -1, -1));

        jLabel28.setText("jLabel8");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 57, -1, -1));

        jLabel29.setText("jLabel9");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 210, -1));

        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 83, 74));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 377, 726, -1));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, -1));

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void postActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postActionHandler
       try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/inuaMkulima", "inuaMkulima", "admin");
            st = conn.createStatement();
            String query = ("SELECT * FROM INUAMKULIMA.USERS where Status = ? ");
            pst = conn.prepareStatement(query);
            pst.setString(1, "online");
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString(1));
                name = rs.getString(1);
                type = rs.getString(3);
                Blob image = rs.getBlob(5);
                Date date = new Date();
                message = JOptionPane.showInputDialog(null, "Write your post:");
                if (message != null && !message.isEmpty()) {
                    query = ("insert into INUAMKULIMA.TRENDS(Message, Name, Type, Date, Image)values(?,?,?,?,?)");
                    pst = conn.prepareStatement(query);
                    pst.setString(1, message);
                    pst.setString(3, "(" + type + ")");
                    pst.setString(2, name);
                    pst.setString(4, date.toString());
                    pst.setBlob(5, image);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Posted successfully!!");
                    this.setVisible(false);
                    new officer1().setVisible(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_postActionHandler

    private void homeActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionHandler
 home backHome = new home();
        backHome.show();
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_homeActionHandler

    private void inboxActionPerfomed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxActionPerfomed
      inbox mpya = new inbox();
        mpya.show();
        setVisible(false) ; // TODO add your handling code here:
    }//GEN-LAST:event_inboxActionPerfomed

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
            java.util.logging.Logger.getLogger(officer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(officer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(officer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(officer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new officer1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

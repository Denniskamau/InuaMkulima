/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inua_mkulima;

import java.awt.Image;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author georgiegegoh
 */
public class farmerInbox extends javax.swing.JFrame {

    java.sql.Connection conn = null;
    ResultSet rs = null;
    Statement st;
    PreparedStatement pst;
    String name = null;
    String type = null;
    String query = null;
    String message = null;
    String date = null;
    
    public farmerInbox() {
        initComponents();
        setLocationRelativeTo(null);
        
        jPanel3.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel9.setVisible(false);

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/inuaMkulima", "inuaMkulima", "admin");
            String query = ("SELECT * FROM INUAMKULIMA.USERS WHERE Status = ? ");
            pst = conn.prepareStatement(query);
            pst.setString(1, "online");
            //pst.setString(2, "Agricultural");
            rs = pst.executeQuery();
            if (rs.next()) {
                name = (rs.getString(1));
            }
            query = ("SELECT * FROM INUAMKULIMA.TRENDS where Name = ? ");
            pst = conn.prepareStatement(query);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.next() && !jPanel3.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel18);
                jLabel7.setText(name);
                jLabel3.setText(type);
                jLabel8.setText(message);
                jLabel5.setText(date);
                jPanel3.setVisible(true);
            }
            if (rs.next() && !jPanel6.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel19);
                jLabel9.setText(name);
                jLabel10.setText(type);
                jLabel12.setText(message);
                jLabel11.setText(date);
                jPanel6.setVisible(true);
            }
            if (rs.next() && !jPanel7.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel20);
                jLabel13.setText(name);
                jLabel14.setText(type);
                jLabel16.setText(message);
                jLabel15.setText(date.toString());
                jPanel7.setVisible(true);
            }
            if (rs.next() && !jPanel9.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel24);
                jLabel17.setText(name);
                jLabel21.setText(type);
                jLabel23.setText(message);
                jLabel22.setText(date.toString());
                jPanel9.setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 154, 44));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1homeActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setText("RECENT MESSAGES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(253, 252, 247));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("label");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel3.setText("(market)");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel5.setText("12/06/2018");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel8.setText("jLabel4");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 48, -1, -1));

        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jButton2.setText("REPLY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2replyActionPerfomed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        jPanel6.setBackground(new java.awt.Color(253, 252, 247));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("label");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel10.setText("(market)");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel11.setText("12/06/2018");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel12.setText("jLabel4");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 48, -1, -1));

        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jButton3.setText("REPLY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3replyActionPerfomed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        jPanel7.setBackground(new java.awt.Color(253, 252, 247));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("label");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel14.setText("(market)");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel15.setText("12/06/2018");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel16.setText("jLabel4");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 48, -1, -1));

        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jButton4.setText("REPLY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4replyActionPerfomed(evt);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        jPanel9.setBackground(new java.awt.Color(253, 252, 247));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("label");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel21.setText("(market)");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel22.setText("12/06/2018");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));
        Date date = new Date();
        jLabel5.setText(date.toString());;

        jLabel23.setText("jLabel4");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 48, -1, -1));

        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jButton5.setText("REPLY");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5replyActionPerfomed(evt);
            }
        });
        jPanel9.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 780, 480));

        jButton6.setBackground(new java.awt.Color(255, 153, 51));
        jButton6.setText("BACK");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6homeActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1homeActionPerformed
        home backHome = new home();
        backHome.show();
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1homeActionPerformed

    private void jButton2replyActionPerfomed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2replyActionPerfomed
        reply();
    }//GEN-LAST:event_jButton2replyActionPerfomed

    private void jButton3replyActionPerfomed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3replyActionPerfomed
        // TODO add your handling code here:
        reply();
    }//GEN-LAST:event_jButton3replyActionPerfomed

    private void jButton4replyActionPerfomed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4replyActionPerfomed
        // TODO add your handling code here:
        reply();
    }//GEN-LAST:event_jButton4replyActionPerfomed

    private void jButton5replyActionPerfomed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5replyActionPerfomed
        // TODO add your handling code here:
        reply();
    }//GEN-LAST:event_jButton5replyActionPerfomed

    private void jButton6homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6homeActionPerformed
        // TODO add your handling code here:
        new Mkulima().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6homeActionPerformed

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
            java.util.logging.Logger.getLogger(farmerInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(farmerInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(farmerInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(farmerInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new farmerInbox().setVisible(true);
            }
        });
    }
    public void reply(){
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
                message = JOptionPane.showInputDialog(null, "Type your reply:");
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
                    new market().setVisible(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

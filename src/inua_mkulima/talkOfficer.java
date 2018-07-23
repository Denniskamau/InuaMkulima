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
public class talkOfficer extends javax.swing.JFrame {

    java.sql.Connection conn = null;
    ResultSet rs = null;
    Statement st;
    PreparedStatement pst;
    String name = null;
    String type = null;
    String query = null;
    String message = null;
    String date = null;
    String nameOnline = null;
    String typeOnline = null;
    
    public talkOfficer() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("TALK TO OFFICER");
        
        jPanel3.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel9.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel6.setVisible(false);
        jLabel10.setVisible(false);

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
                              
            query = ("SELECT * FROM INUAMKULIMA.MESSAGES where Name = ? ORDER BY Date DESC ");
            pst = conn.prepareStatement(query);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.next() && !jPanel3.isVisible()) {
                name = rs.getString(5);
                message = rs.getString(2);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(6);
                getImage(photo, jLabel18);
                jLabel7.setText(name);
                jLabel8.setText(message);
                jLabel5.setText(date);
                jPanel3.setVisible(true);
            }
            if (rs.next() && !jPanel6.isVisible()) {
                name = rs.getString(5);
                message = rs.getString(2);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(6);
                getImage(photo, jLabel19);
                jLabel9.setText(name);
                jLabel12.setText(message);
                jLabel11.setText(date);
                jPanel6.setVisible(true);
            }
            if (rs.next() && !jPanel7.isVisible()) {
                name = rs.getString(5);
                message = rs.getString(2);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(6);
                getImage(photo, jLabel20);
                jLabel13.setText(name);
                jLabel16.setText(message);
                jLabel15.setText(date.toString());
                jPanel7.setVisible(true);
            }
            if (rs.next() && !jPanel9.isVisible()) {
                name = rs.getString(5);
                message = rs.getString(2);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(6);
                getImage(photo, jLabel24);
                jLabel17.setText(name);
                jLabel23.setText(message);
                jLabel22.setText(date.toString());
                jPanel9.setVisible(true);
            }
            if (jPanel6.isVisible()) {
                query = ("SELECT * FROM INUAMKULIMA.REPLY where Message = ? AND Recepient = ? ORDER BY Date DESC ");
                pst = conn.prepareStatement(query);
                pst.setString(1, jLabel12.getText());
                pst.setString(2, name);
                rs = pst.executeQuery();
                if (rs.next() ) {

                }
            }
            //filter replies
            if (jPanel3.isVisible()) {
                query = ("SELECT * FROM INUAMKULIMA.REPLY where Sender = ? AND RepliedMessage = ?");
                pst = conn.prepareStatement(query);
                pst.setString(1, jLabel7.getText());
                pst.setString(2, jLabel8.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    String meso = rs.getString(1);
                    jLabel3.setVisible(true);
                    jLabel3.setText("REPLY: "+meso);
                }
            }
            if (jPanel6.isVisible()) {
                query = ("SELECT * FROM INUAMKULIMA.REPLY where Sender = ? AND RepliedMessage = ?");
                pst = conn.prepareStatement(query);
                pst.setString(1, jLabel9.getText());
                pst.setString(2, jLabel12.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    String meso = rs.getString(1);
                    jLabel4.setVisible(true);
                    jLabel4.setText("REPLY: "+meso);
                }
            }
            if (jPanel7.isVisible()) {
                query = ("SELECT * FROM INUAMKULIMA.REPLY where Sender = ? AND RepliedMessage = ?");
                pst = conn.prepareStatement(query);
                pst.setString(1, jLabel13.getText());
                pst.setString(2, jLabel16.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    String meso = rs.getString(1);
                    jLabel6.setVisible(true);
                    jLabel6.setText("REPLY: "+meso);
                }
            }
            if (jPanel9.isVisible()) {
                query = ("SELECT * FROM INUAMKULIMA.REPLY where Sender = ? AND RepliedMessage = ?");
                pst = conn.prepareStatement(query);
                pst.setString(1, jLabel17.getText());
                pst.setString(2, jLabel23.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    String meso = rs.getString(1);
                    jLabel10.setVisible(true);
                    jLabel10.setText("REPLY: "+meso);
                }
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
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 154, 44));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(244, 198, 24));
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1homeActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setText("RECENT MESSAGES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(253, 252, 247));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("label");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel5.setText("12/06/2018");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel8.setText("jLabel4");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jLabel3.setText("jLabel3");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel14.setText("To:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jPanel6.setBackground(new java.awt.Color(253, 252, 247));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("label");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel11.setText("12/06/2018");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel12.setText("jLabel4");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jLabel4.setText("jLabel4");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel21.setText("To:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel7.setBackground(new java.awt.Color(253, 252, 247));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("label");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel15.setText("12/06/2018");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel16.setText("jLabel4");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jLabel6.setText("jLabel6");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel25.setText("To:");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel9.setBackground(new java.awt.Color(253, 252, 247));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("label");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel22.setText("12/06/2018");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));
        Date date = new Date();
        jLabel5.setText(date.toString());;

        jLabel23.setText("jLabel4");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 64, 69));

        jLabel10.setText("jLabel10");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel26.setText("To:");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

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
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 780, 360));

        jButton6.setBackground(new java.awt.Color(244, 198, 24));
        jButton6.setText("BACK");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6homeActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        jButton4.setBackground(new java.awt.Color(244, 198, 24));
        jButton4.setForeground(new java.awt.Color(33, 28, 18));
        jButton4.setText("Talk to Officer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

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

    private void jButton6homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6homeActionPerformed
        // TODO add your handling code here:
        new Mkulima().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6homeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/inuaMkulima", "inuaMkulima", "admin");
            String query = ("SELECT * FROM INUAMKULIMA.USERS WHERE Status = ? ");
            pst = conn.prepareStatement(query);
            pst.setString(1, "online");
            rs = pst.executeQuery();
            if (rs.next()) {
                nameOnline = (rs.getString(1));
                typeOnline = (rs.getString(3));
                
            }
            String recepient = JOptionPane.showInputDialog(null, "Enter name of Agricultural Officer:");                
            if (recepient != null && !recepient.isEmpty()) {
                query = ("SELECT * FROM INUAMKULIMA.USERS where Name = ? and Type = ? ");
                pst = conn.prepareStatement(query);
                pst.setString(1, recepient);
                pst.setString(2, "Agricultural Officer");
                rs = pst.executeQuery();
                if (rs.next()) {
                    System.out.println(rs.getString(1));
                    name = rs.getString(1);
                    Blob image = rs.getBlob(5);
                    Date date = new Date();
                        message = JOptionPane.showInputDialog(null, "Write your post:");
                        if (message != null && !message.isEmpty()) {
                            query = ("insert into INUAMKULIMA.MESSAGES(Type, Message, Name, Date, Recepient, Image, Status)values(?,?,?,?,?,?,?)");
                            pst = conn.prepareStatement(query);
                            pst.setString(1, typeOnline);
                            pst.setString(2, message);
                            pst.setString(3, nameOnline);
                            pst.setString(4, date.toString());
                            pst.setString(5, name);
                            pst.setBlob(6, image);
                            pst.setString(7, "unreplied");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Posted successfully!!");
                            this.setVisible(false);
                            new talkOfficer().setVisible(true);
                        }
                }   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(talkOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(talkOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(talkOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(talkOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new talkOfficer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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

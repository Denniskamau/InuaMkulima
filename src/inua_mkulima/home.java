/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inua_mkulima;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static inua_mkulima.Register.scaleImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author georgiegegoh
 */
public class home extends javax.swing.JFrame {

    java.sql.Connection conn = null;
    ResultSet rs = null;
    Statement st;
    PreparedStatement pst;
    String name = null;
    String type = null;
    String query = null;
    String message = null;
    String date = null;

    public Date date1 = new Date();

    public home() {
        initComponents();

        //create a menubar
        JMenuBar menubar = new JMenuBar();
        //home tab
        JMenu home = new JMenu("Home");
        home.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent me) {
                setVisible(false);
            }

            @Override
            public void menuCanceled(MenuEvent me) {
                setVisible(false);
            }
        });
        //farmer tab
        JMenu farmer = new JMenu("Farmer");
        farmer.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                new farmer1().setVisible(true);
                setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent me) {
                new farmer1().setVisible(false);
            }

            @Override
            public void menuCanceled(MenuEvent me) {
                new farmer1().setVisible(false);
            }

        });
        //officer tab
        JMenu officer = new JMenu("Agricultural Officer");
        officer.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                new officer1().setVisible(true);
                setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent me) {
                new officer1().setVisible(false);
            }

            @Override
            public void menuCanceled(MenuEvent me) {
                new officer1().setVisible(false);
            }

        });
        //market tab
        JMenu market = new JMenu("Market");
        market.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                new market().setVisible(true);
                setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent me) {
                new market().setVisible(false);
            }

            @Override
            public void menuCanceled(MenuEvent me) {
                new market().setVisible(false);
            }

        });

        //add menus to the menubar
        menubar.add(home);
        menubar.add(farmer);
        menubar.add(officer);
        menubar.add(market);
        setJMenuBar(menubar);

        //setting the toolbar
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        setSize(getPreferredSize().width, 602);
        setTitle("INUA MKULIMA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //et invisible
        jPanel1.setVisible(false);
        jPanel7.setVisible(false);
        jPanel9.setVisible(false);
        jPanel6.setVisible(false);
        jPanel15.setVisible(false);
        jPanel16.setVisible(false);
        jPanel17.setVisible(false);
        jPanel18.setVisible(false);
        jPanel19.setVisible(false);

        //Retrieve records
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/inuaMkulima", "inuaMkulima", "admin");
            query = ("SELECT * FROM INUAMKULIMA.USERS WHERE Status = ? ");
            pst = conn.prepareStatement(query);
            pst.setString(1, "online");
            rs = pst.executeQuery();
            while (rs.next()) {
                lblUsername.setText(rs.getString(1));
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel24);
            }
            query = ("SELECT * FROM INUAMKULIMA.TRENDS ORDER BY Date DESC");
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next() && !jPanel1.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel23);
                jLabel1.setText(name);
                jLabel2.setText(type);
                jLabel3.setText(message);
                jLabel4.setText(date);
                jPanel1.setVisible(true);
            }
            if (rs.next() && !jPanel7.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel25);
                jLabel10.setText(name);
                jLabel11.setText(type);
                jLabel5.setText(message);
                jLabel13.setText(date);
                jPanel7.setVisible(true);
            }
            if (rs.next() && !jPanel9.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel26);
                jLabel14.setText(name);
                jLabel15.setText(type);
                jLabel6.setText(message);
                jLabel17.setText(date.toString());
                jPanel9.setVisible(true);
            }
            if (rs.next() && !jPanel6.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel27);
                jLabel7.setText(name);
                jLabel8.setText(type);
                jLabel9.setText(message);
                jLabel12.setText(date.toString());
                jPanel6.setVisible(true);
            }
            if (rs.next() && !jPanel15.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel18);
                jLabel19.setText(name);
                jLabel20.setText(type);
                jLabel21.setText(message);
                jLabel22.setText(date.toString());
                jPanel1.setVisible(true);
            }
            if (rs.next() && !jPanel16.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel29);
                jLabel30.setText(name);
                jLabel31.setText(type);
                jLabel32.setText(message);
                jLabel33.setText(date.toString());
                jPanel16.setVisible(true);
            }
            if (rs.next() && !jPanel17.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel34);
                jLabel35.setText(name);
                jLabel36.setText(type);
                jLabel37.setText(message);
                jLabel38.setText(date.toString());
                jPanel17.setVisible(true);
            }
            if (rs.next() && !jPanel18.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel39);
                jLabel40.setText(name);
                jLabel41.setText(type);
                jLabel42.setText(message);
                jLabel43.setText(date.toString());
                jPanel18.setVisible(true);
            }
            if (rs.next() && !jPanel19.isVisible()) {
                name = rs.getString(2);
                type = rs.getString(3);
                message = rs.getString(1);
                date = rs.getString(4);
                byte[] photo = rs.getBytes(5);
                getImage(photo, jLabel44);
                jLabel45.setText(name);
                jLabel46.setText(type);
                jLabel47.setText(message);
                jLabel48.setText(date.toString());
                jPanel19.setVisible(true);
            }
        } catch (Exception e) {
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

        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(233, 193, 45));

        jPanel5.setBackground(new java.awt.Color(54, 33, 33));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(155, 129, 56));
        jPanel3.setPreferredSize(new java.awt.Dimension(1040, 600));

        lblUsername.setFont(new java.awt.Font("Bitstream Charter", 1, 14)); // NOI18N
        lblUsername.setText("jLabel16");

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(225, 238, 237));
        jLabel16.setText("(Online)");

        jScrollPane1.setBackground(new java.awt.Color(43, 24, 24));

        jPanel14.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jPanel14.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel1.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel1.setPreferredSize(new java.awt.Dimension(872, 122));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setText("Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Noto Sans", 2, 12)); // NOI18N
        jLabel2.setText("Type");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel4.setText("12/04/2018");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        jPanel13.setBackground(java.awt.SystemColor.controlLtHighlight);

        jLabel3.setBackground(java.awt.SystemColor.controlLtHighlight);
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jLabel3.setText("Hi everyone!Remember next month we expect rains. Start cultivating now");
        jLabel3.setVerticalAlignment(SwingConstants.TOP);
        jLabel3.setOpaque(true);

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 46, 134, -1));
        jPanel4.add(jLabel6);
        jPanel4.setVisible(true);

        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 23, 67, 64));

        jPanel7.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel7.setPreferredSize(new java.awt.Dimension(872, 116));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("16/05/2018");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jPanel11.setBackground(java.awt.SystemColor.controlLtHighlight);

        jLabel5.setBackground(java.awt.SystemColor.controlLtHighlight);
        jLabel5.setText("jLabel5");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setText("Name");

        jLabel11.setFont(new java.awt.Font("Noto Sans", 2, 12)); // NOI18N
        jLabel11.setText("Type");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18))
        );

        jLabel5.setText("Hi everyone! There will be free pesticides being given out on Monday next week. Take yours ");

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 12, -1, -1));
        jPanel4.add(jLabel6);
        jPanel4.setVisible(true);

        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 19, 67, 63));

        jPanel9.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel9.setPreferredSize(new java.awt.Dimension(872, 117));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel14.setText("Name");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Noto Sans", 2, 12)); // NOI18N
        jLabel15.setText("Type");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel17.setText("12/06/2018");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jPanel4.setBackground(java.awt.SystemColor.controlLtHighlight);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 10, 0));

        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 18, 66, 64));

        jLabel6.setBackground(java.awt.SystemColor.controlLtHighlight);
        jLabel6.setText("jLabel6");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));
        jLabel6.setText("Habari! Nataka gunia kama tano ya waru. Number: 0713223284");
        jLabel6.setVerticalAlignment(SwingConstants.TOP);
        jLabel6.setOpaque(true);

        jPanel6.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel6.setPreferredSize(new java.awt.Dimension(872, 100));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setText("Name");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel8.setText("Type");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel9.setText("jLabel9");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel12.setText("jLabel12");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 71, -1, -1));

        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 12, 70, 68));

        jPanel15.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(195, 6, 6));
        jLabel18.setForeground(new java.awt.Color(29, 13, 13));
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, 70, 67));
        jLabel18.setSize(100, 100);

        jLabel19.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel19.setText("Name");
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel20.setText("Type");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel21.setText("jLabel21");
        jPanel15.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel22.setText("jLabel22");
        jPanel15.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 62, -1, -1));

        jLabel28.setBackground(new java.awt.Color(13, 12, 18));
        jLabel28.setFont(new java.awt.Font("Bitstream Charter", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(50, 41, 41));
        jLabel28.setText("ALL POSTS");

        jPanel16.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(195, 6, 6));
        jLabel29.setForeground(new java.awt.Color(29, 13, 13));
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, 70, 67));
        jLabel18.setSize(100, 100);

        jLabel30.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel30.setText("Name");
        jPanel16.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel31.setText("Type");
        jPanel16.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel32.setText("jLabel21");
        jPanel16.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel33.setText("jLabel22");
        jPanel16.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 62, -1, -1));

        jPanel17.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setBackground(new java.awt.Color(195, 6, 6));
        jLabel34.setForeground(new java.awt.Color(29, 13, 13));
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, 70, 67));
        jLabel18.setSize(100, 100);

        jLabel35.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel35.setText("Name");
        jPanel17.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel36.setText("Type");
        jPanel17.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel37.setText("jLabel21");
        jPanel17.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel38.setText("jLabel22");
        jPanel17.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 62, -1, -1));

        jPanel18.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setBackground(new java.awt.Color(195, 6, 6));
        jLabel39.setForeground(new java.awt.Color(29, 13, 13));
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, 70, 67));
        jLabel18.setSize(100, 100);

        jLabel40.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel40.setText("Name");
        jPanel18.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel41.setText("Type");
        jPanel18.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel42.setText("jLabel21");
        jPanel18.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel43.setText("jLabel22");
        jPanel18.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 62, -1, -1));

        jPanel19.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setBackground(new java.awt.Color(195, 6, 6));
        jLabel44.setForeground(new java.awt.Color(29, 13, 13));
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, 70, 67));
        jLabel18.setSize(100, 100);

        jLabel45.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel45.setText("Name");
        jPanel19.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel46.setText("Type");
        jPanel19.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel47.setText("jLabel21");
        jPanel19.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel48.setText("jLabel22");
        jPanel19.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 62, -1, -1));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel28)))
                .addGap(39, 39, 39))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel14);

        jLabel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(161, 33, 33));
        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(647, 647, 647)
                        .addComponent(jButton1)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername)
                            .addComponent(jLabel16)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/inuaMkulima", "inuaMkulima", "admin");
            String query = ("UPDATE INUAMKULIMA.USERS SET Status = ? WHERE Status = ?");
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "offline");
            pst.setString(2, "online");
            pst.executeUpdate();
            new Login().setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();

        }
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}

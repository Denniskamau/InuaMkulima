/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inua_mkulima;

/**
 *
 * @author SAM
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
public class officer extends JFrame implements ActionListener {


public officer(){
        JMenuBar menubar =new JMenuBar();
        JMenu post =new JMenu("POST");
        post.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
               postWindow();
            }

            @Override
            public void menuDeselected(MenuEvent me) {
                
            }

            @Override
            public void menuCanceled(MenuEvent me) {
                
            }
        });
        JMenu inbox =new JMenu("INBOX");
        post.addActionListener(this);
        
     
        
        menubar.add(post);
           menubar.add(inbox);
           setJMenuBar(menubar);
           
           JToolBar toolbar =new JToolBar();
           toolbar.setFloatable(false);
           
            Container container=getContentPane();
    container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS ));
    JLabel msg=new JLabel("what are the best fertilizers??");
    container.add(msg);
    
    JButton replyBtn=new JButton("reply");
    replyBtn.addActionListener(this);
    replyBtn.setToolTipText("click to reply");
    container.add(replyBtn);
    
    JLabel msg1=new JLabel("what are the best markets??");
    container.add(msg1);
   //  JTextField textfield=new JTextField("reply message");
   // container.add(textfield);
     replyBtn=new JButton("reply");
    replyBtn.addActionListener(this);
    replyBtn.setToolTipText("click to reply");
    container.add(replyBtn);
           
           setSize(650,600);
           setTitle("Agricultural Officer Menu");
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocationRelativeTo(null);
}    
public void postWindow(){
     Container container1=getContentPane();
            JLabel post=new JLabel("post");
              container1.add(post);
           JToolBar toolbar =new JToolBar();
           toolbar.setFloatable(false);
           
           //statusbar.setPreferredSize(new Dimension(-1, 22));
           //add(statusbar, BorderLayout.SOUTH);
           
           setSize(550,500);
           setTitle("POST NEW CONTENT");
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocationRelativeTo(null);
           
             
           
        

 
}
public void actionPerformed(ActionEvent evt) {
       String replyMsg = evt.getActionCommand();
       String Msg=JOptionPane.showInputDialog(null, replyMsg);
      String[] messages = null;
      if(Msg!=null){
          messages=new String[]{Msg };
      } 
     else {
           JOptionPane.showMessageDialog(null, "please input a message reply");
    }
      System.out.println(Arrays.toString(messages));
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
         officer ex=new officer();
      ex.setVisible(true);
    }

}

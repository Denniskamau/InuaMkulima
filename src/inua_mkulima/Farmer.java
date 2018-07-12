import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;


public class Farmer  extends JFrame{
    private JLabel statusbar;
    private JLabel messageLabel;
    private JButton btnSubmit;
    private JTextField txtField ;
    // Message arraylist
    ArrayList<String> posts = new ArrayList<String>();
    ArrayList<String> officerMessages = new ArrayList<String>();
    public Farmer() {
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





        //add the menu to the menu bar and set the menubar for this frame
        menubar.add(post);
        menubar.add(inbox);
        menubar.add(talkToOfficer);
        menubar.add(market);
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


    public static void main(String[] args) {
        // TODO code application logic here
        Farmer ex = new Farmer();
        ex.setVisible(true);
    }


}
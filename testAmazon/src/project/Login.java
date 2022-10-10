package project;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import Deo.BaseDonneDeoImp;
import Deo.DataAcces;
import Model.BaseDonne;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;




public class Login extends JFrame{
    JPanel pE,Basic;
    Toolkit tool;
    Image icone;
    private static String username;
    private static String password;
        public Login(int Largeur, int Hauteur, String title){
            super(title);
            setSize(Largeur, Hauteur);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);

            tool= Toolkit.getDefaultToolkit();
            setIconImage(tool.getImage("src\\images\\ebook.jpg"));

            Basic = new JPanel(new BorderLayout());
            pE = new JPanel(new GridLayout(3,2,5,5));
            pE.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            pE.setPreferredSize(new Dimension(200,100));
            pE.setBackground(Color.CYAN);
            JLabel username = new JLabel(" Username");
            username.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            JTextField txtE = new JTextField();
            pE.add(username);
            pE.add(txtE);

            JLabel pass = new JLabel(" Password");
            pass.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            JPasswordField txtP = new JPasswordField();
            pE.add(pass);
            pE.add(txtP);

            JLabel check = new JLabel();

            JButton entre = new JButton("  Log in ");
            entre.setMnemonic(KeyEvent.VK_ENTER);
            JButton SignUp = new JButton("  Create new account ");
            JButton amnesia = new JButton("Forgot your password");
            CustomButton(entre);
            CustomButton(SignUp);
            CustomButton(amnesia);
            pE.add(entre);
            pE.add(SignUp);

            entre.addActionListener(Event->{
                try {
                    List<BaseDonne> list = new BaseDonneDeoImp().getUsers();
                    Map<String,String> map= new HashMap<String,String>();
                    for (BaseDonne users : list) {
                        map.put(users.getUsername(), users.getPassword());
                    }
                    if(map.containsKey(txtE.getText())){
                        String valUser= map.get(txtE.getText());                        
                        if(valUser.equals(new String(txtP.getPassword()))){
                            setUsername(txtE.getText());
                            setPassword(valUser);
                            DataAcces.getConnection();
                            Designs design = null;
                            try{
                                design = new Designs(800, 600, "Ebook interface");
                                setVisible(false);
                            }catch(Exception ex){
                                JOptionPane.showMessageDialog(null,ex.getMessage());
                            }
                        }else{
                            check.setText(" Username or password invalid");
                            revalidate();
                            repaint();
                        }
                    }else{
                        check.setText(" Username not found");
                        revalidate();
                        repaint();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            });

            SignUp.addActionListener(Event->{
                try {
                    new Signup(425, 450, "Create new account");
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            });

            amnesia.addActionListener(Event->{
                new Amnesia(400, 200, " Update Password ");
            });

            Basic.add(check, BorderLayout.NORTH);
            Basic.add(pE, BorderLayout.CENTER);
            Basic.add(amnesia, BorderLayout.SOUTH);
            add(Basic);
            setResizable(false);
        }

        public static String getPassword() {
            return password;
        }
        
        public static void setPassword(String password) {
            Login.password = password;
        }
        public static String getUsername() {
            return username;
        }
        public static void setUsername(String username) {
            Login.username = username;
        }

        public class Amnesia extends JFrame{
            JPanel pE,Basic;
            String valUser;
            String valSerial;
            Toolkit tool;
            Image icone;
                public Amnesia(int Largeur, int Hauteur, String title){
                    super(title);
                    setSize(Largeur, Hauteur);
                    setLocationRelativeTo(null);
                    addWindowListener(new WindowAdapter(){
                        public void windowClosing(WindowEvent windowEvent){
                            setVisible(false);
                         } 
                    });
                    setVisible(true);
        
                    tool= Toolkit.getDefaultToolkit();
                    setIconImage(tool.getImage("src\\images\\ebook.jpg"));

                    Basic = new JPanel(new BorderLayout());
                    pE = new JPanel(new GridLayout(5,2,5,5));
                    pE.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    pE.setPreferredSize(new Dimension(200,100));
                    pE.setBackground(Color.CYAN);
                    JLabel username = new JLabel("  Username");
                    username.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                    JTextField txtE = new JTextField();
                    pE.add(username);
                    pE.add(txtE);
        
                    
        
                    JLabel serial = new JLabel("  Serial code ");
                    serial.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                    JTextField txtSer = new JTextField();
                    pE.add(serial);
                    pE.add(txtSer);
        
                    JLabel pass = new JLabel("  New Password");
                    pass.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                    JPasswordField txtP = new JPasswordField();
        
                    JLabel pass2 = new JLabel("  Confirm New password ");
                    pass2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                    JPasswordField txtP2 = new JPasswordField();
        
                    JLabel check = new JLabel();
        
                    JButton enter = new JButton("  Enter ");
                    enter.setMnemonic(KeyEvent.VK_ENTER);
                    JButton update = new JButton("  Update ");
                    update.setMnemonic(KeyEvent.VK_ENTER);
                    JButton close = new JButton("  Close ");
                    CustomButton(enter);
                    CustomButton(update);
                    CustomButton(close);
                    pE.add(enter);
                    pE.add(close);
        
                    enter.addActionListener(event->{
                        List<BaseDonne> list;
                        try {
                            list = new BaseDonneDeoImp().getUsers();
                            Map<String,String> map= new HashMap<String,String>();
                            for (BaseDonne users : list) {
                                map.put(users.getUsername(), users.getSerialCode());
                            }

                            if(map.containsKey(txtE.getText())){
                                
                                valSerial= map.get(txtE.getText());                        
                                if(valSerial.contentEquals(txtSer.getText())){
                                    valUser= txtE.getText();
                                    check.setText("  Enter a new password  ");
                                    pE.remove(enter);
                                    pE.remove(close);
                                    pE.remove(serial); 
                                    pE.remove(txtSer);
                                    pE.remove(username);
                                    pE.remove(txtE); 
                                    pE.add(pass);
                                    pE.add(txtP);
                                    pE.add(pass2);
                                    pE.add(txtP2);
                                    pE.add(update);
                                    pE.add(close);
                                    revalidate();
                                    repaint();                       
                                }else{
                                    check.setText(" Username or Serial code invalid");
                                    revalidate();
                                    repaint();
                                }
                            }
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                
                    });
        
                    close.addActionListener(Event->{
                        setVisible(false);
                    });
        
                    update.addActionListener(event->{
                        String passw= new String(txtP.getPassword());
                        String passw2= new String(txtP2.getPassword());
                        if(passw.length()<8){
                            check.setText(" Password must contain at least 8 characters ");
                            revalidate();
                            repaint();
                        }else{
                        if (passw.equals(passw2)) {
                            BaseDonne user = BaseDonne.builder()
                            .username(valUser)
                            .password(passw)
                            .serialCode(valSerial)
                            .build();
                            BaseDonneDeoImp updatePass = new BaseDonneDeoImp();
                            updatePass.updatePassword(user);
                            check.setText("  Password Successfully Changed ");
                            revalidate();
                            repaint();
                        }else{
                            check.setText(" The two passwords are different ");
                            revalidate();
                            repaint();
                        }
                    }
                        
                    });
        
                    Basic.add(check, BorderLayout.NORTH);
                    Basic.add(pE, BorderLayout.CENTER);
                    add(Basic);
                    setResizable(false);
                }
            
            }

            public class Signup extends JFrame{
                JPanel pE,Basic;
                Toolkit tool;
                Image icone;
                UtilDateModel model;
                JDatePanel datePanel;
                JDatePicker datePicker;
                static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                    public Signup(int Largeur, int Hauteur, String title) throws ParseException{
                        super(title);
                        setSize(Largeur, Hauteur);
                        setLocationRelativeTo(null);
                        addWindowListener(new WindowAdapter(){
                            public void windowClosing(WindowEvent windowEvent){
                                setVisible(false);
                             } 
                        });
                        setVisible(true);
            
                        tool= Toolkit.getDefaultToolkit();
                        setIconImage(tool.getImage("src\\images\\ebook.jpg"));

                        Basic = new JPanel(new BorderLayout());
                        pE = new JPanel(new GridLayout(9,2,5,5));
                        pE.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                        pE.setPreferredSize(new Dimension(200,100));
                        pE.setBackground(Color.CYAN);

                        JLabel prenom = new JLabel("  Fist Name");
                        prenom.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        JTextField txtprenom = new JTextField();
                        pE.add(prenom);
                        pE.add(txtprenom);

                        JLabel nom = new JLabel("  Last Name");
                        nom.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        JTextField txtnom = new JTextField();
                        pE.add(nom);
                        pE.add(txtnom);

                        JLabel username = new JLabel("  Username");
                        username.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        JTextField txtE = new JTextField();
                        pE.add(username);
                        pE.add(txtE);

                        JLabel emailBox = new JLabel("  Email");
                        emailBox.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        JTextField txtemailBox = new JTextField();
                        pE.add(emailBox);
                        pE.add(txtemailBox);
            
                        JLabel pass = new JLabel("  Password");
                        pass.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        JPasswordField txtP = new JPasswordField();
                        pE.add(pass);
                        pE.add(txtP);
            
                        JLabel pass2 = new JLabel("  Confirm password ");
                        pass2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        JPasswordField txtP2 = new JPasswordField();
                        pE.add(pass2);
                        pE.add(txtP2);

                        JLabel dateNaiss = new JLabel("  Date of Birth ");
                        dateNaiss.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        model = new UtilDateModel();
                        datePanel = new JDatePanel(model);
                        datePicker = new JDatePicker();
                        datePicker.add(datePanel);
                        pE.add(dateNaiss);
                        pE.add(datePicker);

                        JLabel serial = new JLabel("  Serial code ");
                        serial.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                        MaskFormatter mask = new MaskFormatter("AAAAAAAAAA");
                        mask.setPlaceholderCharacter('*');
                        JFormattedTextField txtSer = new JFormattedTextField(mask);
                        pE.add(serial);
                        pE.add(txtSer);
            
                        JLabel check = new JLabel();
            
                        JButton SignUp = new JButton("  Create the account ");
                        SignUp.setMnemonic(KeyEvent.VK_ENTER);
                        JButton close = new JButton("  Close ");
                        CustomButton(SignUp);
                        CustomButton(close);
                        pE.add(SignUp);
                        pE.add(close);
            
                        SignUp.addActionListener(event->{
                            String usern= txtE.getText();
                            String passw= new String(txtP.getPassword());
                            String passw2= new String(txtP2.getPassword());
                            String serialcode= new String(txtSer.getText());
                            String fistname= new String(txtprenom.getText());
                            String lastname= new String(txtnom.getText());
                            String emailS= new String(txtemailBox.getText());
                            DateModel<?> date = datePicker.getModel();
                            String dateString = date.getMonth()+"/"+date.getDay()+"/"+date.getYear(); 
                            List<BaseDonne> UserName;
                            List<String> listUsers= new LinkedList<>();
                            try {
                                UserName = new BaseDonneDeoImp().getUsers();
                                for (BaseDonne usernames : UserName) {
                                    listUsers.add(usernames.getUsername());
                                }
                                if(listUsers.contains(usern)){
                                    check.setText(" Invalid username ");
                                    revalidate();
                                    repaint();
                                }else{
                                    if(emailS.matches(EMAIL_PATTERN)){
                                    if(passw.length()<8){
                                        check.setText(" Password must contain at least 8 characters ");
                                        revalidate();
                                        repaint();
                                    }else{
                            if (passw.equals(passw2)) {
                                BaseDonne user = BaseDonne.builder()
                                .username(usern)
                                .password(passw)
                                .serialCode(serialcode)
                                .lastNameU(lastname)
                                .firstNameU(fistname)
                                .Birthday(dateString)
                                .Email(emailS)
                                .build();
                                BaseDonneDeoImp insert = new BaseDonneDeoImp();
                                insert.insertUser(user);
                                check.setText(" User data are successfully inserted ");
                                revalidate();
                                repaint();
                            }else{
                                check.setText(" The two passwords are different ");
                                revalidate();
                                repaint();
                            }
                        }
                }else{
                    check.setText(" Invalid email ");
                    revalidate();
                    repaint();
                }
            }
                        }catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        });
            
                        close.addActionListener(Event->{
                            setVisible(false);
                        });
            
                        Basic.add(check, BorderLayout.NORTH);
                        Basic.add(pE, BorderLayout.CENTER);
                        add(Basic);
                        setResizable(false);
                    }
                } 
                public  static void CustomButton(JButton btn){
                    btn.setBackground(Color.CYAN);
                    btn.setBorderPainted(false);
                }  
                       
        public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run(){
                    new Login(375, 195,"Username");
                }
            });
        }
}


package project;

import javax.script.ScriptException;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Deo.BaseDonneDeoImp;
import Model.BaseDonne;
import automation.pageObject.LoginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Enumeration;
import java.awt.Toolkit;

public class Designs extends JFrame {
    JPanel pD, startPanel, pE;
    Toolkit tool;
    Image icone;
    public static JProgressBar progress;
    private static String Email;
    private static String password;
    JButton upload, insert, update, delete;
    JTabbedPane tp;
    JToolBar toolbar1;
    TableRowSorter<TableModel> sort;
    JTable table;
    BaseDonneDeoImp allBooks;
    JTextField find;
    ButtonGroup groupCat;
    public static Thread thread;
    int[] rows;
    public Designs(int Largeur, int Hauteur, String title) throws SQLException{
        super(title);
        setSize(Largeur, Hauteur);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        tool= Toolkit.getDefaultToolkit();
        setIconImage(tool.getImage("src\\images\\ebook.jpg"));
 
        startPanel=new JPanel(new GridLayout(15,1,5,5));
        JPanel panelChoose = new JPanel(new GridLayout(1,3,5,5));
        
        JLabel browser= new JLabel("  Select Your Browser");
        JRadioButton chrome = new JRadioButton("  Google Chrome");
        JRadioButton firefox = new JRadioButton("  Firefox");
        JRadioButton edge = new JRadioButton("  Edge", true);
        groupCat = new ButtonGroup();
        groupCat.add(chrome);
        groupCat.add(firefox);
        groupCat.add(edge);
        upload = new JButton("Upload");
        upload.setBorderPainted(false);
        panelChoose.add(chrome);
        panelChoose.add(firefox);
        panelChoose.add(edge);

        JLabel Info = new JLabel("   Log in to your Amazon account  ");
        pE = new JPanel(new GridLayout(1,2,5,5));
            pE.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            pE.setPreferredSize(new Dimension(200,100));
            JLabel email = new JLabel("Email");
            email.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            JTextField txtE = new JTextField();
            

            JLabel pass = new JLabel("Password");
            pass.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            JPasswordField txtP = new JPasswordField();
            

            JButton entre = new JButton("Sign Up");
            entre.setBorderPainted(false);
            JLabel check= new JLabel();
            pE.add(entre);
            pE.add(check);
            entre.addActionListener(Event->{
                String emailS = txtE.getText();
                String passwordS = new String(txtP.getPassword());
                if(!emailS.matches(Login.Signup.EMAIL_PATTERN) || passwordS.length()<8){
                      check.setText(" Email or Password invalid ");
                      revalidate();
                      repaint();
                  }else{
                   setEmail(emailS);
                   setPassword(passwordS);
                   check.setText("  Email and password saved  ");
                   revalidate();
                   repaint();
                  }
            });

        startPanel.add(browser);
        startPanel.add(panelChoose);
        startPanel.add(Info);
        startPanel.add(email);
        startPanel.add(txtE);
        startPanel.add(pass);
        startPanel.add(txtP);
        startPanel.add(pE);
        startPanel.add(upload);
        startPanel.setBackground(Color.CYAN);
        for (int index = 0; index < 4; index++) {
          startPanel.add(new JLabel());
        }
    
        toolbar1 = new JToolBar(JToolBar.HORIZONTAL);
        toolbar1.setRollover(true);
        toolbar1.setLayout(new GridLayout(4,1,5,5));                
        
        pD = new JPanel(new BorderLayout());
        allBooks = new BaseDonneDeoImp();
        
        String columns[] = {"ID", "Language", "BookTitle", "Subtitle", "FirstName", 
        "MiddleName", "LastName", "Description", "Publishing Rights", "Keyword1", 
        "Keyword2", "Keyword3", "Keyword4", "Keyword5", "Keyword6", "Keyword7", 
        "Categorie1", "Categorie2", "Large Print", "Adult Content", "Book Content", 
        "Book Cover", "Barcode", "Price", "Bleed Stings", "printISBN", "ISBN", 
        "imprint", "InkPaper", "Coverfinish", "Marketplace", "Date"};          
        
        DefaultTableModel model = new DefaultTableModel();
        for (int index = 0; index < columns.length; index++) {
          model.addColumn(columns[index]);
        }

        for(BaseDonne data: allBooks.findAll()){
          model.addRow(new Object[]{
            data.getID(),
            data.getLanguage(),
            data.getBookTitle(),
            data.getSubtitle(),
            data.getFirstName(),
            data.getMiddleName(),
            data.getLastName(),
            data.getDescription(),
            data.getPublishingRights(),
            data.getKeywords()[0],
            data.getKeywords()[1],
            data.getKeywords()[2],
            data.getKeywords()[3],
            data.getKeywords()[4],
            data.getKeywords()[5],
            data.getKeywords()[6],
            data.getCategories()[0],
            data.getCategories()[1],
            data.getLargePrint(),
            data.getAdultContent(),
            data.getBookContent(),
            data.getBookCover(),
            data.getBarcode(),
            data.getPrice(),
            data.getBleedStings(),
            data.getPrintISBN(),
            data.getISBN(),
            data.getImprint(),
            data.getInkPaper(),
            data.getCoverfinish(),
            data.getMarketplace(),
            data.getDate()

          });
        }
        ImageIcon ebookImage = new ImageIcon("src\\images\\Ebooks.jpg");
        table = new JTable(model){
          Image img3 = ebookImage.getImage();
          {setOpaque(false);}
          public void paintComponent(Graphics graphics) 
          {
            graphics.drawImage(img3, 0, 0,1300, 755, this);
            super.paintComponent(graphics);
          }
        };
        find = new JTextField();
        sort = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sort);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setEnabled(true);
        table.setBackground(UIManager.getColor("Button.hightlight"));
        table.setSurrendersFocusOnKeystroke(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setColumnSelectionAllowed(true);
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane pane = new JScrollPane(table);
        pD.add(pane, BorderLayout.CENTER);

        find.getDocument().addDocumentListener(new DocumentListener()
        {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String str = find.getText();
                    if (str.trim().length() == 0) {
                        sort.setRowFilter(null);
                    } else {
                        sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    String str = find.getText();
                    if (str.trim().length() == 0) {
                        sort.setRowFilter(null);
                    } else {
                        sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {}
                
            });
            pD.add(find, BorderLayout.NORTH);

        insert = new JButton("Insert");
        update = new JButton("Update");
        delete = new JButton("Delete");
        JButton logout = new JButton("Log out");
        Login.CustomButton(insert);
        Login.CustomButton(update);
        Login.CustomButton(delete);
        Login.CustomButton(logout);
        upload.setBackground(Color.cyan);

        upload.addActionListener(event->{
          rows= table.getSelectedRows();
          if(!check.getText().contains("Email and password saved"))
            check.setText(" Enter your email address ");
          else if(rows.length<0)
                 check.setText(" Select a row ");
          else{
              thread = new Thread(){
                public void run(){
                  try {
                    if(progress !=null){
                      startPanel.remove(progress);
                      progress = null;
                    }
                    progress = new JProgressBar(0, 35);
                    progress.setValue(0);
                    progress.setStringPainted(true);
                    startPanel.add(progress);
                    revalidate();
                    repaint();
                    for (int index = 0; index < rows.length; index++) {
                      new LoginPage(model, rows[index], getSelectedButtonText(groupCat));
                    }
                  } catch (ScriptException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                  }
              }
              };
              thread.start();
            }
        });

        logout.addActionListener(event->{
          new Login(350, 150,"username");
          setVisible(false);
        });

        insert.addActionListener(event->{
          try {
            new InsertEbook(0, " Insert Ebook ", model, table);
          } catch (ParseException e1) {
            JOptionPane.showMessageDialog(pD, e1.getMessage());
          }
        });

        delete.addActionListener(event->{
          int i= table.getSelectedRow();
          int id= (int) model.getValueAt(i, 0);
          int count= allBooks.deleteById(id);
          if(count>0) model.removeRow(i);
        });

        update.addActionListener(event->{
          int i= table.getSelectedRow();
          int id= (int) model.getValueAt(i, 0);
          UpdateEbook updateeBook;
          try {
            updateeBook = new UpdateEbook(id, " Update Ebook ", model, table);
            updateeBook.setData(id);
          } catch (ParseException e1) {
            JOptionPane.showMessageDialog(pD, e1.getMessage());
          }
        });

        toolbar1.add(insert);
        toolbar1.add(update);
        toolbar1.add(delete);
        toolbar1.add(logout);


        pD.add(toolbar1, BorderLayout.SOUTH);

        tp=new JTabbedPane();
        tp.setBounds(5,5,800,600);  
        tp.add("table",pD);  
        tp.add("start",startPanel);  
        add(tp);

    }

    public static String getPassword() {
      return password;
    }
    public static void setPassword(String password) {
      Designs.password = password;
    }
    public static String getEmail() {
      return Email;
    }
    public static void setEmail(String username) {
      Designs.Email = username;
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
      for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
          AbstractButton button = buttons.nextElement();

          if (button.isSelected()) {
              return button.getText();
          }
      }
      return null;
    }
}

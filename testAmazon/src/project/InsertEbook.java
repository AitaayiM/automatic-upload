package project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.UtilDateModel;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;

import Deo.BaseDonneDeoImp;
import Model.BaseDonne;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Image;
 
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;



public class InsertEbook extends JFrame {  
    Toolkit toolkit, tool;
     JButton sauvegarder, annuler, sauvegarderfile2, sauvegarderfile;
     JFileChooser fs1, fs2;
     JToolBar toolbar;
     JPanel p;
     JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt71, txt72, txt73, txt74, txt75, txt76, txt77, txtimprint;
     JTextArea lab6;
     JFormattedTextField txt8, txtisbn;
     MaskFormatter maskPrix, mask;
     JComboBox<String> choixLangue, choixInk, choixfin, choixmar, choixbs;
     JLabel labisbn, imprint;
     JCheckBox pr, lp, ac, pISBN, bc;
     CategoriesPane categories;
     JLabel labelCat1;
     JLabel labelCat2;
     UtilDateModel dateModel;
     JDatePanel datePanel;
     JDatePicker datePicker;
     Image icone;
     JPanel details;
     JPanel content; 
     JPanel publishing; 
    

     public InsertEbook(int id, String titre, DefaultTableModel model, JTable table) throws ParseException{
         super(titre);

        toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        tool= Toolkit.getDefaultToolkit();
        setIconImage(tool.getImage("src\\images\\ebook.jpg"));

        details=new JPanel();
        details.setLayout(new GridLayout(16,2,5,5)); 
        panelManager(details);
        content=new JPanel(); 
        content.setLayout(new GridLayout(13,2,5,5));  
        panelManager(content);
        publishing=new JPanel(); 
        publishing.setLayout(new GridLayout(15,2,5,5));  
        panelManager(publishing);

        toolbar = new JToolBar(JToolBar.HORIZONTAL);

        JLabel labLangue = new JLabel("Language");
        labLangue.setAlignmentX(Component.LEFT_ALIGNMENT);
        labLangue.setBorder(LineBorder.createGrayLineBorder());
        labLangue.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        String[] langues = {"English","German","French","Spanish","Italian","Portuguese","Dutch","Japanese","Afrikaans","Alsatian","Basque","Bokmål Norwegian","Breton","Catalan","Cornish","Corsican","Danish","Eastern Frisian","Finnish","Frisian","Galician","Hebrew","Icelandic","Irish","Latin","Luxembourgish","Manx","Northern Frisian","Norwegian","Nynorsk Norwegian","Provençal","Romansh","Scots","Scottish Gaelic","Swedish","Welsh","Yiddish"};
        choixLangue = new JComboBox<String>(langues);
        choixLangue.setSelectedIndex(-1);
        details.add(labLangue);
        details.add(choixLangue);

     JLabel lab1 = new JLabel("Book title");
     txt1 = new JTextField();

     lab1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     details.add(lab1);
     details.add(txt1);
        
     JLabel lab2 = new JLabel("Subtitle");
     lab2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     txt2 = new JTextField("");
     details.add(lab2);
     details.add(txt2);

     JLabel lab3 = new JLabel("First name");
     lab3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     txt3 = new JTextField();
     details.add(lab3);
     details.add(txt3);

     JLabel lab4 = new JLabel("Middle Name");
     lab4.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     txt4 = new JTextField("");
     details.add(lab4);
     details.add(txt4);

     JLabel lab5 = new JLabel("Last Name");
     lab5.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     txt5 = new JTextField();
     details.add(lab5);
     details.add(txt5);

     JLabel lab61 = new JLabel("description");
     lab61.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     details.add(lab61);
     lab6 = new JTextArea("Tapez votre description ici",10,30);
     lab6.selectAll();
     lab6.setPreferredSize(new Dimension(200,20));
     lab6.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     lab6.setLineWrap(true);
     lab6.setWrapStyleWord(true);
     JScrollPane descSP = new JScrollPane();
     descSP.getViewport().add(lab6);
     details.add(descSP);

     JLabel lab7 = new JLabel("Keywords");
     lab7.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     txt71 = new JTextField("");
     txt72 = new JTextField("");
     txt73 = new JTextField("");
     txt74 = new JTextField("");
     txt75 = new JTextField("");
     txt76 = new JTextField("");
     txt77 = new JTextField("");
     details.add(lab7);
     details.add(txt71);
     details.add(txt72);
     details.add(txt73);
     details.add(txt74);
     details.add(txt75);
     details.add(txt76);
     details.add(txt77);

     pr = new JCheckBox(" This is a public domain work ");
     details.add(pr);

     lp = new JCheckBox("Large print");
     details.add(lp);

     ac = new JCheckBox(" Inappropriate for children under 18 years of age?");
     details.add(ac);
     details.add(new JLabel());

     JLabel labCat = new JLabel("Categories");
     labCat.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     JButton btnCat = new JButton("Choose Categories");
     btnCat.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     btnCat.addActionListener(Event->{
         categories = new CategoriesPane();
     });
     details.add(labCat);
     details.add(btnCat);  
     labelCat1 = new JLabel();
     labelCat2 = new JLabel();
     details.add(labelCat1);
     details.add(labelCat2);

     JLabel labbs = new JLabel("Bleed Settings");
     labbs.setForeground(new Color(50, 50, 25));
     labbs.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     String[] bs = {"No Bleed","Bleed (PDF only)"};
     choixbs = new JComboBox<String>(bs);
     content.add(labbs);
     content.add(choixbs);

     JLabel lab9 = new JLabel("Ink and Paper");
     lab9.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     String[] Ink = {"BlackWhiteCream","BlackWhiteWhite","StandardColor","PremiumColor"};
     choixInk = new JComboBox<String>(Ink);
     content.add(lab9);
     content.add(choixInk);

     JLabel lab10 = new JLabel("Cover finish");
     lab10.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     String[] finish = {"Glossy","Matte"};
     choixfin = new JComboBox<String>(finish);
     content.add(lab10);
     content.add(choixfin);

     JLabel lab12 = new JLabel("Book Cover");
     lab12.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     content.add(lab12);
     sauvegarderfile = new JButton("File");
     sauvegarderfile.addActionListener(Event->{
         fs1 = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Book Cover","JPG","GIM","PDF");
         fs1.setFileFilter(filter);
         int choix= fs1.showOpenDialog(p);
         if(choix == JFileChooser.APPROVE_OPTION)
         sauvegarderfile.setText(fs1.getName(fs1.getSelectedFile()));
     });
     content.add(sauvegarderfile);

     JLabel lab122 = new JLabel("Book Content");
     lab122.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     content.add(lab122);
     sauvegarderfile2 = new JButton("File");
     sauvegarderfile2.addActionListener(Event->{
         fs2 = new JFileChooser();
         FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Book Content","PDF","RTF","DOC","DOCX","HTML");
         fs2.setFileFilter(filter1);
         int choix2= fs2.showOpenDialog(p);
         if(choix2 == JFileChooser.APPROVE_OPTION)
         sauvegarderfile2.setText(fs2.getName(fs2.getSelectedFile()));
     });
     content.add(sauvegarderfile2);

     JLabel labDate = new JLabel("publication date");
     labDate.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     content.add(labDate);

     dateModel = new UtilDateModel();
     datePanel = new JDatePanel(dateModel);
     datePicker = new JDatePicker();
     datePicker.add(datePanel);
     content.add(datePicker);
     
     bc = new JCheckBox("Does your cover include a barcode?");
     content.add(bc);

     pISBN = new JCheckBox(" Use my own ISBN");
     pISBN.setFocusable(false);
     pISBN.addActionListener(Event->{
        try {
            ExtractedISBN(content,pISBN);
        } catch (ParseException e1) {
            JOptionPane.showMessageDialog(content, e1.getMessage());
        }
    });
     content.add(pISBN);

     JLabel lab11 = new JLabel("Market Place");
     lab11.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     String[] Market = {"Amazon.com","Amazon.de","Amazon.fr","Amazon.es","Amazon.it","Amazon.co.jp","Amazon.ca","Amazon.com.au","Amazon.nl","Amazon.co.uk"};
     choixmar = new JComboBox<String>(Market);
     publishing.add(lab11);
     publishing.add(choixmar);

     JLabel lab8 = new JLabel("Princy");
     lab8.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     maskPrix = new MaskFormatter("###.###");
     maskPrix.setPlaceholderCharacter('*');
     txt8 = new JFormattedTextField(maskPrix);
     publishing.add(lab8);
     publishing.add(txt8);

     sauvegarder = new JButton("Finish");
     sauvegarder.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     sauvegarder.addActionListener(Event->{
        int idBook = id ;
        String lang= (String)choixLangue.getSelectedItem();
        Boolean pub =  pr.isSelected();
        Boolean larg= lp.isSelected();
        Boolean adul= ac.isSelected();
        String blee= (String)choixbs.getSelectedItem();
        Boolean pisbn= pISBN.isSelected();
        String isb=null;
        String impr=null;
        if (pisbn) {
           isb= txtisbn.getText();
           impr= txtimprint.getText();
         }
        String bookcr= String.valueOf(fs1.getCurrentDirectory()+"\\"+fs1.getName(fs1.getSelectedFile()));
        String bookct= String.valueOf(fs2.getCurrentDirectory()+"\\"+fs2.getName(fs2.getSelectedFile()));
        Boolean barc= bc.isSelected();
        String titl = txt1.getText();
        String Subtt = txt2.getText();
        String fname = txt3.getText();
        String mname = txt4.getText();
        String lname = txt5.getText();
        String descr = lab6.getText();
        float prix = Float.parseFloat(txt8.getText());
        String ink= (String)choixInk.getSelectedItem();
        String fin = (String)choixfin.getSelectedItem();
        String mar = (String)choixmar.getSelectedItem();
        DateModel<?> date = datePicker.getModel();
        String dateString = date.getMonth()+"/"+date.getDay()+"/"+date.getYear();
        String[] key={txt71.getText() ,txt72.getText(), txt73.getText(), txt74.getText(), txt75.getText(), txt76.getText(), txt77.getText()};
        String[] cats={labelCat1.getText(), labelCat2.getText()};
        BaseDonne bd = BaseDonne.builder()
        .iD(idBook)
        .bookTitle(titl)
        .subtitle(Subtt)
        .firstName(fname)
        .middleName(mname)
        .lastName(lname)
        .description(descr)
        .price(prix)
        .inkPaper(ink)
        .coverfinish(fin)
        .marketplace(mar)
        .keywords(key)
        .categories(cats)
        .language(lang)
        .publishingRights(pub)
        .largePrint(larg)
        .bookContent(pathToString(bookct))
        .bookCover(pathToString(bookcr))
        .barcode(barc)
        .iSBN(isb)
        .adultContent(adul)
        .bleedStings(blee)
        .printISBN(pisbn)
        .imprint(impr)
        .date(dateString)
        .build();
        BaseDonneDeoImp imp= new BaseDonneDeoImp();
        try {
            imp.save(bd);
            updateTableData(model, table);
        } catch (FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

     });   
   

        publishing.add(sauvegarder);
        annuler = new JButton("Close");
        annuler.setBorderPainted(false);
        annuler.addActionListener(event->{
            setVisible(false);
        });
        publishing.add(annuler);

        JTabbedPane tp=new JTabbedPane();  
        tp.setBounds(5,5,575,625); 
        tp.add("Paperback Details",details);  
        tp.add("Paperback Content",content);  
        tp.add("Paperback Rights & Pricing",publishing);  
        tp.revalidate();
        tp.repaint();
        add(tp);  
        
        setLocation((size.width - getWidth())/2, (size.height - getHeight())/2);
        setSize(600,675);  
        setLayout(null);  
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                setVisible(false);
             } 
        });
        setVisible(true);
        setResizable(false);
    
    }

    protected void ExtractedISBN(JPanel content, JCheckBox pISBN) throws ParseException {
        if(labisbn == null){
            labisbn = new JLabel("ISBN");
            labisbn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            mask= new MaskFormatter("#############");
            mask.setPlaceholderCharacter('*');
            txtisbn = new JFormattedTextField(mask);
            imprint = new JLabel("imprint");
            imprint.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            txtimprint = new JTextField();
            content.add(labisbn);
            content.add(txtisbn);
            content.add(imprint);
            content.add(txtimprint);  
           }else{
            content.remove(labisbn);
            content.remove(txtisbn);
            content.remove(imprint);
            content.remove(txtimprint);
               labisbn = null;
               txtisbn = null;
               imprint = null;
               txtimprint = null;
           }   
           revalidate();
           repaint();
        
    }

    public static void panelManager(JPanel panel){
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setBackground(Color.CYAN);
        panel.setToolTipText(" Remplis toutes les données demandées ");
    }

    public void updateTableData(DefaultTableModel model, JTable table) throws SQLException{
        BaseDonneDeoImp allBooks= new BaseDonneDeoImp();
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
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
      table.setModel(model);
      model.fireTableDataChanged();
      table.revalidate();
      table.repaint();
      }
      

    public class CategoriesPane extends JDialog {
    
        JTextField cat1, cat2, cat3;
        JRadioButton zero , un, deux;
     
        public CategoriesPane() {
     
            setTitle(" Categories ");
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent windowEvent){
                    setVisible(false);
                 } 
            });
            toolkit = getToolkit();
            tool= Toolkit.getDefaultToolkit();
            setIconImage(tool.getImage("src\\images\\ebook.jpg"));

     
            JPanel panel = new JPanel();
            JPanel panelBasic = new JPanel(new BorderLayout());
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
     
            JScrollPane pane = new JScrollPane();
            JTextPane textpane = new JTextPane(); 
     
            textpane.setContentType("text/html");
            textpane.setEditable(false);
     
            String cd = "C:\\Users\\Admin\\.vscode\\kdpamazon\\designes\\testAmazon\\src\\project\\Categories.html";     
            try {
                textpane.setPage("File:///" + cd);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
     
            textpane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
     
            pane.getViewport().add(textpane);
            panel.add(pane);
    
            JRadioButton zero = new JRadioButton("Non-Classifiable", true);
            JRadioButton un = new JRadioButton("One category");
            JRadioButton deux = new JRadioButton("Two category");
            ButtonGroup groupCat = new ButtonGroup();
            groupCat.add(zero);
            groupCat.add(un);
            groupCat.add(deux);
            panel.add(zero);
            panel.add(un);
            panel.add(deux);
    
            JButton save= new JButton("Save");
            panelBasic.add(save, BorderLayout.SOUTH);
            panelBasic.add(panel, BorderLayout.CENTER);
    
            zero.addActionListener(Event->extracted(panel, zero));
            un.addActionListener(Event->extracted1(panel, un));
            deux.addActionListener(Event->extracted2(panel, deux));
            save.addActionListener(Event->extractedSave(panel, save));
     
            add(panelBasic);
            setSize(new Dimension(380, 400));
     
            setLocationRelativeTo(null);
            setVisible(true);
     
        }
    
        protected void extractedSave(JPanel panel, JButton save) {
            if(cat1!=null && cat1.getText() !=""){
                labelCat1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                labelCat1.setText("  "+cat1.getText());
                labelCat2.setText("  ");
            }else if(cat2!=null && cat3!=null && cat2.getText() !="" && cat3.getText() !=""){
                labelCat1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                labelCat2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                labelCat1.setText("  "+cat2.getText());
                labelCat2.setText("  "+cat3.getText());
            }else {
                labelCat1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                labelCat1.setText("  Non-Classifiable");
                labelCat2.setText("  ");
            }
            setVisible(false);
        }
    
        protected void extracted(JPanel panel, JRadioButton zero2) {
                if(cat1!=null){
                    panel.remove(cat1);
                    cat1 = null;
                }else if(cat2!=null && cat3!=null){
                    panel.remove(cat2);
                    panel.remove(cat3);
                    cat2 = null;
                    cat3 = null;
                }
                revalidate();
                repaint();
        }
    
        protected void extracted1(JPanel panel, JRadioButton un) {
            if(cat2!=null && cat3!=null) {
                panel.remove(cat2);
                panel.remove(cat3);
                cat2 = null;
                cat3 = null;
            }
            if(cat1 == null){
                cat1 = new JTextField();
                cat1.setToolTipText(" Categorie > SubCategorie > ... ");
                panel.add(cat1);
            }
            revalidate();
            repaint();
        }
    
        protected void extracted2(JPanel panel, JRadioButton deux) {
             if(cat1!=null){
                panel.remove(cat1);
                cat1 = null;
                revalidate();
                repaint();
             }
             if(cat2 == null && cat3 == null){
                cat2 = new JTextField();
                cat3 = new JTextField();
                cat2.setToolTipText(" Categorie > SubCategorie > ...");
                cat3.setToolTipText(" Categorie > SubCategorie > ...");
                panel.add(cat2);
                panel.add(cat3);
            }
            revalidate();
            repaint();
        }
    }

    public String pathToString(String path){
      String URL="";
      String symbol="\\";
      String New=" ";
      for (int index = 0; index < path.length(); index++) {
        if(path.charAt(index)==symbol.charAt(0)){
          URL=URL+index;
          path.replace(path.charAt(index), New.charAt(0));
        }
      }
      return URL+path;
    }

}  

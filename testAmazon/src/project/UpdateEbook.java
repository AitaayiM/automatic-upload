package project;


import java.text.ParseException;
import Deo.BaseDonneDeoImp;
import Model.BaseDonne;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;



public class UpdateEbook extends InsertEbook {  
    public UpdateEbook(int id, String titre, DefaultTableModel model, JTable table) throws ParseException{
        super(id, titre, model, table);
    
    }

    public void setData(int id) throws ParseException{
        BaseDonne  data = new BaseDonne();
        BaseDonneDeoImp imp = new BaseDonneDeoImp();
        data = imp.findById(id);

            choixLangue.setSelectedItem(data.getLanguage());
            choixbs.setSelectedItem(data.getBleedStings());
            choixInk.setSelectedItem(data.getInkPaper());
            choixfin.setSelectedItem(data.getCoverfinish());
            choixmar.setSelectedItem(data.getMarketplace());
            txt1.setText(data.getBookTitle());
            txt2.setText(data.getSubtitle());
            txt3.setText(data.getFirstName());
            txt4.setText(data.getMiddleName());
            txt5.setText(data.getLastName());
            lab6.setText(data.getDescription());
            txt71.setText(data.getKeywords()[0]);
            txt72.setText(data.getKeywords()[1]);
            txt73.setText(data.getKeywords()[2]);
            txt74.setText(data.getKeywords()[3]);
            txt75.setText(data.getKeywords()[4]);
            txt76.setText(data.getKeywords()[5]);
            txt77.setText(data.getKeywords()[6]);
            labelCat1.setText(data.getCategories()[0]);
            labelCat2.setText(data.getCategories()[1]);
            txt8.setText(String.valueOf(data.getPrice()));
            pISBN.setSelected(data.getPrintISBN()==1?true:false);
            bc.setSelected(data.getBarcode()==1?true:false);
            pr.setSelected(data.getPublishingRights()==1?true:false);
            lp.setSelected(data.getLargePrint()==1?true:false);
            ac.setSelected(data.getAdultContent()==1?true:false);
            if(pISBN.isSelected()){
                labisbn = new JLabel("ISBN");
                labisbn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                txtisbn = new JFormattedTextField(mask);
                imprint = new JLabel("imprint");
                imprint.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                txtimprint = new JTextField();
                content.add(labisbn);
                content.add(txtisbn);
                content.add(imprint);
                content.add(txtimprint);
                txtisbn.setText(data.getISBN());
                txtimprint.setText(data.getImprint());
            }
            if(data.getCategories()[0]!="") labelCat2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            if(data.getCategories()[1]!="") labelCat1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

    }

    
}  


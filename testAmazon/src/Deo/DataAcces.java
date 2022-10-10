package Deo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.BaseDonne;

public class DataAcces{

        private static final String HOST = "127.0.0.1";
        private static final int PORT = 3306;
        private static final String BD_NAME = "ebook";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";

        private static Connection connect;

    public static Connection getConnection(){
        try{
            connect = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, BD_NAME), USERNAME, PASSWORD);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return connect;
    }
    public static void create(BaseDonne data){
       
    }

    public static void createPrepared(BaseDonne data) throws FileNotFoundException{
        String query = "INSERT INTO `ebookdata`(`ID`, `Language`, `BookTitle`, `Subtitle`, `FirstName`, `MiddleName`, `LastName`, `Description`, `PublishingRights`, `Keyword1`, `Keyword2`, `Keyword3`, `Keyword4`, `Keyword5`, `Keyword6`, `Keyword7`, `Categorie1`, `Categorie2`, `LargePrint`, `AdultContent`, `BookContent`, `BookCover`, `Barcode`, `Price`, `BleedStings`, `printISBN`, `ISBN`, `imprint`, `InkPaper`, `Coverfinish`, `Marketplace`, `Date`) VALUES('?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?')";
        try(PreparedStatement prestat = connect.prepareStatement(query)) {
            prestat.setString(1, data.getLanguage());
            prestat.setString(2, data.getBookTitle());
            prestat.setString(3, data.getSubtitle());
            prestat.setString(4, data.getFirstName());
            prestat.setString(5, data.getMiddleName());
            prestat.setString(6, data.getLastName());
            prestat.setString(7, data.getDescription());
            prestat.setInt(8, data.getPublishingRights());
            prestat.setString(9, data.getKeywords()[0]);
            prestat.setString(10, data.getKeywords()[1]);
            prestat.setString(11, data.getKeywords()[2]);
            prestat.setString(12, data.getKeywords()[3]);
            prestat.setString(13, data.getKeywords()[4]);
            prestat.setString(14, data.getKeywords()[5]);
            prestat.setString(15, data.getKeywords()[6]);
            prestat.setString(16, data.getCategories()[0]);
            prestat.setString(17, data.getCategories()[1]);
            prestat.setInt(18, data.getLargePrint());
            prestat.setInt(19, data.getAdultContent());

            File file = new File(data.getBookContent());
            FileReader reader = new FileReader(file);
            prestat.setCharacterStream(20, reader, (int)file.length());

            File file2 = new File(data.getBookCover());
            FileReader reader2 = new FileReader(file2);
            prestat.setCharacterStream(21, reader2, (int)file2.length());
            
            prestat.setInt(22, data.getBarcode());
            prestat.setDouble(23, data.getPrice());
            prestat.setString(24, data.getBleedStings());
            prestat.setInt(25, data.getPrintISBN());
            prestat.setString(26, data.getISBN());
            prestat.setString(27, data.getImprint());
            prestat.setString(28, data.getInkPaper());
            prestat.setString(29, data.getCoverfinish());
            prestat.setString(30, data.getMarketplace());
            prestat.setString(31, data.getDate());

            prestat.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                connect.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
          }
        }
    
}
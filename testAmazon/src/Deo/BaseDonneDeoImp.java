package Deo;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.BaseDonne;
import project.Login;

public class BaseDonneDeoImp implements BaseDonneDeo{

    @Override
    public int deleteById(int id) {
        int count= 0;
        Connection con = DataAcces.getConnection();
        if(con == null){
            return count;
        }
        String query = "DELETE FROM ebookdata WHERE id=?";
        try (PreparedStatement prestat = con.prepareStatement(query)) {
            prestat.setInt(1, id);
            if(JOptionPane.showConfirmDialog(null, "   Are you sure you want to delete this E-book ", " Confirm the deletion", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            count = prestat.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return count;
        
    }

    @Override
    public int getIdUser() throws SQLException {
        int id=0;
        Connection con= DataAcces.getConnection();
        String query = "SELECT IDUser FROM users WHERE username=?";
        try(PreparedStatement prestat = con.prepareStatement(query)) {
            prestat.setString(1, Login.getUsername());
            ResultSet result = prestat.executeQuery();
            while (result.next()) {
                id = result.getInt("IDUser");
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return id;
    }


    @Override
    public List<BaseDonne> findAll() throws SQLException {
        Connection con = DataAcces.getConnection();
        if(con == null){
            return null;
        }
        List<BaseDonne> ebooks = new LinkedList<>();
        String query = "SELECT * FROM ebookdata WHERE UserID=?";
        try(PreparedStatement prestat = con.prepareStatement(query)) {
            prestat.setInt(1, getIdUser());
            ResultSet result = prestat.executeQuery();
            while (result.next()) {
                BaseDonne data = BaseDonne.builder()
                .iD(result.getInt("ID"))
                .language(result.getString("Language"))
                .bookTitle(result.getString("BookTitle"))
                .subtitle(result.getString("Subtitle"))
                .firstName(result.getString("FirstName"))
                .middleName(result.getString("MiddleName"))
                .lastName(result.getString("LastName"))
                .description(result.getString("Description"))
                .publishingRights(result.getBoolean("PublishingRights"))
                .keywords(new String[]{result.getString("Keyword1"),result.getString("Keyword2"),result.getString("Keyword3"),result.getString("Keyword4"),result.getString("Keyword5"),result.getString("Keyword6"),result.getString("Keyword7")})
                .categories(new String[]{result.getString("Categorie1"),result.getString("Categorie2")})
                .largePrint(result.getBoolean("LargePrint"))
                .adultContent(result.getBoolean("AdultContent"))
                .bookContent(result.getString("BookContent"))
                .bookCover(result.getString("BookCover"))
                .barcode(result.getBoolean("Barcode"))
                .price(result.getFloat("Price"))
                .bleedStings(result.getString("BleedStings"))
                .printISBN(result.getBoolean("printISBN"))
                .iSBN(result.getString("ISBN"))
                .imprint(result.getString("imprint"))
                .inkPaper(result.getString("InkPaper"))
                .coverfinish(result.getString("Coverfinish"))
                .marketplace(result.getString("Marketplace"))
                .date(result.getString("Date"))
                .build();
                ebooks.add(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                con.close();
            } catch (SQLException ec) {
                JOptionPane.showMessageDialog(null, ec.getMessage());
            }
        }
        return ebooks;
    }

    @Override
    public BaseDonne findById(int id) {
        Connection con = DataAcces.getConnection();
        if(con == null){
            return null;
        }
        String query = "SELECT * FROM ebookdata WHERE id=?";
        try (PreparedStatement prestat= con.prepareStatement(query)) {
            prestat.setInt(1, id);
            ResultSet result = prestat.executeQuery();
            if(result.next()){
                return BaseDonne.builder()
                .iD(result.getInt("ID"))
                .language(result.getString("Language"))
                .bookTitle(result.getString("BookTitle"))
                .subtitle(result.getString("Subtitle"))
                .firstName(result.getString("FirstName"))
                .middleName(result.getString("MiddleName"))
                .lastName(result.getString("LastName"))
                .description(result.getString("Description"))
                .publishingRights(result.getBoolean("PublishingRights"))
                .keywords(new String[]{result.getString("Keyword1"),result.getString("Keyword2"),result.getString("Keyword3"),result.getString("Keyword4"),result.getString("Keyword5"),result.getString("Keyword6"),result.getString("Keyword7")})
                .categories(new String[]{result.getString("Categorie1"),result.getString("Categorie2")})
                .largePrint(result.getBoolean("LargePrint"))
                .adultContent(result.getBoolean("AdultContent"))
                .bookContent(result.getString("BookContent"))
                .bookCover(result.getString("BookCover"))
                .barcode(result.getBoolean("Barcode"))
                .price(result.getFloat("Price"))
                .bleedStings(result.getString("BleedStings"))
                .printISBN(result.getBoolean("printISBN"))
                .iSBN(result.getString("ISBN"))
                .imprint(result.getString("imprint"))
                .inkPaper(result.getString("InkPaper"))
                .coverfinish(result.getString("Coverfinish"))
                .marketplace(result.getString("Marketplace"))
                .date(result.getString("Date"))
                .build();
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                con.close();
            } catch (SQLException ec) {
                JOptionPane.showMessageDialog(null, ec.getMessage());
            }
        }
        return null;
    }

    @Override
    public void save(BaseDonne data) throws FileNotFoundException, SQLException {
        Connection con = DataAcces.getConnection();
        if(con == null){
            return;
        }
        if(data.getID() > 0){
            String query = "UPDATE `ebookdata` SET `Language`='"+data.getLanguage()+"',`BookTitle`='"+data.getBookTitle()+"',`Subtitle`='"+data.getSubtitle()+"',`FirstName`='"+data.getFirstName()+"',`MiddleName`='"+data.getMiddleName()+"',`LastName`='"+data.getLastName()+"',`Description`='"+data.getDescription()+"',`PublishingRights`='"+data.getPublishingRights()+"',`Keyword1`='"+data.getKeywords()[0]+"',`Keyword2`='"+data.getKeywords()[1]+"',`Keyword3`='"+data.getKeywords()[2]+"',`Keyword4`='"+data.getKeywords()[3]+"',`Keyword5`='"+data.getKeywords()[4]+"',`Keyword6`='"+data.getKeywords()[5]+"',`Keyword7`='"+data.getKeywords()[6]+"',`Categorie1`='"+data.getCategories()[0]+"',`Categorie2`='"+data.getCategories()[1]+"',`LargePrint`='"+data.getLargePrint()+"',`AdultContent`='"+data.getAdultContent()+"',`BookContent`='"+data.getBookContent()+"',`BookCover`='"+data.getBookCover()+"',`Barcode`='"+data.getBarcode()+"',`Price`='"+data.getPrice()+"',`BleedStings`='"+data.getBleedStings()+"',`printISBN`='"+data.getPrintISBN()+"',`ISBN`='"+data.getISBN()+"',`imprint`='"+data.getImprint()+"',`InkPaper`='"+data.getInkPaper()+"',`Coverfinish`='"+data.getCoverfinish()+"',`Marketplace`='"+data.getMarketplace()+"',`Date`='"+data.getDate()+"' WHERE `ID`='"+data.getID()+"'" ;
            try(Statement stat=con.createStatement()) {
                int countUp= stat.executeUpdate(query);
                if(countUp>0) JOptionPane.showMessageDialog(null, "Ebook data are successfully updated");  

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                try {
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }else{
            String query = "INSERT INTO ebookdata (UserID, Language, BookTitle, Subtitle, FirstName, MiddleName, LastName, Description, PublishingRights, Keyword1, Keyword2, Keyword3, Keyword4, Keyword5, Keyword6, Keyword7, Categorie1, Categorie2, LargePrint, AdultContent, BookContent, BookCover, Barcode, Price, BleedStings, printISBN, ISBN, imprint, InkPaper, Coverfinish, Marketplace, Date) VALUES ('"+getIdUser()+"','"+data.getLanguage()+"' ,'"+data.getBookTitle()+"' , '"+data.getSubtitle()+"', '"+data.getFirstName()+"', '"+data.getMiddleName()+"','"+data.getLastName()+"', '"+data.getDescription()+"','"+data.getPublishingRights()+"','"+data.getKeywords()[0]+"', '"+data.getKeywords()[1]+"', '"+data.getKeywords()[2]+"', '"+data.getKeywords()[3]+"', '"+data.getKeywords()[4]+"', '"+data.getKeywords()[5]+"', '"+data.getKeywords()[6]+"', '"+data.getCategories()[0]+"','"+data.getCategories()[1]+"', '"+data.getLargePrint()+"', '"+data.getAdultContent()+"', '"+data.getBookContent()+"', '"+data.getBookCover()+"', '"+data.getBarcode()+"','"+data.getPrice()+"', '"+data.getBleedStings()+"', '"+data.getPrintISBN()+"', '"+data.getISBN()+"', '"+data.getImprint()+"', '"+data.getInkPaper()+"', '"+data.getCoverfinish()+"', '"+data.getMarketplace()+"', '"+data.getDate()+"')";    
            try(Statement stat=con.createStatement()){
                int count= stat.executeUpdate(query);
                if(count>0) JOptionPane.showMessageDialog(null, "Ebook data are successfully inserted");     
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
          }
        }
    }

    @Override
    public List<BaseDonne> getUsers() throws SQLException {
        Connection con = DataAcces.getConnection();
        List<BaseDonne> list = new LinkedList<>();
        String query = "SELECT * FROM users";
        try(PreparedStatement prestat = con.prepareStatement(query)){
            ResultSet result = prestat.executeQuery();
            while (result.next()) {
                BaseDonne users= BaseDonne.builder()
                .username(result.getString("username"))
                .password(result.getString("password"))
                .serialCode(result.getString("SerialCode"))
                .lastNameU(result.getString("LastNameU"))
                .firstNameU(result.getString("FirstNameU"))
                .Birthday(result.getString("DateOfBirth"))
                .Email(result.getString("Email"))
                .build();
                list.add(users);
            }
        }
        return list;
    }

    @Override
    public void insertUser(BaseDonne user) {
        Connection con = DataAcces.getConnection();
        String query = "INSERT INTO users(FirstNameU, LastNameU, Email, username, password, DateOfBirth,SerialCode) VALUES('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getUsername()+"', '"+user.getPassword()+"','"+user.getBirthday()+"', '"+user.getSerialCode()+"')";
            try(Statement stat=con.createStatement()){
                stat.executeUpdate(query); 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
          }
    }

    
    @Override
    public void updatePassword(BaseDonne user) {
        Connection con = DataAcces.getConnection();
        String query = " UPDATE users SET password='"+user.getPassword()+"' WHERE username='"+user.getUsername()+"' AND SerialCode='"+user.getSerialCode()+"' ";
            try(Statement stat=con.createStatement()){
                stat.executeUpdate(query);    
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
          }
        
    }

}

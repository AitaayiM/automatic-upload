package automation.pageObject;




import java.time.Duration;

import javax.script.ScriptException;
import javax.swing.table.DefaultTableModel;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automation.baseConfiguration.TestBase;
import project.Designs;

public class DetailsPage extends TestBase{
    
    public DetailsPage(DefaultTableModel model, int row) throws ScriptException{
        PageFactory.initElements(driver, this);
        langue(model, row);
        bookTitle(model, row);
        subTitle(model, row);
        firstName(model, row);
        middleName(model, row);
        lastName(model, row);
        description(model, row);
        publicDomain(model, row);
        keywords(model, row);
        categories();
        category12();
        largePrint(model, row);
        AdultContent(model, row);
        continueToContent();
        content(model, row); 
    }

    @FindBy(id = "data-print-book-language-native")
    WebElement langue;

    @FindBy(id = "data-print-book-title")
    WebElement bookTitle;

    @FindBy(id = "data-print-book-subtitle")
    WebElement subTitle;

    @FindBy(id = "data-print-book-primary-author-first-name")
    WebElement firstName;

    @FindBy(css = "input[placeholder*='Middle name']")
    WebElement middleName;

    @FindBy(css = "input[placeholder*='Last name']")
    WebElement lastName;

    @FindBy(xpath = "//iframe")
    WebElement descriptionFrame;

    @FindBy(css = "body[class*='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    WebElement description;

    @FindBy(id = "non-public-domain")
    WebElement nonPublicDomain;

    @FindBy(id = "public-domain")
    WebElement publicDomain;

    @FindBy(name = "data[print_book][keywords][6]")
    WebElement keyword6;

    @FindBy(id = "data-print-book-categories-button-proto-announce")
    WebElement categories;

    @FindBy(xpath = "//input[@id='checkbox-non--classifiable']")
    WebElement nonClassifiable;

    @FindBy(id = "category-chooser-root-list")
    WebElement list;

    @FindBy(id = "category-chooser-category-1")
    WebElement category1;

    @FindBy(id = "category-chooser-category-2")
    WebElement category2;

    @FindBy(xpath = "(//input[@type='submit'])[5]")
    WebElement saveCategories;

    @FindBy(id = "data-print-book-large-print")
    WebElement largePrint;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    WebElement nonAdultContent;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    WebElement AdultContent;

    @FindBy(id = "save-and-continue-announce")
    WebElement continueToContent;

    @FindBy(id = "save-announce")
    WebElement save;
    
    public void langue(DefaultTableModel model, int row){
        int count=0;
        try {
            customWait(9000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            scrollTo(langue);
            Select langueSelect = new Select(langue);
            langueSelect.selectByValue((String) model.getValueAt(row, 1).toString().toLowerCase());  
            Designs.progress.setValue(8);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            langue(model, row);
        }  
    }
    
    public void bookTitle(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(bookTitle);
            humanWriting((String) model.getValueAt(row, 2), bookTitle);
            Designs.progress.setValue(9);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            bookTitle(model, row);
        }
    }
    
    public void subTitle(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(subTitle);
            String subtitle= (String) model.getValueAt(row, 3);
            if(subtitle !=""){
              humanWriting(subtitle, subTitle);
            }
            Designs.progress.setValue(10);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            subTitle(model, row);
        }
    }
    
    public void firstName(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(firstName);
            humanWriting((String) model.getValueAt(row, 4), firstName);
            Designs.progress.setValue(11);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            firstName(model, row);
        }
    }
    
    public void middleName(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(middleName);
            String middle= (String) model.getValueAt(row, 5);
                if(middle !=""){
                  humanWriting(middle, middleName);
                } 
                Designs.progress.setValue(12);
            } catch (Exception e) {
                stackTrace= new Throwable().getStackTrace()[0];
                refresh(30000, save, count, stackTrace);
            middleName(model, row);
        }
    }
    
    public void lastName(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(lastName);
            humanWriting((String) model.getValueAt(row, 6), lastName);
            Designs.progress.setValue(13);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            lastName(model, row);
        }
    }
    
    public void description(DefaultTableModel model, int row){
        int count=0;
        try {
            driver.switchTo().frame(descriptionFrame);
            humanWriting((String) model.getValueAt(row, 7), description);
            driver.switchTo().defaultContent();
            Designs.progress.setValue(14);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            description(model, row);
        }

    }
    
  

    public void publicDomain(DefaultTableModel model, int row){
        int count=0;
        try {
            if(String.valueOf(model.getValueAt(row, 8)) !="0"){
                scrollTo(publicDomain);
                publicDomain.click();
            }else{
                scrollTo(nonPublicDomain);
                nonPublicDomain.click();
            }
            Designs.progress.setValue(15);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            publicDomain(model, row);
        }
    }
  


    public void keywords(DefaultTableModel model, int row){
        int count=0;
        try {
            WebElement key=null;
            for (int index = 0; index <6; index++) {
                if ((String) model.getValueAt(row, 9+index) !="") {
                  key= driver.findElement(org.openqa.selenium.By.name("data[print_book][keywords]["+index+"]"));
                  humanWriting((String) model.getValueAt(row, 9+index),key);
                }
            }
            Designs.progress.setValue(16);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            keywords(model, row);
        }
    }
    
    public void categories(){
        int count=0;
        try {
            scrollTo(categories);
            categories.click();  
            Designs.progress.setValue(17);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            categories();
        }   
    } 

    public void category12(){
        int count=0;
        try {
            do{
                if(isChecked(nonClassifiable)=="false") nonClassifiable.click(); 
            }while(visibilityOfElementLocated(nonClassifiable) !=null && isChecked(nonClassifiable)=="false");
            saveCategories.click(); 
            Designs.progress.setValue(18);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            category12();
        }     
    }

    public void largePrint(DefaultTableModel model, int row){
        int count=0;
        try {
            if (String.valueOf(model.getValueAt(row, 18)).contains("1")){
                if(isChecked(largePrint)=="false"){
                    scrollTo(largePrint);
                    click(largePrint);
                }   
            } 
            Designs.progress.setValue(19);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            largePrint(model, row);
        }
    }

    public void AdultContent(DefaultTableModel model, int row){
        int count=0;
        try {
            customWait(3000);
            if (String.valueOf(model.getValueAt(row, 19)).contains("1")) {
                do{
                    scrollTo(AdultContent);
                    AdultContent.click();
                }while(visibilityOfElementLocated(AdultContent) !=null && AdultContent.getAttribute("value")=="false");
              }else{
                do{  
                    scrollTo(nonAdultContent);
                    nonAdultContent.click();
                }while(visibilityOfElementLocated(nonAdultContent) !=null && nonAdultContent.getAttribute("value")=="false");
              }
              Designs.progress.setValue(20);
            } catch (Exception e) {
                stackTrace= new Throwable().getStackTrace()[0];
                refresh(30000, save, count, stackTrace);
            AdultContent(model, row);
        }
    }

    public void continueToContent(){
        int count=0;
        try {
            scrollTo(continueToContent);
            continueToContent.isEnabled();
            continueToContent.click();
            Designs.progress.setValue(21);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            continueToContent();
        }
    }

    public ContentPage content(DefaultTableModel model, int row){
        return new ContentPage(model, row);
    }

}

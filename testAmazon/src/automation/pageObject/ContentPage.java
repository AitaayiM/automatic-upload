package automation.pageObject;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.baseConfiguration.TestBase;
import project.Designs;

public class ContentPage extends TestBase{

    public ContentPage(DefaultTableModel model, int row){
        PageFactory.initElements(driver, this);
        iSBN(model, row);
        date(model, row);
        ink(model, row);
        size();
        bleed(model, row);
        coverFinish(model, row);
        bookContent(model, row);
        bookCover(model, row);
        barcode(model, row);
        int count=0;
        launch(count);
        continueToRights();
        rightsPrice(model, row);
    }

    @FindBy(xpath = "(//div[@role='radio'])[1]")
    WebElement kdpISBN;

    @FindBy(id = "free-print-isbn-btn")
    WebElement createISBN;

    @FindBy(id = "print-isbn-confirm-button-announce")
    WebElement confirmISBN;

    @FindBy(xpath = "(//div[@role='radio'])[2]")
    WebElement ownISBN;

    @FindBy(id = "print-isbn-owner-isbn-input")
    WebElement iSBN;

    @FindBy(id = "print-isbn-owner-imprint-input")
    WebElement imprint;

    @FindBy(id = "data-print-book-publication-date")
    WebElement date;

    @FindBy(name = "BW_CREAM")
    WebElement ink1;

    @FindBy(name = "BW_WHITE")
    WebElement ink2;

    @FindBy(name = "COLOR_WHITE")
    WebElement ink3;

    @FindBy(name = "COLOR_COLOR")
    WebElement ink4;

    @FindBy(id = "trim-size-selected-option-announce")
    WebElement size;

    @FindBy(xpath = "//button[@name='false']")
    WebElement noBleed;

    @FindBy(xpath = "//button[@name='true']")
    WebElement bleed;

    @FindBy(xpath = "//button[@name='MATTE']")
    WebElement matte;

    @FindBy(xpath = "//button[@name='GLOSSY']")
    WebElement glossy;

    @FindBy(id = "data-print-book-publisher-interior-file-upload-browse-button-announce")
    WebElement bookContent;
    
    @FindBy(xpath = "(//div[@role='radio'])[4]")
    WebElement radioCover;

    @FindBy(id = "data-print-book-publisher-cover-file-upload-browse-button-announce")
    WebElement bookCover;

    @FindBy(id = "data-print-book-has-publisher-barcode")
    WebElement barcode;

    @FindBy(xpath = "(//div[@class='jele-directive'])[17]")
    WebElement launch;

    @FindBy(xpath = "(//span[@class='a-declarative'])[45]")
    WebElement launchClick;
    
    //Your browser window is currently less than 1200px by 600px. Please adjust your browser window to a larger view or use a different device.
    @FindBy(id = "print-preview-confirm-button-announce")
    WebElement previewConfirm;

    @FindBy(id = "printpreview_approve_button_enabled")
    List<WebElement> approve;

    @FindBy(xpath = "(//span[@class='a-declarative'])[49]")
    WebElement continueToRights;

    @FindBy(xpath = "(//span[@class='a-declarative'])[48]")
    WebElement save;

    public void iSBN(DefaultTableModel model, int row){
        int count=0;
        try {
            customWait(9000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            if (String.valueOf(model.getValueAt(row, 25)).contains("0")) {
                scrollTo(kdpISBN);
                if(kdpISBN.getAttribute("class").toString().toLowerCase().contains("disabled")){ return; }
                kdpISBN.click();
                customWait(1000); 
                createISBN.click();
                customWait(1000);
                confirmISBN.click();
                customWait(1000);
              }else{
                scrollTo(ownISBN);
                ownISBN.click();
                humanWriting((String) model.getValueAt(row, 26), iSBN);
                humanWriting((String) model.getValueAt(row, 27), imprint); 
              }
              Designs.progress.setValue(22);
            } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count,stackTrace);
            iSBN(model, row);
        }
    }

    public void date(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(date);
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("arguments[0].setAttribute('value','"+(String)model.getValueAt(row, 31)+"')", date);
            Designs.progress.setValue(23);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            date(model, row);
        }
    }



    public void ink(DefaultTableModel model, int row){
        int count=0;
        try {
            switch ((String)model.getValueAt(row, 24)) {
                case "BlackWhiteCream":
                    scrollTo(ink1);
                    ink1.click();
                    break;    
                case "BlackWhiteWhite":
                    scrollTo(ink2);
                    ink2.click();
                    break;
                case "StandardColor":
                    scrollTo(ink3);
                    ink3.click();
                    break;
                case "PremiumColor":
                    scrollTo(ink4);
                    ink4.click();
                    break;
            
                default:
                    break;
            }
            Designs.progress.setValue(24);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            ink(model, row);
        }
    }

    public void size(){
        int count=0;
        try {
            scrollTo(size);
            size.click();
            Designs.progress.setValue(25);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            size();
        }
    }

    public void bleed(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(noBleed);
            switch ((String)model.getValueAt(row, 24)) {
                case "No Bleed":
                    noBleed.click();
                    break;
                case "Bleed (PDF only)":
                    bleed.click();
                    break;
                default:
                    break;
            }
            Designs.progress.setValue(26);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            bleed(model, row);
        }   
    }

    public void coverFinish(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(glossy);
            switch ((String)model.getValueAt(row, 29)) {
                case "Glossy":
                    glossy.click();
                    break;
                case "Matte":
                    matte.click();
                    break;
                default:
                    break;
            }
            Designs.progress.setValue(27);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            coverFinish(model, row);
        }
    }

    public void bookContent(DefaultTableModel model, int row){
        int count=0;
        try {
            try {
                robotForUpload((String)model.getValueAt(row, 20), bookContent);
                customWait(60000);
           } catch (AWTException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
           }
           Designs.progress.setValue(28);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            bookContent(model, row);
        }
    }

    public void bookCover(DefaultTableModel model, int row){
        int count=0;
        try {
            try {
                radioCover.click();
                customWait(1000);
                robotForUpload((String)model.getValueAt(row, 21), bookCover);
                customWait(30000);
                Designs.progress.setValue(29);
            } catch (AWTException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            bookCover(model, row);
        }
    }

    public void barcode(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(barcode);
            if(String.valueOf(model.getValueAt(row, 22)).contains("1"))
               barcode.click();
               Designs.progress.setValue(30);
            } catch (Exception e) {
                stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            barcode(model, row);
        }
    }

    public void launch(int count){
        try {
            scrollTo(launch);
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();
            click(launchClick);
            customWait(4000);
            /* if(width<1200 || height<600){
              click(previewConfirm);
              customWait(4000);
              try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                scrollTo(approve.get(0));
                approve.get(0).click();
                customWait(2000);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
              } catch (Exception e) {
                refresh(30000, null, count);
                scrollTo(approve.get(0));
                approve.get(0).click();
                customWait(2000);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
              }
             }else{ */
                click(previewConfirm);
                customWait(60000);
                try {
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                    customWait(10000);
                    scrollTo(approve.get(0));
                    System.out.println(approve.size());
                    approve.get(0).click();
                    customWait(2000);
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                } catch (Exception e) {
                    stackTrace= new Throwable().getStackTrace()[0];
                    refresh(30000, null, count, stackTrace);
                    customWait(10000);
                    scrollTo(approve.get(0));
                    click(approve.get(0));
                    customWait(2000);
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                }
            //}  
            Designs.progress.setValue(31);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            launch(count);
        } 
    }


    public void continueToRights(){
        int count=0;
        try {
            scrollTo(continueToRights);
            click(continueToRights);
            Designs.progress.setValue(32);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            continueToRights();
        }

    }

    public RightsPage rightsPrice(DefaultTableModel model, int row){
        return new RightsPage(model, row);
    }

}

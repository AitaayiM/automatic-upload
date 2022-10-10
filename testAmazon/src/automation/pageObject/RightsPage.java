package automation.pageObject;

import java.time.Duration;

import javax.swing.table.DefaultTableModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automation.baseConfiguration.TestBase;
import project.Designs;

public class RightsPage extends TestBase{

    public RightsPage(DefaultTableModel model, int row){
        PageFactory.initElements(driver, this);
        marketPlace(model, row); 
        pricing(model, row);
        save();
        do{
            customWait(15000);
        }while(Successful.getText()==null || Successful.getText()=="");
        driver.quit();
    }

    @FindBy(xpath = "(//div[@role='radio'])[1]")
    WebElement territories;

    @FindBy(id = "data-print-book-home-marketplace")
    WebElement marketPlace;

    @FindBy(name = "data[print_book][amazon_channel][us][price_vat_exclusive]")
    WebElement pricing;

    @FindBy(id = "save-and-publish-announce")
    WebElement publish;

    @FindBy(id = "save-announce")
    WebElement save;

    @FindBy(xpath= "(//div[@class='a-alert-content'])[52]")
    WebElement Successful;

    public void marketPlace(DefaultTableModel model, int row){
        int count=0;
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            customWait(9000);
            scrollTo(marketPlace);
            Select market = new Select(marketPlace);
            market.selectByValue((String) model.getValueAt(row, 30).toString().toLowerCase()); 
            Designs.progress.setValue(33);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            marketPlace(model, row);
        }
    }

    public void pricing(DefaultTableModel model, int row){
        int count=0;
        try {
            scrollTo(pricing);
            humanWriting((String) model.getValueAt(row, 23), pricing);
            Designs.progress.setValue(34);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            pricing(model, row);
        }
    }

    public void publish(){
        int count=0;
        try {
            scrollTo(publish);
            click(publish);
            Designs.progress.setValue(35);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, save, count, stackTrace);
            publish();
        }
    }

    public void save(){
        scrollTo(save);
        click(save);
        Designs.progress.setValue(35);
    }
    
}

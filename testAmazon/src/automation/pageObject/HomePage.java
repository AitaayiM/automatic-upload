package automation.pageObject;


import java.time.Duration;

import javax.script.ScriptException;
import javax.swing.table.DefaultTableModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.baseConfiguration.TestBase;
import project.Designs;

public class HomePage extends TestBase{

    public HomePage(DefaultTableModel model, int row) throws ScriptException{
        PageFactory.initElements(driver, this);
        create();
        createEbook();
        details(model, row);
    }

    @FindBy(css = "span[class='create-new-button-label']")
    WebElement create;

    @FindBy(xpath = "(//button[@class='a-button-text'])[2]")
    WebElement createEbook;

    public void create(){
        int count=2;
        try {
            customWait(9000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            scrollTo(create);
            create.click();
            Designs.progress.setValue(6);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, null, count, stackTrace);
            create();
        }
    }

    public void createEbook(){
        int count=0;
        try {
            customWait(1000);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            scrollTo(createEbook);
            createEbook.click();
            Designs.progress.setValue(7);
        } catch (Exception e) {
            stackTrace= new Throwable().getStackTrace()[0];
            refresh(30000, null, count, stackTrace);
            createEbook();
        }
    }

    public DetailsPage details(DefaultTableModel model, int row) throws ScriptException{
        return new DetailsPage(model, row);
    } 
}

package automation.pageObject;



import java.time.Duration;

import javax.script.ScriptException;
import javax.swing.table.DefaultTableModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.baseConfiguration.TestBase;
import project.Designs;

public class LoginPage extends TestBase{

	public LoginPage(DefaultTableModel model, int row, String driverChooser) throws ScriptException{
		initial("https://kdp.amazon.com/en_US/", driverChooser);
		PageFactory.initElements(driver, this);
		customWait(3000);
		sign();
		int count=0;
		username(count);
		password();
		enter();
		home(model, row);
	}

	@FindBy(xpath = "//span[@id='signinButton']")
	WebElement sign;

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement username;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement password;

    @FindBy(id = "signInSubmit")
    WebElement enter;

	public void sign() {
		int count=0;
		try {
			scrollTo(sign);
		    sign.click();
			Designs.progress.setValue(2);
		} catch (Exception e) {
			stackTrace= new Throwable().getStackTrace()[0];
			refresh(30000, null, count, stackTrace);
			scrollTo(sign);
		    sign.click();
		}
		
	}

    public void username(int count) {
		try {
			customWait(9000);
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		    scrollTo(username);
		    humanWriting(Designs.getEmail(), username);
			Designs.progress.setValue(3);
		} catch (Exception e) {
			stackTrace= new Throwable().getStackTrace()[0];
			refresh(30000, null, count, stackTrace);
		    username(count);		
		}
		
	}

    public void password() {
		int count=0;
		try {
			scrollTo(password);
			humanWriting(Designs.getPassword(), password);
			Designs.progress.setValue(4);
		} catch (Exception e) {
			stackTrace= new Throwable().getStackTrace()[0];
			refresh(30000, null, count, stackTrace);
			username(count);
			password();
		}

	}

    public void enter() {
		int count=0;
		try {
			scrollTo(enter);
			enter.click();
			Designs.progress.setValue(5);
		} catch (Exception e) {
			stackTrace= new Throwable().getStackTrace()[0];
			refresh(30000, null, count, stackTrace);
			username(count);
			password();
			enter();
		}

	}

	public HomePage home(DefaultTableModel model, int row) throws ScriptException{
		return new HomePage(model, row);
	}

}

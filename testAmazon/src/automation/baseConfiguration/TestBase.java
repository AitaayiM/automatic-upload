package automation.baseConfiguration;


import java.time.Duration;

import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.Designs;


public class TestBase {

    public static WebDriver driver;
    public static Wait<WebDriver> wait;
    public static StackTraceElement stackTrace;

    public void initial(String URL, String driverChooser){
      if(netIsAvailable()==false){
        JOptionPane.showMessageDialog(null, "  No internet connection found  ");
      }else{
        driverChooser(driverChooser);
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Designs.progress.setValue(1);
      }
    }

    public void robotForUpload(String URL, WebElement browse) throws AWTException{
      scrollTo(browse);
      customWait(3000);
      browse.click(); // Click on browse option on the webpage
      customWait(3000); // suspending execution for specified time period
      // creating object of Robot class
      Robot rb = new Robot();
      // copying File path to Clipboard
      String url= stringToPath(URL);
      StringSelection str = new StringSelection(toPathD1(url));
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
      // press Control+V for pasting
      rb.keyPress(KeyEvent.VK_CONTROL);
      rb.keyPress(KeyEvent.VK_V);
      // release Control+V for pasting
      rb.keyRelease(KeyEvent.VK_CONTROL);
      rb.keyRelease(KeyEvent.VK_V);
      // for pressing and releasing Enter
      rb.keyPress(KeyEvent.VK_ENTER);
      rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public ExpectedCondition<WebElement> visibilityOfElementLocated(final WebElement toReturn) {
        return new ExpectedCondition<WebElement>() {
          public WebElement apply(WebDriver driver) {
            if (toReturn.isDisplayed()) {
              return toReturn;
            }
            return null;
          }
        };
      }
      
    public void refresh(int time, WebElement element, int count,StackTraceElement stackTrace){
      if(element !=null){
        scrollTo(element);
        click(element);
      }
      driver.navigate().refresh();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
      customWait(time/3);
      count++;
      if(count==3) giveControl(stackTrace);
    }  

    public void scrollTo(WebElement element){
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(WebElement element){
      JavascriptExecutor js= ((JavascriptExecutor)driver);
      js.executeScript("arguments[0].click();", element);
    }

    public String isChecked(WebElement element){
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        String result= js.executeScript("return arguments[0].checked;", element).toString();
        return result;
    }

    
    public void customWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        } 
    }

    public String stringToPath(String path){
      String symbol="\\";
      int index;
      for (index = 0; index < path.length(); index++) {
        if(String.valueOf(path.charAt(index)).matches("[0-9]")){
          path.replace(path.charAt(index), symbol.charAt(0));
        }else{
          break;
        }
      }
      return path.substring(index);
    }

    public String toPathD1(String path){
      String symbol="\\";
      char[] PATH=path.toCharArray();
      String newPATH="C:";
      int index;
      for (index = 2; index < PATH.length; index++) {
        if(Character.isUpperCase(PATH[index])){
          newPATH=newPATH+symbol;
        }
        newPATH=newPATH+PATH[index];
      }
      return newPATH;
    }


    public void humanWriting(String sendKey,WebElement element){
      element.clear();
      String letter = null;
      for (int i = 0; i < sendKey.length(); i++) {
           letter  = String.valueOf(sendKey.charAt(i));     
           element.sendKeys(letter);
           customWait(25);
      }
    }

    public void driverChooser(String Driver){
      if(Driver.contains("Google Chrome")){
        System.setProperty("webdriver.chrome.driver","src\\drivers\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOp = new ChromeOptions();
        chromeOp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(chromeOp);
      }else if(Driver.contains("Firefox")){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\.vscode\\kdpamazon\\designes\\testAmazon\\src\\drivers\\geckodriver\\geckodriver.exe");
        FirefoxOptions firefoxOp = new FirefoxOptions();
        firefoxOp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new FirefoxDriver(firefoxOp);
      }else{
        System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\.vscode\\kdpamazon\\designes\\testAmazon\\src\\drivers\\edgedriver\\msedgedriver.exe");
        EdgeOptions edgeOp = new EdgeOptions();
        edgeOp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        edgeOp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new EdgeDriver(edgeOp);
      }
    }

    private static boolean netIsAvailable() {
      try {
          final URL url = new URL("http://www.google.com");
          final URLConnection conn = url.openConnection();
          conn.connect();
          conn.getInputStream().close();
          return true;
      } catch (MalformedURLException e) {
          throw new RuntimeException(e);
      } catch (IOException e) {
          return true;
      }
    }

    public void giveControl(StackTraceElement stackTrace){
      if (netIsAvailable()==false) {
        JOptionPane.showMessageDialog(null, "  No internet connection found  ");
      }else{
        if(JOptionPane.showConfirmDialog(null, " There is a problem with the site, in the "+stackTrace.getMethodName()+" please check manually, then tell us do you want to continue? ", " Control", JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION)
        Designs.thread= null;
      }
    }



}

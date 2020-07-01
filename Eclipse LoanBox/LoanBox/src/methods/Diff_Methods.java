package methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.WebElement;
//import org.seleniumhq.jetty9.util.log.Log;
import utility.method_constant;
//import utility.project_elements;
import org.openqa.selenium.NoAlertPresentException;
import utility.Log;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.awt.AWTException;

public class Diff_Methods {
    
	WebDriver driver;
	
		
	//###########*******************************  Scroll Methods  *********************####################//
	public static void ByPixel(WebDriver driver) {
       
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // This  will scroll down the page by  1000 pixel vertical		
        js.executeScript(method_constant.Scroll_Vertically_By_Pixels);
    }
	
	
	
	
	public static WebElement  ByVisibleElement(WebDriver driver, WebElement ScrollToElement) {
	       
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the page till the element is found	
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollToElement);
        js.executeScript("arguments[0].scrollIntoView();", ScrollToElement);// This Call Just for Example.
        return null;
    }
	
	
	
	
	public static void ByPage(WebDriver driver) {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
       
        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
	
	
public static void ByPageUp(WebDriver driver) {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
       
        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
	
	
	//###########*******************************  POP UP Handling  *********************####################//
	
	
	
public static void DismissAlert(WebDriver driver) throws NoAlertPresentException,InterruptedException{
        
	Alert alert = driver.switchTo().alert();	
	alert.dismiss();	
    }


public static void AcceptAlert(WebDriver driver) throws NoAlertPresentException,InterruptedException{
    
	Alert alert = driver.switchTo().alert();	
	alert.accept();	
    }


public static void GetTextAlert(WebDriver driver) throws NoAlertPresentException,InterruptedException{
    
	Alert alert = driver.switchTo().alert();	
	alert.getText();	
    }

public static void SendKeysToAlert(WebDriver driver) throws NoAlertPresentException,InterruptedException{
    
	Alert alert = driver.switchTo().alert();	
	alert.sendKeys(method_constant.Send_TextToAlert);	
    }



// ----- Upload Docs ---------

public static void UploadDocs(WebDriver driver, String FilePath) throws NoAlertPresentException,InterruptedException,AWTException{
    
	StringSelection ss = new StringSelection(FilePath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

    //imitate mouse events like ENTER, CTRL+C, CTRL+V
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    
    Log.info("File Is uploaded SucessFully.");
	
    }

public static void CloseWindow(WebDriver driver) {

	String originalHandle = driver.getWindowHandle();

    //Do something to open new tabs

    for(String handle : driver.getWindowHandles()) {
        if (!handle.equals(originalHandle)) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }

    driver.switchTo().window(originalHandle);

}

/////// javascript Click

public static void safeJavaScriptClick(WebElement element,WebDriver driver) throws Exception {
    try {
        if (element.isEnabled() && element.isDisplayed()) {
            System.out.println("Clicking on element with using java script click");

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } else {
            System.out.println("Unable to click on element");
        }
    }
     catch (Exception e) {
        System.out.println("Unable to click on element "+ e.getStackTrace());
    }
}


public static String getSystemDate()
{
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    return formatter.format(date);
}


/*public static String getListingDateFormat(String Dt)
{
    //SimpleDateFormat formatter = new SimpleDateFormat("dd MMM,yyyy");
    int day=Dt.charAt(0)+Dt.charAt(1);
    int month=Dt.charAt(3)+Dt.charAt(4);
    int year=Dt.charAt(6)+Dt.charAt(7)+Dt.charAt(8)+Dt.charAt(9);
    return "a";
    //Date date = new Date();
    //return formatter.format(Dt);
}*/

public static String replaceCommaBySpaceString(String str)
{
    String str1=str.replace(",", " ");
    str=str1.replace(" ", "");
    return str;
}


 // 

public static void explicitlyWaitForElement(WebDriver driver, String xPathOfElementToWaitFor) {
    WebDriverWait wait = new WebDriverWait(driver, method_constant.waitTime);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathOfElementToWaitFor)));

}





		
}

package UBPageObject;

//import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import methods.Diff_Methods;
import utility.Log;
import utility.project_elements;

public class UBLoginRequest {

	private static WebElement element = null;
	//private static List<WebElement> radioButtons = null;

	//**********Find element and return*************
	public static WebElement getUBUsername(WebDriver driver) throws Exception {
		try {
			element = driver.findElement(By.xpath(project_elements.UB_Username));
		}
		catch (Exception e) {
			Log.error("UB username element not found -->"+project_elements.UB_Username);
			throw (e);
		}
		Log.info("UB username element found");
		return element;
	}

	public static WebElement getUBPassword(WebDriver driver) throws Exception{
		try {
			element = driver.findElement(By.xpath(project_elements.UB_Password));
		}
		catch (Exception e) {
			Log.error("UB Password element not found -->"+project_elements.UB_Password);
			throw (e);
		}
		Log.info("UB password element found");
		return element;
	}
	
	public static WebElement getUBSubmit(WebDriver driver) throws Exception{
		try {
			element = driver.findElement(By.xpath(project_elements.UB_Submit));
		}
		catch (Exception e) {
			Log.error("UB Submit element not found -->"+project_elements.UB_Submit);
			throw (e);
		}
		Log.info("UB Submit element found");
		return element;
	}


}

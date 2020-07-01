package InspectionPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import methods.Diff_Methods;
import utility.project_elements;
import utility.Log;

public class InspAddRequest {
	
private static WebElement element = null;
//private static List<WebElement> radioButtons=null;
	
	//***************  Find DO Link Element and Return **************//
	public static WebElement getInspectionUsername(WebDriver driver) throws Exception
	{  
		try{
			element = driver.findElement(By.xpath(project_elements.Inspection_Username));
 }catch (Exception e){
			 
			Log.error("Inspection Username Element not found -->" + project_elements.Inspection_Username);
			            throw(e);
 						}
			 
			 Log.info("Inspection Username Element found");
			        return element;
	}
	
	public static WebElement getInspectionPassword(WebDriver driver) throws Exception
	{  
		try{
	     element	 = driver.findElement(By.xpath(project_elements.Inspection_Password));
 }catch (Exception e){
			 
			Log.error("Inspection Password Element not found -->" + project_elements.Inspection_Password);
			            throw(e);
 						}
			 
			 Log.info("Inspection Password Element found");
			        return element;
	}
	
	
	
	
}
package InspectionModule;

import org.openqa.selenium.WebDriver;
//import pageObjects.Home_page;
//import pageObjects.Login_Page;
import InspectionPageObjects.InspAddRequest;
//import methods.Diff_Methods;
import utility.ExcelUtils;
import utility.Log;
//import utility.project_elements;


public class InspectionSignIN {

	
	public static String SignIn_Result = "FAILED";
	public static void Execute(WebDriver driver) throws Exception{

	//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
	String sUserName = ExcelUtils.getCellData(1, 1);
	Log.info("Username picked from Excel is "+ sUserName );
	
	String sPassword = ExcelUtils.getCellData(1, 2);
	//String Password = Long.toString(sPassword);
    Log.info("Password picked from Excel is "+ sPassword );
    
    //Thread.sleep(5000);
    InspAddRequest.getInspectionUsername(driver).click();
    InspAddRequest.getInspectionUsername(driver).sendKeys(sUserName);
	Log.info("Username entered in the Username text box");

	InspAddRequest.getInspectionPassword(driver).click();
	InspAddRequest.getInspectionPassword(driver).sendKeys(sPassword);
	Log.info("Password entered in the Password text box");
	
	
	//Thread.sleep(5000);
	
  
    	Log.info("Login Sucessfully");
    	SignIn_Result = "PASS";		
   
	
	}
	
}

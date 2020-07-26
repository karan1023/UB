package MainExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.*;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import UBModule.UBLogin;

public class Executor {

WebDriver driver;
		
	@BeforeClass
	public void SetWait(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	
	@Test
	public void First() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		//System.setProperty("webdriver.chrome.driver", value);
		drivers Driver = new drivers();
		Driver.ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://ub-ph.gaadi.com/V1");
		driver.manage().window().maximize();
		constant.DataFile();
		ExcelUtils.setExcelFile(constant.absolute, "Sheet1");
		Log.info("Excel sheet opened");
		
		UBLogin.Execute(driver);
		//Thread.sleep(500);
		//driver.quit();
		
		
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
	
	/*
	@Test
	public void AddDO() throws Exception 
	{
		
		
		DOMConfigurator.configure("log4j.xml");
		
		
					drivers Driver = new drivers(); 
					Driver.ChromeDriver();
					WebDriver driver = new ChromeDriver();
			       driver.get("http://dealercrmstaging.gaadi.com/");
			       driver.manage().window().maximize();
		
			       constant.DataFile();
					ExcelUtils.setExcelFile(constant.absolute,"Sheet3");
				    Log.info(" Excel sheet opened");

				    Thread.sleep(5000);
				    
				       //##############################   For Refurb Listing  ################
				       Log.startTestCase("Selenium_ADD_DO");
				       ExcelUtils.setCellData(CdrivrSignIN.SignIn_Result, 1, 3);
				       
				       CdrivrSignIN.Execute(driver);
				       ExcelUtils.setCellData(CdrivrSignIN.SignIn_Result, 1, 3);
				       
				       AddDO.Execute(driver);
				       logOut.Execute(driver);
				      // Diff_Methods.CloseWindow(driver);
				       driver.quit();
				       Log.endTestCase("Selenium_ADD_DO");
		
		
	}  
	
	
	
	
	
@Test
public void SendReport() throws Exception 
{
	    String from = "nitish.kumar@girnarsoft.co.in";
	    String pass = "Nitish";
	    String to = "nsnitish.ns@gmail.com";
	    String cc = "nsnitish.ns.ns@gmail.com";
	    String BCC = "kapil.yadav@girnarsoft.co.in";
	    String subject = constant.Project_Name + " Automation Report";
	    String body = "Automation TestNG Report";
	
	SendFileEmail.sendPDFReportByGMail(from, pass, to, cc, BCC, subject, body);
	
}
	*/


}
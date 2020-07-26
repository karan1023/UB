package UBModule;
import org.openqa.selenium.WebDriver;
import UBPageObject.UBLoginRequest;
import utility.ExcelUtils;
import utility.Log;
import utility.constant;

public class UBLogin {
	public static String SignIn_Result = "FAILED";
	public static void Execute(WebDriver driver) throws Exception{
		
		ExcelUtils.setExcelFile(constant.absolute, "Sheet1");
		
		//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
		String UserName = ExcelUtils.getCellData(0, 1);
		Log.info("Username picked from Excel is "+ UserName );
		
		String Password = ExcelUtils.getCellData(1, 1);
		//String Password = Long.toString(sPassword);
	    Log.info("Password picked from Excel is "+ Password );
	    
	    //Thread.sleep(5000);
	    UBLoginRequest.getUBUsername(driver).click();
	    UBLoginRequest.getUBUsername(driver).sendKeys(UserName);
	    Log.info("Username entered in the Username text box");

		UBLoginRequest.getUBPassword(driver).click();
		UBLoginRequest.getUBPassword(driver).sendKeys(Password);
	    Log.info("Password entered in the Password text box");
		
	    Thread.sleep(7000);
	    
	    UBLoginRequest.getUBSubmit(driver).click();
	    Log.info("Clicked on Submit button");
			    
	    Log.info("Login Sucessfully");
	    SignIn_Result = "PASS";		
	}

}

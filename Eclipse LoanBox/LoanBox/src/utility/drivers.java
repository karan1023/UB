package utility;

import java.io.File;
import java.net.URL;

public class drivers {	
	
public  void ChromeDriver() throws Exception{
		
		ClassLoader classLoader = getClass().getClassLoader();
	    URL resource = classLoader.getResource("resources/drivers/chromedriver");
	    File f = new File("Driver");
	    if (!f.exists()) {
	        f.mkdirs();
	    }
	    File chromeDriver = new File("Driver" + File.separator + "chromedriver");
	    if (!chromeDriver.exists()) {
	        chromeDriver.createNewFile();
	        org.apache.commons.io.FileUtils.copyURLToFile(resource, chromeDriver);
	    }
	    System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
	     
	   
	}
		
}

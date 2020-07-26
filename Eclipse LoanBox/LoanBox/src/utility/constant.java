package utility;

import java.io.File;
//import java.net.URL;

public class constant {

	public static final String Project_Name = "Inspection";	
	
	public static String absolute = null;
	public static String image_path = null;
	public static String report_Path = null;
		
	public  static void DataFile() throws Exception{
		File DataFile = new File("LoanBox/src/testData/testData.xlsx");
	    absolute = DataFile.getAbsolutePath();
	}
	
	public static String Image_path() {
		File image_File = new File("src/testData/Screenshot.png");
		image_path = image_File.getAbsolutePath();
		return image_path;
 	}

	public static String ReportPath() {
		File image_File = new File("test-output/emailable-report.html");
		report_Path = image_File.getAbsolutePath();
		return report_Path;
 	}
}
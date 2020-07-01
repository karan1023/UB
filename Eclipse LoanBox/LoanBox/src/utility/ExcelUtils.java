package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.hpsf.Decimal;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;



public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static int Norows;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception {
	try {
	
				// Open the Excel file
				FileInputStream ExcelFile = new FileInputStream(Path);
	
			// Access the required test data sheet
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
			} catch (Exception e){
				throw (e);
			}
	}

//This method is to read the test data from the Excel cell,
public static long getCellData1(int RowNum, int ColNum) throws Exception{
    try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            long CellData1 = (long)Cell.getNumericCellValue();
            return CellData1;
    }catch (Exception e){
                            return 0;
                        }
}

public static int getCellDataInt(int RowNum, int ColNum) throws Exception{
    try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            int CellData1 = (int)Cell.getNumericCellValue();
            return CellData1;
    }catch (Exception e){
                            return 0;
                        }
}

public static Double getCellDataDouble(int RowNum, int ColNum) throws Exception{
    try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            double CellData1 = (double)Cell.getNumericCellValue();
            return CellData1;
    }catch (Exception e){
                            return 0.0;
                        }
}


public static String getCellData(int RowNum, int ColNum) throws Exception{
    try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            //Cell.setCellType(CellType.STRING);
            String CellData = Cell.getStringCellValue();
            return CellData;
    }catch (Exception e){
                            return "";
                        }
}

public static CellType getCellType(int RowNum, int ColNum) throws Exception{
    

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            //Cell.setCellType(CellType.STRING);
            //String CellData = Cell.getStringCellValue();
            return Cell.getCellType();
            //return CellData;
    
}

public static int getNumberOfRows()
{
    try{

        Norows = ExcelWSheet.getPhysicalNumberOfRows();
        //Cell.setCellType(CellType.STRING);
        
        return Norows;
}catch (Exception e){
                        return 0;
                    }
    
}


//This method is to write in the Excel cell, Row num and Col num are the parameters
public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
	try{
		Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL); 
			if (Cell == null) {
					Cell = Row.createCell(ColNum);
					Cell.setCellValue(Result);
								} else {
									Cell.setCellValue(Result);
								}
			
			constant.DataFile();
// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(constant.absolute);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
				}catch(Exception e){
					throw (e);
									}
				}
}
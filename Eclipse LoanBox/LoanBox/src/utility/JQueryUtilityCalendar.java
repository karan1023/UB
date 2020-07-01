package utility;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JQueryUtilityCalendar {
    
    
    public static int getDestYear(Date destDate)
    {
        Calendar destCalendar = Calendar.getInstance();
        destCalendar.setTime(destDate);
    
        return destCalendar.get(Calendar.YEAR);
    }
    
    public static int getDestMonth(Date destDate)
    {
        Calendar destCalendar = Calendar.getInstance();
        destCalendar.setTime(destDate);
    
        //return destCalendar.get(Calendar.MONTH);
        
        int month = destCalendar.get(Calendar.MONTH) + 1;
        return month;
        
        
        
    }
    
    public static int getDestDay(Date destDate)
    {
        Calendar destCalendar = Calendar.getInstance();
        destCalendar.setTime(destDate);
    
        int destDay = destCalendar.get(Calendar.DAY_OF_MONTH);
        
        return destDay;
    }
    

    public static int getDestHour(Date destDate)
    {
        Calendar destCalendar = Calendar.getInstance();
        destCalendar.setTime(destDate);
    
        return destCalendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public static int getDestMinute(Date destDate)
    {
        Calendar destCalendar = Calendar.getInstance();
        destCalendar.setTime(destDate);
    
        return destCalendar.get(Calendar.MINUTE);
    }
    

    

    public static void selectJQueryDateTimePickerYear(WebDriver driver, WebDriverWait waitObj, int destYear) throws InterruptedException {
        
        
        // First click default year item, then the year scroll list will be shown.
                By defaultYearBy = By.xpath("//div[@class='xdsoft_label xdsoft_year']");
                waitObj.until(ExpectedConditions.visibilityOfElementLocated(defaultYearBy));
                WebElement defaultYearWebElement = driver.findElement(defaultYearBy);
                defaultYearWebElement.click();
                Thread.sleep(2000);
                
                // Select correct year in the list.
                List<WebElement> yrs=driver.findElements(By.xpath("//div[@class='xdsoft_label xdsoft_year']//div[contains(@class,'xdsoft_option ')]"));
                int count=driver.findElements(By.xpath("//div[@class='xdsoft_label xdsoft_year']//div[contains(@class,'xdsoft_option ')]")).size();
                System.out.println(count);
                
                
                for(WebElement yearElement : yrs)
                {
                    String yearText = yearElement.getAttribute("data-value");
                    
                    if(String.valueOf(destYear).equals(yearText.trim()))
                    {
                        // Scroll to the year option web element to make it visible.
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yearElement);
                        
                        Thread.sleep(1000);
                        
                        // Click to select the year.
                        yearElement.click();    
                        break;
                    }
                }    
        
    }

    public static void selectJQueryDateTimePickerMonth(WebDriver driver, WebDriverWait waitObj, int destMonth) throws InterruptedException {
        
        
        // First click default month item, then the month scroll list will be shown.
                By defaultMonthBy = By.xpath("//div[@class='xdsoft_label xdsoft_month']");
                waitObj.until(ExpectedConditions.visibilityOfElementLocated(defaultMonthBy));
                WebElement defaultMonthWebElement = driver.findElement(defaultMonthBy);
                defaultMonthWebElement.click();
                
                // Select correct month in the list.
                List<WebElement> months=driver.findElements(By.xpath("//div[@class='xdsoft_label xdsoft_month']//div[contains(@class,'xdsoft_option ')]"));
                int countmonth=driver.findElements(By.xpath("//div[@class='xdsoft_label xdsoft_month']//div[contains(@class,'xdsoft_option ')]")).size();
                System.out.println(countmonth);
                
                
                for(WebElement monthElement : months)
                {
                    String monthText = monthElement.getAttribute("data-value");
                    int monthtext1=Integer.parseInt(monthText)+1;
                    String monthnew=String.valueOf(monthtext1);
                    
                    if(String.valueOf(destMonth).equals(monthnew.trim()))
                    {
                        // Scroll to the month option web element to make it visible.
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", monthElement);
                        
                        Thread.sleep(1000);
                       // WebElement ele= (WebElement)waitObj.until(ExpectedConditions.elementToBeClickable((monthElement))); 
                        
                        // Click to select the month.
                        monthElement.click();
                        
                        break;
                    }
                }    
        
    }

    public static void selectJQueryDateTimePickerDay(WebDriver driver, WebDriverWait waitObj, int destDay) {
        
        // Get all day web element list.
                By byDay = By.xpath("//div[@class='xdsoft_calendar']//td");
                List<WebElement> dayElementList = driver.findElements(byDay);
                
                // Loop in the list.
                for(WebElement dayElement : dayElementList)
                {
                    // Get css class value first.
                    String classValue = dayElement.getAttribute("class");
                    
                    // If it is this month's day.
                    if(classValue.indexOf("xdsoft_other_month")==-1)
                    {
                        String dayValue = dayElement.getAttribute("data-date");
                        if(String.valueOf(destDay).equals(dayValue.trim()))
                        {
                            dayElement.click();
                            break;
                        }
                    }
                }
        
    }
    
    
    public static void selectJQueryDateTimePickerHourMinute(WebDriver driver, WebDriverWait waitObj, int destHour, int destMinute) throws InterruptedException
    {
        waitObj.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='xdsoft_time_variant']")));
        // Get all hour and minute web element list.
        By byHourMinute = By.xpath("//div[@class='xdsoft_time ']");
        List<WebElement> hourMinuteElementList = driver.findElements(byHourMinute);
        
        System.out.println("Hi");
        // Loop in the list.
        for(WebElement hourMinuteElement : hourMinuteElementList)
        {
            // Get css class value first.
            String classValue = hourMinuteElement.getAttribute("class");
            Log.info("class"+classValue);        
            // If it is this month's day.
            if(classValue.indexOf("xdsoft_time")>-1)
            {
                String hourValue = hourMinuteElement.getAttribute("data-hour");
                String minuteValue = hourMinuteElement.getAttribute("data-minute");
                
                if(hourValue!=null && minuteValue!=null && hourValue.trim().length()>0 && minuteValue.trim().length()>0)
                {
                    if(String.valueOf(destHour).equals(hourValue.trim()) && String.valueOf(destMinute).equals(minuteValue.trim()))
                    {
                        //int minuteValueInt = Integer.parseInt(minuteValue);
                    //    int deltaMinute = destMinute - minuteValueInt;
                        /*if((deltaMinute <= 5) && (deltaMinute>=-5))
                        {*/
                        
                    //    System.out.println("hi");
                            // Scroll to the hour:minute option web element to make it visible.
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hourMinuteElement);
                            //Thread.sleep(3000);
                            WebDriverWait wait = new WebDriverWait(driver, 10);
                            wait.until(ExpectedConditions.elementToBeClickable((hourMinuteElement)));
                            hourMinuteElement.click();
                            break;
                        //}
                    }
                }
            }
        }
    }
    

}


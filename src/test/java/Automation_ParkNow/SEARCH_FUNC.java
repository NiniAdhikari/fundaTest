package Automation_ParkNow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SEARCH_FUNC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		String baseUrl="http://www.funda.nl/en/";
		 driver.get(baseUrl);
	     driver.manage().window().maximize();  
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	// Select Range location
	  WebElement rangeLocation_dropdown=driver.findElement(By.name("filter_Afstand"));// Range drop-down
	  Select rangeLocation=new Select(rangeLocation_dropdown); //   
	  
		  List <WebElement> rangeLoc=rangeLocation.getOptions();
	 
		int totalranLocation=rangeLoc.size();
	
		
		// Select Min. Price
		  WebElement minPrice_dropdown=driver.findElement(By.name("filter_FundaKoopPrijsVan"));// Range drop-down
		  Select minPrice=new Select(minPrice_dropdown); //   
		  
		  List <WebElement> miPrice=rangeLocation.getOptions();
		 
			int totalminPrice=miPrice.size();
			
			// Select Max Price
			  WebElement maxPrice_dropdown=driver.findElement(By.name("filter_Afstand"));// Range drop-down
			  Select maxPrice=new Select(rangeLocation_dropdown); //   
			  
	
			  List <WebElement> mxPrice=rangeLocation.getOptions();
			 
				int totalmaxPrice=mxPrice.size();
				
		
		
	for (int rangeDropdown=0;rangeDropdown<=totalranLocation;rangeDropdown++) 
	{
		  
		for (int minPriceDropdown=0;minPriceDropdown<totalminPrice;minPriceDropdown++)
		{
			for (int maxPriceDropdown=0;maxPriceDropdown<totalmaxPrice;maxPriceDropdown++)
			{
			
		  
		        
				WebElement locationElement = driver.findElement(By.name("filter_location"));
		  
				getSearch( locationElement); // Enter Post-code
			
		   driver.findElement(By.cssSelector("button[type='submit'][class='button-primary-alternative']")).click(); // Click Submit 
		   // Find number of results
		   WebElement results=driver.findElement(By.xpath("/html/body/main/form/div[2]/div[1]/span"));
		// Wait 30 secs until this object appears 
		   WebDriverWait wait = new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.visibilityOf(results));
		   
		   System.out.println("For Range=" + rangeLoc.get(rangeDropdown).getText()+"Min Price="+miPrice.get(minPriceDropdown).getText()+"MAx Price" +mxPrice.get(maxPriceDropdown).getText()+"Total number of houses="+results );
		   driver.navigate().back();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   
		   
			}
	}
	} 
	}


public static void getSearch( WebElement locationElement)
{
	locationElement.click();
	locationElement.clear();
	locationElement.sendKeys("1052CX");			
	
	
}

}

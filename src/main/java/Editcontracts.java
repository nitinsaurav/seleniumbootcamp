import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Editcontracts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@aria-describedby='error']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"View All\"]")));
		
		

//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[text()=\"View All\"]")).click();
		
		Thread.sleep(30000);
		
		  WebElement element1=driver.findElement(By.xpath("//p[text()='Contracts']"));
		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].scrollIntoView();", element1);
		  js.executeScript("arguments[0].click()", element1);
		  
		 WebElement element2= driver.findElement(By.xpath("//div[@data-aura-class='uiScroller']"));
		  js.executeScript("arguments[0].click()", element2);
		 // Thread.sleep(30000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Select a List View']")));
		  driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
		  Thread.sleep(30000);
		  driver.findElement(By.xpath("//span[text()='All Contracts']")).click();
			Thread.sleep(5000);
		  
		WebElement element3=  driver.findElement(By.xpath("//input[contains(@placeholder,'Search this lis')]"));
		Thread.sleep(5000);
		element3.sendKeys("00000101",Keys.ENTER);
		Thread.sleep(5000);
		
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")));
		
		
		//driver.switchTo().frame(0);
	    WebElement element31 =driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]"));
		//element3.click();
	    js.executeScript("arguments[0].click();", element31);
	    
	    driver.findElement(By.xpath("//a[@title='Edit']")).click();
	    
	   
	   // Thread.sleep(30000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='button' and @class='select' and @aria-describedby='4276:0-label']")));
		
	    
	   driver.findElement(By.xpath("//a[@role='button' and @class='select' and @aria-describedby='4276:0-label']")).click();
	  //a[@class ='selected']
	    
		Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//a[@title='Activated']")).click();
	    
	   WebElement element34= driver.findElement(By.xpath("//a[@class='select' and text()='--None--' ]"));
	    
	    js.executeScript("arguments[0].scrollIntoView();", element34);
	    js.executeScript("arguments[0].click()", element34);
	    
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='menuitemradio'and @title='30 Days']")));
	    driver.findElement(By.xpath("//a[@role='menuitemradio' and @title='30 Days']")).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//span[@data-aura-rendered-by='3162:0' and text()='Save']")).click();
	    
	    String str=driver.findElement(By.xpath("//span[text()='Activated']")).getText();
	    
	    if(str.equals("Activated")) {
	    	System.out.println("Status is updated ");
	    	
	    }
	    else {
	    	System.out.println("Status is not updated ");
	    }
		  
		

	}

}

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Create_new_Oppertunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		
		driver.findElement(By.xpath("//button[text()=\"View All\"]")).click();
		Thread.sleep(5000);
		
		WebElement element =driver.findElement(By.xpath("//p[text()='Sales']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		element.click();
		
		//Thread.sleep(5000);
	WebElement element1=	driver.findElement(By.xpath("//a[@title='Opportunities']"));

	js.executeScript("arguments[0].click();",element1);
	
	driver.findElement(By.xpath("//a[@title='New']")).click();
	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Nitin Saurav 3");
	

	
	

DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	String date1=dateFormat.format(date);
	driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(date1);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='--None--']")).click(); 
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	
	
	String ele=driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
	
	if(ele.equalsIgnoreCase("Salesforce Automation by Nitin Saurav 3")) {
		System.out.println("oppertunity is created ");
		
	}
	else 
	{
		System.out.println("oppertunity is not created ");
	}
	
	
		

	}

}

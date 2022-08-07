import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
		Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@role='button' and contains(@class,'globalCreateTrigger slds-button ')]")).click();
		
		//driver.findElement(By.xpath("//button[text()=\"View All\"]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.className("select")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@role='menuitemradio' and @title='Mr.']")).click();
		
		Thread.sleep(5000);
		WebElement element =driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		
		element.sendKeys("Nitin");
		
		Thread.sleep(5000);
		
		WebElement element1=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		
		element1.sendKeys("Saurav");
		
		Thread.sleep(5000);
		WebElement element2=driver.findElement(By.xpath("//input[@inputmode='email']"));
		element2.sendKeys("Nitin@test.com");
		

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element2);
		
		WebElement element3=driver.findElement(By.xpath("//input[@type='tel']"));
		element3.sendKeys("12334");
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='New Account']")).click();
		
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Account Name']/parent::label/following-sibling::input")));

		driver.findElement(By.xpath("//span[text()='Account Name']/parent::label/following-sibling::input")).sendKeys("Nitin'sAccounrt");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save']/parent::button[@title='Save'])[2]")));
		driver.findElement(By.xpath("(//span[text()='Save']/parent::button[@title='Save'])[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Save']/parent::button[@data-aura-class='uiButton']")).click();
	}

}

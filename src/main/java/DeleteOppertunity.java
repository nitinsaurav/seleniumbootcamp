import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOppertunity {

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
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()=\"View All\"]")).click();
		Thread.sleep(10000);
		WebElement element=driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']"));
		element.sendKeys("opportunities");
		element.click();
		driver.findElement(By.xpath("//mark[text()='Opportunities']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@title='Select a List View']/lightning-icon")).click();
		
		

	}

}

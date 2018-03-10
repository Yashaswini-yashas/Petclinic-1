package bm.petclinic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PetClinic {
	public static WebDriver driver;
	@BeforeSuite

	public void setup(){
		//System.setProperty("webdriver.chrome.driver", "D:\\Users\\maudas\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		//driver=new ChromeDriver();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.get("https://s3-us-west-2.amazonaws.com/java-demo-bucket/elb-petclinic-dns.txt");
		String url=driver.findElement(By.xpath("//body")).getText();
		driver.get(url);
		
		driver.get(url);
		
	}

	@Test
	public void getTitle(){
		String title=driver.getTitle();
		if(title.equals("PetClinic :: a Spring Framework demonstration")){
			System.out.println("Application is working properly");
		}
		
		else{
			System.out.println("Issue with application ");
		}
		
		//driver.findElement(By.xpath("//div[@id='main-navbar']/ul/li[3]/a")).click();
		
	}
}

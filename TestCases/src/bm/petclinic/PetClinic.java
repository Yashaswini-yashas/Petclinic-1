package bm.petclinic;

import java.util.concurrent.TimeUnit;
import java.util.List;
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
        System.out.println("browser is initiated");
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
            Assert.fail();
		}
		
		//driver.findElement(By.xpath("//div[@id='main-navbar']/ul/li[3]/a")).click();
		
	}
    
    @Test
    public void addOwner(){
        driver.findElement(By.linkText("FIND OWNERS")).click();
		 driver.findElement(By.linkText("Add Owner")).click();
		 driver.findElement(By.xpath("//form[@class='form-horizontal']//input[@name='firstName']")).sendKeys("Demo");
		 driver.findElement(By.xpath("//form[@class='form-horizontal']//input[@name='lastName']")).sendKeys("Test");
		 driver.findElement(By.xpath("//form[@class='form-horizontal']//input[@name='address']")).sendKeys("Dummy address");
		 driver.findElement(By.xpath("//form[@class='form-horizontal']//input[@name='city']")).sendKeys("Mumbai");
		 driver.findElement(By.xpath("//form[@class='form-horizontal']//input[@name='telephone']")).sendKeys("1234567890");
		 driver.findElement(By.xpath("//form[@class='form-horizontal']//button[@class='btn btn-default']")).click();
		 
    }
    
    @Test
    public void findOwner(){
         driver.findElement(By.linkText("FIND OWNERS")).click();
		 driver.findElement(By.xpath("//form[@id='search-owner-form']//input[@name='lastName']")).sendKeys("Test");
		 driver.findElement(By.xpath("//form[@id='search-owner-form']//button[@class='btn btn-default']")).click();
    }
    
    @Test
    public void vets(){
        driver.findElement(By.linkText("VETERINARIANS")).click();
		 List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-striped']//td"));
		 System.out.println("Available Vets with Specialities");
		 for(WebElement iterate:list) {
			 System.out.println(iterate.getText());
		 }
        
    }
    
    @Test
    public void pets(){
         driver.findElement(By.linkText("FIND OWNERS")).click();
		 driver.findElement(By.xpath("//form[@id='search-owner-form']//button[@class='btn btn-default']")).click();
		 List <WebElement> pets=driver.findElements(By.xpath("//table[@id='ownersTable']//tr/td[5]"));
		 System.out.println("Pets available are: ");
		 for(WebElement element:pets) {
			 System.out.println(element.getText());
		 }
        
    }
        
        
}

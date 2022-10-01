package Week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		WebElement mouseover1 = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions build=new Actions(driver);
		build.moveToElement(mouseover1).perform();
		
		WebElement search = driver.findElement(By.id("brandSearchBox"));
        search.sendKeys("L'Oreal");
        search.sendKeys(Keys.ENTER);
        WebElement brand1 = driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]"));
        brand1.click();
        
        //Check title contains
        String title = driver.getTitle();
        System.out.println("Title contains" + title);
        
        //sort and select customer top rated
        

        
		
	 /* // Sort and get the top rated:
        Thread.sleep(3000);
       driver.findElement(By.xpath("//div[@class='css-0']//span[@class='sort-name']")).click();
       driver.findElement(By.xpath("(//label[@class='control control-radio']//div)[7]")).click();
       Thread.sleep(3000);
       
       //click on category
        driver.findElement(By.id("category")).click();
       
       //Click on Hair
       driver.findElement(By.linkText("hair")).click();
       //Actions build1=new Actions(driver);
       //build1.moveToElement(hair).perform();
       //Thread.sleep(3000);*/
        
      //5) Click sort By and select customer top rated
      		Thread.sleep(2000);
      		driver.findElement(By.xpath("//div[@class='css-0']//span[@class='sort-name']")).click();
      		driver.findElement(By.xpath("(//label[@class='control control-radio']//div)[7]")).click();
      		//6) Click Category and click Hair->Click haircare->Shampoo
      		Thread.sleep(1000);
      		driver.findElement(By.id("first-filter")).click();
      		//click hair
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("(//li[@class='css-1do4irw'])[2]")).click();
      		//click hair care
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("(//li[@class='css-1do4irw'])[2]")).click();
      		// click shampoo
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("(//label[@class='control control-checkbox'])[1]")).click();
      		//7) Click->Concern->Color Protection
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj'])[6]")).click();
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("(//label[@class='control control-checkbox'])[13]")).click();
      		//8)check whether the Filter is applied with Shampoo
      		String filterSampoo = driver.findElement(By.xpath("//div[@class='css-1emjbq5']//span")).getText();
      		if(filterSampoo.contains("Shampoo"))
      		{
      			System.out.println("Shampoo is filtered");
      		}else
      		{
      			System.out.println("Shampoo is not filtered");
      		}
      		//9) Click on L'Oreal Paris Colour Protect Shampoo
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
      		Set<String> windowHandles = driver.getWindowHandles();
      		List<String> windows=new ArrayList<String>(windowHandles);
      		driver.switchTo().window(windows.get(1));

      		//10) GO to the new window and select size as 175ml
      		Thread.sleep(1000);
      		WebElement sizeOption = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
      		Select selectOption=new Select(sizeOption);
      		selectOption.selectByVisibleText("175ml");
      		//Print the MRP of the product
      		String MRP = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
      		System.out.println("Shampoo rate is:" +MRP);

      		// Click on ADD to BAG
      		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();

      		// Go to Shopping Bag 
      		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
      		//Print the Grand Total amount
      		Thread.sleep(2000);
      		//WebElement switchFrame=driver.findElement(By.xpath("//div[@class='css-1o9rwmy e1xdieeb5']"));
      		driver.switchTo().frame(0);
      		Thread.sleep(2000);
      		String grandTotal=driver.findElement(By.xpath("(//div[@class='footer-layout css-2vxg6l e25lf6d0']//span)[1]")).getText();
      		System.out.println("Shampoo Grand Total is:" +grandTotal);

      		// Click Proceed
      		driver.findElement(By.xpath("//div[@class='css-207d6f e25lf6d6']")).click();

      		// Click on Continue as Guest
      		driver.findElement(By.xpath("//button[@class='btn full big']")).click();

      		//Check if this grand total is the same in step 14
      		String finalGrandTotal=driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//span")).getText();
      		System.out.println("Shampoo final Grand Total is:" +finalGrandTotal);
      		if(grandTotal==finalGrandTotal)
      		{
      			System.out.println("Grand Total same");

      		}else
      		{
      			System.out.println("Grand Total not same");

      		}
      		driver.close();
        
	}

}

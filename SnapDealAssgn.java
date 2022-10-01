package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssgn {
	public static void main(String[] args) {




		//Select the price range (900-1200)
				String fromRange="900";
				String toRange="1200";
				
				WebElement rangeFrom = driver.findElement(By.xpath("//input[@class='input-filter']"));
				rangeFrom.clear();
				rangeFrom.sendKeys(fromRange);
				WebElement rangeTo=driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
				rangeTo.clear();
				rangeTo.sendKeys(toRange);
				driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
				
				//Filter with color Navy   --Navy color shoe not available, so i filtered yellow
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@for='Color_s-Yellow']")).click();
				
				//verify the all applied filters 
				Thread.sleep(2000);
				String priceFilter = driver.findElement(By.xpath("//div[@class='filters']//div/a")).getText();
				System.out.println("Filtered Price is: "+priceFilter);
				String colorFilter = driver.findElement(By.xpath("(//div[@class='filters']//div/a)[2]")).getText();
				System.out.println("Filtered color is: " +colorFilter);
				
				if(priceFilter.contains(fromRange))
				{
					System.out.println("Applied Price is Filtered correctly");	
				}
				else
				{
					System.out.println("Applied Price is not Filtered correctly");	
				}
				//shoe color verified
				if(colorFilter.contains("Yellow"))
				{
					System.out.println("Applied color is Filtered correctly");	
				}
				else
				{
					System.out.println("Applied color is not Filtered correctly");	
				}
				
				//Mouse Hover on first resulting Training shoes
				Thread.sleep(1000);
				WebElement firstResulting = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
				Thread.sleep(1000);
				builder.moveToElement(firstResulting).perform();
		//		
				//click QuickView button
				WebElement firstResultingShoe = driver.findElement(By.xpath("//a[@class='dp-widget-link hashAdded']/following::div[@class='clearfix row-disc']//div"));
				Thread.sleep(1000);
				firstResultingShoe.click();
				Thread.sleep(2000);
				
				//Print the cost and the discount percentage
				String cost = driver.findElement(By.xpath("//DIV[@class='product-price pdp-e-i-PAY-l clearfix']//span")).getText();
				String discountPercentage = driver.findElement(By.xpath("(//DIV[@class='product-price pdp-e-i-PAY-l clearfix']//span)[2]")).getText();
				System.out.println("The Cost is "+cost +" and the Discount percentage is " +discountPercentage);
				
				// Take the snapshot of the shoes
				File Source = driver.getScreenshotAs(OutputType.FILE);
				File designation=new File("./snaps/shoe.png");
				FileUtils.copyFile(Source, designation);
				
				//Close the current window
				driver.findElement(By.xpath("//div[@class='close close1 marR10']//i")).click();
				// Close the main window
			driver.close();
}
}

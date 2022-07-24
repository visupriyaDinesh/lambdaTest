package lambdaTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class Scenario2 extends LambdaBassClass{
	
	@Test
	public void testScenario2(){

		
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement slider = driver.findElement(By.xpath("//output[@id='rangeSuccess']/preceding-sibling::input"));
		Actions action = new Actions(driver); 
		action.moveToElement(slider, 120, 0).click(); 
		action.build().perform();

		
	String range = driver.findElement(By.id("rangeSuccess")).getText();
		if(range.equals("95"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
	}

}

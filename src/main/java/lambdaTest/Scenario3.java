package lambdaTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 extends LambdaBassClass {

	@Test
	public void testScenario3() {
		driver.findElement(By.linkText("Input Form Submit")).click();

		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		String message = driver.findElement(By.id("name")).getAttribute("validationMessage");
		Assert.assertTrue(message.equals("Please fill out this field."));

		driver.findElement(By.name("name")).sendKeys("Visupriya");
		driver.findElement(By.name("email")).sendKeys("visu@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Welcome@123");
		driver.findElement(By.name("company")).sendKeys("XYZ");
		driver.findElement(By.name("website")).sendKeys("NY");
		driver.findElement(By.name("city")).sendKeys("www.xyz.com");
		driver.findElement(By.name("address_line1")).sendKeys("st.joseph street");
		driver.findElement(By.name("address_line2")).sendKeys("NY North");

		WebElement country = driver.findElement(By.name("country"));
		Select countrySelect = new Select(country);
		countrySelect.selectByVisibleText("United States");

		driver.findElement(By.id("inputState")).sendKeys("NY");

		String successMsg = driver.findElement(By.xpath("//p[contains(@class,'success-msg')]")).getText();
		if (successMsg.equalsIgnoreCase("Thanks for contacting us, we will get back to you shortly.")) {
			System.out.println("Submitted Successfully");
		} else {
			System.out.println("Submittion failed");
		}
	}

}

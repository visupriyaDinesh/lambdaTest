package lambdaTest;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Scenario1 extends LambdaBassClass {

	String input = "Welcome to LambdaTest";

	@Test
	public void testScenario1() {
	
		driver.findElement(By.linkText("Simple Form Demo")).click();
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("simple-form-demo")) {
			System.out.println("URL Correct");
		} else {
			System.out.println("URL incorrect");
		}
		Assert.assertTrue(currentUrl.contains("simple-form-demo"));

		driver.findElement(By.xpath("(//input[@placeholder='Please enter your Message'])[1]")).sendKeys(input);


		driver.findElement(By.id("showInput")).click();

		String message = driver.findElement(By.id("message")).getText();
		if (input.equalsIgnoreCase(message)) {
			System.out.println("Welcome test is correct");
		} else {
			System.out.println("Welcome test is incorrect");
		}
		Assert.assertTrue(input.equalsIgnoreCase(message));
	}

}

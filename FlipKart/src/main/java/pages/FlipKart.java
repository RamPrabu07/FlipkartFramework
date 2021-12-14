package pages;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart extends BaseClass {
	@Test(dataProvider = "readData")
	public void mobileOrder(String uName, String password) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']//input")).sendKeys(uName);
		driver.findElement(By.xpath("(//div[@class='IiD88i _351hSN']//input)[2]")).sendKeys(password);

		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2HKlqd')]")).click();

		/*
		 * WebElement findElement =
		 * driver.findElement(By.xpath("//span[text()='Electronics']")); Actions builder
		 * = new Actions(driver); builder.moveToElement(findElement).perform();
		 */

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='xtXmba'])[3]")).click();

		driver.findElement(By.xpath("//div[@class='_HYyiu']")).click();
		driver.findElement(By.xpath("//div[text()='realme C25Y (Metal Grey, 64 GB)']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		String secondWindow = windowList.get(1);
		driver.switchTo().window(secondWindow);
		driver.findElement(By.xpath("//li[@class='col col-6-12']//button")).click();

		boolean displayed = driver.findElement(By.xpath("//span[text()=' ₹10,999']")).isDisplayed();
		Assert.assertTrue(displayed);

		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		driver.findElement(By.xpath("(//input[@name='address']/following-sibling::div)[3]")).click();
		driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Credit / Debit / ATM Card']")).click();

		driver.findElement(By.xpath("(//button[text()='Change'])[3]")).click();
		driver.findElement(By.xpath("//div[@class='_3dsJAO']/span")).click();

	}

}

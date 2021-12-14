package pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveItem extends BaseClass {
	@Test(dataProvider = "readData")
	public void removeCart(String uName,String password) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']//input")).sendKeys(uName);
		driver.findElement(By.xpath("(//div[@class='IiD88i _351hSN']//input)[2]")).sendKeys(password);

		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2HKlqd')]")).click();

		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		driver.findElement(By.xpath("//div[text()='Remove']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Cancel']/following-sibling::div")).click();
		WebElement findElement = driver.findElement(By.xpath("//div[text()='Your cart is empty!']"));
		String text = findElement.getText();
		if (text.equalsIgnoreCase("Your cart is empty!")) {
			System.out.println("Moblie removed from cart");
			
		}else {
			System.out.println("Moblie phone is not removed from cart");
		}
	}

}

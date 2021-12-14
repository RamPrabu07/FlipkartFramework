package baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import datalibrary.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public  static ChromeDriver driver;
	
	 @DataProvider 
	 
	public Object[][] readData() throws IOException {
		return ReadExcel.readExcelData();
		

	}
	
	
    @BeforeMethod()
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		

	}
    @AfterMethod()
	public void postCondition() {
		driver.quit();
	}

}

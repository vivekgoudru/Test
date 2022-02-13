import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BaseUtilities.DriverFactory;

public class Alerts extends DriverFactory {

	@Test
	public void alert() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "webdriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.findElement(By.name("cusid")).sendKeys("1234");
		driver.findElement(By.name("submit")).click();
//		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File destfile = new File("Screenshots//Alert.png");
//		FileUtils.copyFile(scr, destfile);
		driver.switchTo().alert().accept();
		driver.close();
	}

}

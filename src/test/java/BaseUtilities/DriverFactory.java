package BaseUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverFactory {
	
	@Test
	public void drivers() {
		System.setProperty("webdriver.chrome.driver","webdriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://google.com");
		driver.close();
		
	}
	

}

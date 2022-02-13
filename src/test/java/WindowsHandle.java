import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class WindowsHandle {
    	
	@Test
	void windowhandle() throws IOException {

		System.setProperty("webdriver.chrome.driver", "webdriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Click Here")).click();
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> s = driver.getWindowHandles();
		Iterator<String> i1 = s.iterator();
		while (i1.hasNext()) {
			String child = i1.next();

			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.findElement(By.name("emailid")).sendKeys("hello@gamil.com");
				driver.findElement(By.name("btnLogin")).click();
				File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File destFile = new File("Screenshots//test.png");
				FileUtils.copyFile(file, destFile);
				driver.close();
			}
		}

		driver.switchTo().window(parent);
		System.out.println("Main WIndow");
		driver.close();

	}

	static void WindowsHandle1() throws IOException {

		WebDriver driver1 = new ChromeDriver();
		driver1.get("http://demo.guru99.com/popup.php");
		driver1.manage().window().maximize();
		driver1.findElement(By.linkText("Click Here")).click();
		String mainwindow = driver1.getWindowHandle();
		Set<String> s1 = driver1.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String childwindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(childwindow)) {
				driver1.switchTo().newWindow(WindowType.WINDOW);
				driver1.findElement(By.name("emailid")).sendKeys("hello@gamil.com");
				driver1.findElement(By.name("btnLogin")).click();
				File scrnshot = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
				File destfile = new File("Screenshots//test.png1");
				FileUtils.copyFile(scrnshot, destfile);
				driver1.close();
			}
		}
		driver1.switchTo().window(mainwindow);
		driver1.close();
	}
}

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", ".\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div[@class='form-check-inline']/label/span[contains(text(),'User')]/following-sibling::span[@class='checkmark']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/p")));
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText());
		Actions actions = new Actions(driver);
		WebElement ClickOKbutton = driver
				.findElement(By.xpath("//div[@class='modal-content']/div/button[@id='okayBtn']"));
		actions.moveToElement(ClickOKbutton).click().perform();
		// static drop down selection
		WebElement staticDropdown = driver.findElement(By.xpath("(//*[@class='form-control'])[3]"));
		// This methods of choosing drop down will work only when there is 'select'
		// option available in dom page in devtools
		Select dropdown = new Select(staticDropdown);
		List<WebElement> allOptions = dropdown.getOptions();

		for (WebElement option : allOptions) {
			if (option.getText().equals("Teacher")) {
				option.click();
				break;
			}
		}
		// static drop down elements display
		List<WebElement> staticDropdown1 = driver.findElements(By.xpath("(//*[@class='form-control'])[3]"));
		for (WebElement option1 : staticDropdown1) {
			System.out.println(option1.getText());
		}
		driver.findElement(By.id("signInBtn")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Shop Name')]")));	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WebDriverWait wait2= new WebDriverWait(driver, 10);
		WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));	
		String[] ItemsNeeded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		for (int i = 0; i < ItemsNeeded.length; i++) {
			driver.findElement(By.xpath("//h4/a[contains(text(),'"+ItemsNeeded[i]+"')]/following::div/button")).click();
		}
		String[] Checkout=driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).getText().split("\n");
		Assert.assertEquals(Checkout[0], "Checkout ( "+ItemsNeeded.length+" )");
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		

//		

	}

}

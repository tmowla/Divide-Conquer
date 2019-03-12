package main.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHashMap {
	
//	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		
		Map <String, String> data = new HashMap <String, String> ();
		String credentials [][] = {{"Username: amipavelo", "Password: tmowla0011"}, {"Username: mowlatanbir", "Password: tmowla00"}};
		String userName = null;
		String password = null;
		
		int counter = 1;
		
		for (int i=0; i<credentials.length; i++) {
			for(int j=0;j<credentials[i].length; j++) {
				
				if(credentials[i][j].contains("Username"))
				{
					userName = credentials[i][j].substring(10);
					data.put("Username"+counter, credentials[i][j].substring(10));
				}
				else if (credentials[i][j].contains("Password"))
				{
					password = credentials[i][j].substring(10);
					data.put("Password"+counter, credentials[i][j].substring(10));
				}

			}
//			System.out.println("Username: " + userName);
//			System.out.println("Password: " + password);
			
			data.put("size", Integer.toString(counter));
			counter = counter +1;
			
		}
		
	for (int i =1; i <= Integer.parseInt(data.get("size")); i ++)
	{
		System.out.println(data.get("Username"+i));
		System.out.println(data.get("Password"+i));
	
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace-GiT\\Divide-Conquer\\PracticeSelenium\\Driver\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		JavascriptExecutor jsE = (JavascriptExecutor) chromeDriver;
		chromeDriver.get("http://www.gmail.com");
		chromeDriver.manage().window().maximize();
		
		WebElement emailInput = chromeDriver.findElement(By.id("identifierId"));
		emailInput.sendKeys("User Name");
		jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", emailInput);
		
		WebElement nextButton = chromeDriver.findElement(By.xpath("//span[text()='Next']")); //tagName[@AttributeName = 'AttributeValue'] //tagName[AttributeName() = 'AttributeValue']
		jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", nextButton);
		nextButton.click();
		
		WebElement passInput = chromeDriver.findElement(By.name("password"));
		String passLebel = "Enter your password";
		if(passLebel.equals(passInput.getAttribute("aria-label"))) {
			jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", passInput);
			passInput.sendKeys("Password");
			WebElement submitButton = chromeDriver.findElement(By.xpath("//span[text()='Next']")); //tagName[@AttributeName = 'AttributeValue'] //tagName[AttributeName () = 'AttributeValue']
			submitButton.click();
			
		}
	
	}
	
	}

}

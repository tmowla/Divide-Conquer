package main.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigninGmail {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace-GiT\\Divide-Conquer\\PracticeSelenium\\Driver\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		JavascriptExecutor jsE = (JavascriptExecutor) chromeDriver;
		chromeDriver.get("http://www.gmail.com");
		chromeDriver.manage().window().maximize();
		
//		Thread.sleep(2000);//Implicit Wait
//		WebDriverWait waitTime = new WebDriverWait(chromeDriver,20); //Define the Object for Explicit Wait
//		waitTime.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("identifierId")));
		
		WebElement emailInput = chromeDriver.findElement(By.id("identifierId"));
		emailInput.sendKeys("amipavelo"); 
		jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", emailInput);
		
		WebElement nextButton = chromeDriver.findElement(By.xpath("//span[text()='Next']")); //tagName[@AttributeName = 'AttributeValue'] //tagName[AttributeName() = 'AttributeValue']
		jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", nextButton);
		nextButton.click();
		
		WebElement passInput = chromeDriver.findElement(By.name("password"));
		String passLebel = "Enter your password";
		if(passLebel.equals(passInput.getAttribute("aria-label"))) {
			jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", passInput);
			passInput.sendKeys("tanmow00");
			WebElement submitButton = chromeDriver.findElement(By.xpath("//span[text()='Next']")); //tagName[@AttributeName = 'AttributeValue'] //tagName[AttributeName () = 'AttributeValue']
			submitButton.click();
			
		}

	}

}

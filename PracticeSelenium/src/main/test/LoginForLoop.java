package main.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginForLoop {
	
	public static void main(String[] args) throws InterruptedException {
		
		String credentials [][] = {{"Username: amipavelo", "Password: tmowla0011"}, {"Username: mowlatanbir", "Password: tmowla1100"}};
		String userName = null;
		String password = null;
		
		for (int i=0; i<credentials.length; i++) {
			for(int j=0;j<credentials[i].length; j++) {
				
				if(credentials[i][j].contains("Username"))
				{
					userName = credentials[i][j].substring(10);
				}
				else if (credentials[i][j].contains("Password"))
				{
					password = credentials[i][j].substring(10);
				}
			}
			System.out.println("Username: " + userName);
			System.out.println("Password: " + password);
			
			System.setProperty("webdriver.chrome.driver", "C:\\Workspace-GiT\\Divide-Conquer\\PracticeSelenium\\Driver\\chromedriver.exe");
			WebDriver chromeDriver = new ChromeDriver();
			JavascriptExecutor jsE = (JavascriptExecutor) chromeDriver;
			chromeDriver.get("http://www.gmail.com");
			chromeDriver.manage().window().maximize();
			
			WebElement emailInput = chromeDriver.findElement(By.id("identifierId"));
			emailInput.sendKeys(userName);
			jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", emailInput);
			
			WebElement nextButton = chromeDriver.findElement(By.xpath("//span[text()='Next']")); //tagName[@AttributeName = 'AttributeValue'] //tagName[AttributeName() = 'AttributeValue']
			jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", nextButton);
			nextButton.click();
			
			WebElement passInput = chromeDriver.findElement(By.name("password"));
			String passLebel = "Enter your password";
			if(passLebel.equals(passInput.getAttribute("aria-label"))) {
				jsE.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", passInput);
				passInput.sendKeys(password);
				WebElement submitButton = chromeDriver.findElement(By.xpath("//span[text()='Next']")); //tagName[@AttributeName = 'AttributeValue'] //tagName[AttributeName () = 'AttributeValue']
				submitButton.click();
				
			}
		}
	
	}

}

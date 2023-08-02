package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}

	@FindBy(id= "Email")
	WebElement email;
	
	@FindBy(id= "Password")
	WebElement pass;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	
	
	public void enterEmail(String emailAddress) {
		email.clear();
		email.sendKeys(emailAddress);
	}
	
	public void enterPassword(String pwd) {
		pass.clear();
		pass.sendKeys(pwd);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickonloginbutton() {
		login.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickonlogoutbutton() {
		logout.click();
	}
	
}

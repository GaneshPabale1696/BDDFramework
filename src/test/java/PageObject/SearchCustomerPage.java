package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}

	@FindBy(id="SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement searchResult;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;
	
	@FindBy(id="SearchLastName")
	WebElement lastName;
	
	
	//action method to enter email address
	public void enterEmailAdd(String email)
	{
		emailAdd.sendKeys(email);
	}
	
	//action method to perform click action on search button 
	public void clickOnSearchButton()
	{
		searchBtn.click();
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean found = false;
		
		//total no. of rows in a grid 
		int ttlRows = tableRows.size();
		
		//total no. of columns
		int ttlCols = tableColumns.size();
		
		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			WebElement WebElementEmail=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]"));
				
			String actualEmailAdd = WebElementEmail.getText();
			
			if(actualEmailAdd.equals(email))
			{
				found=true;
			}
		}
		return found;
	}
	
	////Search Customer By Name////////
	public void enterFirstName(String firstNameText)
	{
		firstName.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		lastName.sendKeys(lastNameText);
	}
	
	public boolean searchCustomerByName(String name) {
		
		boolean found = false;
		
		//total no. of rows in a grid 
		int ttlRows = tableRows.size();
		
		//total no. of columns
		//int ttlCols = tableColumns.size();
		
		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			WebElement WebElementName=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]"));
				
			String actualName = WebElementName.getText();
			
			if(actualName.equals(name))
			{
				found=true;
				break;
			}
		}
		return found;
	}
	
	
	
}

package StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

/*Parent Class*/
public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginpg;
	public SearchCustomerPage SearchCustPg;
	public AddNewCustomerPage addNewCustPg;
	public static org.apache.logging.log4j.Logger log;
	
	//genarate unique email id
	public String generateEmailId()
	{
	 return (RandomStringUtils.randomAlphabetic(5));
		 
	}
}

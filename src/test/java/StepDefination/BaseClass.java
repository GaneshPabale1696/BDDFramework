package StepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

/*Parent Class*/
public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginpg;
	public SearchCustomerPage SearchCustPg;
	public AddNewCustomerPage addNewCustPg;
	public static org.apache.logging.log4j.Logger log;
	public ReadConfig readConfig;
	
	//genarate unique email id
	public String generateEmailId()
	{
	 return (RandomStringUtils.randomAlphabetic(5));
		 
	}
}

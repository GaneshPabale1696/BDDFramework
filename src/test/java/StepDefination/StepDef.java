package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

/*Child Class of Base Class*/
public class StepDef extends BaseClass {

	@Before("@Sanity")
	public void setup1() {
		
		log=org.apache.logging.log4j.LogManager.getLogger("StepDef");
				
		System.out.println("Setup-sanity Method Executed");
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		log.fatal("Setup1 Executed....");
		
	}
	
	/*@Before("@regression")
	public void setup2() {
		System.out.println("Setup-regression Method Executed");
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
	}*/

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		loginpg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		SearchCustPg = new SearchCustomerPage(driver);
		log.info("User launch chrome browser....");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);

		log.info("URL is opened");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {

		loginpg.enterEmail(emailadd);
		loginpg.enterPassword(password);
		log.info("email address and password entered");
		
	}

	@When("Click on Login")
	public void click_on_login() {
		loginpg.clickonloginbutton();
		log.info("Login button clicked..");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expected) {

		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expected)) {
			log.info("Test Passed:Login Feature:Page title matched.");
			Assert.assertTrue(true);// pass
		} else {
			log.warn("Test failed:Login Feature:Page title not matched.");
			Assert.assertTrue(false);// fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginpg.clickonlogoutbutton();

		log.info("user clicked on logout link.");
	}

	@Then("close browser")
	public void close_browser() {

		driver.close();
		log.warn("Browser closed");

	}

	//////// Add New Customers/////////////////////////////////////////

	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {

		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			log.info("user can view dashboard test passed.");
			Assert.assertTrue(true);
		} else {
			log.warn("user can view dashboard test failed.");
			Assert.assertTrue(false);
		}

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		addNewCustPg.clickOnCustomersMenu();
		log.info("Customer Menu clicked");
		Thread.sleep(2000);
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		addNewCustPg.clickOnCustomersMenuItem();
		log.info("Customer Menu Item clicked");
		Thread.sleep(2000);
		
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addNewCustPg.clickOnAddnew();
		log.info("Clicked on add new button");
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {

		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			log.info("User can view Add new customer page-passed");
			Assert.assertTrue(true);// pass
		} else {
			log.warn("User can view Add new customer page-failed");
			Assert.assertTrue(false);// fail
		}

	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		// addNewCustPg.enterEmail("gp89@gmail.com");
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("Gupta");
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterDob("6/13/1988");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");
		
		log.info("Customer information entered..");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();

		log.info("Clicked on save button..");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(exptectedConfirmationMsg)) {
			Assert.assertTrue(true);// pass
			log.info("User can view confirmation message-passed");
		} else {
			log.warn("User can view confirmation message-failed");
			Assert.assertTrue(false);// fail
		}

	}

	/////////////////////////// Search Customer Steps//////////////////////////////
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
		log.info("Emailed address entered");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Click on search button")
	public void click_on_search_button() {
		SearchCustPg.clickOnSearchButton();
		log.info("Click on search button.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {

		String expectedEmail = "victoria_victoria@nopCommerce.com";

		// Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if (SearchCustPg.searchCustomerByEmail(expectedEmail) == true) {
			log.info("User should found Email in the Search table-passed");
			Assert.assertTrue(true);
		} else {
			log.warn("User should found Email in the Search table-failed");
			Assert.assertTrue(false);
		}

	}

	/////// Search Customer By Name ///////////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		SearchCustPg.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		SearchCustPg.enterLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {

		String expectedName = "Victoria Terces";

		if (SearchCustPg.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
	
	@After
	public void tearDown(Scenario sc)
	{
		System.out.println("Tear Down Method Executed");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "F:\\Projects\\my projects\\BDDFramework-master\\BDDFramework-master\\Screenshots\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}
	
	/*@After
	public void tearDown2()
	{
		System.out.println("Tear Down Method Executed");
		driver.quit();
	}*/
	
	/* @BeforeStep
	public void beforeStepMethodDemo()
	{
		System.out.println("This is Before step...");
	}
	
	
	@AfterStep
	public void afterStepMethodDemo()
	{
		System.out.println("This is after step...");
	} */

}

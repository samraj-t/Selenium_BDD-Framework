package stepdefs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import ExtentReport.ExtentReport;
import PageObject.HomePage;
import PageObject.Login;

import PageObject.NewCustomer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import readExcel.ReadExcel;

public class LoginSteps {
	
	WebDriver driver;
    ReadExcel excel = new ReadExcel();
    Login objLogin;

    HomePage objHomePage;
    
    NewCustomer objNewCustomer;
    
  

  ExtentReport extRpt = new ExtentReport();
  Logger log = Logger.getLogger("Samraj Execution Logs");
  
  
	@Given("^I have user name and password$")
	public void i_have_user_name_and_password() throws Throwable {
		
		 System.setProperty("webdriver.chrome.driver","E:\\Samraj\\Selenium\\Colombo Selenium\\Drivers\\chromedriver.exe");
	      driver = new ChromeDriver();
	      log.info("Launching browser");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      String Url = excel.readExcel(1, 0, ".\\Data\\data.xlsx", "Sheet1"); 
	      System.out.println(Url);
	      driver.get(Url);
	    // Write code here that turns the phrase above into concrete actions
		log.info("Login Page");
        //Create Login Page object
    	extRpt.setUpReport();
    	extRpt.startTestCase("User Login");
    objLogin = new Login(driver);

    //Verify login page title

    

    //login to application
    //driver.get(excel.readExcel(1, 0, ".\\Data\\data.xlsx", "Sheet1"));
    objLogin.loginToGuru99(excel.readExcel(1, 1, ".\\Data\\data.xlsx", "Sheet1"), excel.readExcel(1, 2, ".\\Data\\data.xlsx", "Sheet1"));

    // go the next page

   
	    throw new PendingException();
	}

	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 objHomePage = new HomePage(driver);
		    extRpt.logEventsPass("Logged Successfully");
		    log.info("Successful Login");
		    //Verify home page

		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	    throw new PendingException();
	}

	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
		String loginPageTitle = objLogin.getLoginTitle();

	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
	    throw new PendingException();
	}

}

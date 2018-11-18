package PageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import readExcel.ReadExcel;

public class NewCustomer {
	WebDriver driver;
	//Fairy fairy = Fairy.create();
	ReadExcel excel = new ReadExcel();
	public String CustomerId;
	
	//excel.readExcel(1, 0, ".\\Data\\data.xlsx", "Sheet1"); 
	
//	  By cutomerName = By.name("name");
//	  By male = By.name("rad1");
//	  By dob = By.name("dob");
//	  By address = By.name("addr");
//	  By city = By.name("city");
//	  By state = By.name("state");
//	  By pinno = By.name("pinno");
//	  By telephoneno = By.name("telephoneno");
//	  By password = By.name("password");
//	  By createCustomerButton = By.name("sub");
//	  By email = By.name("emailid");
	  
	  //Getting the inputs from Excel Sheet
	  By cutomerName = By.name("name");
	  By male = By.name("rad1");
	  By dob = By.name("dob");
	  By address = By.name("addr");
	  By city = By.name("city");
	  By state = By.name("state");
	  By pinno = By.name("pinno");
	  By telephoneno = By.name("telephoneno");
	  By password = By.name("password");
	  By createCustomerButton = By.name("sub");
	  By email = By.name("emailid");
	
    public NewCustomer(WebDriver driver){

        this.driver = driver;

      
    }
    
    public String createNewCustomer( String CustId) throws IOException, InterruptedException
    {
//    	Person person = fairy.person();
//    	
//    	driver.findElement(cutomerName).sendKeys(person.getFirstName() + person.getLastName());
//    	driver.findElement(male).click();
//    	driver.findElement(dob).sendKeys("12/12/1980");
//    	driver.findElement(address).sendKeys(person.getAddress().toString());
//    	driver.findElement(city).sendKeys(person.getAddress().getCity().toString());
//    	driver.findElement(state).sendKeys(person.getAddress().getStreet());
//    	driver.findElement(pinno).sendKeys("123456");
//    	driver.findElement(telephoneno).sendKeys("123355666");
//    	driver.findElement(email).sendKeys(person.getEmail().toString());
//    	driver.findElement(password).sendKeys(person.getPassword().toString());
//    	driver.findElement(createCustomerButton).click();
    	
    	//Filling the details via Excel Sheet
    	driver.findElement(cutomerName).sendKeys(excel.readExcel(1, 0, ".\\Data\\data.xlsx", "Sheet2"));
    	driver.findElement(male).click();
    	driver.findElement(dob).sendKeys("12/12/1980");
    	driver.findElement(address).sendKeys(excel.readExcel(1, 2, ".\\Data\\data.xlsx", "Sheet2"));
    	driver.findElement(city).sendKeys(excel.readExcel(1, 3, ".\\Data\\data.xlsx", "Sheet2"));
    	driver.findElement(state).sendKeys(excel.readExcel(1, 4, ".\\Data\\data.xlsx", "Sheet2"));
    	driver.findElement(pinno).sendKeys("123456");
    	driver.findElement(telephoneno).sendKeys("123355666");
    	driver.findElement(email).sendKeys(excel.readExcel(1, 7, ".\\Data\\data.xlsx", "Sheet2"));
    	driver.findElement(password).sendKeys(excel.readExcel(1, 8,".\\Data\\data.xlsx","Sheet2"));
    	driver.findElement(createCustomerButton).click();
    	System.out.println("Checking");
    	Thread.sleep(6000);
    	//Getting customer ID and storing it in CustomerId variable
    	CustomerId = driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]/following-sibling::td")).getText();
    	System.out.println("Customer ID: " + CustomerId);
    	return(CustomerId);
    	
    }
    
    public void navigateNewCustomer(WebDriver driver)
    {
    	driver.navigate().to("https://demo.guru99.com/v4/manager/addcustomerpage.php");
    }
    
}

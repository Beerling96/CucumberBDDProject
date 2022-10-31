package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PgeObject.AddNewCustomerPage;
import PgeObject.LoginPage;
import PgeObject.SearchCustomerPage;
import Utilities.ReadConfig;

import org.apache.logging.log4j.*;
public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage SearchCustPg;
	public static Logger log;
	public ReadConfig readConfig;
	
	public String generateEmailId() {
		return(RandomStringUtils.randomAlphabetic(5));
	}
}

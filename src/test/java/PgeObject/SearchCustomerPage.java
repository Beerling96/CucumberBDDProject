package PgeObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);  
	}
	
	@FindBy(id = "SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id = "search-customers")
	WebElement searchBtn;
	
	
	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@role='grid']//tbody/tr")
	List<WebElement> tablRows;
	
	@FindBy(xpath = "//table[@role='grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;
	
	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}
	
	public void clickOnSearchButton() {
		searchBtn.click();
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean found = false;
		
		//total no of rows 
		int tttlRows = tablRows.size();

		//and columns
		//int ttlColumns = tableColumns.size();
		
		
		for(int i=1; i<tttlRows; i++) {
			WebElement webElementEmail = ldriver.findElement(By.xpath("//table[@role='grid']//tbody/tr[" + i + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			
			if(actualEmailAdd.equals(email)) {
				found = true;
			}
			
		}
		return found;
	}
}

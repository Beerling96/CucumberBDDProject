package StepDefinition;

import io.cucumber.java.en.And;

public class CloseStep extends BaseClass{

	@And("close browser")
	public void close_browser() {
		driver.close();
		log.info("Browser closed");
		
		//driver.quit();

	}
}

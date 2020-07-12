package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "header-content")
	WebElement Title_Field;
	@FindBy(how = How.XPATH, using = "//form[@name='todo']/descendant::input[@type='checkbox']")
	WebElement ListCheckBoxElements;
	
	public void waitForElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@name='todo']/descendant::input[@type='checkbox']")));
	}

}

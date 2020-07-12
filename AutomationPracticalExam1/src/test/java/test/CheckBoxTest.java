package test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import page.ListItemsPage;
import util.BrowserFactory;

public class CheckBoxTest {
	WebDriver driver;
	ListItemsPage listItemsPage;
	
	@FindBy(how = How.XPATH, using = "//form[@name='todo']/descendant::input[@type='checkbox']")
	WebElement ListCheckBoxElements;
	
	@Before
	public void startEverything() {
		driver = BrowserFactory.startBrowser();
		listItemsPage = PageFactory.initElements(driver, ListItemsPage.class);
	}

	@Test
	public void toggleAllCheckBoxTest() throws InterruptedException {
		listItemsPage.clickOnToggleAllBox();
		Assert.assertTrue(isAllCheckBoxesSelected(ListCheckBoxElements));
		Thread.sleep(3000);
	}

	private boolean isAllCheckBoxesSelected(WebElement listCheckBoxElements2) {
		List<WebElement> list = driver
				.findElements(By.xpath("//form[@name='todo']/descendant::input[@type='checkbox']"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isSelected()) {
			}
		}
		return true;
	}

	@After
	public void closeEverything() {
		driver.close();
		driver.quit();
	}

}

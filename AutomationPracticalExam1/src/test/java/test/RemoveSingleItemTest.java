package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import page.DashboardPage;
import page.ListItemsPage;
import util.BrowserFactory;

public class RemoveSingleItemTest {
	WebDriver driver;
	ListItemsPage listItemsPage;
	DashboardPage dashboardPage;

	@FindBy(how = How.XPATH, using = "//form[@name='todo']/descendant::input[@type='checkbox']")
	WebElement ListCheckBoxElements;

	@Before
	public void startEverything() {
		driver = BrowserFactory.startBrowser();
		listItemsPage = PageFactory.initElements(driver, ListItemsPage.class);
	}

	@Test
	public void singleItemShouldBeAbleToRemove() throws InterruptedException {
		listItemsPage.clickOnSingleItemBox();
		Thread.sleep(2000);
		listItemsPage.clickOnRemoveButton();
		Assert.assertNull("Could not remove item!",ListCheckBoxElements);
		Thread.sleep(5000);
	}

	@After
	public void closeEverything() {
		driver.close();
		driver.quit();
	}
}

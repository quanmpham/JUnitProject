package test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.ListItemsPage;
import util.BrowserFactory;

public class RemoveAllItemsTest {
	WebDriver driver;
	ListItemsPage listItemsPage;

	@Before
	public void launchBrowser() {
		driver = BrowserFactory.startBrowser();
		listItemsPage = PageFactory.initElements(driver, ListItemsPage.class);
	}

	@Test
	public void selectBoxTest() throws InterruptedException {
		listItemsPage.clickOnToggleAllBox();
		listItemsPage.clickOnRemoveButton();
		Assert.assertTrue("Did not successfully delete all the checkboxes!", isListItemsEmpty());
		Thread.sleep(5000);
	}
	
	public boolean isListItemsEmpty() {
		List<String> checkBoxList = listItemsPage.getListOfCheckBoxes();
		for (int i = 0; i < checkBoxList.size(); i++) {
			if (checkBoxList.get(i).isEmpty()) {
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

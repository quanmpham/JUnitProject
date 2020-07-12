package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListItemsPage {

	WebDriver driver;

	public ListItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	// Library of elements
	@FindBy(how = How.NAME, using = "allbox")
	WebElement AllBox_Field;
	@FindBy(how = How.NAME, using = "todo[0]")
	WebElement ZeroBox_Field;
	@FindBy(how = How.NAME, using = "todo[1]")
	WebElement OneBox_Field;
	@FindBy(how = How.XPATH, using = "//input[@value='Remove']")
	WebElement Remove_Button;
	@FindBy(how = How.XPATH, using = "//form[@name='todo']/descendant::input[@type='checkbox']")
	WebElement ListCheckBoxElements;

	public void clickOnSingleItemBox() {
		ListCheckBoxElements.click();
	}

	public void clickOnToggleAllBox() {
		AllBox_Field.click();
	}

	public void clickOnRemoveButton() {
		Remove_Button.click();
	}

	public List<String> getListOfCheckBoxes() {
		List<String> list = new ArrayList<String>();

		List<WebElement> columnDataElements = driver
				.findElements(By.xpath("//form[@name='todo']/descendant::input[@type='checkbox']"));
		for (int i = 0; i < columnDataElements.size(); i++) {
			list.add(i, columnDataElements.get(i).getText());
		}
		return list;
	}

}

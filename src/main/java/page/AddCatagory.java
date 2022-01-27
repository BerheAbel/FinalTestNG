package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddCatagory {

	WebDriver driver;
	public AddCatagory(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']") WebElement ADDCATAGORY;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']") WebElement ADDBUTTON;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']") WebElement DROPDOWN;
	public void userAbleToAddCatagory(String X) {
		ADDCATAGORY.sendKeys(X);
	}
	public void UserAbleToClick() {
		ADDBUTTON.click();
	}
	public void userNotAbleToDuplicateValues(String X) {
		ADDCATAGORY.sendKeys(X);
		ADDBUTTON.click();
	}
	public void userVlidatingMonth(String month) {
		Select select = new Select(DROPDOWN);
		select.selectByVisibleText(month);
	}
}

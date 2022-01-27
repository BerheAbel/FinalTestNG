package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCatagory;
import util.BrowserFactory;

public class TestPage {

	WebDriver driver;
	@Test
	public void catagory()  {
		driver = BrowserFactory.init();
		AddCatagory addcatagory = PageFactory.initElements(driver, AddCatagory.class);
		addcatagory.userAbleToAddCatagory("AbelBerhe");
		addcatagory.UserAbleToClick();
		addcatagory.userNotAbleToDuplicateValues("Abel3");
		addcatagory.userVlidatingMonth("Jan");
		addcatagory.userVlidatingMonth("Feb");
		addcatagory.userVlidatingMonth("Mar");
	}
}

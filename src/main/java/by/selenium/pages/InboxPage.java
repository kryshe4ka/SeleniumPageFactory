package by.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends Page {

	@FindBy(xpath = "//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a")
	private WebElement eWriteLetter;

	@FindBy(id = "PH_logoutLink")
	private WebElement logOut;

	public InboxPage(WebDriver driver) {
		super(driver);
	}

	public NewLetterPage pressButtonNewLetter() {
		eWriteLetter.click();
		sleep(4000);
		return new NewLetterPage(driver);
	}

	public MainPage logOut() {
		logOut.click();
		return new MainPage(driver);
	}

}

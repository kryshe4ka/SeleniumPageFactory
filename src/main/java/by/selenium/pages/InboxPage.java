package by.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InboxPage extends Page {

	private final By logOutLocator = By.id("PH_logoutLink");
	private final By eWriteLetterLocator = By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a");

	public InboxPage(WebDriver driver) {
		super(driver);
	}

	public NewLetterPage pressButtonNewLetter() {
		WebElement eWriteLetter = driver.findElement(eWriteLetterLocator);
		eWriteLetter.click();
		sleep(2000);
		return new NewLetterPage(driver);
	}

	public MainPage logOut() {
		getDriver().findElement(logOutLocator).click();
		return new MainPage(driver);
	}

}

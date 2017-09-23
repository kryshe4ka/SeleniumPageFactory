package by.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

	private final String URL = "https://mail.ru";
	private final String LOGIN = "tathtp";
	private final String PASSWORD = "Klopik123";
	private final By eLoginLocator = By.id("mailbox__login");
	private final By ePasswordLocator = By.id("mailbox__password");

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}
	
	public InboxPage authorization() {
		WebElement eLoginField = getDriver().findElement(eLoginLocator);
		eLoginField.sendKeys(LOGIN);
		WebElement ePasswordField = getDriver().findElement(ePasswordLocator);
		ePasswordField.sendKeys(PASSWORD);
		ePasswordField.submit();
		return new InboxPage(driver);
	}

}

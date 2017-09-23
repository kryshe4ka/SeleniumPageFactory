package by.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

	@FindBy(id = "mailbox__login")
	private WebElement eLoginField;

	@FindBy(id = "mailbox__password")
	private WebElement ePasswordField;

	private final String URL = "https://mail.ru";
	private final String LOGIN = "tathtp";
	private final String PASSWORD = "Klopik123";

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}

	public InboxPage authorization() {
		eLoginField.sendKeys(LOGIN);
		ePasswordField.sendKeys(PASSWORD);
		ePasswordField.submit();
		sleep(10000);
		return new InboxPage(driver);
	}

}

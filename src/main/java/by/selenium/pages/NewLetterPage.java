package by.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewLetterPage extends Page {

	@FindBy(xpath = "//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]")
	private WebElement eToField;

	@FindBy(name = "Subject")
	private WebElement eSubjectField;

	@FindBy(id = "tinymce")
	private WebElement eMessageBody;

	@FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
	private WebElement frame;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div")
	private WebElement eSendButton;

	@FindBy(id = "PH_logoutLink")
	private WebElement logOut;

	private final String TO = "kryshe4ka@gmail.com";
	private final String SUBJECT = "SPAM: AutoTest by Selenium";
	private final String MESSAGE = "Hello!\n This is auto letter by Selenium\nBest regards,\nLisa Kryshkovskaya";

	public NewLetterPage(WebDriver driver) {
		super(driver);
	}

	public InboxPage sendLetter() {
		eToField.sendKeys(TO);
		eSubjectField.sendKeys(SUBJECT);
		driver.switchTo().frame(frame);
		eMessageBody.sendKeys(MESSAGE);
		driver.switchTo().defaultContent();
		eSendButton.click();
		sleep(3000);
		return new InboxPage(driver);
	};

	public MainPage logOut() {
		logOut.click();
		return new MainPage(driver);
	}
}

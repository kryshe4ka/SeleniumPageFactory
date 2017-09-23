package by.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewLetterPage extends Page {

	private final String TO = "kryshe4ka@gmail.com";
	private final String SUBJECT = "SPAM: AutoTest by Selenium";
	private final String MESSAGE = "Hello!\n This is auto letter by Selenium\nBest regards,\nLisa Kryshkovskaya";
	private final By eToLocator = By
			.xpath("//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]");
	private final By eSubjectLocator = By.name("Subject");
	private final By eMessageBodyLocator = By.id("tinymce");
	private final By eSendButtonLocator = By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div");
	private final By frameLocator = By.xpath("//iframe[contains(@id,'composeEditor_ifr')]");
	private final By logOutLocator = By.id("PH_logoutLink");

	public NewLetterPage(WebDriver driver) {
		super(driver);
	}

	public InboxPage sendLetter() {
		WebElement eToField = driver.findElement(eToLocator);
		eToField.sendKeys(TO);
		WebElement eSubjectField = driver.findElement(eSubjectLocator);
		eSubjectField.sendKeys(SUBJECT);
		WebElement frame = driver.findElement(frameLocator);
		driver.switchTo().frame(frame);
		WebElement eMessageBody = driver.findElement(eMessageBodyLocator);
		eMessageBody.sendKeys(MESSAGE);
		driver.switchTo().defaultContent();
		WebElement eSendButton = driver.findElement(eSendButtonLocator);
		eSendButton.click();
		sleep(3000);
		return new InboxPage(driver);
	};

	public MainPage logOut() {
		getDriver().findElement(logOutLocator).click();
		return new MainPage(driver);
	}
}

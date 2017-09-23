package by.selenium.pagestest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

import by.selenium.pages.InboxPage;
import by.selenium.pages.MainPage;
import by.selenium.pages.NewLetterPage;

@RunWith(JUnit4.class)
public class SmokePagesTest extends TestCase {

	private WebDriver driver;
	private final String CHROME = "webdriver.chrome.driver";
	private final String CHROMEDRIVERPATH = "/usr/local/bin/chromedriver";
	static MainPage mainPage;
	static InboxPage inboxPage;
	static InboxPage resultPage;
	static NewLetterPage newLetterPage;

	@Before
	public void initBrowserChrome() {
		System.setProperty(CHROME, CHROMEDRIVERPATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		mainPage = PageFactory.initElements(driver, MainPage.class);
		inboxPage = PageFactory.initElements(driver, InboxPage.class);
		newLetterPage = PageFactory.initElements(driver, NewLetterPage.class);
		resultPage = PageFactory.initElements(driver, InboxPage.class);
	}

	@Test
	public void sendNewLetterTest() {
		// Open main page
		mainPage.open();
		// Authorization
		inboxPage = mainPage.authorization();
		// Send New Letter
		newLetterPage = inboxPage.pressButtonNewLetter();
		resultPage = newLetterPage.sendLetter();
		// Log out
		resultPage.logOut();
	}

	@After
	public void destroyBrowser() {
		driver.quit();
	}
}

package by.selenium.pagestest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import junit.framework.TestCase;

import by.selenium.pages.InboxPage;
import by.selenium.pages.MainPage;
import by.selenium.pages.NewLetterPage;

@RunWith(JUnit4.class)
public class SmokePagesTest extends TestCase{

	private WebDriver driver;
	private final String CHROME = "webdriver.chrome.driver";
	private final String CHROMEDRIVERPATH= "/usr/local/bin/chromedriver";

	@Before
	public void initBrowserChrome() {
		System.setProperty(CHROME, CHROMEDRIVERPATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void sendNewLetterTest() {
		// Open main page
		MainPage mainPage = new MainPage(driver);
		mainPage.open();
		// Authorization
		InboxPage inboxPage = mainPage.authorization();
		// Send New Letter
		NewLetterPage newLetterPage = inboxPage.pressButtonNewLetter();
		InboxPage resultPage = newLetterPage.sendLetter();
		//Log out
		resultPage.logOut();
	}

	@After
	public void destroyBrowser() {
		driver.quit();
	}
}

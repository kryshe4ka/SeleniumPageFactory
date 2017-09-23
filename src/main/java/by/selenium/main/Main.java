package by.selenium.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	private final static String CHROME = "webdriver.chrome.driver";
	private final static String CHROMEDRIVERPATH = "/usr/local/bin/chromedriver";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

	}

}

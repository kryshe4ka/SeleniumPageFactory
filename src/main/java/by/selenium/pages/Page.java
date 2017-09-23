package by.selenium.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	protected final WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void sleep(int msek) {
		try {
			Thread.sleep(msek);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

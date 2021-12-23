package com.orangehrmlive.demo.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitUtils {
	
	static WebDriverWait wait;
	
	
	public static void waitforElementCLickable(WebElement element , WebDriver driver) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitforElementVisible(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitforelementToBeSelected(WebElement element , WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
}

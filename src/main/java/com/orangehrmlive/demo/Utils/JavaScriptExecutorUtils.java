package com.orangehrmlive.demo.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtils {
	
	static JavascriptExecutor js;
	
	
	public static void jsScrolltoElement(WebElement element , WebDriver driver) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void jsClick(WebElement element, WebDriver driver) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

}

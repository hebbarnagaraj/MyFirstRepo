package com.orangehrmlive.demo.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
	
	
	static Actions actions;
	
	public static void mouseHoverAction(WebDriver driver , WebElement element) {
		actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public static void doubleCLickAction(WebDriver driver , WebElement element) {
		actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public static void contextClickAction(WebDriver driver , WebElement element) {
		actions=new Actions(driver);
		actions.contextClick(element);
	}
	

}

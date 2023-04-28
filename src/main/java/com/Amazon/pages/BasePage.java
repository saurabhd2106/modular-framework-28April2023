package com.Amazon.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.DropdownControl;
import commonLibs.ElementControl;
import commonLibs.FrameControl;
import commonLibs.MouseControl;

public class BasePage {
	
	ElementControl elementControl;
	
	MouseControl mouseControl;
	
	DropdownControl dropdownControl;
	
	FrameControl frameControl;
	
	public BasePage(WebDriver driver) {
		
		elementControl = new ElementControl();

		dropdownControl = new DropdownControl();

		mouseControl = new MouseControl(driver);
		
		frameControl = new FrameControl(driver);
	}

}

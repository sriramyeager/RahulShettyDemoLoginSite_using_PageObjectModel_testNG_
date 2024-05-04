package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base  {

	WebDriver driver;
	public Properties prop;

	public base() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver intializeBrowserAndOpenApplication(String broswerName) {

		if (broswerName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if(broswerName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();

		}else if (broswerName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		}else if (broswerName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		return driver;
	} 


}


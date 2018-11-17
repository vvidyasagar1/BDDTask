package com.utilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver=null;


    public static WebDriver getDriver(String typeOfDriver){
        switch(typeOfDriver.toUpperCase())
        {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
   
                 driver=new ChromeDriver();
                 break;
            case "IE":
                System.setProperty("webdriver.ie.driver","src\\test\\resources\\drivers\\IEDriverServer.exe");
                driver=new InternetExplorerDriver();
                break;
            default:
            	System.setProperty("webdriver.ie.driver","src\\test\\resources\\drivers\\geckodriver.exe");
            	driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
   
@After
public void closeDriver(){
    driver.quit();
}
}


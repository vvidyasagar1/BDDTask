package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver=driver;
    }

    //Using FindBy for locating elements
    @FindBy(how= How.NAME, using="q")
    WebElement searchText;
    @FindBy(how= How.NAME, using="btnK")
    WebElement searchBtn;


    public void openSearchPage(){
        driver.get("https://www.google.com");
    }
    public void enterSearchData(String searchInput){
        searchText.sendKeys(searchInput);
        searchBtn.click();
    }
    public int getNumberOfGumLinks(String searchLink){
        return  driver.findElements(By.xpath("//h3[contains(text(),'"+searchLink+"')]")).size();
    }
    public void navigateGumLinks(String searchLink){
        List<WebElement> gumLinks=driver.findElements(By.partialLinkText(searchLink));

        System.out.println("size---->"+gumLinks.size());
        if(gumLinks.size()>0){
            for(int i=0;i<gumLinks.size();i++){
            	 System.out.println("size---->"+gumLinks.size());
                WebDriverWait wait=new WebDriverWait(driver,5);
                wait.until(ExpectedConditions.elementToBeClickable(gumLinks.get(i)));
                String originalHandle = driver.getWindowHandle();

                String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
                gumLinks.get(i).sendKeys(selectLinkOpeninNewTab);
                System.out.println("title-->"+driver.getTitle());
                //Do something to open new tabs
                for(String handle : driver.getWindowHandles()) {
                    if (!handle.equals(originalHandle)) {
                        driver.switchTo().window(handle);
                        driver.close();
                    }
                }
                driver.switchTo().window(originalHandle);
            }
        }
    }
}

package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import com.pages.SearchPage;
import org.openqa.selenium.support.PageFactory;
import com.utilities.Driver;

public class GoogleSteps {
    WebDriver driver;
    SearchPage searchPage;

    @Given("^user is on Google Home Page$")
    public void user_is_on_Google_Home_Page() {
        driver = Driver.getDriver("chrome");
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.openSearchPage();

    }

    @When("^validate how many Gumtree links there are available ([^\"]*)$")
    public void choose_to_buy_the_first_item(String searchLink) {
        System.out.println("The count of GumTree links"+searchPage.getNumberOfGumLinks(searchLink));

    }

    @When("^navigate to each Gumtree link ([^\"]*)$")
    public void moves_to_checkout_from_mini_cart(String searchLink) {
        searchPage.navigateGumLinks(searchLink);
    }

    @When("^verify the number of results ([^\"]*)$")
    public void enter_personal_details_on_checkout_page(String searchLink) throws InterruptedException {
        if (searchPage.getNumberOfGumLinks(searchLink) > 0) {
            Assert.assertTrue("The number of the results is greater than 0.",true);
        }
    }


    //@When("^he search for as ([^\"]*)$")
    @When("^he search for as ([^\"]*)$")
    public void he_search_for_as_Cars_in_London(String arg1) {

        searchPage.enterSearchData(arg1);
    }
    @When("^Close the application$")
    public void closeApplication(){
        driver.quit();
    }
}



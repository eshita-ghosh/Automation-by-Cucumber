package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.LandingPage;
import setup.Setup;

public class searchStepDefinition extends Setup {
    LandingPage landingPage;
    @Given("user visits the website")
    public void user_visits_the_website() {
        driver.get("https://github.com/");
    }
    @When("user input the search {string}")
    public void userInputTheSearch(String keyword) throws InterruptedException {
        landingPage = new LandingPage(driver);
        //landingPage.doSearch(keyword);
        driver.findElement(By.xpath("//button[@placeholder='Search or jump to...']")).click();
        driver.findElement(By.id("query-builder-test")).sendKeys(keyword);
        Thread.sleep(2000);
        driver.findElement(By.id("query-builder-test")).sendKeys(Keys.ENTER);
    }
    @Then("search result display and verify with {string}")
    public void searchResultDisplayAndVerifyWith(String repoName) throws InterruptedException {
        Thread.sleep(10000);
        //String actualVal = driver.findElements(By.className("search-match")).get(0).getText();
        //String actualVal = driver.findElement(By.xpath("//a[@[href=\"/facebook/create-react-app\"]")).getText();
        String actualVal = driver.findElements(By.className("qaOIC")).get(0).getText();
        //Thread.sleep(10000);
        Assert.assertTrue(actualVal.contains(repoName));
    }

    @And("user click on about page")
    public void userClickOnAboutPage() throws InterruptedException {
        landingPage = new LandingPage(driver);
        driver.findElement(By.className("octicon-mark-github")).click();
        Thread.sleep(5000);
        landingPage.doScroll(driver);
        landingPage.clickAbout();
        Thread.sleep(5000);
    }

    @Then("user verify the about page")
    public void userVerifyTheAboutPage() {
        String actualVal = driver.getCurrentUrl();
        String expectedVal = "about";
        Assert.assertTrue(actualVal.contains(expectedVal));
    }

}

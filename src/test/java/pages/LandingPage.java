package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {
    public LandingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//button[@placeholder='Search or jump to...']")
    public WebElement searchField;
    @FindBy(className = "Link--secondary")
    public List<WebElement> linkAbout;
//    @FindBy(className = "search-match")
//    public List<WebElement> searchResulTtxt;

    public void doSearch(String keyword) throws InterruptedException {
        //searchField.sendKeys(keyword);
        searchField.sendKeys("create-react-app");
        Thread.sleep(2000);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
    public void clickAbout(){
        linkAbout.get(48).click();
    }
    public void doScroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,2000)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}

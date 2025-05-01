package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.URLs;

public class HomePage extends BasePage {

    /**
     * Constructor for BasePage.
     * Initializes WebDriver, WebDriverWait, and JavaScriptExecutorHelper.
     *
     * @param driver WebDriver instance to be used
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By teamLink= By.xpath("//a[.='Team']");

    public void clickTeamLinkOnNavbar(){
        clickWithJS(driver.findElements(teamLink).get(0));
    }

    public void naviateToHomePage() {
        driver.get(URLs.BASE_URL.getUrl());
        acceptCookie();
    }

   
}

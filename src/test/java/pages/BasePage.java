package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.TimeoutConstants;

/**
 * Base class for all page objects in the application.
 * Provides common functionality and utilities for page interactions.
 * Implements both IPageActions and IElementActions interfaces.
 */
public abstract class BasePage{
    /** Logger instance for this class */
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    
    /** WebDriver instance for browser interactions */
    protected final WebDriver driver;
    
    /** WebDriverWait instance for explicit waits */
    protected final WebDriverWait wait;

    private JavascriptExecutor jsExecutor;

    private By acceptCookie= By.id("hs-eu-confirmation-button");
    private By languageChoose= By.xpath("(//*[@class=\"nav-lang__item w-inline-block nav-lang__active\"])[1]");
    private By deLanguageChoose =By.xpath("(//a[@cb-lang-code=\"de\"])[1]");
    private By engLanguageChoose =By.xpath("(//a[@cb-lang-code=\"en\"])[1]");

    /**
     * Constructor for BasePage.
     * Initializes WebDriver, WebDriverWait, and JavaScriptExecutorHelper.
     * @param driver WebDriver instance to be used
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TimeoutConstants.EXPLICIT_WAIT_MEDIUM);
        PageFactory.initElements(driver, this);
        this.jsExecutor = (JavascriptExecutor) driver;

    }

    public void acceptCookie(){
        click(acceptCookie);
    }

    public void setLanguageChoose(String language){
        hover(languageChoose);
        if (language.equalsIgnoreCase("De")){
            clickWithJS(deLanguageChoose);
        }else if (language.equalsIgnoreCase("En")){
            clickWithJS(engLanguageChoose);
        }
    }

    /**
     * Scrolls to an element containing specific text within a given tag.
     * @param tagName HTML tag name to search within
     * @param text Text content to find
     * @return WebElement containing the specified text
     */
    public WebElement scrollToElementByText(String tagName, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script =
                "var elements = [...document.querySelectorAll(arguments[0])];" +
                        "var el = elements.find(e => e.innerText.includes(arguments[1]));" +
                        "if (el) { el.scrollIntoView({behavior: 'smooth', block: 'center'}); }" +
                        "return el;";

        return (WebElement) js.executeScript(script, tagName, text);
    }

    /**
     * Finds an element containing specific text within a given tag.
     * @param tagName HTML tag name to search within
     * @param text Text content to find
     * @return WebElement containing the specified text
     */
    public WebElement findElementByText(String tagName, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return [...document.querySelectorAll(arguments[0])].find(el => el.innerText.includes(arguments[1]));";
        return (WebElement) js.executeScript(script, tagName, text);
    }

    /**
     * Sets the value of a dropdown element using JavaScript.
     * @param dropdown WebElement representing the dropdown
     * @param value Value to be selected
     */
    protected void selectDropdownByValue(WebElement dropdown, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].value='" + value + "';";
        js.executeScript(script, dropdown);
    }

    /**
     * Waits for the page to load completely.
     * Checks document.readyState until it equals "complete".
     */
    public void waitForPageLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
            logger.debug("Page load completed successfully");
        } catch (Exception e) {
            logger.error("Page failed to load within timeout period", e);
            throw e;
        }
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void click(By locator) {
        try {
            waitForElementVisible(locator).click();
        } catch (Exception e) {
        }
    }

    public void clickWithJS(By locator) {
        WebElement element = waitForElementVisible(locator);
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    public void clickWithJS(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    // SendKeys (By)
    public void sendKeys(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeys(WebElement element, String text) {
        waitForElementVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    // SendKeys with JS (By)
    public void sendKeysWithJS(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, text);
    }

    // SendKeys with JS (WebElement)
    public void sendKeysWithJS(WebElement element, String text) {
        waitForElementVisible(element);
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, text);
    }

    public void switchToFrame(By locator) {
        WebElement iframe = waitForElementVisible(locator);
        driver.switchTo().frame(iframe);
    }

    public void switchToFrame(WebElement iframeElement) {
        waitForElementVisible(iframeElement);
        driver.switchTo().frame(iframeElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hover(By locator) {
        WebElement element = waitForElementVisible(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
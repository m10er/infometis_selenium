package pages;

import model.JobAapplyForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobPage extends BasePage {

    /**
     * Constructor for BasePage.
     * Initializes WebDriver, WebDriverWait, and JavaScriptExecutorHelper.
     *
     * @param driver WebDriver instance to be used
     */
    public JobPage(WebDriver driver) {
        super(driver);
    }

    private final By jobsLink= By.cssSelector("[class=\"filter__btn w-radio\"]");
    private final By jobsList = By.xpath("//*[@class=\"infometen w-inline-block\"]//h4");
    private final By inputs= By.cssSelector("[class='input']");
    private final By firstName = By.cssSelector("input[name=\"firstname\"]");
    private final By lastName= By.cssSelector("[placeholder=\"Nachname*\"]");
    private final By email = By.cssSelector("[name=\"email\"]");
    private final By phone = By.cssSelector("[name=\"phone\"]");
    private final By cv = By.cssSelector("[type=\"file\"]");
    private final By motivationInput= By.cssSelector("[name=\"message\"]");
    private final By submitButtons = By.cssSelector("[class=\"hs-button primary large\"]");
    private final By iframeId= By.xpath("(//*[@class=\"hs-form-iframe\"])[1]");
    private final By warnAllField = By.xpath("//*[contains(text(), 'Bitte füllen Sie alle Pflichtfelder aus.')]");



    public void clickJobsLink(){
        clickWithJS(driver.findElements(jobsLink).get(5));

    }

    public void clickJobsItem(String jobsType){
        List<WebElement> jobs= driver.findElements(jobsList);
        for (WebElement job: jobs){
            try {
                if (job.getText().equalsIgnoreCase(jobsType.toLowerCase())){
                    clickWithJS(job);
            }

            } catch (Exception e) {
            }
        }
    }

    public void setJobApplyForm(JobAapplyForm user) throws InterruptedException {
        waitForPageLoad();
           switchToFrame(iframeId);

        sendKeysWithJS(firstName,user.getFirstName());
        sendKeysWithJS(lastName, user.getLastName());
        sendKeysWithJS(email, user.getEmailAddres());
        sendKeysWithJS(phone, user.getPhone());
        sendKeys(cv, user.getFilePath());
        sendKeysWithJS(motivationInput, user.getMotivation());
    }

    public void clickSubmitButton(){
        clickWithJS(submitButtons);
    }

    public boolean isDisplayedWarningForAllInput(){
        return driver.findElement(warnAllField).isDisplayed();
    }

}

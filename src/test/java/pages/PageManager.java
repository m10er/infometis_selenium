package pages;

import org.openqa.selenium.WebDriver;



public class PageManager {
    public HomePage homePage;
    public JobPage jobPage;


    public PageManager(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.jobPage = new JobPage(driver);
    }
}

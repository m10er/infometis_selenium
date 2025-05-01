package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseSteps{
    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        pageManager.homePage.naviateToHomePage();
    }
    @When("the user clicks on the {string} link in the navbar")
    public void theUserClicksOnTheLinkInTheNavbar(String arg0) {
        pageManager.homePage.clickTeamLinkOnNavbar();
    }

    @And("the user set the Language as {string}")
    public void theUserSetTheLanguageAs(String language) {
        pageManager.homePage.setLanguageChoose(language);
    }
}

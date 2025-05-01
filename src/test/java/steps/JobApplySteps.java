package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import model.JobAapplyForm;
import org.junit.Assert;
import utilities.faker.TestDataGeneratorFactory;


public class JobApplySteps extends BaseSteps {
    JobAapplyForm jobAapplyForm;

    @And("the user clicks on the {string} linkin the Team Page")
    public void theUserClicksOnTheLinkinTheTeamPage(String arg0) {
        pageManager.jobPage.clickJobsLink();
    }


    @And("the user fills in the job application form without entering motivation text")
    public void theUserFillsInTheJobApplicationFormWithoutEnteringMotivationText() throws InterruptedException {
        jobAapplyForm= new JobAapplyForm();
        jobAapplyForm.setFirstName(TestDataGeneratorFactory.getGenerator().generateFirstName());
        jobAapplyForm.setLastName(TestDataGeneratorFactory.getGenerator().generateLastName());
        jobAapplyForm.setPhone(TestDataGeneratorFactory.getGenerator().generatePhoneNumber());
        jobAapplyForm.setEmailAddres(TestDataGeneratorFactory.getGenerator().generateEmail());
        jobAapplyForm.setFilePath("C:\\Users\\User\\Desktop\\infometis_Playwright\\file\\CVMuammer.pdf");
        pageManager.jobPage.setJobApplyForm(jobAapplyForm);
    }

    @And("the user submits the job application form")
    public void theUserSubmitsTheJobApplicationForm() {
        pageManager.jobPage.clickSubmitButton();
    }

    @Then("the user should see an error message indicating that all fields must be filled")
    public void theUserShouldSeeAnErrorMessageIndicatingThatAllFieldsMustBeFilled() {
        Assert.assertTrue(pageManager.jobPage.isDisplayedWarningForAllInput());
    }

    @And("the user clicks on the {string}")
    public void theUserClicksOnThe(String job) {
        pageManager.jobPage.clickJobsItem(job);

    }
}

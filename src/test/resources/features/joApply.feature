@job
Feature: Job Application Form Validation

  Scenario: User submits job application form without filling motivation field
    Given the user is on the homepage
    When the user clicks on the "Team" link in the navbar
    And the user clicks on the "Jobs" linkin the Team Page
    And the user clicks on the "Software Test Automation Engineer"
    And the user fills in the job application form without entering motivation text
    And the user submits the job application form
    Then the user should see an error message indicating that all fields must be filled
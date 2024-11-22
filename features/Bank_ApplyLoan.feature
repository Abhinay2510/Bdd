Feature: Log in and Logout functionality

  Scenario: Log in and Logout|TC_05_bank_test

    Given User opens the browser and navigates to the application
    When User enters "Abhinay" and "infotech@1"
    And User enters a 4 digit number
    And User clicks on the Login button
    And User clicks on the Apply Now button
    And User scrolls down until the checkbox is visible
    And User selects the checkbox
    And User clicks on the Agree and Continue button
    And User clicks on the Profile button
    And User clicks on the Logout button

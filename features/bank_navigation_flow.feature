Feature: Apply loan from Online Bank

  @3iBank_flow, @regession
  Scenario: User applies for a loan online through Bank |TC_02_bank_test

    Given User opens the chrome and launch Bank application
    When Enter login details and sigin into bank
    Then User should Navigate to Dashborad and click on apply button
    And Fill the personal Details and Click on Save button
    #And Fill the Employment Details and click on submit button
    #And Validate UI Message
    And click user icon and logout output
    
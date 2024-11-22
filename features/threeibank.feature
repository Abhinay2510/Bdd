Feature: Flexcube Login Feature

	@TC_1
  Scenario: Successful login with valid credentials | Flexcube_TC_01
   # Given the user open the Flexcube app in the browser
    #Then Verify the Flexcube app login page
    When the user enter the  "valid_login_name" and "password"
    And the user clicks on the Sign in button
    Then Verify user
    #When the user clicks on the logout button

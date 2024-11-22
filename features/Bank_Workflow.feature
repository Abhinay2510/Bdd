Feature: Login and Profile Update

Scenario: Login and Update Profile|TC_04_bank_test
  Given I am on the login page
  When I enter username "bhaskar" and password "bhaskar"
  And I enter 4 digit number "2222"
  And I click on Login button
  And I click on Logout
Feature: Flexcube Login Feature

 
  Scenario: Successful CIF number creation for individual customer |Flexcube_TC_01
    
    Given User opens the chrome browser and launches the Oracle Flexcube Application
    When Maker enter the login detailes and sigin into the Flexcube Application
    And Enter fastpath code "STDCIF" and click on go button
    And Verify the Customer Mainteance Screen is displayed
    And Click on New Option in the screen
    And user click on "Individual" customer type
    And Click on Custmer no P button in the screen
    And user click and enter Full Name "CustomerFullName"
    And User click and enter Short Name "CustomerShortName"
    And Enter Customer Category
    And User Fills all Mandatory field under Personal tab
    And User click on Additional tab
    When Enter data of location and Media fields under additional tab
    And Click on Save button
    And Remarked pop up should be display
    And user click on Ok button
    And Override description popup should be displayed
    When user click on Accept button in the popup
    And Successfully Created the customer number and sent to Checker for the Authorization 
    And Close the Customer Maintenance screen
    #checker
    When Open the Oracle flexcube in the new window tab
    And Checker enter the login detailes and sigin into the Flexcube Application
    And Enter fastpath code "STSCIF" and click on go button
    And Verify the Customer Summary is displayed
    And Search for "UnAuthorized" Customer number in the Customer summary screen
    And Save the Generate Customer Number
    And Double click on the UnAuthorized Customer number in the list
    And Verify the Unauthorized Customer Record in the Customer Maintenance screen
    And Click on the Authorize button in the screen
    And user click on Accept button in the Authorize screen
    Then Successfully Created the CIF number for the Individual Customer
    And Close the Customer Maintenance and Customer Summary Screen
     When user clicks on the user profile icon and select sign off option from the list
    Then Confirm Message popup should be displayed with ok and cancel buttons
    When user clicks on the Ok button in the popup screen
    Then user Successfully logs out from the page  and navigate to the Flexcube login page
    
    
    Scenario: Successful Account creation for the individual |Flexcube_TC_02
    Given User opens the chrome browser and launches the Oracle Flexcube Application
    When Maker enter the login detailes and sigin into the Flexcube Application
    And  Enter fastpath code "STDCUSAC" and click on go button
    And Verify the Customer Account Maintenance screen
    And Click on New Option in the screen 
    And Enter the Mandatory Customer number,Account class code and Currency Code fields in the screen
    And Click on Fetch button and Generate the Customer Account Number
    And user click on MIS and Provided the pool code
    And Enter Mandatory fields in Main tab
   	And Click on Save button
    And Remarked pop up should be display
    And user click on Ok button
    And Override description popup should be displayed
    And user click on Accept button in the popup
    Then Successfully Created Customer Account and sent to Checker for Authorization
     And Close the Customer Maintenance screen
    When user clicks on the user profile icon and select sign off option from the list
    And Confirm Message popup should be displayed with ok and cancel buttons
    When user clicks on the Ok button in the popup screen
    Then user Successfully logs out from the page  and navigate to the Flexcube login page
    #checker
    Given Open the Oracle flexcube in the new window tab
    When Checker enter the login detailes and sigin into the Flexcube Application
    And Enter fastpath code "STSCUSAC" and click on go button
    And Verify the Customer Account Summary is displayed
    And Search for "UnAuthorized" Customer number in the Customer Account summary screen
    And Save the Customer Account Number
    And Double click on the UnAuthorized Customer number in the list
    And Verify the Unauthorized Customer Record in the Customer Maintenance screen
    And Click on the Authorize button in the screen
    And user click on Accept button in the Authorize screen
    Then Successfully Authorized the Customer Account and  Created Customer Account number
    And Close the Customer Maintenance and Customer Account Summary Screen
     When user clicks on the user profile icon and select sign off option from the list
    Then Confirm Message popup should be displayed with ok and cancel buttons
    When user clicks on the Ok button in the popup screen
    Then user Successfully logs out from the page  and navigate to the Flexcube login page
    
    

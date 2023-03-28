


@TRAN10-482
Feature: Login feature for transatlantik page


  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts. And dashboard/quick launcpad should be displayed.

  Accounts are: driver,sales manager, store manager



  Background: The user is on the login page
    Given user is on the login page

  @TRAN10-466
  Scenario: Login as driver
    When user enters driver username
    And user enters driver password
    And user click to the login button
    Then user should see the quick launchpad page
   # Then user lands on the quick launchpad page


  @TRAN10-467
    Scenario: Login as sales manager
    When user enters sales manager username
    And user enters sales manager password
    And user click to the login button
    Then user should see the dashboard


 @TRAN10-468
  Scenario: Login as store manager
    When user enters store manager username
    And user enters store manager password
    And user click to the login button
    Then user should see the dashboard







  @TRAN10-469
  Scenario Outline: AC-1:  Can not login with invalid credentials - Negative Scenario
    When The user tries to login with "<username>" and "<password>"
    Then Invalid username or password message should be displayed

    Examples:
      | username        | password    |
      | salesmanager101 | ofjdj       |
      | kkfoefee        | UserUser123 |
      | abcdefgh        | UserUser123 |
      | storemanager51  | aad3412!    |
      | asdaw           | sdf323'+%   |




    @TRAN10-470
  Scenario: Warning Messages from username field
    When The user clicks on login btn while username field is empty,and with any password
    Then "Please fill out this field." message should be displayed in username field



@TRAN10-471
  Scenario: Warning message from password field
    When The user enters any username and click on login btn while password field is empty
    Then "Please fill out this field." message should be displayed in password field




  @TRAN10-472
  Scenario: Warning message from username field
    When user enters anything in the username and password field
    Then "Please fill out this field." message should be displayed in username field




    @TRAN10-475
  Scenario: AC-4: Password field bullet sign
    When The user enters anything into password field
    Then The password field must be seen in bullet sign





    @TRAN10-474
  Scenario: AC-6: Remember me
    And The user  see and clicks on RememberMe button



@TRAN10-476
  Scenario: AC-7: Enter key on keyboard
    When The user enters username into username field
    And Hit the enter key on keyboard
    And The user enters password into password field
    And Hit the enter key on keyboard
    Then The user is on the Quick Launchpad page

  @TRAN10-473
  Scenario: AC-5: Forgot Password page title
    When The user clicks on Forgot your password? link
    Then The user lands on the Forgot Password page



    @TRAN10-477
  Scenario: AC-8: All users can see their usernames in profile menu
    When user enters driver username
    And user enters driver password
    And user click to the login button
      Then The user can see his own username user1 in the profile menu

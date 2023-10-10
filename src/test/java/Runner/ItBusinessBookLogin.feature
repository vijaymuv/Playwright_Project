Feature: Login into It Business Book
Scenario: login with valid credentials
  Given  user launches browser and navigates to it business book
  When user enters email and password
  And user clicks login button
  Then user validates the outcome


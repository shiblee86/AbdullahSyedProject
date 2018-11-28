@SMOKE @TS_1
Feature: Logging into the app

Description: User should be able to login given that user enters valid username and password

Scenario: Logging into the application with valid credential

Given User is able to launch any browser
And User is able to navigate to the url
When User clicks on Account & List
And User enters userName
And User enters password
And User clicks on SignIn button
Then user should be able to see "Hi Syed"
And user should be able to close the browser
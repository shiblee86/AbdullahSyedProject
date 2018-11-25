@smoke @TS_2
Feature: Loggin in function validation

Description: Given that user enters valid user and password user should be able to log into the application

Scenario: User enters valid userName and password to login

Given User is able to launch any browser
And User is able to navigate to the url
When User clicks on Account & List
And User enters valid username
|userName|syed.r.abdullah@gmail.com|
And User enters valid password
|password|$Sa038575|
And User clicks on SignIn button
Then User should be able to see "Hi, Syed"
And User should be able to close the browser

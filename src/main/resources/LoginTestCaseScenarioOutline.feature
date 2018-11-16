@smoke @TS_3
Feature: Loggin function validation

Description: User should only be able to login user valid userName and password

Scenario Outline: User tries to login with both invalid userName and password and valid userName and password

Given User is able to launch any browser
And User is able to navigate to the url
When User clicks on Account & List
And User enters username "<userName>"
And User enters password "<password>"
And User clicks on SignIn button
Then User should see "Hi, Syed"
And User should be able to close the browser

Examples:
|userName|password|
|syed|1234|
|syed.rabdullah@gmail.com|F1234$2|
|syed.r.abdullah@gmail.com|$Sa038575|
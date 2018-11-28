@SMOKE_01 @Test4
Feature: Searching function validation

Description: User should be able to search for items

Scenario Outline: User should be able to search for items and obtain a list

Given User is able to launch any browser
And User is able to navigate to the url
When user enters productName "<productName>" in search box and clicks search
Then user should be able to see the list of searched for
And user should be able to close the browser

Examples:
|productName|
|iphone|
|HP laptop|

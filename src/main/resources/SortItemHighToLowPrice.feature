@SMOKE_1 @TS_5
Feature: Sorting items by price

Description: User should be able to sort items by price

Scenario: User should be able to sort items by selecting high to low from sort drop-down

Given User is able to launch any browser
And User is able to navigate to the url
When user enters productName "<productName>" in search box and clicks search
|productName|
|iphone|
|hp laptop|
Then user should be able to see the list of searched for
And user should be able to click on sort button and click on high to low prices
And user should be able to close the browser


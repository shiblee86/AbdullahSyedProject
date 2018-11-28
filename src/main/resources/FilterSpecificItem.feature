@SMOKE1 @TS_6
Feature: Filtering out specific items

Description: User should be able to filter for specific items after searching for items

Scenario Outline: Filtering out search result for specific product after search is complete

Given User is able to launch any browser
And User is able to navigate to the url
When user enters productName "<productName>" in search box and clicks search
Then user should be able to see product list of page
And user should be able to sort product by price from high to low
And user should be able to filter out specificProduct "<specificProduct>"
And user should be able to close the browser

Examples:
|productName|specificProduct|
|iphone|iPhone X|
|hp laptop|HP Stream|


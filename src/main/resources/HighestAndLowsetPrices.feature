@SMOKE_1 @TS_7
Feature: Seeing highest and lowest prices

Description: User should be able to see item with the highest and item with the lowest price

Scenario: After searching for item, user should be able to see item with the highest and item with the lowest price

Given User is able to launch any browser
And User is able to navigate to the url
When user enters productName "<productName>" in search box and clicks search
Then user should be able to see item with the highest and item with the lowest price
And user should be able to sort product by price from high to low
And user should be able to close the browser
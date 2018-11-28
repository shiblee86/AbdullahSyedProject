@SMOKE_1 @TS_8
Feature: Adding item to cart

Description: User should be able to add item to cart

Scenario Outline: User should be able to add item to cart

Given User is able to launch any browser
And User is able to navigate to the url
When user enters productName "<productName>" in search box and clicks search
And user sees product list of page
Then user should be able to click on a product
And user should be able to add the product to the cart
And user should be able to close the browser

Examples:
|productName|specificProduct|
|iphone|iPhone X|

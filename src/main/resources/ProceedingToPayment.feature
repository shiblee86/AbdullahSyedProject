@SMOKE_1 @TS_9
Feature: Proceeding to payment validation

Description: User should be able to pay for the item by going to payment page

Scenario Outline: After adding an item to cart, user should be able to proceed to payment screen

Given User is able to launch any browser
And User is able to navigate to the url
And user enters productName "<productName>" in search box and clicks search
And user sees product list of page
And user clicks on a product
And user adds the product to the cart
Then user should be able to proceed to the payment screen

Examples:
|productName|specificProduct|
|iphone|iPhone X|

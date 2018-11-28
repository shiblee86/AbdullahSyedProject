@SMOKE_1 @TS_11
Feature: Adding new payment method

Description: User should be able to add new payment method to purchase item

Scenario Outline: User tries to add a new payment type after adding item to cart and proceeding to payment screen

Given User is able to launch any browser
And User is able to navigate to the url
And User clicks on Account & List
And User enters valid username "<userName>"
And User enters valid password "<password>"
And User clicks on SignIn button
And User sees be able to see "Hi, Syed"
And the user is able to click on the search button and search for product "<productName"
And the user is able to sort item by high to low price
And the user is able to find total page number
And the user is able to find current page number
And the user is able to see all searched products and count
And the user is able to filter specific products count of a specific product "specificProduct"
And the user is able to see item with highest and item with lowset price
And the user is able to sort item by low to high price
And the user is able to add click on an item and see details
And the user is able to add the item to the cart
And the user is able to proceed to payment
And the user is able to click change payment
And the user is able to add new bank account
Then the User should be able should see success message on screen
And the user will be able to proceed to finishing transaction
And the user should be able to close the browser

Examples:
|userName|syed.r.abdullah@gmail.com|
|password|$Sa038575|
|productName|specificProduct|
|iphone|iphone x|
|hp laptop|hp stream|
 

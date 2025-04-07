Feature: Purchasing the product

@AddToCart
Scenario: ordering the computer 
Given the User is on the HomePage "https://demowebshop.tricentis.com/"
And the User clicks the login button in the page
And the User provides email and password
And the User clicks the Login button
And the User should be logged in to the website
When the User clicks the computer category
And the User Desktops category
And the User clicks the simple computer
And the User should click the processor as slow
Then the User clicks the add to cart button
And Click shopping cart
And agree terms and conditions and click checkOut
And the User gives the address for shipping 
And click continue button for billing address
And click continue button for Shipping address
And click continue button for Shipping Method
And click continue button for Payment Method
And click continue button for Payment Information
And click continue button for confirm order
And Verify the order
And the User is able to see the order number
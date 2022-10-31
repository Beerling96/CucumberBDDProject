Feature: Customers
Background: Steps Common for all scenarios
 Given User opens Chrome Browser
    When User opens url "https://admin-demo.nopcommerce.com/login"
    And User enter Email "admin@yourstore.com" and Password as "admin"
    And Click on Login 
Then User can view Dashboard

@Sanity
Scenario: Add new customer
When User click on customer Menu
And click on customers Menu Item
And click on Add new button
Then User can view Add New Customer page
When User enter customer info
And Click on Save button
Then User can view confirmation message "The new customer has been added successfully."
And close browser 

@regression
Scenario: search customer by email

When User click on customer Menu
And click on customers Menu Item
And enter customer Email
When Click on search button
Then User should found Email in the search table
And close browser

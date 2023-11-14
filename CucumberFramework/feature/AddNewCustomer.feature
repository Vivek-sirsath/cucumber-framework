#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Add new customer
  I want to use this template for adding new customer 

  @tag1
  Scenario: Add new customer functionality
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can see dashboard
    When User click on Customers dropdown
    And User click on Customers option
    And User clicks on Add New button
    Then User can see a form to add new customer page
    When User enter customer info
    And Click on save button
    Then User can see confirmation message "The new customer has been added successfully."
    And Close browser
    
  Scenario: Search customer functionality
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can see dashboard
    When User click on Customers dropdown
    And User click on Customers option
    And Enter customer email
    When Click on search button
    Then User should found email in search table
    And Close browser

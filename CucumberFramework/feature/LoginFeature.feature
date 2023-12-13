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
# # # [DEFINES STEPS THAT ARE COMMON TO ALL THE TESTS IN THE FEATURE FILE] 
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

# # # [HERE ALL THE STEPS WRITTEN IN GHERKIN LANGUAGE]
# # # [EACH FEATURE FILE SHOULD HAVE ONLY ONE FEATURE]
# # # [UPPER CASE AND lOWER CASE LETTERS IN STEPS SHOULD BE SAME IN ALL SCENARIOS]

Feature: Login
  I want to use this template for LoginFeature file

# Test Steps -

  @sanity @regression
  Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then The page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then The page should be "Your store. Login"
    And Close browser

 @regression
 Scenario Outline: Successful login with valid credentials by DDT
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and password as "<password>"
    And Click on Login
    Then The page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then The page should be "Your store. Login"
    And Close browser
 
Examples: 
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|
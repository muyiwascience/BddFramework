@Regression
Feature: Open a booking form via services

 As a customer
  I want to view a booking form
  So that I can see what is on the page

@Regression
Scenario: Get a booking form via the services
   Given I have access to the web api
   When i fetch a booking form
   Then i should see the details

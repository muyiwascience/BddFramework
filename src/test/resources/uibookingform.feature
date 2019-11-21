Feature:
  As a customer
  I want to view a booking form
  So that I can make a booking

   Background: This is a pre-condition for all test in this feature file
    Given I am directed to the hotel booking form page


  @Regression
  Scenario: Hotel Booking form page
    Then I should see hotel booking form


  @Regression
  Scenario: Valid booking test
     When I enter details
      | Firstname                  | Surname     | Price    |
      | captain1bishop£!           | bishop£!    | 10       |
     And I select a deposit, Check-in and & Check-out
     Then the booking should be saved
     | Firstname        |
     | captain1bishop£! |

   @Regression
   Scenario: Delete booking test
   When I delete a record from the bookings
    | Firstname        |
    | captain1bishop£! |

   Then the record should be deleted succesfully
    | Firstname        |
    | captain1bishop£! |


   @Regression
   Scenario: Invalid booking test
   When I do enter numbers in the price field
    | Firstname                  | Surname     | Price    |
    | invalidbooking             | bishop£!    | £10      |
   And I select a deposit, Check-in and & Check-out
   Then the booking should not be saved
    | Firstname        |
    | invalidbooking   |











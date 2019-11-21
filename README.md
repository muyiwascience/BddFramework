# Hotel Booking form
## Purpose (Why):

* To execute automated tests against a booking form application.

## Getting Started

### Project Architecture:
The project architecture integrates [https://github.com/selenium-cucumber/selenium-cucumber-java-maven-example) within a [Maven](https://maven.apache.org/guides/getting-started/) framework.

Set variables in Bash profile

Mac:
export JAVA_HOME=`/usr/libexec/java_home -v 1.8.0_212`

Windows:

Click on Environment Variables, under System Variables, find PATH, and click on it.


## Executing Tests:
i. Go to the root of the folder
ii. Run mvn test

```
mvn test
```

### Out of Scope for this project

Unable to test Firstname textfield lenght
Unable to test Surname textfield lenght
Unable to test Price textfield lenght
Validation errors
It should not accept Past dates for Check-In and Check-Out

###  What to be tested

  1. First name text field
  2. Last name text field
  3. Price text field
  4. Deposit (drop down)
  5. Check In
  6. Checkout
  7. Delete Button
  8  Save Button
  9. Calender-Checkin
  10.Calender-CheckOut

### Manual Test cases:

 1. Check that Hotel booking form is displayed
    i. Go to url: http://hotel-test.equalexperts.io/
    ii. check that hotel booking form is displayed on the page
    Expected Result: Hotel booking form should be displayed
    Actual Result: Hotel booking form is displayed


 2.  Verify Firstname text field
    i. Ensure that texfield is blank
   ii. Enter: captain1bishop£! in the text field
  iii. Delete: captain1bishop£! in the text field
    Expected Result : It should accept letters, numbers and special characters
    Actual Result : It accepts letters, numbers and special characters

 3.  Verify Surname text field
    i. Ensure that surname field is blank
   ii. Enter: bishop£! in the text field
  iii. Delete: bishop£! in the text field
    Expected Result : It should accept letters, numbers and special characters
    Actual Result : It accepts letters, numbers and special characters

4. Verify Price field
   i. Ensure that price field is blank
   ii. Enter: 20.23 in the field
  iii. Delete: 20.23
    Expected Result : It should accept numbers and decimal values
    Actual Result : It accepts numbers and decimal values

5. Verify Deposit
   i. Verify you can select True or False
   ii. Select True then select False

6. Verify Check-In
   i. Click on Check-in field and hover your mouse on the calender
   ii. Select Month and year by clicking on the arrows (Back or Next)
   ii. Select a date
    Expected Result: A Modal Popop box should be displayed and a date should be selected
    Actual Result: A modal Popop is selected and a date is selected

6. Verify Check-Out
   i. Click on Check-out field and hover your mouse on the calender
  ii. Select Month and year by clicking on the arrows (Back or Next)
 iii. Select a date
    Expected Result: A Modal Popop box should be displayed and a date should be selected
    Actual Result: A modal Popop is selected and a date is selected

7. Verify a valid booking
   i. Enter a Firstname: captain1bishop£!
  ii. Enter a Surname: bishop£!
 iii. Enter a Price: 22.33
  iv. Go to Deposit drop down and select True
   v. Go to Check-in, Click on Next and Click on 23
  vi. Go to Check-out, Click on Next and Click on 24
 vii. Click on save
   Expected Result: captain1bishop£!; bishop£!; false ; 2019-12-23; 2019-11-24 is displayed and booking is successful
   Actual Result: Displayed as expected.

8. Verify that user can not make a booking when the Price contains characters or special characters
   i. Enter a Firstname: captain1bishop£!
  ii. Enter a Surname: bishop£!
 iii. Enter a Price: abcde
  iv. Go to Deposit drop down and select True
   v. Go to Check-in, Click on Next and Click on 23
  vi. Go to Check-out, Click on Next and Click on 24
 vii. Click on save
   Expected Result: save button is not clickable and the record is not shown after refreshing the page
   Actual Result: No action on clicking on Save button.

9. Verify that a record can be deleted
    i. Enter a Firstname: captain1bishop£!
    ii. Enter a Surname: bishop£!
   iii. Enter a Price: 22.33
    iv. Go to Deposit drop down and select True
     v. Go to Check-in, Click on Next and Click on 23
    vi. Go to Check-out, Click on Next and Click on 24
   vii. Click on save
   vii. Refresh the page and delete this record by clicking on Delete
  viii. Check this record is not available on the Page
  Expected Result: Record should be deleted
  Actual Result: The booking is deleted.


Performance Testing:
i.  Run the cuke Test
ii. Performance JSON content is saved in "/src/main/resources/Data"








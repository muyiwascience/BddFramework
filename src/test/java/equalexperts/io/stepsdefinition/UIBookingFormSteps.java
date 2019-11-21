package equalexperts.io.stepsdefinition;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import equalexperts.io.pages.BookingFormPage;
import equalexperts.io.support.WorldHelper;
import org.junit.Assert;


import java.util.List;


public class UIBookingFormSteps {


    private final WorldHelper helper;
    private BookingFormPage bookingFormPage;
    String actualMessage = "Hotel booking form";


    public UIBookingFormSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am directed to the hotel booking form page$")
    public void iAmDirectedToTheHotelBookingFormPage() throws Throwable {
        bookingFormPage = helper.getBookingFormPage().loadApplication();
    }


    @Then("^I should see hotel booking form$")
    public void iShouldSeeHotelBookingForm() throws Throwable {
        Assert.assertEquals(bookingFormPage.validateMessage(), actualMessage);
    }

    @When("^I enter details$")
    public void iEnterDetails(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String firstname = data.get(1).get(0);
        String surname = data.get(1).get(1);
        String price = data.get(1).get(2);
        bookingFormPage = bookingFormPage.enterTheDetails(firstname, surname, price);
    }

    @When("^I select a deposit, Check-in and & Check-out$")
    public void iSelectADepositCheckInAndCheckOut() throws Throwable {
        bookingFormPage = bookingFormPage.selectDepositType().goToCheckInAndSelectADate().goToCheckoutAndSelectADate();


    }


    @Then("^the booking should be saved$")
    public void theBookingShouldBeSaved(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String firstname = data.get(1).get(0);
        bookingFormPage.validateBooking(firstname);
    }

    @When("^I delete a record from the bookings$")
    public void iDeleteARecordFromTheBookings(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String firstname = data.get(1).get(0);
        bookingFormPage.iDeleteAbooking(firstname);

    }

    @Then("^the record should be deleted succesfully$")
    public void theRecordShouldBeDeletedSuccesfully(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String firstname = data.get(1).get(0);
        bookingFormPage.validateDeletedRecord(firstname);

    }

    @When("^I do enter numbers in the price field$")
    public void iDoEnterNumbersInThePriceField(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String firstname = data.get(1).get(0);
        String surname = data.get(1).get(1);
        String price = data.get(1).get(2);
        bookingFormPage = bookingFormPage.enterTheDetails(firstname, surname, price);
    }

    @Then("^the booking should not be saved$")
    public void theBookingShouldNotBeSaved(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String firstname = data.get(1).get(0);
        bookingFormPage.bookingIsNotsaved(firstname);

    }

}
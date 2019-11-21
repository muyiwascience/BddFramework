package equalexperts.io.support;



import equalexperts.io.browserconfig.BrowserFactory;
import equalexperts.io.pages.BasePage;
import equalexperts.io.pages.BookingFormPage;
import org.openqa.selenium.support.PageFactory;



public class WorldHelper extends BrowserFactory {


    private BookingFormPage bookingFormPage;
    private BasePage basePage;

    public BasePage getBasePage(){
        if (basePage == null) {
            basePage = PageFactory.initElements(driver, BasePage.class);
        }
        return basePage;

    }


    public BookingFormPage getBookingFormPage() {
        if (bookingFormPage == null) {
            bookingFormPage = PageFactory.initElements(driver, BookingFormPage.class);
        }
        return bookingFormPage;
    }
}
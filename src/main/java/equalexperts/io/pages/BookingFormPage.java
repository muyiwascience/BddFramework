package equalexperts.io.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

import java.util.List;


public class BookingFormPage extends BasePage {




    @FindBy(css = "div.container > div.jumbotron > h1")
    private WebElement hotelBookingForm = null;

    @FindBy(id = "firstname")
    private WebElement firstameTextField = null;

    @FindBy(id = "lastname")
    private WebElement surnameTextField = null;

    @FindBy(css = "#totalprice")
    private WebElement totalPrice = null;

    @FindBy(css = "#depositpaid > option:nth-child(1)")
    private WebElement depositTrue = null;

    @FindBy(css = "#depositpaid > option:nth-child(2)")
    private WebElement depositFalse = null;

    @FindBy(css = "#checkin")
    private WebElement checkInDate = null;

    @FindBy(css = "#checkout")
    private WebElement checkOutDate = null;

    @FindBy(css = "#ui-datepicker-div > table")
    private WebElement calenderTableCheckIn = null;

    @FindBy(css = "#ui-datepicker-div > table")
    private WebElement calenderTableCheckOut = null;

    @FindBy(css = "div > a.ui-datepicker-next.ui-corner-all > span")
    private WebElement nextMonth = null;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div[7]")
    private WebElement saveButton = null;

    @FindBy(css = "#bookings")
    private WebElement webtable = null;



    public BookingFormPage(WebDriver driver) {
        super(driver);
    }

    public String validateMessage() {
        return hotelBookingForm.getText();
    }

    public BookingFormPage enterTheDetails(String firstname, String surname, String price) {
        wait.until(ExpectedConditions.elementToBeClickable(firstameTextField));
        firstameTextField.clear();
        firstameTextField.sendKeys(firstname);
        surnameTextField.sendKeys(surname);
        totalPrice.sendKeys(price);
        return PageFactory.initElements(driver, BookingFormPage.class);
    }

    public BookingFormPage selectDepositType() {
        depositFalse.click();
        return PageFactory.initElements(driver, BookingFormPage.class);
    }

    public BookingFormPage goToCheckInAndSelectADate() {
        wait.until(ExpectedConditions.elementToBeClickable(checkInDate));
        checkInDate.click();
        driver.switchTo().activeElement();
        nextMonth.click();
        WebElement calenderElement = calenderTableCheckIn;
        List<WebElement> tableRow = calenderElement.findElements(By.tagName("tr"));
        for (WebElement buttonTag : tableRow) {
            for (WebElement dateTag : buttonTag.findElements(By.tagName("td"))) {
                if (dateTag.getText().contains("13")) {
                    wait.until(ExpectedConditions.visibilityOf(dateTag));
                    dateTag.click();
                    break;
                }
            }
        }

        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, BookingFormPage.class);
    }

    public BookingFormPage goToCheckoutAndSelectADate() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutDate));
        checkOutDate.click();
        driver.switchTo().activeElement();
        nextMonth.click();
        nextMonth.click();
        WebElement calenderElement = calenderTableCheckOut;
        List<WebElement> tableRow = calenderElement.findElements(By.tagName("tr"));
        for (WebElement tableTag : tableRow) {
            for (WebElement dateTag : tableTag.findElements(By.tagName("td"))) {
                if (dateTag.getText().contains("20")) {
                    wait.until(ExpectedConditions.visibilityOf(dateTag));
                    dateTag.click();
                    break;
                }
            }
        }

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(webtable));
        return PageFactory.initElements(driver, BookingFormPage.class);
    }

    public void validateBooking(String firstname) {
        driver.navigate().refresh();
        long finish = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total Time after Refresh - "+totalTime);
        List<WebElement> intRow = webtable.findElements(By.cssSelector("#bookings > div:nth-child(n)"));
        int rowsCount = intRow.size();
        for (int row = 0; row < rowsCount; row++) {
            if (intRow.get(row).getText().contains(firstname)) {
                Assert.assertTrue(intRow.get(row).getText().contains(firstname));
            }
        }
    }

    public void iDeleteAbooking(String firstname) throws InterruptedException {
        List<WebElement> intRow = webtable.findElements(By.cssSelector("#bookings > div:nth-child(n)"));
        int rowsCount = intRow.size();
        for (int row = 0; row < rowsCount; row++) {
            for (WebElement buttonElement : intRow.get(row).findElements(By.cssSelector("input"))) {
                if (intRow.get(row).getText().contains(firstname)) {
                    buttonElement.click();
                    break;
                }
            }
        }
    }


    public void validateDeletedRecord(String firstname) {
        driver.navigate().refresh();
        List<WebElement> intRow = webtable.findElements(By.cssSelector("#bookings > div:nth-child(n)"));
        int rowsCount = intRow.size();
        for (int row = 0; row < rowsCount; row++) {
            Assert.assertFalse(intRow.get(row).getText().contains(firstname));
        }
    }

    public void bookingIsNotsaved(String firstname) {
        driver.navigate().refresh();
        List<WebElement> intRow = webtable.findElements(By.cssSelector("#bookings > div:nth-child(n)"));
        int rowsCount = intRow.size();
        for (int row = 0; row < rowsCount; row++) {
            Assert.assertFalse(intRow.get(row).getText().contains(firstname));
        }
    }
    

}












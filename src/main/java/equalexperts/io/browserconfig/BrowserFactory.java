package equalexperts.io.browserconfig;


import equalexperts.io.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserFactory {


    protected static WebDriver driver;
    private static FileInputStream fis;
    private Properties config;


    public BrowserFactory initialiseBrowsers() {


        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ObjectRepo.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config = new Properties();
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers-package/chrome/chromedriver");
            driver = new ChromeDriver();
        }

        return PageFactory.initElements(driver, BrowserFactory.class);
    }


    public BasePage cleanUpBrowsers() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return new BasePage(driver);
    }


    public void tearDownBrowsers() {
        long start = System.currentTimeMillis();
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total Time for page load - "+totalTime);
        if (driver != null);
        driver.quit();


    }


}
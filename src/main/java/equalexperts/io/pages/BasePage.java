package equalexperts.io.pages;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;


public class BasePage {


    protected WebDriverWait wait;
    private FileInputStream fis;
    protected WebDriver driver;
    private Properties config;



    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;


        try

        {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ObjectRepo.properties");
        }

        catch(
                FileNotFoundException e
        )

        {
            e.printStackTrace();
        }

        try

        {
            config = new Properties();
            config.load(fis);
        }

        catch(
                IOException e
        )

        {
            e.printStackTrace();
        }
    }



    public BookingFormPage loadApplication() throws IOException {
        driver.navigate().to(config.getProperty("baseUrl"));

        JavascriptExecutor js1=((JavascriptExecutor)driver);
        try {
            Thread.sleep(5000);
        }catch(Exception e) {e.printStackTrace();}
        String url=driver.getCurrentUrl();
        System.out.println("Current URL :"+url);
        long pageLoadTime= (Long)js1.executeScript("return (window.performance.timing.loadEventEnd-window.performance.timing.responseStart)");
        long TTFB= (Long)js1.executeScript("return (window.performance.timing.responseStart-window.performance.timing.navigationStart)");
        long endtoendRespTime= (Long)js1.executeScript("return (window.performance.timing.loadEventEnd-window.performance.timing.navigationStart)");


        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());

        System.out.println("PageLoadTime Time :"+pageLoadTime);
        System.out.println("TTFB :"+TTFB);
        System.out.println("User perceived Time :"+endtoendRespTime);
        System.out.println("timeStamp"+ts);


        JSONObject obj = new JSONObject();

        obj.put("url", url);
        obj.put("PageLoad Time", pageLoadTime);
        obj.put("TTFB", TTFB);
        obj.put("User Time", endtoendRespTime);
        obj.put("Timestamp",ts.toString());

        try {
            String jsoncontent=obj.toJSONString();
            File f1=new File(System.getProperty("user.dir")+ "/src/main/resources/Data");

            if(!(f1.exists()))
            {
                f1.createNewFile();
            }
            FileWriter fw1=new FileWriter(f1);
            PrintWriter pw1=new PrintWriter(fw1);
            if(f1.exists()&& f1.isFile())
            {
                pw1.println(jsoncontent);
                pw1.flush();
                pw1.close();
                fw1.close();
            }
            else {
                System.out.println("Please provide a valid path to desitnation Jsonfile");
            }
        }catch(Exception e) {e.printStackTrace();}


        driver.manage().window().maximize();
        return PageFactory.initElements(driver, BookingFormPage.class);

    }



}
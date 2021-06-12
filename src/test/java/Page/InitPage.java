package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InitPage {

    static String chromeDriver = "chromedriver/chromedriver";

    public WebDriver createDriver(){
        System.setProperty("webdriver.chrome.driver",chromeDriver);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void openBrowser(WebDriver driver,String webUrl){
        driver.get(webUrl);
    }

}

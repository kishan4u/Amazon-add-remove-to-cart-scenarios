package StepDefinations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {


    public static WebDriver driver;

// Baseclass to launch the browser and URL, also to have cross browser testing cases
    public static void lauchBrowser(String browserName, String url) {
        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();                  // Setting up the browser driver
               driver = new ChromeDriver();                                //Launcing the browser
                driver.manage().window().maximize();                      //Maxmizing the window
                driver.get(url);                                            //Launching the Amazon url
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(url);
                break;
            case "IE":
                WebDriverManager.edgedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                driver.get(url);
                break;
            default:
               System.out.println("Message");
        }

    }

}

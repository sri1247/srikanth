package Actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {
    WebDriver driver;
    String browser;
    SeleniumActions seleniumActions=new SeleniumActions(driver, this);

    Logger log=Logger.getLogger(BrowserSetup.class);
    public BrowserSetup(WebDriver driver, PageFactory pageFactory) throws Exception {
    }
    public WebDriver startBrowser(String browser) throws Exception {

        if (browser.equalsIgnoreCase("firefox")) {
            log.info("initialize WebDriver Firefox");
            driver = new FirefoxDriver();
            log.info("Opened WebDriver firefox ");
        } else if (browser.equalsIgnoreCase("InternetExplore")) {
            log.info("initialize WebDriver InternetExplore");
            System.setProperty("webdriver.ie.driver", "D:\\RecruiterBehaviourAutomation\\RecruiterBehaviourAutomation\\src\\main\\java\\libs\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            log.info("opened InternetExplore");
            System.out.println("initialize WebDriver InternetExplore");
        } else if (browser.equalsIgnoreCase("googlechrome")) {
            log.info("initialize WebDriver GoogleChrome");
            System.setProperty("webdriver.chrome.driver", "D:\\RecruiterBehaviourAutomation\\RecruiterBehaviourAutomation\\src\\main\\java\\libs\\chromedriver.exe");
            driver = new ChromeDriver();
            log.info("opened GoogleChrome");}
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        return driver;
    }
    }


package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

//klasa zawierająca ustawienia sterownika dla przeglądarki

public class WebDriverFactory {

    public static WebDriver createChromedriverWithImplicitlyWait(int seconds) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

        return driver;
    }

    public static WebDriver mozillaDriver(int sec) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

        return driver;
    }

    public static WebDriver safariDriver(int sec) {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");

        WebDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

        return driver;
    }
}

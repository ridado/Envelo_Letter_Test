package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}

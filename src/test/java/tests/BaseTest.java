package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static final String SECOND_LIFE = "";
    private final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SECOND_LIFE);
    }

    @AfterEach
    void afterVoid() {
        driver.quit();
    }
}

package tests;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesLoader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static final String SECOND_LIFE = "https://second-life.space/";
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

    protected Properties testProperties;
    protected Properties httpProperties;

    @BeforeClass
    public void setUp() throws IOException {
        PropertiesLoader.getInstance();
        testProperties = PropertiesLoader.getTestProperties();
        httpProperties = PropertiesLoader.getHttpProperties();
    }
}

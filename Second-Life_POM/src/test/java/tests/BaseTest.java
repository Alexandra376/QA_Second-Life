package tests;

import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesLoader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static final String SECOND_LIFE = "https://second-life.space";
    public WebDriver driver;
    public WebDriverWait wait;
    protected Properties testProperties;

    protected User correctUser;
    protected User wrongEmailUser;
    protected User wrongPasswordUser;

    @BeforeEach
    public void startDriver() throws IOException {
        PropertiesLoader.getInstance();
        testProperties = PropertiesLoader.getTestProperties();

        String userEmail = testProperties.getProperty("userLogin.email");
        String userPassword = testProperties.getProperty("userLogin.password");
        String userWrongEmail = testProperties.getProperty("userLogin.wrongEmail");
        String userWrongPassword = testProperties.getProperty("userLogin.wrongPassword");

        correctUser = new User(userEmail, userPassword);
        wrongEmailUser = new User(userWrongEmail, userPassword);
        wrongPasswordUser = new User(userEmail, userWrongPassword);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SECOND_LIFE);
    }

    @AfterEach
    void afterVoid() {
        driver.quit();
    }
}

//package tests;
//
//import model.Admin;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.PropertiesLoader;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//public class BaseAdminTest {
//    public static final String SECOND_LIFE_ADMIN = "https://second-life.space/#/admin/auth/admin/login";
//    public WebDriver driver;
//    public WebDriverWait wait;
//    protected Admin correctAdmin;
//    protected Admin wrongEmailAdmin;
//    protected Admin wrongPasswordAdmin;
//    protected Properties testProperties;
//
//    public Admin getCorrectAdmin() {
//        return correctAdmin;
//    }
//
//    @BeforeEach
//    public void startDriver() throws IOException {
//        PropertiesLoader.getInstance();
//        testProperties = PropertiesLoader.getTestProperties();
//
//        String adminEmail = testProperties.getProperty("adminLogin.email");
//        String adminPassword = testProperties.getProperty("adminLogin.password");
//        String adminWrongEmail = testProperties.getProperty("adminLogin.wrongEmail");
//        String adminWrongPassword = testProperties.getProperty("adminLogin.wrongPassword");
//
//        correctAdmin = new Admin(adminEmail, adminPassword);
//        wrongEmailAdmin = new Admin(adminWrongEmail, adminPassword);
//        wrongPasswordAdmin = new Admin(adminEmail, adminWrongPassword);
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.get(SECOND_LIFE_ADMIN);
//    }
//
//    @AfterEach
//    void afterVoid() {
//        driver.quit();
//    }
//}

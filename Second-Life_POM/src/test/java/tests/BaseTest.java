package tests;

import model.RegisterUser;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesLoader;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class BaseTest {
    public static final String SECOND_LIFE = "https://second-life.space";
    public WebDriver driver;
    public WebDriverWait wait;
    protected Properties testProperties;
    protected User correctUser;
    protected User wrongEmailUser;
    protected User wrongPasswordUser;
    protected RegisterUser correctRegisterUser;
    protected RegisterUser wrongEmailRegisterUser;
    protected RegisterUser wrongPasswordRegisterUser1;
    protected RegisterUser wrongPasswordRegisterUser2;
    protected RegisterUser existEmail;

    @BeforeEach
    public void startDriver() throws IOException {
        PropertiesLoader.getInstance();
        testProperties = PropertiesLoader.getTestProperties();

        String userEmail = testProperties.getProperty("userLogin.email");
        String userPassword = testProperties.getProperty("userLogin.password");
        String userWrongEmail = testProperties.getProperty("userLogin.wrongEmail");
        String userWrongPassword = testProperties.getProperty("userLogin.wrongPassword");

        String userRegisterPassword = testProperties.getProperty("userRegister.password");
        String userRegisterRepeatPassword = testProperties.getProperty("userRegister.repeatPassword");
        String userRegisterFirstname = testProperties.getProperty("userRegister.firstname");
        String userRegisterLastname = testProperties.getProperty("userRegister.lastname");
        String userRegisterWrongEmail = testProperties.getProperty("userRegister.wrongEmail");
        String userRegisterWrongPassword1 = testProperties.getProperty("userRegister.repeatPasswordWithoutLetterAbdSpecialCharacter");
        String userRegisterRepeatPassword1 = testProperties.getProperty("userRegister.repeatPassword");
        String userRegisterWrongPassword2 = testProperties.getProperty("userRegister.repeatPasswordWithoutSpecialCharacter");
        String userRegisterRepeatPassword2 = testProperties.getProperty("userRegister.repeatPassword");
        String userRegisterExistEmail = testProperties.getProperty("userRegister.existEmail");

        correctUser = new User(userEmail, userPassword);
        wrongEmailUser = new User(userWrongEmail, userPassword);
        wrongPasswordUser = new User(userEmail, userWrongPassword);

        correctRegisterUser = new RegisterUser(getRandomEmail(), userRegisterPassword, userRegisterRepeatPassword, userRegisterFirstname, userRegisterLastname);
        wrongEmailRegisterUser = new RegisterUser(userRegisterWrongEmail, userRegisterPassword, userRegisterRepeatPassword, userRegisterFirstname, userRegisterLastname);
        wrongPasswordRegisterUser1 = new RegisterUser(getRandomEmail(), userRegisterWrongPassword1, userRegisterRepeatPassword1, userRegisterFirstname, userRegisterLastname);
        wrongPasswordRegisterUser2 = new RegisterUser(getRandomEmail(), userRegisterWrongPassword2, userRegisterRepeatPassword2, userRegisterFirstname, userRegisterLastname);
        existEmail = new RegisterUser(userRegisterExistEmail, userRegisterPassword, userRegisterRepeatPassword, userRegisterFirstname, userRegisterLastname);

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

    public static String getRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new SecureRandom();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(chars.length());
            result.append(chars.charAt(randomIndex));
        }
        return result + "@test.com";
    }
}

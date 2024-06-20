package tests;

import model.*;
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

public class BaseUserTest {
    public static final String SECOND_LIFE_USER = "https://second-life.space";
    public WebDriver driver;
    public WebDriverWait wait;
    protected Properties testProperties;
    protected User correctUser;
    protected User wrongEmailUser;
    protected User wrongPasswordUser;
    protected User correctTestUser;
    protected RegisterUser correctRegisterUser;
    protected RegisterUser wrongEmailRegisterUser;
    protected RegisterUser wrongPasswordRegisterUser1;
    protected RegisterUser wrongPasswordRegisterUser2;
    protected RegisterUser existEmail;
    protected CreateNewOfferFree createNewOfferFree;
    protected CreateNewOfferAuction createNewOfferAuction;
    protected CreateNewOfferAuctionWinBid createNewOfferAuctionWithWinBid;
    protected CreateNewOfferFree createNewOfferFreeWithIncorrectTitle;
    protected CreateNewOfferFree createNewOfferFreeWithIncorrectDescription;
    protected Admin correctAdmin;
    protected Admin wrongEmailAdmin;
    protected Admin wrongPasswordAdmin;
    public Admin getCorrectAdmin() {
        return correctAdmin;
    }

    @BeforeEach
    public void startDriver() throws IOException {
        PropertiesLoader.getInstance();
        testProperties = PropertiesLoader.getTestProperties();

        String userEmail = testProperties.getProperty("userLogin.email");
        String userPassword = testProperties.getProperty("userLogin.password");
        String userTestEmail = testProperties.getProperty("userLoginTest.email");
        String userTestPassword = testProperties.getProperty("userLoginTest.password");
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
        correctTestUser = new User(userTestEmail, userTestPassword);
        wrongEmailUser = new User(userWrongEmail, userPassword);
        wrongPasswordUser = new User(userEmail, userWrongPassword);

        String createNewOfferTitle = testProperties.getProperty("createNewOfferUI.title");
        String createNewOfferWithIncorrectTitle = testProperties.getProperty("createNewOfferUI.titleLessThan5Symbols");
        String createNewOfferWithIncorrectDescription = testProperties.getProperty("createNewOfferUIr.descriptionLessThan5Symbols");
        String createNewOfferDescription = testProperties.getProperty("createNewOfferUIr.description");
        String createNewOfferStartPrice = testProperties.getProperty("createNewOfferUI.startPrice");
        String createNewOfferWinBid = testProperties.getProperty("createNewOfferUI.winBid");
        String createNewOfferAuctionDuration = testProperties.getProperty("createNewOfferUIr.auctionDuration");

        int startPriceInt = Integer.parseInt(createNewOfferStartPrice);
        int winBidInt = Integer.parseInt(createNewOfferWinBid);
        int auctionDurationInt = Integer.parseInt(createNewOfferAuctionDuration);

        createNewOfferFree = new CreateNewOfferFree(createNewOfferTitle, createNewOfferDescription, auctionDurationInt);
        createNewOfferAuction = new CreateNewOfferAuction(createNewOfferTitle, createNewOfferDescription, startPriceInt, auctionDurationInt);
        createNewOfferAuctionWithWinBid = new CreateNewOfferAuctionWinBid(createNewOfferTitle, createNewOfferDescription, startPriceInt, winBidInt, auctionDurationInt);
        createNewOfferFreeWithIncorrectDescription = new CreateNewOfferFree(createNewOfferWithIncorrectTitle, createNewOfferWithIncorrectDescription, auctionDurationInt);
        createNewOfferFreeWithIncorrectTitle = new CreateNewOfferFree(createNewOfferWithIncorrectTitle, createNewOfferDescription, auctionDurationInt);

        correctRegisterUser = new RegisterUser(getRandomEmail(), userRegisterPassword, userRegisterRepeatPassword, userRegisterFirstname, userRegisterLastname);
        wrongEmailRegisterUser = new RegisterUser(userRegisterWrongEmail, userRegisterPassword, userRegisterRepeatPassword, userRegisterFirstname, userRegisterLastname);
        wrongPasswordRegisterUser1 = new RegisterUser(getRandomEmail(), userRegisterWrongPassword1, userRegisterRepeatPassword1, userRegisterFirstname, userRegisterLastname);
        wrongPasswordRegisterUser2 = new RegisterUser(getRandomEmail(), userRegisterWrongPassword2, userRegisterRepeatPassword2, userRegisterFirstname, userRegisterLastname);
        existEmail = new RegisterUser(userRegisterExistEmail, userRegisterPassword, userRegisterRepeatPassword, userRegisterFirstname, userRegisterLastname);

        String adminEmail = testProperties.getProperty("adminLogin.email");
        String adminPassword = testProperties.getProperty("adminLogin.password");
        String adminWrongEmail = testProperties.getProperty("adminLogin.wrongEmail");
        String adminWrongPassword = testProperties.getProperty("adminLogin.wrongPassword");

        correctAdmin = new Admin(adminEmail, adminPassword);
        wrongEmailAdmin = new Admin(adminWrongEmail, adminPassword);
        wrongPasswordAdmin = new Admin(adminEmail, adminWrongPassword);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(SECOND_LIFE_USER);
    }

    public User getCorrectUser() {
        return correctUser;
    }

    public User getCorrectTestUser() {
        return correctTestUser;
    }

    public CreateNewOfferFree getOfferFree() {
        return createNewOfferFree;
    }

    public CreateNewOfferAuction getOfferAuction() {
        return createNewOfferAuction;
    }

    public CreateNewOfferAuctionWinBid getOfferAuctionWinBid() {
        return createNewOfferAuctionWithWinBid;
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

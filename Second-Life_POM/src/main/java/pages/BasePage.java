package pages;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    WebDriver driver;
    WebDriverWait wait;
    public User user;
    Admin admin;
    User testUser;
    CreateNewOfferFree offerFree;
    CreateNewOfferAuction offerAuction;
    CreateNewOfferAuctionWinBid offerAuctionWinBid;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void fillInputField(WebElement e, String value) {
        LOGGER.info(() -> String.format("Fill the input field with locator %s with the value %s", e.toString(), value));
        WebElement element = waitForClickableElement(e);
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"));
    }

    private WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(WebElement element) {
        LOGGER.info(() -> String.format("Click on an element with locator %s", element.toString()));
        waitForClickableElement(element).click();
    }

    public void checkElementIsDisplayed(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), String.format("Expected element at locator %s not found", element));
    }

    public void login() {
        LoginUserPage loginUserPage = new LoginUserPage(driver, wait);
        loginUserPage.login(user);
    }

    public void loginAndTestAccount() {
        LoginUserPage loginUserPage = new LoginUserPage(driver, wait);
        loginUserPage.loginTestAccount(user);
    }

    public void loginAdmin() {
        LoginAdminPage loginAdminPage = new LoginAdminPage(driver, wait, admin);
        loginAdminPage.login(admin);
    }

    public void createNewOfferFree() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, user);
        createNewOfferUserPage.submitFreeOffer(offerFree);
    }

    public void createNewOfferFreeWithTestAccount() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, testUser);
        createNewOfferUserPage.submitFreeOfferWithTestAccount(offerFree);
    }

    public void createNewOfferAuctionWithTestAccount() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, testUser);
        createNewOfferUserPage.submitOfferAuctionWithTestAccount(offerAuction);
    }

    public void createNewOfferAuctionWithWinBidTestAccount() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, testUser);
        createNewOfferUserPage.submitOfferAuctionWithWinBidWithTestAccount(offerAuctionWinBid);
    }

    public void verifyOffer() {
        VerificationAdminPage verifyOfferPage = new VerificationAdminPage(driver, wait, admin);
        verifyOfferPage.verifyOffer();
    }

    public void createNewOfferAuction() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, user);
        createNewOfferUserPage.submitOfferAuction(offerAuction);
    }

    public void createNewOfferAuctionWinBid() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, user);
        createNewOfferUserPage.submitOfferAuctionWithWinBid(offerAuctionWinBid);
    }
}

package pages;

import model.Admin;
import model.CreateNewOfferFree;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeOfferPage extends BasePage {
    @FindBy(xpath = "//a[@href='#/offers/all']")
    WebElement offersLink;
    @FindBy(xpath = "//li[text()='Free offer']")
    WebElement dropDownFreeOffer;
    @FindBy(xpath = "//button[text()='Apply']")
    WebElement buttonApply;
    @FindBy(xpath = "//button[text()='Back']")
    WebElement buttonBack;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement buttonCancel;
    @FindBy(xpath="//button[@class='css-7flg2j']")
    WebElement buttonLogout;

    public void clickOnOffersLink() {
        clickOnElement(offersLink);
    }
    public void clickOnDropDownFreeOffer() {
        clickOnElement(dropDownFreeOffer);
    }
    public void clickOnButtonApply() {
        clickOnElement(buttonApply);
    }
    public void clickOnButtonBack() {
        clickOnElement(buttonBack);
    }
    public void clickOnButtonCancel() {
        clickOnElement(buttonCancel);
    }
    public void clickOnLogout() {
        clickOnElement(buttonLogout);
    }

    private User user;
    private User testUser;
    private Admin admin;
    private CreateNewOfferFree offerFree;

    public FreeOfferPage(WebDriver driver, WebDriverWait wait, User user, User testUser, CreateNewOfferFree offerFree, Admin admin) {
        super(driver, wait);
        this.user = user;
        this.admin = admin;
        this.offerFree = offerFree;
        this.testUser = testUser;
    }

    public void login() {
        LoginUserPage loginUserPage = new LoginUserPage(driver, wait);
        loginUserPage.login(user);
    }

    public void precondition() {
        clickOnOffersLink();
        clickOnDropDownFreeOffer();
    }

    public void createNewOfferFree() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, user);
        createNewOfferUserPage.submitFreeOffer(offerFree);
    }

    public void createNewOfferFreeWithTestAccount() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, testUser);
        createNewOfferUserPage.submitFreeOfferWithTestAccount(offerFree);
    }

    public void verifyOffer() {
        VerificationAdminPage verifyOfferPage = new VerificationAdminPage(driver, wait, admin);
        verifyOfferPage.verifyOffer();
    }

    public void applyForFreeOffer() {
        createNewOfferFreeWithTestAccount();
        verifyOffer();
        clickOnLogout();
        login();
        precondition();
        clickOnButtonApply();
    }

    public void cancelFreeOffer() {
        createNewOfferFree();
        verifyOffer();
        precondition();
        clickOnButtonCancel();
    }
}

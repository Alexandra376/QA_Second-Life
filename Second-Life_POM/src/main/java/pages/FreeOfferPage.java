package pages;

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
    @FindBy(xpath = "//h3[text()='Bicycle']")
    WebElement title;
    @FindBy(xpath = "//button[text()='Back']")
    WebElement buttonBack;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement buttonCancel;

    public void clickOnOffersLink() {
        clickOnElement(offersLink);
    }
    public void clickOnDropDownFreeOffer() {
        clickOnElement(dropDownFreeOffer);
    }
    public void clickOnButtonApply() {
        clickOnElement(buttonApply);
    }
    public void clickOnTitle() {
        clickOnElement(title);
    }
    public void clickOnButtonBack() {
        clickOnElement(buttonBack);
    }
    public void clickOnButtonCancel() {
        clickOnElement(buttonCancel);
    }

    private User user;
    private CreateNewOfferFree offerFree;

    public FreeOfferPage(WebDriver driver, WebDriverWait wait, User user, CreateNewOfferFree offerFree) {
        super(driver, wait);
        this.user = user;
        this.offerFree = offerFree;
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

    public void applyForFreeOffer() {
        login();
        precondition();
        clickOnTitle();
        clickOnButtonApply();
        clickOnButtonBack();
    }

    public void cancelFreeOffer() {
        login();
        createNewOfferFree();
        precondition();
        clickOnButtonCancel();
    }
}

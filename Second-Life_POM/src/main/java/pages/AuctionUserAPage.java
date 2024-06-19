package pages;

import model.CreateNewOfferAuction;
import model.CreateNewOfferAuctionWinBid;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuctionUserAPage extends BasePage {
    @FindBy(xpath = "//a[@href='#/offers/all']")
    WebElement offersLink;
    @FindBy(xpath = "//li[text()='Auction']")
    WebElement dropDownAuctionOffer;
    @FindBy(xpath = "//button[text()='Apply']")
    WebElement buttonApply;
    @FindBy(xpath = "//h3[text()='Bicycle']")
    WebElement title;
    @FindBy(xpath = "//button[text()='Back']")
    WebElement buttonBack;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement buttonCancel;
    @FindBy(xpath = "//button[@class='css-7b3zi8']")
    WebElement buttonBuyOut;
    @FindBy(xpath = "//button[@class='css-1bd4r8c']")
    WebElement modalWindowConfirmAction;
    @FindBy(xpath = "//button[text()='OK']")
    WebElement buttonOk;

    public void clickOnOffersLink() {
        clickOnElement(offersLink);
    }
    public void clickOnDropDownFreeOffer() {
        clickOnElement(dropDownAuctionOffer);
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
    public void clickOnButtonBuyOut() {
        clickOnElement(buttonBuyOut);
    }
    public void checkIsModalWindowDisplayed() {
        checkElementIsDisplayed(modalWindowConfirmAction);
    }
    public void clickOnButtonOk() {
        clickOnElement(buttonOk);
    }

    private User user;
    private CreateNewOfferAuction offerAuction;
    private CreateNewOfferAuctionWinBid offerAuctionWinBid;

    public AuctionUserAPage(WebDriver driver, WebDriverWait wait, User user, CreateNewOfferAuction offerAuction, CreateNewOfferAuctionWinBid offerAuctionWinBid) {
        super(driver, wait);
        this.user = user;
        this.offerAuction = offerAuction;
        this.offerAuctionWinBid = offerAuctionWinBid;
    }

    public void login() {
        LoginUserPage loginUserPage = new LoginUserPage(driver, wait);
        loginUserPage.login(user);
    }

    public void precondition() {
        clickOnOffersLink();
        clickOnDropDownFreeOffer();
    }

    public void createNewOfferAuction() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, user);
        createNewOfferUserPage.submitOfferAuction(offerAuction);
    }

    public void createNewOfferAuctionWinBid() {
        CreateNewOfferUserPage createNewOfferUserPage = new CreateNewOfferUserPage(driver, wait, user);
        createNewOfferUserPage.submitOfferAuctionWithWinBid(offerAuctionWinBid);
    }

    public void applyAuction() {
        login();
        precondition();
        clickOnTitle();
        clickOnButtonApply();
        clickOnButtonBack();
    }

    public void buyoutAuctionWinBid() {
        login();
        precondition();
        clickOnButtonBuyOut();
        checkIsModalWindowDisplayed();
        clickOnButtonOk();
    }

    public void cancelAuction() {
        login();
        createNewOfferAuction();
        precondition();
        clickOnTitle();
        clickOnButtonCancel();
        clickOnButtonBack();
    }

    public void cancelAuctionWinBid() {
        login();
        createNewOfferAuctionWinBid();
        precondition();
        clickOnTitle();
        clickOnButtonCancel();
        clickOnButtonBack();
    }
}

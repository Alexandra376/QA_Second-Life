package pages;

import model.Admin;
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
    @FindBy(xpath = "//button[.//p[text()='Buyout']]")
    WebElement buttonBuyOut;
    @FindBy(xpath = "//button[text()='ОК']")
    WebElement buttonOk;
    @FindBy(xpath="//button[@class='css-7flg2j']")
    WebElement buttonLogout;

    public void clickOnOffersLink() {
        clickOnElement(offersLink);
    }
    public void clickOnDropDownAuctionOffer() {
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
    public void clickOnButtonOk() {
        clickOnElement(buttonOk);
    }
    public void clickOnLogout() {
        clickOnElement(buttonLogout);
    }

    public AuctionUserAPage(WebDriver driver, WebDriverWait wait, User user,  User testUser, CreateNewOfferAuction offerAuction, CreateNewOfferAuctionWinBid offerAuctionWinBid, Admin admin) {
        super(driver, wait);
        this.user = user;
        this.admin = admin;
        this.testUser = testUser;
        this.offerAuction = offerAuction;
        this.offerAuctionWinBid = offerAuctionWinBid;

    }

    public void precondition() {
        clickOnOffersLink();
        clickOnDropDownAuctionOffer();
    }

    public void applyAuction() {
        createNewOfferAuctionWithTestAccount();
        verifyOffer();
        clickOnLogout();
        login();
        precondition();
        clickOnButtonApply();
    }

    public void buyoutAuctionWinBid() {
        createNewOfferAuctionWithWinBidTestAccount();
        verifyOffer();
        clickOnLogout();
        login();
        precondition();
        clickOnButtonBuyOut();
        clickOnButtonOk();
    }

    public void cancelAuction() {
        createNewOfferAuction();
        verifyOffer();
        precondition();
        clickOnTitle();
        clickOnButtonCancel();
        clickOnButtonBack();
    }

    public void cancelAuctionWinBid() {
        createNewOfferAuctionWinBid();
        verifyOffer();
        precondition();
        clickOnTitle();
        clickOnButtonCancel();
        clickOnButtonBack();
    }
}

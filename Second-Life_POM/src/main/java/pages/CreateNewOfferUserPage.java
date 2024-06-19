package pages;

import model.CreateNewOfferAuction;
import model.CreateNewOfferAuctionWinBid;
import model.CreateNewOfferFree;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class CreateNewOfferUserPage extends BasePage {
    @FindBy(xpath = "//input[@name='title']")
    WebElement inputTitle;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElement textAreaDescription;
    @FindBy(xpath = "//div[contains(@class, 'css-1ui1n6c')]//div[contains(@class, 'css-aikfgu')]")
    WebElement dropDownTypeOffer;
    @FindBy(xpath = "//li[text()='Free offer']")
    WebElement dropDownTypeOfferFree;
    @FindBy(xpath = "//li[text()='Offer + auction']")
    WebElement dropDownTypeOfferAuction;
    @FindBy(xpath = "//li[text()='Offer + auction with win bid']")
    WebElement dropDownTypeOfferAuctionWithWinBid;
    @FindBy(xpath = "//input[@name='startPrice']")
    WebElement inputStartPrice;
    @FindBy(xpath = "//input[@name='winbid']")
    WebElement inputWinBid;
    @FindBy(xpath = "//button[text()='Copy to a new draft']")
    WebElement buttonCopyToDraft;
    @FindBy(xpath = "//div[contains(@class, 'css-1ibiycq')][1]//div[contains(@class, 'css-aikfgu')]")
    WebElement dropDownCategory;
    @FindBy(xpath = "//li[text()='Sports and Leisure']")
    WebElement dropDownCategorySports;
    @FindBy(xpath = "//li[text()='Electronic']")
    WebElement dropDownCategoryElectronic;
    @FindBy(xpath = "//div[contains(@class, 'css-1ibiycq')][2]//div[contains(@class, 'css-aikfgu')]")
    WebElement dropDownLocation;
    @FindBy(xpath = "//li[text()='Berlin']")
    WebElement dropDownLocationBerlin;
    @FindBy(xpath = "//li[text()='Hessen']")
    WebElement dropDownLocationHessen;
    @FindBy(xpath = "//input[@name='durationAuction']")
    WebElement inputDurationAction;
    @FindBy(xpath = "//button[text()='Save as draft']")
    WebElement buttonSaveAsDraft;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement buttonSubmit;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement buttonCancel;
    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement inputUploadImage;
    @FindBy(xpath = "//div[@class='css-1h5x3dy']")
    WebElement personalAccountIcon;
    @FindBy(xpath = "//li[text()='Create new offer']")
    WebElement dropDownCreateNewOffer;
    @FindBy(xpath = "//div[text()='Free']")
    WebElement titleFree;
    @FindBy(xpath = "//div[text()='Current price: ']")
    WebElement titleCurrentPrice;
    @FindBy(xpath = "//p[text()='Title must be longer than 5 characters']")
    WebElement paragraphTitle;
    @FindBy(xpath = "//p[text()='Description must be longer than 5 characters']")
    WebElement paragraphDescription;

    private User user;

    public CreateNewOfferUserPage(WebDriver driver, WebDriverWait wait, User user) {
        super(driver, wait);
        this.user = user;
    }

    public void loginAndPrecondition() {
        LoginUserPage loginUserPage = new LoginUserPage(driver, wait);
        loginUserPage.login(user);
        clickOnPersonalAccountIcon();
        clickOnDropDownCreateNewOffer();
    }

    public void clickOnButtonCopyToDraft() {
        clickOnElement(buttonCopyToDraft);
    }
    public void clickOnButtonSavaAsDraft() {
        clickOnElement(buttonSaveAsDraft);
    }
    public void clickOnButtonSubmit() {
        clickOnElement(buttonSubmit);
    }
    public void clickOnButtonCancel() {
        clickOnElement(buttonCancel);
    }
    public void clickOnDropDownTypeOffer() {
        clickOnElement(dropDownTypeOffer);
    }
    public void clickOnDropDownTypeOfferFree() {
        clickOnElement(dropDownTypeOfferFree);
    }
    public void clickOnDropDownTypeOfferAuction() {
        clickOnElement(dropDownTypeOfferAuction);
    }
    public void clickOnDropDownTypeOfferAuctionWithWinBid() {
        clickOnElement(dropDownTypeOfferAuctionWithWinBid);
    }
    public void clickOnDropDownCategory() {
        clickOnElement(dropDownCategory);
    }
    public void clickOnDropDownCategorySports() {
        clickOnElement(dropDownCategorySports);
    }
    public void clickOnDropDownCategoryElectronic() {
        clickOnElement(dropDownCategoryElectronic);
    }
    public void clickOnDropDownLocation() {
        clickOnElement(dropDownLocation);
    }
    public void clickOnDropDownLocationBerlin() {
        clickOnElement(dropDownLocationBerlin);
    }
    public void clickOnDropDownLocationHessen() {
        clickOnElement(dropDownLocationHessen);
    }

    public void clickOnPersonalAccountIcon() {
        clickOnElement(personalAccountIcon);
    }
    public void clickOnDropDownCreateNewOffer() {
        clickOnElement(dropDownCreateNewOffer);
    }

    public void fillCreateNewOfferFree(CreateNewOfferFree offer) {
        fillInputField(inputTitle, offer.getTitle());
        fillInputField(textAreaDescription, offer.getDescription());
        fillInputField(inputDurationAction, String.valueOf(offer.getAuctionDuration()));
    }
    public void fillCreateNewOfferFreeWithIncorrectTitle(CreateNewOfferFree offer) {
        fillInputField(inputTitle, offer.getTitle());
        fillInputField(textAreaDescription, offer.getDescription());
        fillInputField(inputDurationAction, String.valueOf(offer.getAuctionDuration()));
    }
    public void fillCreateNewOfferFreeWithIncorrectDescription(CreateNewOfferFree offer) {
        fillInputField(inputTitle, offer.getTitle());
        fillInputField(textAreaDescription, offer.getDescription());
        fillInputField(inputDurationAction, String.valueOf(offer.getAuctionDuration()));
    }
    public void fillCreateNewOfferAuction(CreateNewOfferAuction offer) {
        fillInputField(inputTitle, offer.getTitle());
        fillInputField(textAreaDescription, offer.getDescription());
        fillInputField(inputStartPrice, String.valueOf(offer.getStartPrice()));
        fillInputField(inputDurationAction, String.valueOf(offer.getAuctionDuration()));
    }
    public void fillCreateNewOfferAuctionWinBid(CreateNewOfferAuctionWinBid offer) {
        fillInputField(inputTitle, offer.getTitle());
        fillInputField(textAreaDescription, offer.getDescription());
        fillInputField(inputStartPrice, String.valueOf(offer.getStartPrice()));
        fillInputField(inputWinBid, String.valueOf(offer.getWinBid()));
        fillInputField(inputDurationAction, String.valueOf(offer.getAuctionDuration()));
    }

    public void addPhoto() {
        File file = new File("/Users/alexandra/test-pictures/bicycle.png");
        inputUploadImage.sendKeys(file.getAbsolutePath());
    }

    public void saveAsDraft(CreateNewOfferFree offer) {
        loginAndPrecondition();
        fillCreateNewOfferFree(offer);
        clickOnDropDownTypeOffer();
        clickOnDropDownTypeOfferFree();
        clickOnDropDownCategory();
        clickOnDropDownCategorySports();
        clickOnDropDownLocation();
        clickOnDropDownLocationBerlin();
        addPhoto();
        clickOnButtonSavaAsDraft();
        checkElementIsDisplayed(titleFree);
    }
    public void submit(CreateNewOfferAuction offer) {
        loginAndPrecondition();
        clickOnDropDownTypeOffer();
        clickOnDropDownTypeOfferAuction();
        fillCreateNewOfferAuction(offer);
        clickOnDropDownCategory();
        clickOnDropDownCategoryElectronic();
        clickOnDropDownLocation();
        clickOnDropDownLocationHessen();
        addPhoto();
        clickOnButtonSubmit();
        checkElementIsDisplayed(titleCurrentPrice);
    }
    public void cancel(CreateNewOfferAuctionWinBid offer) {
        loginAndPrecondition();
        clickOnDropDownTypeOffer();
        clickOnDropDownTypeOfferAuctionWithWinBid();
        fillCreateNewOfferAuctionWinBid(offer);
        clickOnDropDownCategory();
        clickOnDropDownCategorySports();
        clickOnDropDownLocation();
        clickOnDropDownLocationBerlin();
        addPhoto();
        clickOnButtonCancel();
        checkElementIsDisplayed(buttonCancel);
    }
    public void copyToNewDraft(CreateNewOfferAuctionWinBid offer) {
        loginAndPrecondition();
        clickOnDropDownTypeOffer();
        clickOnDropDownTypeOfferAuctionWithWinBid();
        fillCreateNewOfferAuctionWinBid(offer);
        clickOnDropDownCategory();
        clickOnDropDownCategorySports();
        clickOnDropDownLocation();
        clickOnDropDownLocationBerlin();
        addPhoto();
        clickOnButtonCopyToDraft();
        checkElementIsDisplayed(titleCurrentPrice);
    }
    public void submitIncorrectTitle(CreateNewOfferFree offer) {
        loginAndPrecondition();
        clickOnDropDownTypeOffer();
        clickOnDropDownTypeOfferFree();
        fillCreateNewOfferFreeWithIncorrectTitle(offer);
        clickOnDropDownCategory();
        clickOnDropDownCategorySports();
        clickOnDropDownLocation();
        clickOnDropDownLocationBerlin();
        addPhoto();
        clickOnButtonSubmit();
        checkElementIsDisplayed(paragraphTitle);
    }
    public void submitIncorrectDescription(CreateNewOfferFree offer) {
        loginAndPrecondition();
        clickOnDropDownTypeOffer();
        clickOnDropDownTypeOfferFree();
        fillCreateNewOfferFreeWithIncorrectDescription(offer);
        clickOnDropDownCategory();
        clickOnDropDownCategorySports();
        clickOnDropDownLocation();
        clickOnDropDownLocationBerlin();
        addPhoto();
        clickOnButtonSubmit();
        checkElementIsDisplayed(paragraphDescription);
    }
}

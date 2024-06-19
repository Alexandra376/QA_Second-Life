package pages;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class PersonalInformationUserPage extends BasePage {

    @FindBy(xpath = "//li[text()='Personal information']")
    WebElement dropDownPersonalInformation;
    @FindBy(xpath = "//div[@class='css-1h5x3dy']")
    WebElement personalAccountIcon;
    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement inputUploadImage;
    @FindBy(xpath = "//button[text()='Back']")
    WebElement buttonBack;
    @FindBy(xpath = "//p[text()='Let your unwanted items find a new home and bring joy to others.']")
    WebElement homePageText;
    @FindBy(xpath = "//button[text()='Remove Image']")
    WebElement buttonRemoveImage;

    public void clickOnPersonalAccountIcon() {
        clickOnElement(personalAccountIcon);
    }
    public void clickOnPersonalInformation() {
        clickOnElement(dropDownPersonalInformation);
    }
    public void clickOnButtonBack() {
        clickOnElement(buttonBack);
    }
    public void clickOnButtonRemoveImg() {
        clickOnElement(buttonRemoveImage);
    }

    private User user;

    public PersonalInformationUserPage(WebDriver driver, WebDriverWait wait, User user) {
        super(driver, wait);
        this.user = user;
    }

    public void loginAndPrecondition() {
        LoginUserPage loginUserPage = new LoginUserPage(driver, wait);
        loginUserPage.login(user);
        clickOnPersonalAccountIcon();
        clickOnPersonalInformation();
    }
    public void addPhoto() {
        File file = new File("/Users/alexandra/test-pictures/bicycle.png");
        inputUploadImage.sendKeys(file.getAbsolutePath());
    }

    public void successfullyUploadPhoto() {
        loginAndPrecondition();
        addPhoto();
        clickOnButtonRemoveImg();
        clickOnButtonBack();
        clickOnButtonBack();
        checkElementIsDisplayed(homePageText);
    }
}

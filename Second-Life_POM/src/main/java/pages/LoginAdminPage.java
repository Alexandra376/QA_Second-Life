package pages;

import model.Admin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAdminPage extends BasePage {
    @FindBy(xpath = "//input[contains(@name, 'email')]")
    WebElement emailInput;
    @FindBy(xpath = "//input[contains(@name, 'password')]")
    WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement signInButton;
    @FindBy(xpath = "//button[contains(@class, 'css-7flg2j')]")
    WebElement logoutButton;
    @FindBy(xpath = "//p[text()='Field type email']")
    WebElement wrongEmailMessage;
    @FindBy(xpath = "//div[text()='Password is incorrect']")
    WebElement wrongPasswordMessage;
    @FindBy(xpath = "//a[@href='#/aboutUs']")
    WebElement aboutUsLink;
    @FindBy(xpath = "//a[@href='https://second-life.space/#/admin']")
    WebElement adminLink;

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }
    public void clickOnAboutUsLink() {
        clickOnElement(aboutUsLink);
    }
    public void clickOnAdminLink() {
        clickOnElement(adminLink);
    }

    private Admin admin;

    public LoginAdminPage(WebDriver driver, WebDriverWait wait, Admin admin) {
        super(driver, wait);
        this.admin = admin;
    }

    public void precondition() {
        clickOnAboutUsLink();
        clickOnAdminLink();
    }

    public void fillUserLoginForm(Admin admin) {
        fillInputField(emailInput, admin.getEmail());
        fillInputField(passwordInput, admin.getPassword());
    }

    public void login(Admin admin) {
        precondition();
        fillUserLoginForm(admin);
        clickOnSignInButton();
        checkElementIsDisplayed(logoutButton);
    }

    public void loginWrongEmail(Admin admin) {
        precondition();
        fillUserLoginForm(admin);
        clickOnSignInButton();
        checkElementIsDisplayed(wrongEmailMessage);
    }

    public void loginWrongPassword(Admin admin) {
        precondition();
        fillUserLoginForm(admin);
        clickOnSignInButton();
        checkElementIsDisplayed(wrongPasswordMessage);
    }
}

package pages;

import model.User;
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

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }

    public void fillUserLoginForm(User user) {
        fillInputField(emailInput, user.getEmail());
        fillInputField(passwordInput, user.getPassword());
    }

    public void login(User user) {
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkElementIsDisplayed(logoutButton);
    }

    public void loginWrongEmail(User user) {
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkElementIsDisplayed(wrongEmailMessage);
    }

    public void loginWrongPassword(User user) {
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkElementIsDisplayed(wrongPasswordMessage);
    }

    public LoginAdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}

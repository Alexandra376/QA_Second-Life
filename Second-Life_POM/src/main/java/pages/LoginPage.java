package pages;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(css = "[href='/auth/user/login']")
    WebElement loginLink;
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


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(User user) {
        clickOnLoginLink();
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkIsLogOutPresent();
    }

    public void loginWrongEmail(User user) {
        clickOnLoginLink();
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkWrongEmailLetterPresent();
    }

    public void loginWrongPassword(User user) {
        clickOnLoginLink();
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkWrongPasswordLetterPresent();
    }

    public void fillUserLoginForm(User user) {
        fillInputField(emailInput, user.getEmail());
        fillInputField(passwordInput, user.getPassword());
    }

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }
    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }
    void checkIsLogOutPresent() {
        checkElementIsDisplayed(logoutButton);
    }
    void checkWrongEmailLetterPresent() {
        checkElementIsDisplayed(wrongEmailMessage);
    }
    void checkWrongPasswordLetterPresent() {
        checkElementIsDisplayed(wrongPasswordMessage);
    }
}

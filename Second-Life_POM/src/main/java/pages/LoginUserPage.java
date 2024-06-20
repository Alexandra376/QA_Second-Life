package pages;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUserPage extends BasePage {
    @FindBy(xpath = "//a[@href='#/auth/user/login']")
    WebElement loginLink;
    @FindBy(xpath = "//input[contains(@name, 'email')]")
    WebElement emailInput;
    @FindBy(xpath = "//input[contains(@name, 'password')]")
    WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement signInButton;
    @FindBy(xpath = "//button[@class='css-7flg2j']")
    WebElement logoutButton;
    @FindBy(xpath = "//p[text()='Field type email']")
    WebElement wrongEmailMessage;
    @FindBy(xpath = "//div[text()='Password is incorrect']")
    WebElement wrongPasswordMessage;

    @BeforeEach
    public void precondition(){
        new LoginUserPage(driver,wait).clickOnLoginLink();
    }

    public LoginUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
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

    public void login(User user) {
        precondition();
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkElementIsDisplayed(logoutButton);
    }

    public void loginTestAccount(User user) {
        precondition();
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkElementIsDisplayed(logoutButton);
    }

    public void loginWrongEmail(User user) {
        precondition();
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkElementIsDisplayed(wrongEmailMessage);
    }

    public void loginWrongPassword(User user) {
        precondition();
        fillUserLoginForm(user);
        clickOnSignInButton();
        checkElementIsDisplayed(wrongPasswordMessage);
    }
}

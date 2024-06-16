package pages;

import model.RegisterUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
    @FindBy(css = "[href='/auth/user/login']")
    WebElement loginLink;
    @FindBy(xpath = ("//button[text()='Sign up']"))
    WebElement signUpButton;
    @FindBy(xpath = ("//input[contains(@name, 'email')]"))
    WebElement emailInput;
    @FindBy(xpath = ("//input[contains(@name, 'password')]"))
    WebElement passwordInput;
    @FindBy(xpath = ("//input[contains(@name, 'repeatpassword')]"))
    WebElement repeatPasswordInput;
    @FindBy(xpath = ("//input[contains(@name, 'firstname')]"))
    WebElement firstNameInput;
    @FindBy(xpath = ("//input[contains(@name, 'lastname')]"))
    WebElement lastNameInput;
    @FindBy(xpath = "//button[contains(@class, 'css-7flg2j')]")
    WebElement logoutButton;
    @FindBy(xpath = "//div[text()='Registration successful. Please sign in.']")
    WebElement successfulRegistrationMessage;
    @FindBy(xpath = "//p[text()='Password must contain at least one letter']")
    WebElement wrongPasswordWithoutLetterMessage;
    @FindBy(xpath = "//p[text()='Password must contain at least one special character']")
    WebElement wrongPasswordWithoutSpecialCharacterAndLetterMessage;
    @FindBy(xpath = "//p[text()='Please enter a valid email address']")
    WebElement wrongEmail;
    @FindBy(xpath = "//p[text()='Email already exists']")
    WebElement emailAlreadyExistMessage;
    @FindBy(xpath = "//button[text()='ОК']")
    WebElement okButton;

    public void register(RegisterUser registerUser) {
        clickOnLoginLink();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkRegistrationMessagePresent();
        clickOnOkButton();
    }

    public void wrongPasswordWithoutSpecialCharacterAndLetter(RegisterUser registerUser) {
        clickOnLoginLink();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkWrongPasswordLetterWithoutSpecialCharacterAndMessagePresent();
    }

    public void wrongPasswordWithoutLetter(RegisterUser registerUser) {
        clickOnLoginLink();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkWrongPasswordWithoutLetterMessagePresent();
    }

    public void wrongEmail(RegisterUser registerUser) {
        clickOnLoginLink();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkWrongEmailMessagePresent();
    }

    public void emailAlreadyExist(RegisterUser registerUser) {
        clickOnLoginLink();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkEmailAlreadyExistMessagePresent();
    }

    public void fillUserRegisterForm(RegisterUser registerUser) {
        fillInputField(emailInput, registerUser.getEmail());
        fillInputField(passwordInput, registerUser.getPassword());
        fillInputField(repeatPasswordInput, registerUser.getRepeatPassword());
        fillInputField(firstNameInput, registerUser.getFirstname());
        fillInputField(lastNameInput, registerUser.getLastname());
    }

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }
    public void clickOnSignUpButton() {
        clickOnElement(signUpButton);
    }
    public void clickOnLogoutLink() {
        clickOnElement(logoutButton);
    }
    public void clickOnOkButton() {
        clickOnElement(okButton);
    }
    void checkRegistrationMessagePresent() {
        checkElementIsDisplayed(successfulRegistrationMessage);
    }
    void checkWrongPasswordLetterWithoutSpecialCharacterAndMessagePresent() {
        checkElementIsDisplayed(wrongPasswordWithoutSpecialCharacterAndLetterMessage);
    }
    void checkWrongPasswordWithoutLetterMessagePresent() {
        checkElementIsDisplayed(wrongPasswordWithoutLetterMessage);
    }
    void checkWrongEmailMessagePresent() {
        checkElementIsDisplayed(wrongEmail);
    }
    void checkEmailAlreadyExistMessagePresent() {
        checkElementIsDisplayed(emailAlreadyExistMessage);
    }
}

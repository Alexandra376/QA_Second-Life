package pages;

import model.RegisterUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationUserPage extends BasePage {
    @FindBy(css = "[href='#/auth/user/login']")
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
    @FindBy(xpath = "//div[contains(@class, 'css-14vb45k')]")
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
    @BeforeEach
    public void precondition(){
        new RegistrationUserPage(driver,wait).clickOnLoginLink();
    }
    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }
    public void clickOnSignUpButton() {
        clickOnElement(signUpButton);
    }
    public void clickOnOkButton() {
        clickOnElement(okButton);
    }
    void checkRegistrationMessagePresent() {
        checkElementIsDisplayed(successfulRegistrationMessage);
    }

    public void register(RegisterUser registerUser) {
        precondition();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkRegistrationMessagePresent();
        clickOnOkButton();
        checkElementIsDisplayed(logoutButton);
    }

    public void wrongPasswordWithoutSpecialCharacterAndLetter(RegisterUser registerUser) {
        precondition();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkElementIsDisplayed(wrongPasswordWithoutSpecialCharacterAndLetterMessage);
    }

    public void wrongPasswordWithoutLetter(RegisterUser registerUser) {
        precondition();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkElementIsDisplayed(wrongPasswordWithoutLetterMessage);
    }

    public void wrongEmail(RegisterUser registerUser) {
        precondition();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkElementIsDisplayed(wrongEmail);
    }

    public void emailAlreadyExist(RegisterUser registerUser) {
        precondition();
        clickOnSignUpButton();
        fillUserRegisterForm(registerUser);
        clickOnSignUpButton();
        checkElementIsDisplayed(emailAlreadyExistMessage);
    }

    public void fillUserRegisterForm(RegisterUser registerUser) {
        fillInputField(emailInput, registerUser.getEmail());
        fillInputField(passwordInput, registerUser.getPassword());
        fillInputField(repeatPasswordInput, registerUser.getRepeatPassword());
        fillInputField(firstNameInput, registerUser.getFirstname());
        fillInputField(lastNameInput, registerUser.getLastname());
    }

    public RegistrationUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}

package pages;

import model.Admin;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerificationAdminPage extends BasePage {
    @FindBy(xpath="//a[@href='#/admin/offers/all/verification']")
    WebElement verificationLink;
    @FindBy(xpath="//a[text()='Verify']")
    WebElement verify;
    @FindBy(xpath="//button[text()='Visit website']")
    WebElement visitWebsite;
    @FindBy(xpath="//span[text()='Offers']")
    WebElement spanOffers;
    public void clickOnVerificationLink() {
        clickOnElement(verificationLink);
    }
    public void clickOnVerify() {
        clickOnElement(verify);
    }
    public void clickOnSpanOffers() {
        clickOnElement(spanOffers);
    }
    public void clickOnVisitWebsite() {
        clickOnElement(visitWebsite);
    }
    private Admin admin;

    public VerificationAdminPage(WebDriver driver, WebDriverWait wait, Admin admin) {
        super(driver, wait);
        this.admin = admin;
    }

    public void login() {
        LoginAdminPage loginAdminPage = new LoginAdminPage(driver, wait, admin);
        loginAdminPage.login(admin);
    }

    public void verifyOffer() {
        login();
        clickOnSpanOffers();
        clickOnVerificationLink();
        clickOnVerify();
        clickOnVisitWebsite();
    }
}

package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsUserPage extends BasePage {
    @FindBy(xpath = "//a[@href='#/aboutUs']")
    WebElement aboutUsLink;
    @FindBy(xpath = "//img[@src='/assets/tree-StE3drNv.png']")
    WebElement imgTree;
    @FindBy(xpath = "//img[@src='/assets/question-CqPQ4Ojy.png']")
    WebElement imgQuestion;
    @BeforeEach
    public void precondition(){
        new AboutUsUserPage(driver,wait).clickOnAboutUsLink();
    }
    public void clickOnAboutUsLink() {
        clickOnElement(aboutUsLink);
    }

    private Boolean isImageBroken(WebElement imageElement, boolean isExpectedToBeBroken) {
        Boolean isImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth!= \"undefined\" && arguments[0].naturalWidth > 0;",
                imageElement);
        if(isExpectedToBeBroken) {
            Assertions.assertFalse(isImagePresent, "Image is displayed");
        } else {
            Assertions.assertTrue(isImagePresent, "Image is not displayed");
        }
        return isImagePresent;
    }

    Boolean isImageTreePresent() {
        return isImageBroken(imgTree, true);
    }
    Boolean isImageQuestionPresent() {
        return isImageBroken(imgQuestion, true);
    }

    public void isImagesPresentSuccess() {
        precondition();
        isImageTreePresent();
        isImageQuestionPresent();
    }

    public AboutUsUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}

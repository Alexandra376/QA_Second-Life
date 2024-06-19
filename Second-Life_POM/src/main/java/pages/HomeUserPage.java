package pages;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeUserPage extends BasePage {
    @FindBy(xpath="//input[(@placeholder='Search...')]")
    WebElement inputSearch;
    @FindBy(xpath="//button[@class='css-1tdncm9']")
    WebElement buttonSearch;
    @FindBy(xpath = "//div[contains(@class, 'css-1cwjfy3')]")
    WebElement dropDown;
    @FindBy(xpath = "//li[text()='All Germany']")
    WebElement allGermany;
    @FindBy(xpath = "//span[text()='All Germany']")
    WebElement allGermany1;
    @FindBy(xpath = "//li[text()='Baden-Württemberg']")
    WebElement badenWurttemberg;
    @FindBy(xpath = "//span[text()='Baden-Württemberg']")
    WebElement badenWurttemberg1;
    @FindBy(xpath = "//li[text()='Bayern']")
    WebElement bayern;
    @FindBy(xpath = "//span[text()='Bayern']")
    WebElement bayern1;
    @FindBy(xpath = "//li[text()='Berlin']")
    WebElement berlin;
    @FindBy(xpath = "//span[text()='Berlin']")
    WebElement berlin1;
    @FindBy(xpath = "//li[text()='Brandenburg']")
    WebElement brandenburg;
    @FindBy(xpath = "//span[text()='Brandenburg']")
    WebElement brandenburg1;
    @FindBy(xpath = "//li[text()='Hamburg']")
    WebElement hamburg;
    @FindBy(xpath = "//span[text()='Hamburg']")
    WebElement hamburg1;
    @FindBy(xpath = "//li[text()='Hessen']")
    WebElement hessen;
    @FindBy(xpath = "//span[text()='Hessen']")
    WebElement hessen1;
    @FindBy(xpath = "//li[text()='Mecklenburg-Vorpommern']")
    WebElement mecklenburgVorpommern;
    @FindBy(xpath = "//span[text()='Mecklenburg-Vorpommern']")
    WebElement mecklenburgVorpommern1;
    @FindBy(xpath = "//li[text()='Niedersachsen']")
    WebElement niedersachsen;
    @FindBy(xpath = "//span[text()='Niedersachsen']")
    WebElement niedersachsen1;
    @FindBy(xpath = "//li[text()='Nordrhein-Westfalen']")
    WebElement nordrheinWestfalen;
    @FindBy(xpath = "//span[text()='Nordrhein-Westfalen']")
    WebElement nordrheinWestfalen1;
    @FindBy(xpath = "//li[text()='Rheinland-Pfalz']")
    WebElement rheinlandPfalz;
    @FindBy(xpath = "//span[text()='Rheinland-Pfalz']")
    WebElement rheinlandPfalz1;
    @FindBy(xpath = "//li[text()='Sachsen']")
    WebElement sachsen;
    @FindBy(xpath = "//span[text()='Sachsen']")
    WebElement sachsen1;
    @FindBy(xpath = "//li[text()='Sachsen-Anhalt']")
    WebElement sachsenAnhalt;
    @FindBy(xpath = "//span[text()='Sachsen-Anhalt']")
    WebElement sachsenAnhalt1;
    @FindBy(xpath = "//li[text()='Schleswig-Holstein']")
    WebElement schleswigHolstein;
    @FindBy(xpath = "//span[text()='Schleswig-Holstein']")
    WebElement schleswigHolstein1;
    @FindBy(xpath = "//li[text()='Thüringen']")
    WebElement thüringen;
    @FindBy(xpath = "//span[text()='Thüringen']")
    WebElement thüringen1;

    public void clickOnInputSearch() {
        clickOnElement(inputSearch);
    }
    public void clickOnButtonSearch() {
        clickOnElement(buttonSearch);
    }
    public void searchBar() {
        clickOnInputSearch();
    }
    public void clickOnDropDown() {
        clickOnElement(dropDown);
    }

    @BeforeEach
    public void dropDownPrecondition(){
        new HomeUserPage(driver,wait).clickOnDropDown();
    }
    public void clickOnDropDownAllGermany() {
        clickOnElement(allGermany);
    }
    public void clickOnDropDownBadenWurttemberg() {
        clickOnElement(badenWurttemberg);
    }
    public void clickOnDropDownBayern() {
        clickOnElement(bayern);
    }
    public void clickOnDropDownBerlin() {
        clickOnElement(berlin);
    }
    public void clickOnDropDownBrandenburg() {
        clickOnElement(brandenburg);
    }
    public void clickOnDropDownHamburg() {
        clickOnElement(hamburg);
    }
    public void clickOnDropDownHessen() {
        clickOnElement(hessen);
    }
    public void clickOnDropDownMecklenburgVorpommern() {
        clickOnElement(mecklenburgVorpommern);
    }
    public void clickOnDropDownNiedersachsen() {
        clickOnElement(niedersachsen);
    }
    public void clickOnDropDownNordrheinWestfalen() {
        clickOnElement(nordrheinWestfalen);
    }
    public void clickOnDropDownRheinlandPfalz() {
        clickOnElement(rheinlandPfalz);
    }
    public void clickOnDropDownSachsen() {
        clickOnElement(sachsen);
    }
    public void clickOnDropDownSachsenAnhalt() {
        clickOnElement(sachsenAnhalt);
    }
    public void clickOnDropDownSchleswigHolstein() {
        clickOnElement(schleswigHolstein);
    }
    public void clickOnDropDownThüringen() {
        clickOnElement(thüringen);
    }

    public void dropDownAllGermany() {
        dropDownPrecondition();
        clickOnDropDownAllGermany();
        checkElementIsDisplayed(allGermany1);
    }
    public void dropDownBadenWurttemberg() {
        dropDownPrecondition();
        clickOnDropDownBadenWurttemberg();
        checkElementIsDisplayed(badenWurttemberg1);
    }
    public void dropDownBayern() {
        dropDownPrecondition();
        clickOnDropDownBayern();
        checkElementIsDisplayed(bayern1);
    }
    public void dropDownBerlin() {
        dropDownPrecondition();
        clickOnDropDownBerlin();
        checkElementIsDisplayed(berlin1);
    }
    public void dropDownBrandenburg() {
        dropDownPrecondition();
        clickOnDropDownBrandenburg();
        checkElementIsDisplayed(brandenburg1);
    }
    public void dropDownHamburg() {
        dropDownPrecondition();
        clickOnDropDownHamburg();
        checkElementIsDisplayed(hamburg1);
    }
    public void dropDownHessen() {
        dropDownPrecondition();
        clickOnDropDownHessen();
        checkElementIsDisplayed(hessen1);
    }
    public void dropDownMecklenburgVorpommern() {
        dropDownPrecondition();
        clickOnDropDownMecklenburgVorpommern();
        checkElementIsDisplayed(mecklenburgVorpommern1);
    }
    public void dropDownNiedersachsen() {
        dropDownPrecondition();
        clickOnDropDownNiedersachsen();
        checkElementIsDisplayed(niedersachsen1);
    }
    public void dropDownNordrheinWestfalen() {
        dropDownPrecondition();
        clickOnDropDownNordrheinWestfalen();
        checkElementIsDisplayed(nordrheinWestfalen1);
    }
    public void dropDownRheinlandPfalz() {
        dropDownPrecondition();
        clickOnDropDownRheinlandPfalz();
        checkElementIsDisplayed(rheinlandPfalz1);
    }
    public void dropDownSachsen() {
        dropDownPrecondition();
        clickOnDropDownSachsen();
        checkElementIsDisplayed(sachsen1);
    }
    public void dropDownSachsenAnhalt() {
        dropDownPrecondition();
        clickOnDropDownSachsenAnhalt();
        checkElementIsDisplayed(sachsenAnhalt1);
    }
    public void dropDownSchleswigHolstein() {
        dropDownPrecondition();
        clickOnDropDownSchleswigHolstein();
        checkElementIsDisplayed(schleswigHolstein1);
    }
    public void dropDownThüringen() {
        dropDownPrecondition();
        clickOnDropDownThüringen();
        checkElementIsDisplayed(thüringen1);
    }
    public void checkSuccessWorkSearch() {

    }

    public HomeUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}

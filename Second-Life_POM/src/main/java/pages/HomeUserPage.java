package pages;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeUserPage extends BasePage {
    @FindBy(xpath="//input[(@placeholder='Search...')]")
    WebElement inputSearch;
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
    public void searchBar() {
        clickOnInputSearch();
    }
    public void clickOnDropDown() {
        clickOnElement(dropDown);
    }

    @BeforeEach
    public void precondition(){
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

    void checkIsDropDownAllGermanyPresent() {
        checkElementIsDisplayed(allGermany1);
    }
    void checkIsDropDownBadenWurttembergPresent() {
        checkElementIsDisplayed(badenWurttemberg1);
    }
    void checkIsDropDownBayernPresent() {
        checkElementIsDisplayed(bayern1);
    }
    void checkIsDropDownBerlinPresent() {
        checkElementIsDisplayed(berlin1);
    }
    void checkIsDropDownBrandenburgPresent() {
        checkElementIsDisplayed(brandenburg1);
    }
    void checkIsDropDownHamburgPresent() {
        checkElementIsDisplayed(hamburg1);
    }
    void checkIsDropDownHessenPresent() {
        checkElementIsDisplayed(hessen1);
    }
    void checkIsDropDownMecklenburgVorpommernPresent() {
        checkElementIsDisplayed(mecklenburgVorpommern1);
    }
    void checkIsDropDownNordrheinWestfalenPresent() {
        checkElementIsDisplayed(nordrheinWestfalen1);
    }
    void checkIsDropDownNiedersachsenPresent() {
        checkElementIsDisplayed(niedersachsen1);
    }
    void checkIsDropDownRheinlandPfalzPresent() {
        checkElementIsDisplayed(rheinlandPfalz1);
    }
    void checkIsDropDownSachsenPresent() {
        checkElementIsDisplayed(sachsen1);
    }
    void checkIsDropDownSachsenAnhaltPresent() {
        checkElementIsDisplayed(sachsenAnhalt1);
    }
    void checkIsDropDownSchleswigHolsteinPresent() {
        checkElementIsDisplayed(schleswigHolstein1);
    }
    void checkIsDropDownThüringenPresent() {
        checkElementIsDisplayed(thüringen1);
    }

    public void dropDownAllGermany() {
        precondition();
        clickOnDropDownAllGermany();
        checkIsDropDownAllGermanyPresent();
    }
    public void dropDownBadenWurttemberg() {
        precondition();
        clickOnDropDownBadenWurttemberg();
        checkIsDropDownBadenWurttembergPresent();
    }
    public void dropDownBayern() {
        precondition();
        clickOnDropDownBayern();
        checkIsDropDownBayernPresent();
    }
    public void dropDownBerlin() {
        precondition();
        clickOnDropDownBerlin();
        checkIsDropDownBerlinPresent();
    }
    public void dropDownBrandenburg() {
        precondition();
        clickOnDropDownBrandenburg();
        checkIsDropDownBrandenburgPresent();
    }
    public void dropDownHamburg() {
        precondition();
        clickOnDropDownHamburg();
        checkIsDropDownHamburgPresent();
    }
    public void dropDownHessen() {
        precondition();
        clickOnDropDownHessen();
        checkIsDropDownHessenPresent();
    }
    public void dropDownMecklenburgVorpommern() {
        precondition();
        clickOnDropDownMecklenburgVorpommern();
        checkIsDropDownMecklenburgVorpommernPresent();
    }
    public void dropDownNiedersachsen() {
        precondition();
        clickOnDropDownNiedersachsen();
        checkIsDropDownNiedersachsenPresent();
    }
    public void dropDownNordrheinWestfalen() {
        precondition();
        clickOnDropDownNordrheinWestfalen();
        checkIsDropDownNordrheinWestfalenPresent();
    }
    public void dropDownRheinlandPfalz() {
        precondition();
        clickOnDropDownRheinlandPfalz();
        checkIsDropDownRheinlandPfalzPresent();
    }
    public void dropDownSachsen() {
        precondition();
        clickOnDropDownSachsen();
        checkIsDropDownSachsenPresent();
    }
    public void dropDownSachsenAnhalt() {
        precondition();
        clickOnDropDownSachsenAnhalt();
        checkIsDropDownSachsenAnhaltPresent();
    }
    public void dropDownSchleswigHolstein() {
        precondition();
        clickOnDropDownSchleswigHolstein();
        checkIsDropDownSchleswigHolsteinPresent();
    }
    public void dropDownThüringen() {
        precondition();
        clickOnDropDownThüringen();
        checkIsDropDownThüringenPresent();
    }

    public HomeUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}

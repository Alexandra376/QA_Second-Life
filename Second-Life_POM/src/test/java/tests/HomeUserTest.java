package tests;

import org.junit.jupiter.api.Test;
import pages.HomeUserPage;

public class HomeUserTest extends BaseUserTest {
    @Test
    void testDropdown1Positive() {
        new HomeUserPage(driver, wait).dropDownAllGermany();
    }
    @Test
    void testDropdown2Positive() {
        new HomeUserPage(driver, wait).dropDownBadenWurttemberg();
    }
    @Test
    void testDropdown3Positive() {
        new HomeUserPage(driver, wait).dropDownBayern();
    }
    @Test
    void testDropdown4Positive() {
        new HomeUserPage(driver, wait).dropDownBerlin();
    }
    @Test
    void testDropdown5Positive() {
        new HomeUserPage(driver, wait).dropDownBrandenburg();
    }
    @Test
    void testDropdown6Positive() {
        new HomeUserPage(driver, wait).dropDownHamburg();
    }
    @Test
    void testDropdown7Positive() {
        new HomeUserPage(driver, wait).dropDownHessen();
    }
    @Test
    void testDropdown8Positive() {
        new HomeUserPage(driver, wait).dropDownMecklenburgVorpommern();
    }
    @Test
    void testDropdown9Positive() {
        new HomeUserPage(driver, wait).dropDownNiedersachsen();
    }
    @Test
    void testDropdown10Positive() {
        new HomeUserPage(driver, wait).dropDownNordrheinWestfalen();
    }
    @Test
    void testDropdown11Positive() {
        new HomeUserPage(driver, wait).dropDownRheinlandPfalz();
    }
    @Test
    void testDropdown12Positive() {
        new HomeUserPage(driver, wait).dropDownSachsen();
    }
    @Test
    void testDropdown13Positive() {
        new HomeUserPage(driver, wait).dropDownSachsenAnhalt();
    }
    @Test
    void testDropdown14Positive() {
        new HomeUserPage(driver, wait).dropDownSchleswigHolstein();
    }
    @Test
    void testDropdown15Positive() {
        new HomeUserPage(driver, wait).dropDownThüringen();
    }
}

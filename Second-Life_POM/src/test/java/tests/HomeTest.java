package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
    @Test
    void testDropdown1Positive() {
        new HomePage(driver, wait).dropDownAllGermany();
    }
    @Test
    void testDropdown2Positive() {
        new HomePage(driver, wait).dropDownBadenWurttemberg();
    }
    @Test
    void testDropdown3Positive() {
        new HomePage(driver, wait).dropDownBayern();
    }
    @Test
    void testDropdown4Positive() {
        new HomePage(driver, wait).dropDownBerlin();
    }
    @Test
    void testDropdown5Positive() {
        new HomePage(driver, wait).dropDownBrandenburg();
    }
    @Test
    void testDropdown6Positive() {
        new HomePage(driver, wait).dropDownHamburg();
    }
    @Test
    void testDropdown7Positive() {
        new HomePage(driver, wait).dropDownHessen();
    }
    @Test
    void testDropdown8Positive() {
        new HomePage(driver, wait).dropDownMecklenburgVorpommern();
    }
    @Test
    void testDropdown9Positive() {
        new HomePage(driver, wait).dropDownNiedersachsen();
    }
    @Test
    void testDropdown10Positive() {
        new HomePage(driver, wait).dropDownNordrheinWestfalen();
    }
    @Test
    void testDropdown11Positive() {
        new HomePage(driver, wait).dropDownRheinlandPfalz();
    }
    @Test
    void testDropdown12Positive() {
        new HomePage(driver, wait).dropDownSachsen();
    }
    @Test
    void testDropdown13Positive() {
        new HomePage(driver, wait).dropDownSachsenAnhalt();
    }
    @Test
    void testDropdown14Positive() {
        new HomePage(driver, wait).dropDownSchleswigHolstein();
    }
    @Test
    void testDropdown15Positive() {
        new HomePage(driver, wait).dropDownThüringen();
    }
}

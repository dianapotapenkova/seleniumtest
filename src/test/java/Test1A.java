import config.SeleniumConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage1A;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test1A {

    private SeleniumConfig config;
    private HomePage1A homePage1A;

    @Before
    public void setUp() {
        config = new SeleniumConfig();
        homePage1A = new HomePage1A(config);

    }

    @After
    public void teardown() {
        config.close();
    }

    @Test
    public void testAddTeapot() throws Exception {
        config.getDriver().get("https://1a.lv");
        homePage1A.clickSearchField();
        homePage1A.typeTextInSearchField("tea pot");
        homePage1A.clickButtonSearch();
        homePage1A.clickLinkTeaPots();
        assertTrue(homePage1A.getCountForFoundItems() > 0);
        homePage1A.clickButtonAddItemToCart();
        homePage1A.clickButtonOpenCart();
        assertTrue(homePage1A.getCountForAddedItems() > 0);
    }
}

import config.SeleniumConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.CTCOPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCTCOPage {

    private SeleniumConfig config;
    private CTCOPage ctcoPage;

    @Before
    public void setUp() {
        config = new SeleniumConfig();
        ctcoPage = new CTCOPage(config);

    }

    @After
    public void teardown() {
        config.close();
    }

    @Test
    public void testAutomationEngineerJobDescription() {
        config.getDriver().get("https://ctco.lv/");
        ctcoPage
                .selectVacancies()
                .clickOptionTestAutomationEngineer();
        assertTrue(ctcoPage.getTextFromSkills().contains("Good level in English"));
        assertTrue(ctcoPage.getTextFromSkills().contains("Team player with good analytical and communication skills"));
        assertTrue(ctcoPage.getTextFromSkills().contains("Experience with automated testing tools and frameworks"));

    }
}

import config.SeleniumConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.CTCOSideBar;
import pages.CTCOTestAutomationEngineer;
import pages.CTCOVacancies;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCTCOPage {

    private SeleniumConfig config;
    private CTCOSideBar ctcoSideBar;
    private CTCOVacancies ctcoVacancies;
    private CTCOTestAutomationEngineer ctcoTestAutomationEngineer;

    @Before
    public void setUp() {
        config = new SeleniumConfig();
        ctcoSideBar = new CTCOSideBar(config);
        ctcoVacancies = new CTCOVacancies(config);
        ctcoTestAutomationEngineer = new CTCOTestAutomationEngineer(config);

    }

    @After
    public void teardown() {
        config.close();
    }

    @Test
    public void testAutomationEngineerJobDescription() {
        config.getDriver().get("https://ctco.lv/");
        ctcoSideBar.selectVacancies();
        ctcoVacancies.clickOptionTestAutomationEngineer();
        assertTrue(ctcoTestAutomationEngineer.getTextFromSkills().contains("Good level in English"));
        assertTrue(ctcoTestAutomationEngineer.getTextFromSkills().contains("Team player with good analytical and communication skills"));
        assertTrue(ctcoTestAutomationEngineer.getTextFromSkills().contains("Experience with automated testing tools and frameworks"));

    }
}

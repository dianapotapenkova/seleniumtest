package pages;

import config.SeleniumConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CTCOVacancies {

    private SeleniumConfig config;
    private Actions action;

    public CTCOVacancies(SeleniumConfig config) {
        this.config = config;
        this.driver = config.getDriver();
        PageFactory.initElements(this.config.getDriver(), this);
        this.action = new Actions(config.getDriver());
    }

    private WebDriver driver;

    //Objects
    @FindBy(css = "a[href='https://ctco.lv/careers/vacancies/test-automation-engineer-2/']")
    private WebElement optionTestAutomationEngineer;

    //Functions
    public CTCOVacancies clickOptionTestAutomationEngineer() {
        optionTestAutomationEngineer.click();
        return this;
    }

}

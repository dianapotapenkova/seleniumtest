package pages;

import config.SeleniumConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CTCOTestAutomationEngineer {

    private SeleniumConfig config;
    private Actions action;

    public CTCOTestAutomationEngineer(SeleniumConfig config) {
        this.config = config;
        this.driver = config.getDriver();
        PageFactory.initElements(this.config.getDriver(), this);
        this.action = new Actions(config.getDriver());
    }

    private WebDriver driver;

    //Objects
    @FindBy(xpath = "//h1[text()='Test Automation Engineer']/following-sibling::div/p[3]")
    private WebElement skills;

    //Functions
    public String getTextFromSkills() {
        WebDriverWait wait = new WebDriverWait(config.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(skills));
        return skills.getText();
    }

}

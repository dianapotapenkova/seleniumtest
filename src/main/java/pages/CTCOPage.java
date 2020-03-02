package pages;

import config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CTCOPage {

    private SeleniumConfig config;
    private Actions action;

    public CTCOPage(SeleniumConfig config) {
        this.config = config;
        this.driver = config.getDriver();
        PageFactory.initElements(this.config.getDriver(), this);
        this.action = new Actions(config.getDriver());
    }

    private WebDriver driver;


    //Objects
    @FindBy(css = "a[href='https://ctco.lv/careers/']")
    private WebElement careers;

    @FindBy(css = "a[href='https://ctco.lv/careers/vacancies/']")
    private WebElement vacancies;

    @FindBy(css = "a[href='https://ctco.lv/careers/vacancies/test-automation-engineer-2/']")
    private WebElement optionTestAutomationEngineer;

    @FindBy(xpath = "//h1[text()='Test Automation Engineer']/following-sibling::div/p[3]")
    private WebElement skills;


    //Functions

    public CTCOPage selectVacancies() {
        action.moveToElement(careers).build().perform();
        vacancies.click();
        return this;
    }

    public CTCOPage clickOptionTestAutomationEngineer() {
        optionTestAutomationEngineer.click();
        return this;
    }

    public String getTextFromSkills() {
        WebDriverWait wait = new WebDriverWait(config.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(skills));
        return skills.getText();
    }
}

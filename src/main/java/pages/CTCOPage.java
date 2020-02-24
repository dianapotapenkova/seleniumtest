package pages;

import config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CTCOPage {

    private SeleniumConfig config;

    public CTCOPage(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
    }

    //Objects
    @FindBy(xpath =  "//a[@href='https://ctco.lv/careers/']")
    private WebElement careers;

    @FindBy(xpath = "//a[@href='https://ctco.lv/careers/vacancies/']")
    private WebElement vacancies;

    @FindBy(xpath =  "//a[text()='Test Automation Engineer']")
    private WebElement optionTestAutomationEngineer;

    @FindBy(xpath =  "//h1[text()='Test Automation Engineer']/following-sibling::div/p[3]")
    private WebElement skills;


    //Functions

    public CTCOPage clickCareers(){
        careers.click();
        return this;
    }

    public CTCOPage clickVacancies(){
        WebDriverWait wait = new WebDriverWait(config.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
        return this;
    }

    public CTCOPage clickOptionTestAutomationEngineer(){
        optionTestAutomationEngineer.click();
        return this;
    }

    public String getTextFromSkills(){
        WebDriverWait wait = new WebDriverWait(config.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(skills));
        return skills.getText();
    }
}

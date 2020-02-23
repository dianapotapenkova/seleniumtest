package pages;

import config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage1A {
    private SeleniumConfig config;

    public HomePage1A(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
    }

    //Objects
    @FindBy(css="input[type = 'search']")
    private WebElement fieldSearch;

    @FindBy(css="a[class = 'close-button animated']")
    private  WebElement buttonCloseBanner;

    @FindBy(css="input[type = 'submit']")
    private WebElement buttonSearch;

//    @FindBy(css="strong[class = 'ait-search-result-title']")
//    private WebElement linkTeaPots;

    @FindBy(xpath="//strong[text()='Tējkannas (ar svilpi)']")
    private WebElement linkTeaPots;

    @FindBy(xpath="//div[text()='Atrastas preces: ']/span")
    private WebElement counterForFoundItems;

    @FindBy(css="a[class='button btn-cart']")
    private WebElement buttonAddItemToCart;

    @FindBy(css="a[class = 'button btn-cart product-is-in-cart']")
    private WebElement buttonOpenCart;

    @FindBy(xpath="//div[@id='shopping_cart_container']/a/span")
    private WebElement counterForAddedItems;

    @FindBy(xpath = "//iframe[contains(@src,'//cdn.mxapis.com/serve/display/43416/desktop/1582488020?campaign_id=2766')]")
    private WebElement bannerIframe;

    @FindBy(xpath = "//a[@class='close-button animated']")
    private WebElement buttonBannerClose;




    //Functions
    public HomePage1A clickSearchField(){
        handlePopup();
        fieldSearch.click();
        return this;
    }

    public HomePage1A typeTextInSearchField(String itemToSearchFor){
        fieldSearch.sendKeys(itemToSearchFor);
        return this;
    }

    public HomePage1A closeBanner(){
        if (config.getDriver().findElement(By.cssSelector("a[class = 'close-button animated']")).isDisplayed()) {
            buttonCloseBanner.click();
        }
        return this;
    }

    public HomePage1A clickButtonSearch(){
        buttonSearch.click();
        return this;
    }

    public HomePage1A clickLinkTeaPots(){
        handlePopup();
        linkTeaPots.click();
        return this;
    }

    public int getCountForFoundItems(){
        return Integer.valueOf(counterForFoundItems.getText());
    }

    public HomePage1A clickButtonAddItemToCart(){
        handlePopup();
        buttonAddItemToCart.click();
        return this;
    }

    public HomePage1A clickButtonOpenCart(){
        handlePopup();
        buttonOpenCart.click();
        return this;
    }

    public int getCountForAddedItems(){
        return Integer.valueOf(counterForAddedItems.getText());
    }

    private void handlePopup() {
        WebDriver driver = config.getDriver();
        try {
            if (bannerIframe.isDisplayed()) {
                driver.switchTo().frame(bannerIframe);
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOf(buttonCloseBanner));
                buttonCloseBanner.click();
                driver.switchTo().defaultContent();
            }
        } catch (NoSuchElementException e){
            return;
        }
    }

}

package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.pages.components.DesktopComponents;
import java.util.ArrayList;
import java.util.List;
@Log4j2
public class MainPage extends BasePage{

    private By myAccountButton = By.xpath("//div/a//span[text()='My Account']");
    private By registerButton = By.xpath("//ul/li/a[text()='Register']");
    private By loginButton = By.xpath("//ul/li/a[text()='Login']");
    private By desktopButton = By.xpath("//li/a[text()='Desktops']");
    private By desktopShowAllDesktopButton = By.xpath("//div[@class='dropdown-menu show']/a[@class='see-all']");
    private By selectCurrency = By.xpath("//a[@class='dropdown-toggle']");
    private By selectCurrencyEUR = By.xpath("//ul[@class='dropdown-menu show']/li/a[@href='EUR']");
    private By selectCurrencyGBP = By.xpath("//ul[@class='dropdown-menu show']/li/a[@href='GBP']");
    private By selectCurrencyUSD = By.xpath("//ul[@class='dropdown-menu show']/li/a[@href='USD']");
    private By actualCurrentCurrency = By.xpath("//a[@class='dropdown-toggle']/strong");
    private By mainComponents = By.xpath("//div[@class='product-thumb']");
    private By camerasButton = By.xpath("//li/a[text()='Cameras']");
    private By linkToBrandsPage = By.xpath("//ul[@class='list-unstyled']//a[text()='Brands']");

    @Step("Click on [My Account]")
    public MainPage openMyAccount(){
        log.info("Click on My Account");
        find(myAccountButton).click();
        return this;
    }
    @Step("Click on [Register] button")
    public RegisterAccountPage selectRegisterOption(){
        log.info("Click on Register button");
        find(registerButton).click();
        return new RegisterAccountPage();
    }

    @Step("Click on [Desktop] button")
    public MainPage selectDesktops(){
        log.info("Click on Desktop button");
        find(desktopButton).click();
        return this;
    }

    @Step("Click on [All Desktop] button")
    public DesktopPage selectAllDesktop(){
        log.info("Click on All Desktop button");
        find(desktopShowAllDesktopButton).click();
        return new DesktopPage();
    }

    @Step("Select currency {currency}")
    public void selectCurrency(String currency){
        log.info("Select currency");
        find(selectCurrency).click();
        if(currency == "EUR"){
            find(selectCurrencyEUR).click();
        } else if (currency == "GBP"){
            find(selectCurrencyGBP).click();
        } else if (currency == "USD") {
            find(selectCurrencyUSD).click();
        }
    }

    @Step("Check if currency is $")
    public MainPage checkThatCurrencyIsValid(){
        log.info("Check if currency is $");
        if(find(actualCurrentCurrency).getText() == "$"){
            return this;
        } else {
            find(selectCurrency).click();
            find(selectCurrencyUSD).click();
        }
        return this;
    }

    @Step("Get all components on [Main] page")
    public List<DesktopComponents> getMainComponents(){
        log.info("Get all components on Main page");
        List<DesktopComponents> products = new ArrayList<>();
        List<WebElement> containers = findAll(mainComponents);
        for (WebElement container : containers) {
            DesktopComponents desktopComponents = new DesktopComponents(container);
            products.add(desktopComponents);
        }
        return products;
    }

    @Step("Click on element by Locator [JS]")
    public ProductPage clickOnButton(WebElement locator){
        log.info("Click on element");
        submitByWebElement(locator);
        return new ProductPage();
    }

    @Step("Go to [Cameras] page")
    public CamerasPage clickOnCamerasButton(){
        log.info("Go to Cameras page");
        find(camerasButton).click();
        return new CamerasPage();
    }


    @Step("Go to [Brand] page")
    public BrandsPage goToBrandsPage(){
        log.info("Go to Brand page");
        submitByLocator(linkToBrandsPage);
        return new BrandsPage();

    }





}

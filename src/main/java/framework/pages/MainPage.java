package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.pages.components.DesktopComponents;
import java.util.ArrayList;
import java.util.List;

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

    public MainPage openMyAccount(){
        find(myAccountButton).click();
        return this;
    }

    public RegisterAccountPage selectRegisterOption(){
        find(registerButton).click();
        return new RegisterAccountPage();
    }

    public MainPage selectDesktops(){
        find(desktopButton).click();
        return this;
    }

    public DesktopPage selectAllDesktop(){
        find(desktopShowAllDesktopButton).click();
        return new DesktopPage();
    }

    public void selectCurrency(String currency){
        find(selectCurrency).click();
        if(currency == "EUR"){
            find(selectCurrencyEUR).click();
        } else if (currency == "GBP"){
            find(selectCurrencyGBP).click();
        } else if (currency == "USD") {
            find(selectCurrencyUSD).click();
        }
    }

    public MainPage checkThatCurrencyIsValid(){
        if(find(actualCurrentCurrency).getText() == "$"){
            return this;
        } else {
            find(selectCurrency).click();
            find(selectCurrencyUSD).click();
        }
        return this;
    }

    public List<DesktopComponents> getMainComponents(){
        List<DesktopComponents> products = new ArrayList<>();
        List<WebElement> containers = findAll(mainComponents);
        for (WebElement container : containers) {
            DesktopComponents desktopComponents = new DesktopComponents(container);
            products.add(desktopComponents);
        }
        return products;
    }


    public ProductPage clickOnButton(WebElement locator){
        submitByWebElement(locator);
        return new ProductPage();
    }

    public CamerasPage clickOnCamerasButton(){
        find(camerasButton).click();
        return new CamerasPage();
    }

    public BrandsPage goToBrandsPage(){
        submitByLocator(linkToBrandsPage);
        return new BrandsPage();

    }





}

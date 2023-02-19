package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import framework.pages.components.DesktopComponents;

import java.util.List;


import java.util.ArrayList;
@Log4j2
public class DesktopPage extends BasePage {

    private By desktopComponents = By.xpath("//div[@class='product-thumb']");
    private By currentShowSelectCount = By.xpath("//label[text()='Show']/following-sibling::select/option[@selected]");
    private By currentSortBySelectValue = By.xpath("//label[text()='Sort By']/following-sibling::select/option[@selected]");
    private By sortBySelectValue = By.xpath("//label[text()='Show']/following-sibling::select");
    private By countShowingPages = By.xpath("//div[@class='col-sm-6 text-end']");
    private By sortBySelectCustomValue = By.xpath("//select[@id='input-sort']");

    @Step("Get current sort parameter")
    public String getSortByValue(){
        log.info("Get current sort parameter");
        return find(currentSortBySelectValue).getText();

    }

    @Step("Set sort parameter by {text}")
    public DesktopPage setSortByValue(String text) {
        log.info("Set sort parameter by selected text");
        Select select = new Select(find(sortBySelectCustomValue));
        select.selectByVisibleText(text);
        return this;
    }

    @Step("Get filter value")
    public String getShowValue(){
        log.info("Get filter value");
        return find(currentShowSelectCount).getText();

    }

    @Step("Select filter value as {value}")
    public void setShowValue(String value){
        log.info("Select filter value");
        Select select = new Select(find(sortBySelectValue));
        select.selectByVisibleText(value);
    }

    @Step("Get current count of page")
    public String getCountShowingPages(){
        log.info("Get current count of page");
        return find(countShowingPages).getText();
    }

    @Step("Get all components on [Desktop] page")
    public List<DesktopComponents> getDesktopComponents(){
        log.info("Get all components on Desktop page");
        List<DesktopComponents> products = new ArrayList<>();
        List<WebElement> containers = findAll(desktopComponents);
        for (WebElement container : containers) {
            DesktopComponents desktopComponents = new DesktopComponents(container);
            products.add(desktopComponents);
        }
        return products;
    }


}

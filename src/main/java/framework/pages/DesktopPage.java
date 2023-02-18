package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import framework.pages.components.DesktopComponents;

import java.util.List;


import java.util.ArrayList;

public class DesktopPage extends BasePage {

    private By desktopComponents = By.xpath("//div[@class='product-thumb']");
    private By currentShowSelectCount = By.xpath("//label[text()='Show']/following-sibling::select/option[@selected]");
    private By currentSortBySelectValue = By.xpath("//label[text()='Sort By']/following-sibling::select/option[@selected]");
    private By sortBySelectValue = By.xpath("//label[text()='Show']/following-sibling::select");
    private By countShowingPages = By.xpath("//div[@class='col-sm-6 text-end']");
    private By sortBySelectCustomValue = By.xpath("//select[@id='input-sort']");

    public String getSortByValue(){
        return find(currentSortBySelectValue).getText();

    }

    public DesktopPage setSortByValue(String text) {
        Select select = new Select(find(sortBySelectCustomValue));
        select.selectByVisibleText(text);
        return this;
    }

    public String getShowValue(){
        return find(currentShowSelectCount).getText();

    }

    public void setShowValue(String value){
        Select select = new Select(find(sortBySelectValue));
        select.selectByVisibleText(value);
    }

    public String getCountShowingPages(){
        return find(countShowingPages).getText();
    }


    public List<DesktopComponents> getDesktopComponents(){
        List<DesktopComponents> products = new ArrayList<>();
        List<WebElement> containers = findAll(desktopComponents);
        for (WebElement container : containers) {
            DesktopComponents desktopComponents = new DesktopComponents(container);
            products.add(desktopComponents);
        }
        return products;
    }


}

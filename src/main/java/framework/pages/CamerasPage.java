package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.pages.components.DesktopComponents;

import java.util.ArrayList;
import java.util.List;

public class CamerasPage extends BasePage{
    private By camerasComponents = By.xpath("//div[@class='product-thumb']");

    public List<DesktopComponents> getCamerasComponents(){
        List<DesktopComponents> products = new ArrayList<>();
        List<WebElement> containers = findAll(camerasComponents);
        for (WebElement container : containers) {
            DesktopComponents desktopComponents = new DesktopComponents(container);
            products.add(desktopComponents);
        }
        return products;
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BrandsPage extends BasePage{
    private By allBrands = By.xpath("//div[@class='col-sm-3']/a");

    public List<WebElement> findAllBrands(){
        return findAll(allBrands);
    }

}

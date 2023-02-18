package framework.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

@Log4j2
public class BrandsPage extends BasePage{
    private By allBrands = By.xpath("//div[@class='col-sm-3']/a");

    public List<WebElement> findAllBrands(){
        log.info("Find all Brands in page");
        return findAll(allBrands);
    }

}

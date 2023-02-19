package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class ProductPage extends BasePage {
    private By productNewPrice = By.xpath("//ul[@class='list-unstyled']//span[@class='price-new']");

    @Step("Get price on [Detail] Product page")
    public String getNewProductPrise(){
        log.info("Get price on detail Product page");

        return find(productNewPrice).getText();
    }



}

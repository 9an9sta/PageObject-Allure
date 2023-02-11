package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private By productNewPrice = By.xpath("//ul[@class='list-unstyled']//span[@class='price-new']");

    public String getNewProductPrise(){
        return find(productNewPrice).getText();
    }



}

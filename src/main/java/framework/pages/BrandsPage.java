package framework.pages;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public class BrandsPage extends BasePage {

  private final By allBrands = By.xpath("//div[@class='col-sm-3']/a");

  @Step("Find all brand in [Brand] page")

  public List<String> findAllBrands() {
    List<WebElement> allBrandsWebElement = findAll(allBrands);
    List<String> allBrandsNe = new ArrayList<>();
    for (WebElement brands : allBrandsWebElement) {
      String a = (brands.getText());
      allBrandsNe.add(a);
    }
    log.info("Find all Brands in page");
    return allBrandsNe;
  }

}

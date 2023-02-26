package framework.pages;

import framework.pages.components.DesktopComponents;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public class CamerasPage extends BasePage {

  private By camerasComponents = By.xpath("//div[@class='product-thumb']");

  @Step("Get all Cameras parameters")
  public List<DesktopComponents> getCamerasComponents() {
    log.info("Get all Cameras parameters");
    List<DesktopComponents> products = new ArrayList<>();
    List<WebElement> containers = findAll(camerasComponents);
    for (WebElement container : containers) {
      DesktopComponents desktopComponents = new DesktopComponents(container);
      products.add(desktopComponents);
    }
    return products;
  }
}

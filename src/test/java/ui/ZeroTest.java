package ui;

import framework.pages.BrandsPage;
import framework.pages.MainPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ZeroTest extends BaseTest {

  //Go to the https://demo.opencart.com/
  MainPage mainPage = new MainPage();
  BrandsPage brandsPage = new BrandsPage();

  @Test
  public void checkAreFollowingBrandsExistOnPage() {
    //Click on 'Brands' at the bottom of the page
    mainPage.goToBrandsPage();
    //Check that following brands exists on page [Apple,Canon,Hewlett-Packard,HTC,Palm,Sony]
    List<String> expectedResult = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm",
        "Sony");
    List<String> actualResult = brandsPage.findAllBrands();
    Assertions
        .assertThat(actualResult)
        .as("Brands are not the same")
        .isEqualTo(expectedResult);

  }

}

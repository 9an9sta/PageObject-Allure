package ui;

import framework.pages.MainPage;
import framework.pages.ProductPage;
import framework.pages.components.DesktopComponents;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class FourTest extends BaseTest {

  private final MainPage mainPage = new MainPage();
  private final ProductPage productPage = new ProductPage();

  @Test
  public void checkThatPriceCorrectly() {
    SoftAssertions softly = new SoftAssertions();
    //On the main page check that current currency is $ (change to $ if not)
    mainPage.checkThatCurrencyIsValid();
    List<DesktopComponents> products = mainPage.getMainComponents();
    DesktopComponents mainProductList = null;

    for (DesktopComponents product : products) {
      if (product.getName().equals("iPhone")) {
        mainProductList = product;

      }
    }

    String expectedDollarPrice = mainProductList.getNewPrice().replace("$", "");

    //Click on the Iphone
    mainPage.clickOnButton(mainProductList.getWeName());

    //Check that price 123.20
    String actualDollarPrice = productPage.getNewProductPrise().replace("$", "");
    softly.assertThat(expectedDollarPrice).as("Dollar price are different")
        .isEqualTo(actualDollarPrice);

    //Change currency to euro
    mainPage.selectCurrency("EUR");

    //Check that price 106.04
    String actualEuroPrice = productPage.getNewProductPrise().replace("€", "");
    softly.assertThat(actualEuroPrice).as("Euro price are different").isEqualTo("106.04");

    //Change currency to Pound Sterling
    mainPage.selectCurrency("GBP");

    //Check that price 95.32
    String actualPoundSterlingPrice = productPage.getNewProductPrise().replace("£", "");
    softly.assertThat(actualPoundSterlingPrice).as("Pound Sterling are different")
        .isEqualTo("95.32");
    softly.assertAll();
  }

}

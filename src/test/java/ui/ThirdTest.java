package ui;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.DesktopPage;
import pages.MainPage;
import pages.components.DesktopComponents;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ThirdTest extends BaseTest{
    private final DesktopPage desktopPage = new DesktopPage();
    private final MainPage mainPage = new MainPage();
    @Test
    public void checkThatProductSortedCorrectly(){
        SoftAssertions softly = new SoftAssertions();
        //Go to the https://demo.opencart.com/
        mainPage.selectDesktops()                   //Hover over Desktops from top menu
                .selectAllDesktop()                 //Click on Show All Desktops
                .setSortByValue("Name (A - Z)");    //Select 'Name (A - Z)' from Sort by dropdown

        //Check that products were sorted correctly
        List<DesktopComponents> products = desktopPage.getDesktopComponents();
        List<String> desktopProduct = new ArrayList<>();
        List<String> actualListOfProducts = null;
        for (DesktopComponents product : products) {
            desktopProduct.add(product.getName());
        }
        actualListOfProducts = desktopProduct;
        desktopProduct.sort(String.CASE_INSENSITIVE_ORDER);
        softly.assertThat(actualListOfProducts).as("list are not be sorted").isEqualTo(desktopProduct);

        //Select 'Price (Low > High)' from Sort by dropdown
        desktopPage.setSortByValue("Price (Low > High)");

        //Check that products were sorted correctly
        List<DesktopComponents> desktopComponents = desktopPage.getDesktopComponents();
        List<String> prices = new ArrayList<>();
        for (DesktopComponents desktopComponent : desktopComponents) {
            prices.add(desktopComponent.getNewPrice());
        }
        List<Double> doubles = new ArrayList<>();
        for (String price : prices) {
            doubles.add(Double.parseDouble(price.replace("$","").replace(",","")));
        }
        List<Double> actualListOfProductsPrice = doubles;
        doubles.sort(Comparator.comparing(Double::doubleValue));
        softly.assertThat(actualListOfProductsPrice).as("list with price are not sorted").containsExactlyElementsOf(doubles);
        softly.assertAll();
    }
}

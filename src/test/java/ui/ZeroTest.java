package ui;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import framework.pages.BrandsPage;
import framework.pages.MainPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ZeroTest extends BaseTest {
    //Go to the https://demo.opencart.com/
    MainPage mainPage = new MainPage();
    BrandsPage brandsPage = new BrandsPage();
    @Test
    public void checkAreFollowingBrandsExistOnPage(){
        //Click on 'Brands' at the bottom of the page
        mainPage.goToBrandsPage();

        //Check that following brands exists on page [Apple,Canon,Hewlett-Packard,HTC,Palm,Sony]
        List<WebElement> allBrandsWebElement = brandsPage.findAllBrands();
        List<String> allBrandsNe = new ArrayList<>();
        List<String> expectedResult = Arrays.asList("Apple","Canon","Hewlett-Packard","HTC","Palm","Sony");

        for (WebElement brands : allBrandsWebElement) {
            String a = (brands.getText());
            allBrandsNe.add(a);
        }
        Assertions
                .assertThat(allBrandsNe)
                .as("Brands are not the same")
                .isEqualTo(expectedResult);

    }

}

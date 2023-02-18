package ui;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import framework.pages.CamerasPage;
import framework.pages.MainPage;
import framework.pages.components.DesktopComponents;

import java.util.List;

public class FifthTest extends BaseTest {
    MainPage mainPage = new MainPage();
    CamerasPage camerasPage = new CamerasPage();

    @Test
    public void checkCamerasPrice(){
        SoftAssertions softly = new SoftAssertions();
        //Go to the https://demo.opencart.com/
        //Click on the Cameras
        mainPage.clickOnCamerasButton();

        //Check that 2 cameras exist on page
        List<DesktopComponents> products = camerasPage.getCamerasComponents();
        int actualCamerasCount = products.size();
        softly.assertThat(actualCamerasCount).as("Not two cameras exist on page").isEqualTo(2);

        //Check that Canon EOS 5D has old price 122.00
        //Check that Canon EOS 5D has new price 98.00
        DesktopComponents cameraCanonProduct = null;
        DesktopComponents cameraNikonProduct = null;
        for (DesktopComponents product: products) {
            if(product.getName().equals("Canon EOS 5D")){
                cameraCanonProduct = product;
            }
            if(product.getName().equals("Nikon D300")){
                cameraNikonProduct = product;
            }
        }
        String actualCamerasOldPrice = cameraCanonProduct.getOldPrice().replace("$", "");
        String actualCamerasNewPrice = cameraCanonProduct.getNewPrice().replace("$", "");
        softly.assertThat(actualCamerasOldPrice).as("Old price are not the same").isEqualTo("122.00");
        softly.assertThat(actualCamerasNewPrice).as("New price are not the same").isEqualTo("98.00");

        //Check that Nikon D300 has ex.rate 80.00
        String actualCameraTax = cameraNikonProduct.getExTax().replace("$", "");
        softly.assertThat(actualCameraTax).as("Camera tax are not the same").isEqualTo("80.00");
        softly.assertAll();

    }
}

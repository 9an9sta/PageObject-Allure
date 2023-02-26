package ui;

import framework.pages.DesktopPage;
import framework.pages.MainPage;
import framework.pages.components.DesktopComponents;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

  private final DesktopPage desktopPage = new DesktopPage();
  private final MainPage mainPage = new MainPage();


  @Test
  public void checkThatPageElementAreOllShow() {
    SoftAssertions softly = new SoftAssertions();

    //Go to the https://demo.opencart.com/
    mainPage.selectDesktops()       //Hover over Desktops from top menu
        .selectAllDesktop();    //Click on Show All Desktops

    //Check that value in Show dropdown is 10
    String actualShowSelectValue = desktopPage.getShowValue();

    //Check that value in Sort By is Default
    String actualSortByValue = desktopPage.getSortByValue();
    softly.assertThat(actualShowSelectValue).as("Show value are not the same").isEqualTo("10");
    softly.assertThat(actualSortByValue).as("Sort By value are not the same").isEqualTo("Default");

    //Check that 10 products display on page
    List<DesktopComponents> products = desktopPage.getDesktopComponents();

    int actualDesktopProductCount = products.size();
    softly.assertThat(actualDesktopProductCount)
        .as("The product count on a page are not the same")
        .isEqualTo(10);

    //Select 25 from Show dropdown
    desktopPage.setShowValue("25");

    //Check that 12 products now displayed
    List<DesktopComponents> changeProduct = desktopPage.getDesktopComponents();
    int actualDesktopProductCountAfterSettingShowOption = changeProduct.size();
    softly.assertThat(actualDesktopProductCountAfterSettingShowOption)
        .as("The product count after changes are not the same")
        .isEqualTo(12);

    //Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page
    String actualCountShowingPages = desktopPage.getCountShowingPages();
    softly.assertThat(actualCountShowingPages)
        .as("Showing product count are not the same")
        .isEqualTo("Showing 1 to 12 of 12 (1 Pages)");

    softly.assertAll();

  }


}

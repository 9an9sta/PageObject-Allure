package ui;

import framework.pages.MainPage;
import framework.pages.RegisterAccountPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
  public void checkSuccessfulCreateAccountMessage() {
    String userFirstName = "Admiral";
    String userLastName = "Buldog";
    String userEmail = "AdmiralBuldog123@gmail.com";
    String userPassword = "12345Test";
    //Go to the https://demo.opencart.com/
    mainPage.openMyAccount()                //Click on 'My account' icon
        .selectRegisterOption()         //Click on 'Register' button
        .setFirstName(userFirstName)    //Fill form with valid values
        .setLastName(userLastName)
        .setEmail(userEmail)
        .setPassword(userPassword)
        .setNoOptions()
        .submitCheckbox()
        .continueRegisterButton();

    //Check that you was redirected to new page with title 'Welcome'
    Assertions
        .assertThat(RegisterAccountPage.getCurrentPageURl())
        .as("Page are not the same")
        .isEqualTo("Welcome");
  }

}

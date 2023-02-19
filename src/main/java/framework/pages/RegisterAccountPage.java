package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
@Log4j2
public class RegisterAccountPage extends BasePage{
    private By firstNameField = By.xpath("//div/input[@id='input-firstname']");
    private By lastNameField = By.xpath("//div/input[@id='input-lastname']");
    private By emailField = By.xpath("//div/input[@id='input-email']");
    private By passwordField = By.xpath("//div/input[@id='input-password']");
    private By newsLetterYesOptions = By.xpath("//div/input[@id='input-newsletter-yes']");
    private By newsLetterNoOptions = By.xpath("//div/input[@id='input-newsletter-no']");
    private By privacyPolicyCheckbox = By.xpath("//input[@type='checkbox']");
    private By continueRegistrationButton = By.xpath("//button[text()='Continue']");

    @Step("Enter first name")
    public RegisterAccountPage setFirstName(String firstName){
        log.info("Enter first name");
        find(firstNameField).sendKeys(firstName);
        return this;
    }
    @Step("Enter last name")
    public RegisterAccountPage setLastName(String lastName){
        log.info("Enter last name");
        find(lastNameField).sendKeys(lastName);
        return this;
    }

    @Step("Enter email")
    public RegisterAccountPage setEmail(String email){
        log.info("Enter email");
        find(emailField).sendKeys(email);
        return this;
    }
    @Step("Enter password")
    public RegisterAccountPage setPassword(String password){
        log.info("Enter password");
        find(passwordField).sendKeys(password);
        return this;
    }

    @Step("Subscribe on Newsletter")
    public RegisterAccountPage setYesOptions(){
        log.info("Subscribe on Newsletter");
        find(newsLetterYesOptions).click();
        return this;
    }

    @Step("Unsubscribe on Newsletter")
    public RegisterAccountPage setNoOptions(){
        log.info("Unsubscribe on Newsletter");
        find(newsLetterNoOptions).click();
        return this;
    }

    public RegisterAccountPage submitPrivacyPolicy(){
        find(privacyPolicyCheckbox).click();
        return this;
    }

    @Step("Click on [Continue] registration button")
    public RegisterAccountPage continueRegisterButton(){
        log.info("Click on Continue registration button");
        submitByLocator(continueRegistrationButton);
        return new RegisterAccountPage();
    }

    @Step("Submit [Privacy Policy]")
    public RegisterAccountPage submitCheckbox(){
        log.info("Submit Privacy Policy");
        submitByLocator(privacyPolicyCheckbox);
        return this;
    }

    @Step("Get current page URL")
    public static String getCurrentPageURl(){
        log.info("Get current page URL");
        return driver.getCurrentUrl();
    }










}

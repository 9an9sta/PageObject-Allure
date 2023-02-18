package framework.pages;

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

    public RegisterAccountPage setFirstName(String firstName){
        log.info("Enter first name");
        find(firstNameField).sendKeys(firstName);
        return this;
    }
    public RegisterAccountPage setLastName(String lastName){
        log.info("Enter last name");
        find(lastNameField).sendKeys(lastName);
        return this;
    }

    public RegisterAccountPage setEmail(String email){
        log.info("Enter email");
        find(emailField).sendKeys(email);
        return this;
    }

    public RegisterAccountPage setPassword(String password){
        log.info("Enter password");
        find(passwordField).sendKeys(password);
        return this;
    }

    public RegisterAccountPage setYesOptions(){
        log.info("Subscribe on Newsletter");
        find(newsLetterYesOptions).click();
        return this;
    }

    public RegisterAccountPage setNoOptions(){
        log.info("Unsubscribe on Newsletter");
        find(newsLetterNoOptions).click();
        return this;
    }

    public RegisterAccountPage submitPrivacyPolicy(){
        find(privacyPolicyCheckbox).click();
        return this;
    }

    public RegisterAccountPage continueRegisterButton(){
        log.info("Click on Continue registration button");
        submitByLocator(continueRegistrationButton);
        return new RegisterAccountPage();
    }

    public RegisterAccountPage submitCheckbox(){
        log.info("Submit Privacy Policy");
        submitByLocator(privacyPolicyCheckbox);
        return this;
    }

    public static String getCurrentPageURl(){
        return driver.getCurrentUrl();
    }










}

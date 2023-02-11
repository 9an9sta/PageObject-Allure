package pages;

import org.openqa.selenium.By;

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
        find(firstNameField).sendKeys(firstName);
        return this;
    }
    public RegisterAccountPage setLastName(String lastName){
        find(lastNameField).sendKeys(lastName);
        return this;
    }

    public RegisterAccountPage setEmail(String email){
        find(emailField).sendKeys(email);
        return this;
    }

    public RegisterAccountPage setPassword(String password){
        find(passwordField).sendKeys(password);
        return this;
    }

    public RegisterAccountPage setYesOptions(){
        find(newsLetterYesOptions).click();
        return this;
    }

    public RegisterAccountPage setNoOptions(){
        find(newsLetterNoOptions).click();
        return this;
    }

    public RegisterAccountPage submitPrivacyPolicy(){
        find(privacyPolicyCheckbox).click();
        return this;
    }

    public RegisterAccountPage continueRegisterButton(){
        submitByLocator(continueRegistrationButton);
        return new RegisterAccountPage();
    }

    public RegisterAccountPage submitCheckbox(){
        submitByLocator(privacyPolicyCheckbox);
        return this;
    }

    public static String getCurrentPageURl(){
        return driver.getCurrentUrl();
    }










}

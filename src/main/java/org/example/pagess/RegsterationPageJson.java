package org.example.pagess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegsterationPageJson {
    private WebDriver driver;

    @FindBy(name="email")
    private WebElement usernameInput;

    @FindBy(name="password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button-input newd']")
    private WebElement loginButton;


    public RegsterationPageJson(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void fillRegistrationForm(String firstName, String lastName, String email, String password, String phoneNumber) {
//        firstNameInput.sendKeys(firstName);
//        lastNameInput.sendKeys(lastName);
//        emailInput.sendKeys(email);
//        passwordInput.sendKeys(password);
//        phoneNumberInput.sendKeys(phoneNumber);
   // }

    public void Login(String Name , String Pass) {
        usernameInput.sendKeys(Name);
        passwordInput.sendKeys(Pass);
        loginButton.click();
    }

//    public void clickSubmitButton() {
//        submitButton.click();
//    }
}

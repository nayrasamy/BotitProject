package org.example.pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LL {
    private WebDriver driver;
    @FindBy(name = "email")
    private WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button-input']")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/ul/li[1]/a")
    private WebElement catalog;
    @FindBy(className = "tab-label-1 wow")
    private WebElement Categories;
    @FindBy(xpath = "//*[@id=\"tab2\"]/div[2]/div[1]/div[1]/a\n")
    private WebElement AddNewCategory;
    @FindBy(id = "add_name_en")
    private WebElement CategoryName;
    @FindBy(id = "add_name_ar")
    private WebElement LocalArabicName;
    @FindBy(xpath = "//*[@id=\"popup2-branch\"]/div/div[2]/input")
    public WebElement DoneButton;

    public LL(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }
    public void LL() {
        DoneButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 11111);
        WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    }
}

package org.example.pagess;

import com.aventstack.extentreports.model.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ChangePricePage {
    private WebDriver driver;

//    public ChangePricePage(WebDriver driver) {
//        super(driver);
//    }

    public ChangePricePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    @FindBy(xpath = "//span[@class='catalog-icon']")
    WebElement catalogMenu;
    @FindBy(xpath = "//label[contains(text(),'Items')]")
    WebElement itemTab;

    @FindBy(id = "Yes")
    WebElement yesButton;

    @FindBy(name = "mainPrice")
    WebElement price;
    @FindBy(xpath = "//input[@value='Save & Exit']")
    WebElement saveBtn;


    @FindBy(xpath = "//tbody/tr[7]/td[5]")
    WebElement catPrice;

    public static final String priceNewValue = "22";
    public String changePrice() throws InterruptedException {


Thread.sleep(10000);
            //  Thread.sleep(1000);
         //   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='catalog-icon']")));
            catalogMenu.click();
          //  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[contains(text(),'Items')]")));
       Thread.sleep(10000);

            itemTab.click();/*Loop until to find Backpack Burgundy category
             * click on Edit btn*/


            List<WebElement> article = driver.findElements(By.xpath("//h2[contains(text(),'Backpack Burgundy')]"));
            for (WebElement product : article) {
                // locate promotional element
            //    Log.info(".............Click on edit button ..............");
                WebElement editBtn = product.findElement(By.xpath("//tbody/tr[7]/td[6]/div[1]/a[1]"));
                if (editBtn.isDisplayed()) {
                    // locate buy now button
                    editBtn.click();

                    break;
                }
            }


            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", yesButton);
            price.clear();
            price.sendKeys(priceNewValue);

          saveBtn.click();
            itemTab.click();

            System.out.println("Price value in grid table is :" + catPrice.getText());




        return catPrice.getText();
    }
}

package org.example.pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(String productName, String productDescription, double productPrice) {
        // Add product with provided data
        driver.findElement(By.id("productName")).sendKeys(productName);
        driver.findElement(By.id("productDescription")).sendKeys(productDescription);
        driver.findElement(By.id("productPrice")).sendKeys(String.valueOf(productPrice));
        driver.findElement(By.id("addProductButton")).click();
    }
}

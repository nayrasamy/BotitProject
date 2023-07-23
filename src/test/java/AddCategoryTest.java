import org.example.pagess.CategoryPage;
import org.example.pagess.ExcelUtils;
import org.example.pagess.LginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddCategoryTest {
    private WebDriver driver;

    @Test(dataProvider = "productData")
    public void testAddProduct(String productName, String productDescription, double productPrice) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://example.com");

        LginPage loginPage = new LginPage(driver);
//        loginPage.login("username", "password");

        driver.get("http://transmission-dev.azurewebsites.net/login");


//        // Perform login
//        loginPage.setUsername("testbotitb2@dist.com");
//        loginPage.setPassword("123456");
//        loginPage.clickLoginButton();
        Thread.sleep(1000);

        CategoryPage productPage = new CategoryPage(driver);
        productPage.addProduct(productName, productDescription, productPrice);

        // Perform assertions or validations after adding the product

        driver.quit();
    }

    @DataProvider(name = "productData")
    public Object[][] provideProductData() throws IOException {
        return ExcelUtils.getProductData();
    }
}


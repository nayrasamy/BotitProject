import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTest {
    public static void main(String[] args) {
        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
        WebDriverWait wait;

        // Navigate to the login page
        driver.get("http://transmission-dev.azurewebsites.net/login");

        // Find username and password fields
        WebElement usernameField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the credentials
        usernameField.sendKeys("testbotitb2@dist.com");
        passwordField.sendKeys("123456");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-input newd']"));
        loginButton.click();

        // Perform assertions or further actions after login
        // ...

        // Wait until the logo element is visible
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
   WebElement logoElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.logo")));

        String expectedUrl = "http://transmission-dev.azurewebsites.net/home";
        String expectedTitle = "Botit";

        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        // Assert the URL and title after successful login
        Assert.assertEquals(actualUrl, expectedUrl, "Login unsuccessful - URL mismatch.");
        Assert.assertEquals(actualTitle, expectedTitle, "Login unsuccessful - Title mismatch.");

        // Close the browser
        driver.quit();
    }


//    @DataProvider(name = "loginData")
//    public Object[][] provideProductData() throws IOException {
//        String excelFile = "path/to/product_data.xlsx";
//        FileInputStream fis = new FileInputStream(excelFile);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        int numberOfRows = sheet.getLastRowNum() + 1;
//        int numberOfColumns = sheet.getRow(0).getLastCellNum();
//
//        Object[][] data = new Object[numberOfRows - 1][numberOfColumns];
//        for (int i = 1; i < numberOfRows; i++) {
//            Row row = sheet.getRow(i);
//            for (int j = 0; j < numberOfColumns; j++) {
//                Cell cell = row.getCell(j);
//                data[i - 1][j] = getCellValue(cell);
//            }
//        }
//
//        workbook.close();
//        fis.close();
//
//        return data;
//    }
//
//    private Object getCellValue(Cell cell) {
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return cell.getNumericCellValue();
//            case BOOLEAN:
//                return cell.getBooleanCellValue();
//            default:
//                return null;
//        }
//    }
}


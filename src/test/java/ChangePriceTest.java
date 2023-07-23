import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pagess.ChangePricePage;
import org.example.pagess.LginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChangePriceTest {
    private WebDriver driver;
    private LginPage loginPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://transmission-dev.azurewebsites.net/login");


    }

    @Test (priority = 0)
    public void loginTest() throws InterruptedException {
//        driver.get("https://example.com/login");
        loginPage = new LginPage(driver);
        loginPage.Login("testbotitb2@dist.com" , "123456");
        Thread.sleep(1000);
        // Add assertions or further actions after login
    }


//    @Test  (priority = 1)
//    public void ChangePrice() throws InterruptedException {
//        ChangePricePage changePrice = new ChangePricePage(driver);
//
//
//        String actualResults = changePrice.changePrice();
//        System.out.println("New Price Value is : " + actualResults);
////        Assert.assertEquals(actualResults, changePrice.);
//        //  actualResults = branchPage.clickSendButton();
//        Assert.assertEquals(actualResults,ChangePricePage.priceNewValue+"EGP");
//
//
//    }


    @Test  (priority = 2)
    public void loginTest2() {
        System.out.println("1");
    }

    @Test  (priority = 1)
    public void loginTest3() {
        System.out.println("3");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}


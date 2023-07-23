import org.example.pagess.LginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTestPOM extends TestBase{

    private WebDriver driver;
    LginPage loginPage;
    @Test
    public void loginTest() {
//        driver.get("https://example.com/login");

          loginPage = new LginPage(driver);

        loginPage.Login("eser" ,"arr");



        // Add assertions or further actions after login
    }

}

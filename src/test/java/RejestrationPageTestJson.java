import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pagess.RegsterationPageJson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class RejestrationPageTestJson {
    private WebDriver driver;
    private RegsterationPageJson registrationPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://transmission-dev.azurewebsites.net/login");
        registrationPage = new RegsterationPageJson(driver);
    }

    @Test
    public void testRegistrationFromJson() throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject registrationData = (JSONObject) jsonParser.parse(new FileReader("src/test/resources/LoginData.json"));


        String email = (String) registrationData.get("email");
        String password = (String) registrationData.get("password");

        registrationPage.Login(email, password);
//        registrationPage.fillRegistrationForm(firstName, lastName, email, password, phoneNumber);
//        registrationPage.clickSubmitButton();

        // Add assertions to verify successful registration or any other relevant checks
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



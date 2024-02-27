package anhtester.testcase;

import anhtester.common.ValidateHelper;
import anhtester.pages.HomePage;
import anhtester.pages.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private HomePage homePage;

    private By loginSubmitBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]");

    @Test
    public void SignInTAA() throws Exception {

        WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    //==========quan trong============
    validateHelper = new ValidateHelper(driver);
    //==========quan trong============
    homePage = new HomePage(driver);

    driver.get("http://127.0.0.1:3000/");
    validateHelper.waitForPageLoaded();
    homePage.goToSignInPopup();
    homePage.SignIn("0933863327","Xuannhi03!");
    }
}

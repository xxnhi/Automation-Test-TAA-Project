package anhtester.testcase;

import anhtester.common.ValidateHelper;
import anhtester.pages.AccountPage;
import anhtester.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private AccountPage accountPage;
    private HomePage homePage;
    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //==========quan trong============
        validateHelper = new ValidateHelper(driver);
        //==========quan trong============
        accountPage = new AccountPage(driver);
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 1)
    public void ChangePassword() throws Exception {
        homePage.goToAccountPage();
        accountPage.ChangePassword("","","");

    }
}

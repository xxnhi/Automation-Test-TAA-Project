package anhtester.testcase;

import anhtester.base.TestListener;
import anhtester.common.ultilities.Log;
import anhtester.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class LoginTest {

    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void addLoginLogIn(ITestResult result) throws InterruptedException{
        Log.info("Chạy test case: " +result.getName());
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 1)
    public void LoginFailWithPhoneAndPasswordNull() throws InterruptedException {
        loginPage.LoginFailWithPhoneAndPasswordNull();
    }

    @Test(priority = 2)
    public void LoginFailWithPhoneNull() throws InterruptedException {
        loginPage.LoginFailWithPhoneNull("Xuannhi03!");
    }

    @Test(priority = 3)
    public void LoginFailWithFailPhone() throws InterruptedException {
        loginPage.LoginFailWithFailPhone("0","Xuannhi03!");
    }

    @Test(priority = 4)
    public void LoginFailWithIncorrectPassword() throws InterruptedException {
        loginPage.LoginFailWithIncorrectPassword("0933863327","123456");
    }

    @Test(priority = 5)
    public void LoginSuccess() throws InterruptedException {
        loginPage.LoginSuccess("0933863327","Xuannhi03!");
    }
}

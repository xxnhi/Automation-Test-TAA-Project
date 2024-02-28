package anhtester.testcase;

import anhtester.base.BaseSetup;
import anhtester.common.ValidateHelper;
import anhtester.pages.HomePage;
import anhtester.pages.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private HomePage homePage;

    private By loginSubmitBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]");

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //==========quan trong============
        validateHelper = new ValidateHelper(driver);
        //==========quan trong============
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test(priority = 2)
    public void SignInTAA() throws Exception {

    driver.get("http://127.0.0.1:3000/");
    validateHelper.waitForPageLoaded();
    homePage.goToSignInPopup();
    //data 1
//    homePage.SignIn("","","Vui lòng nhập tất cả các trường");
//    //data 2
//    homePage.SignIn("","Abcd@123","Vui lòng nhập tất cả các trường");
//    //data 3
//    homePage.SignIn("0","Abcd@123","Số điện thoại chưa được đăng ký");
    //data 4
//        homePage.SignIn("0933863327","123456","Mật khẩu không chính xác");
    // data 5
    homePage.SignIn("0933863327","Xuannhi03!", "Đăng nhập thành công");

    }
}

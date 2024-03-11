package anhtester.testcase;

import anhtester.base.TestListener;
import anhtester.common.helpers.ValidateHelper;
import anhtester.pages.AccountPage;
import anhtester.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)

public class AccountTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private AccountPage accountPage;
    private HomePage homePage;

    private HomeTest homeTest;
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


    @Test (priority = 6)
    public void ProductReview() throws Exception {
        accountPage.ProductReview();
    }

    @Test (priority = 5)
    public void ViewFavoriteProduct(){
        accountPage.ViewFavoriteProduct();
    }


    @Test (priority = 3)
    public void ViewOrderHistory(){
        homePage.goToOrderPage();
        accountPage.ViewOrderHistory();
    }
    @Test(priority = 4)
    public void ChangePassword() throws Exception {
        homePage.goToAccountPage();
        accountPage.goToChangePasswordPopup();
        accountPage.ChangePassword("","","","Vui lòng nhập mật khẩu cũ ở đây");
//        accountPage.ChangePassword("xuannhi","Xuannhi27","Xuannhi27");
//        accountPage.ChangePassword("Abcd@123","Xuannhi","Xuannhi27");
//        accountPage.ChangePassword("Abcd@123","Abcd@123","Abcd@123");
//        accountPage.ChangePassword("Abcd@123","Xuannhi27","Xuannhi27");
    }
}

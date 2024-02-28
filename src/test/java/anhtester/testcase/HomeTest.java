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

    @Test (priority = 1)
    public void SearchProduct() throws Exception {
        driver.get("http://127.0.0.1:3000/");
        homePage.SearchProduct("Vòng tay", "Vòng tay thời tiết - mây và cầu vồng");
        homePage.SearchProduct("Vòng cổ","Vòng cổ choker đính ngọc trai sành điệu");
        homePage.SearchProduct("Túi","Túi Đeo Vai Nữ");
    }

    @Test(priority = 4)
    public void ViewProduct() throws Exception {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToProductPage();
        homePage.ViewProduct();
    }

    @Test(priority = 3)
    public void Register() throws Exception {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 1
        homePage.Register("","","","","","Vui lòng nhập tất cả các trường");
        //data 2
        homePage.Register("","0933863327","xuannhi@gmail.com","Abcd@123","Abcd@123","Vui lòng nhập tất cả các trường");
        //data 3
        homePage.Register("Xuan Nhi","","xuannhi@gmail.com","Abcd@123","Abcd@123","Vui lòng nhập tất cả các trường");
        //data 4
        homePage.Register("Xuan Nhi","0933863327","","Abcd@123","Abcd@123","Vui lòng nhập tất cả các trường");
        //data 5
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","","Abcd@123","Vui lòng nhập tất cả các trường");
        //data 6
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","Abcd@123","","Vui lòng nhập tất cả các trường");
        //data 7
        homePage.Register("Xuan Nhi","0933863327","xuannhi","Abcd@123","Abcd@123","Email không hợp lệ");
        //data 8
        homePage.Register("Xuan Nhi","0","xuannhi@gmail.com","Abcd@123","Abcd@123","Số điện thoại không hợp lệ");
        //data 9
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","123","123","Mật khẩu phải có ít nhất 8 ký tự, bao gồm cả chữ và số, không có dấu cách và ký tự đặc biệt");
        //data 10
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","123","Abcd@12345","Mật khẩu và Xác nhận mật khẩu phải giống nhau");
        //data 11
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","Abcd@123","Abcd@12345","Mật khẩu và Xác nhận mật khẩu phải giống nhau");
        //data 12
        homePage.Register("Xuan Nhi","0933863337","xini@gmail.com","Abcd@123","Abcd@123","Đăng ký thành công. Vui lòng đăng nhập");
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

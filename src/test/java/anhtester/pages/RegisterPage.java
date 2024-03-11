package anhtester.pages;

import anhtester.common.helpers.ValidateHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage  {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private WebDriverWait wait;
    private HomePage homePage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        validateHelper = new ValidateHelper(driver);
        homePage = new HomePage(driver);
    }

    public void RegisterFailWithNamePhoneEmailPassRepassNull() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 1
        homePage.Register("","","","","","Vui lòng nhập tất cả các trường");
    }

    public void RegisterFailWithFullNameNull() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 2
        homePage.Register("","0933863327","xuannhi@gmail.com","Abcd@123","Abcd@123","Vui lòng nhập tất cả các trường");
    }

    public void RegisterFailWithPhoneNull() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 3
        homePage.Register("Xuan Nhi","","xuannhi@gmail.com","Abcd@123","Abcd@123","Vui lòng nhập tất cả các trường");
    }

    public void RegisterFailWithEmailNull() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 4
        homePage.Register("Xuan Nhi","0933863327","","Abcd@123","Abcd@123","Vui lòng nhập tất cả các trường");
    }

    public void RegisterFailWithPassNull() throws InterruptedException{
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 5
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","","Abcd@123","Vui lòng nhập tất cả các trường");
    }

    public void RegisterFailWithRepassNull() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 6
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","Abcd@123","","Vui lòng nhập tất cả các trường");
    }

    public void RegisterFailWithInvalidEmail() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 7
        homePage.Register("Xuan Nhi","0933863327","xuannhi","Abcd@123","Abcd@123","Email không hợp lệ");
    }

    public void RegisterFailWithInvalidPhone() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 8
        homePage.Register("Xuan Nhi","0","xuannhi@gmail.com","Abcd@123","Abcd@123","Số điện thoại không hợp lệ");
    }

    public void RegisterFailWithInvalidPass() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 9
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","123","123","Mật khẩu phải có ít nhất 8 ký tự, bao gồm cả chữ và số, không có dấu cách và ký tự đặc biệt");
    }

    public void RegisterFailWithPassDifferRepass1() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 10
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","123","Abcd@12345","Mật khẩu và Xác nhận mật khẩu phải giống nhau");

    }

    public void RegisterFailWithPassDifferRepass2() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 11
        homePage.Register("Xuan Nhi","0933863327","xuannhi@gmail.com","Abcd@123","Abcd@12345","Mật khẩu và Xác nhận mật khẩu phải giống nhau");
    }

    public void RegisterSuccess() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToRegisterPopup();
        //data 12
        homePage.Register("Xuan Nhi","0933863347","xini27@gmail.com","Abcd@123","Abcd@123","Số điện thoại hoặc email đã tồn tại");
//        homePage.Register("Xuan Nhi","0933863557","xinyni27@gmail.com","Abcd@1234","Abcd@1234","Đăng ký thành công. Vui lòng đăng nhập");

    }






}

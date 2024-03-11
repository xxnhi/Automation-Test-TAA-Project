package anhtester.pages;

import anhtester.common.helpers.ValidateHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
        private WebDriver driver;
        private ValidateHelper validateHelper;
        private WebDriverWait wait;
        private HomePage homePage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        validateHelper = new ValidateHelper(driver);
        homePage = new HomePage(driver);
    }

    public void LoginFailWithPhoneAndPasswordNull() throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToSignInPopup();
        homePage.SignIn("","","Vui lòng nhập tất cả các trường");
    }

    public void LoginFailWithPhoneNull(String pass) throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToSignInPopup();
        homePage.SignIn("",pass,"Vui lòng nhập tất cả các trường");

    }

    public void LoginFailWithFailPhone(String phone, String pass) throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToSignInPopup();
        homePage.SignIn(phone,pass,"Số điện thoại chưa được đăng ký");
    }

    public void LoginFailWithIncorrectPassword(String phone, String pass) throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToSignInPopup();
        homePage.SignIn(phone,pass,"Mật khẩu không chính xác");
    }

    public void LoginSuccess(String phone, String pass) throws InterruptedException {
        driver.get("http://127.0.0.1:3000/");
        validateHelper.waitForPageLoaded();
        homePage.goToSignInPopup();
        homePage.SignIn("0933863327","Xuannhi03!","Mật khẩu không chính xác");
    }


}

package anhtester.pages;

import anhtester.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Instant;

public class HomePage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private WebDriverWait wait;
//======== dang nhap ===============
    private By loginBtn = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/button[1]/span[1]");

    private By registerBtn = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/button[2]/span[1]");
    private By phoneInput = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
    private By passwordInput = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/span[1]/input[1]");

    private By loginSubmitBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]");

    private By loginImg = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/img[1]");
//====================== dang ky =================

    private By textReg = By.xpath("//h1[contains(text(),'Đăng ký')]");
    private By regBtn = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/button[2]/span[1]");
    private By regFullNameInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]");
    private By regPhoneInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]");
    private By regEmailInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/input[1]");
    private By regPasswordInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/span[1]/input[1]");
    private By regRepasswordInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[5]/div[1]/span[1]/input[1]");
    private By checkLabel = By.xpath("//body/div[@id='main']/div[@id='modal--register']/div[1]/form[1]/div[6]/div[1]/span[1]/label[1]");
    private By regSubmitBtn= By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/button[1]/span[1]");



    public HomePage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void goToRegisterPopup(){
        validateHelper.waitForPageLoaded();
        validateHelper.clickElement(regBtn);
    }

    public void Register(String fullname, String phone, String email, String pass, String repass, String alertNoti){
        validateHelper.waitForPageLoaded();
        Assert.assertTrue(validateHelper.verifyElementText(textReg,"Đăng ký"),"Không phải popup Đăng ký");
        validateHelper.setText(regFullNameInput, fullname);
        validateHelper.setText(regPhoneInput, phone);
        validateHelper.setText(regEmailInput, email);
        validateHelper.setText(regPasswordInput, pass);
        validateHelper.setText(regRepasswordInput, repass);
        validateHelper.clickElement(checkLabel);
        validateHelper.clickElement(regSubmitBtn);
        validateHelper.isAlertTitleMatching(alertNoti);

    }

    public void goToSignInPopup(){
        validateHelper.waitForPageLoaded();
        validateHelper.clickElement(loginBtn);
    }

    public void SignIn (String phone, String password, String alertNoti){
        validateHelper.waitForPageLoaded();
        Assert.assertTrue(validateHelper.verifyElementText(loginSubmitBtn,"Đăng nhập"),"Không phải popup Đăng nhập");
        validateHelper.setText(phoneInput, phone);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(loginSubmitBtn);
        validateHelper.isAlertTitleMatching(alertNoti);
    }

}

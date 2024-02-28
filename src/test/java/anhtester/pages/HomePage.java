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

    private By loginBtn = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/button[1]/span[1]");

    private By registerBtn = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/button[2]/span[1]");
    private By phoneInput = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
    private By passwordInput = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/span[1]/input[1]");

    private By loginSubmitBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]");

    private By loginImg = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/img[1]");

    public HomePage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
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

package anhtester.pages;

import anhtester.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
//============ Thanh menu ==============
    private By productMenu = By.xpath("/html[1]/body[1]/div[1]/header[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]");
    private By articleMenu = By.xpath("/html[1]/body[1]/div[1]/header[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]");
    private By aboutUsMenu = By.xpath("/html[1]/body[1]/div[1]/header[1]/nav[1]/div[1]/ul[1]/li[4]/a[1]");

    private By avatarImg = By.xpath("//header/div[1]/div[1]/div[1]/div[1]");
    private By profileOptions = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");

    private By logOutOptions = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");

    private By searchInput = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/form[1]/span[1]/input[1]");
    private By searchBtn = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/form[1]/span[1]/button[1]/span[1]");

    private By acceptLogOutBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]/span[1]");

//============ Trang san pham ======================
    private By textOneProduct = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/main[1]/div[1]/div[1]/div[2]/h3[1]/a[1]");

    private By textTitleViewDetailProduct = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[2]/div[1]/p[1]");

    private By trangSucLeftMenu = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/aside[1]/ul[1]/li[2]/span[1]");
    private By vongTayLeftMenu = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/aside[1]/ul[1]/li[2]/ul[1]/li[2]/span[1]");
    private By nhanLeftMenu = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/aside[1]/ul[1]/li[2]/ul[1]/li[4]/span[1]");

    private By phuKienTocLeftMenu = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/aside[1]/ul[1]/li[3]/span[1]");
    private By tramCaiLeftMenu = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/aside[1]/ul[1]/li[3]/ul[1]/li[4]/span[1]");



//============ Trang tin tuc =======================

    private By article1Text = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]");
    private By article2Text = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/div[1]/article[2]/div[1]/div[1]/a[1]");
    private By article3Text = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/div[1]/article[3]/div[1]/div[1]/a[1]");

//=========== Trang ca nhan ========================
    public HomePage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void LogOut(){
        validateHelper.clickElement(acceptLogOutBtn);
    }

    public void goToLogOutPopup(){
        Actions actions = new Actions(driver);
        WebElement avatarImgElement = driver.findElement(avatarImg);
        // Hover vào phần tử
        actions.moveToElement(avatarImgElement).perform();
        validateHelper.clickElement(logOutOptions);
    }


    public void goToAccountPage(){
        Actions actions = new Actions(driver);
        WebElement avatarImgElement = driver.findElement(avatarImg);
        // Hover vào phần tử
        actions.moveToElement(avatarImgElement).perform();
//        validateHelper.clickElement(avatarImg);
        validateHelper.clickElement(profileOptions);
    }

    public void FilterProduct(){
        // loc sp "Vong tay"
        validateHelper.clickElement(trangSucLeftMenu);
        validateHelper.clickElement(vongTayLeftMenu);
        //loc sp "Nhan"
        validateHelper.clickElement(nhanLeftMenu);
        //loc sp "Tram cai
        validateHelper.clickElement(phuKienTocLeftMenu);
        validateHelper.clickElement(tramCaiLeftMenu);
    }

    public void goToArticlePage(){
        validateHelper.clickElement(articleMenu);
    }

    public void ViewProductDetail(By productFrame, By viewQuickBtn, By viewDetailBtn) throws InterruptedException {
        WebElement viewQuickBtmvcBtnElement = driver.findElement(productFrame);
        Actions actions = new Actions(driver);
        // Hover vào phần tử
        actions.moveToElement(viewQuickBtmvcBtnElement).perform();
        Thread.sleep(2000);
        validateHelper.clickElement(viewQuickBtn);
        Thread.sleep(2000);
        validateHelper.clickElement(viewDetailBtn);
        Thread.sleep(2000);
    }

    public void SearchProduct(String product, String productOneText){
        validateHelper.setText(searchInput, product);
        validateHelper.clickElement(searchBtn);
        validateHelper.verifyElementText(textOneProduct, productOneText);

    }

    public void goToProductPage(){
        validateHelper.clickElement(productMenu);
    }

    public void ScrollToEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Lấy chiều cao của trang
        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");

        // Số lần cuộn tối đa (tùy chọn)
        int maxScrolls = 10;

        // Chiều cao cần cuộn mỗi lần
        int scrollHeight = pageHeight.intValue() / maxScrolls;

        // Cuộn từ từ
        for (int i = 0; i < maxScrolls; i++) {
            // Cuộn đến vị trí mới
            js.executeScript("window.scrollBy(0, " + scrollHeight + ")");

            // Tạm dừng một chút để có hiệu ứng cuộn
            try {
                Thread.sleep(500); // Đợi 500ms trước khi cuộn tiếp
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    public void SignIn (String phone, String password, String alertNoti) throws InterruptedException {
        validateHelper.waitForPageLoaded();
        Assert.assertTrue(validateHelper.verifyElementText(loginSubmitBtn,"Đăng nhập"),"Không phải popup Đăng nhập");
        validateHelper.setText(phoneInput, phone);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(loginSubmitBtn);
        Thread.sleep(5000);
        validateHelper.isAlertTitleMatching(alertNoti);
    }

}

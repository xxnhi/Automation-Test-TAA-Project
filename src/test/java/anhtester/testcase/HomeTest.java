package anhtester.testcase;

import anhtester.common.ValidateHelper;
import anhtester.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private HomePage homePage;
    private WebDriverWait wait;

//    private By loginSubmitBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/button[1]/span[1]");

    //============= Trang san pham===========================
    private By productFrameBtmvc = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/main[1]/div[1]/div[5]");
    private By productFrameVtnsmn = By.xpath("//html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[4]");
    private By productFrameVtttmvcv = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[3]");

    private By productFrameVcmcnmdt = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[2]");
    private By viewQuickBtmvcBtn = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/main[1]/div[1]/div[5]/div[3]/div[1]");

    private By viewQuickVtnsmn = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[4]/div[3]/div[1]");
    private By viewQuickVtttmvcv = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[3]/div[3]/div[1]");

    private By viewQuickVcmcnmdt = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[2]/div[3]/div[1]");

    private By viewDetailBtmvcBtn = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/main[1]/div[1]/div[5]/div[4]/div[1]/div[2]/div[5]/a[1]/span[1]");
    private By viewDetailVtnsmnBtn = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/main[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[5]/a[1]/span[1]");
    private By viewDetailVtttmvcvBtn = By.xpath("/html[1]/body[1]/div[1]/div[7]/div[1]/main[1]/div[1]/div[3]/div[4]/div[1]/div[2]/div[5]/a[1]/span[1]");

    private By viewDetailVcmcnmdt = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[2]/div[4]/div[1]/div[2]/div[5]/a[1]");
    private By viewDetailVtttmvcv = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[3]/div[4]/div[1]/div[2]/div[5]/a[1]/span[1]");

    private By addCartBtnVcmcnmdt = By.xpath("//body/div[@id='main']/div[3]/div[1]/main[1]/div[1]/div[2]/div[4]/div[1]/div[2]/div[5]/button[1]");

    private By addCartBtnVtttmvcv = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[3]/div[4]/div[1]/div[2]/div[5]/button[1]");

    private By addCartBtnVtnsmn = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[5]/button[1]");


    private By viewQuickQuitBtnVcmcnmdt = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[2]/div[4]/div[1]/button[1]");

    private By viewQuickQuitBtnVtttmvcv = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[3]/div[4]/div[1]/button[1]");

    private By viewQuickQuitBtnVtnsmn = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/main[1]/div[1]/div[4]/div[4]/div[1]/button[1]");


    //============ Trang tin tuc =======================
    private By pictureArticle = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/img[1]");

    private By article1Text = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]");
    private By article2Text = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/div[1]/article[2]/div[1]/div[1]/a[1]");
    private By article3Text = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/div[1]/article[3]/div[1]/div[1]/a[1]");

    // =============== Trang chi tiet sp =================
    private By addCartInDetail = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[2]/div[8]/button[1]");

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //==========quan trong============
        validateHelper = new ValidateHelper(driver);
        //==========quan trong============
//        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test (priority = 15)
    public void OrderProduct() throws Exception {
        homePage.OrderProduct();
    }
    @Test (priority = 14)
    public void DeleteProductInCart() throws Exception {
    homePage.DeleteProductInCart("Delete success");
    }
    @Test (priority = 13)
    public void IncreaseOrDecreaseProductInCart(){
        homePage.IncreaseOrDecreaseProductInCart();
    }

    @Test (priority = 12)
    public void ViewCartPage() throws InterruptedException {
        homePage.goToCartPage();
    }

    @Test (priority = 2)
    public void BuyQuickProducts() throws Exception {
        homePage.goToProductPage();
        homePage.BuyQuickProduct(productFrameVcmcnmdt);
    }

    @Test(priority = 11)
    public void AddProductToCart() throws Exception {
        /* bị lỗi không nhấn ở ngoài được
        homePage.goToProductPage();
        homePage.ViewQuickDetail(productFrameVcmcnmdt,viewQuickVcmcnmdt);
        homePage.AddProductToCart(addCartBtnVcmcnmdt, viewQuickQuitBtnVcmcnmdt);
        homePage.ViewQuickDetail(productFrameVtttmvcv,viewQuickVtttmvcv);
        homePage.AddProductToCart(addCartBtnVtttmvcv, viewQuickQuitBtnVtttmvcv);
        */
        homePage.goToProductPage();
        homePage.ViewProductDetail(productFrameVcmcnmdt, viewQuickVcmcnmdt, viewDetailVcmcnmdt);
        validateHelper.clickElement(addCartInDetail);
        Thread.sleep(3000);
        homePage.goToProductPage();
        homePage.ViewProductDetail(productFrameVtttmvcv, viewQuickVtttmvcv, viewDetailVtttmvcv);
        validateHelper.clickElement(addCartInDetail);
    }

    @Test (priority = 10)
    public void LogOut() throws Exception {
        homePage.goToLogOutPopup();
        homePage.LogOut();
    }

    @Test (priority = 9)
    public void FilterProduct() {
        driver.get("http://127.0.0.1:3000/");
        homePage.goToProductPage();
        homePage.FilterProduct();

    }
    @Test (priority = 8)
    public void ViewArticle() throws Exception {
        driver.get("http://127.0.0.1:3000/");
        homePage.goToArticlePage();
        validateHelper.scrollToElement(pictureArticle);
        validateHelper.clickElement(article1Text);
        homePage.ScrollToEnd();

        homePage.goToArticlePage();
        validateHelper.scrollToElement(pictureArticle);
        validateHelper.clickElement(article2Text);
        homePage.ScrollToEnd();


        homePage.goToArticlePage();
        validateHelper.scrollToElement(pictureArticle);
        validateHelper.clickElement(article3Text);
        homePage.ScrollToEnd();
        
    }

    @Test (priority = 7)
    public void ViewArticleList()   throws Exception {
        driver.get("http://127.0.0.1:3000/");
        homePage.goToArticlePage();
        homePage.ScrollToEnd();
    }

    @Test (priority = 6)
    public void ViewProductDetail() throws Exception {

        driver.get("http://127.0.0.1:3000/");
        homePage.goToProductPage();
        homePage.ViewProductDetail(productFrameBtmvc, viewQuickBtmvcBtn, viewDetailBtmvcBtn);
        homePage.goToProductPage();
        homePage.ViewProductDetail(productFrameVtnsmn, viewQuickVtnsmn, viewDetailVtnsmnBtn);
        homePage.goToProductPage();
        homePage.ViewProductDetail(productFrameVtttmvcv, viewQuickVtttmvcv, viewDetailVtttmvcvBtn);
    }

    @Test (priority = 5)
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
        homePage.ScrollToEnd();
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
    homePage.SignIn("0933863327","Xuannhi03!", "Vui lòng điền vào trường này.");

    }
}

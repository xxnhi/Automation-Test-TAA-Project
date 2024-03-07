package anhtester.testcase;

import anhtester.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {

    private RegisterPage registerPage;
    private WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 1)
    public void RegisterFailWithNamePhoneEmailPassRepassNull(){
        registerPage.RegisterFailWithNamePhoneEmailPassRepassNull();
    }

    @Test(priority = 2)
    public void RegisterFailWithFullNameNull(){
        registerPage.RegisterFailWithFullNameNull();
    }

    @Test(priority = 3)
    public void RegisterFailWithPhoneNull(){
        registerPage.RegisterFailWithPhoneNull();
    }

    @Test(priority = 4)
    public void RegisterFailWithEmailNull(){
        registerPage.RegisterFailWithEmailNull();
    }

    @Test(priority = 5)
    public void RegisterFailWithPassNull(){
        registerPage.RegisterFailWithPassNull();
    }


    @Test(priority = 6)
    public void RegisterFailWithRepassNull(){
        registerPage.RegisterFailWithRepassNull();
    }

    @Test(priority = 7)
    public void RegisterFailWithInvalidEmail(){
        registerPage.RegisterFailWithInvalidEmail();
    }

    @Test(priority = 8)
    public void RegisterFailWithInvalidPhone(){
        registerPage.RegisterFailWithInvalidPhone();
    }

    @Test(priority = 9)
    public void RegisterFailWithInvalidPass(){
        registerPage.RegisterFailWithInvalidPass();
    }

    @Test(priority = 10)
    public void RegisterFailWithPassDifferRepass1(){
        registerPage.RegisterFailWithPassDifferRepass1();
    }

    @Test(priority = 11)
    public void RegisterFailWithPassDifferRepass2(){
        registerPage.RegisterFailWithPassDifferRepass2();
    }

    @Test(priority = 12)
    public void RegisterSuccess(){
        registerPage.RegisterSuccess();
    }
    
}
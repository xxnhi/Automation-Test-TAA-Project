package anhtester.pages;

import anhtester.common.ValidateHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private WebDriverWait wait;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void ChangePassword(){
        
    }
}

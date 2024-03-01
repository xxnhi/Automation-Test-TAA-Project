package anhtester.pages;

import anhtester.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private WebDriverWait wait;

    private By changePassBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[1]/article[3]/button[1]/span[1]");

    private By oldPassInput = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[1]/div[1]/div[1]/span[1]/input[1]");

    private By newPassInput = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[1]/div[2]/div[1]/span[1]/input[1]");
    private By confirmPassInput = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[1]/div[3]/div[1]/span[1]/input[1]");
    private By confirmBtn = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[2]/button[1]");


    public AccountPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void goToChangePasswordPopup(){
        validateHelper.scrollToElement(changePassBtn);
        validateHelper.clickElement(changePassBtn);
    }

    public void ChangePassword(String oldPass, String newPass, String confirmPass){
        validateHelper.waitForPageLoaded();
        validateHelper.setText(oldPassInput, oldPass);
        validateHelper.setText(newPassInput, newPass);
        validateHelper.setText(confirmPassInput, confirmPass);
        validateHelper.clickElement(confirmBtn);

    }
}

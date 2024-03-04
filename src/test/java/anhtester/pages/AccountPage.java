package anhtester.pages;

import anhtester.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private HomePage homePage;
    private WebDriverWait wait;
    private By profileTile = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[1]/article[2]/h2[1]");

    private By changePassBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[1]/article[3]/button[1]/span[1]");

    private By oldPassInput = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[1]/div[1]/div[1]/span[1]/input[1]");

    private By newPassInput = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[1]/div[2]/div[1]/span[1]/input[1]");
    private By confirmPassInput = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[1]/div[3]/div[1]/span[1]/input[1]");
    private By confirmBtn = By.xpath("/html[1]/body[1]/div[1]/div[9]/div[1]/form[1]/div[2]/button[1]");

    // ============= trang gio hang ==============
    private By minusBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[1]/span[6]/span[1]");
    private By plusBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[1]/span[6]/span[2]");
    private By numberInput = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[1]/span[6]/input[1]");
    private By priceSpan = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[1]/span[5]/span[1]");

    private By unitPriceSpan = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[1]/span[5]/span[1]");
    private By textSpan= By.xpath("//span[contains(text(),'Vòng cổ mặt cười nhiều màu dễ thương')]");
    private By totalCostSpan = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[1]/span[7]");

    private By tickBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[1]/span[1]/span[1]/label[1]/span[2]");

    private By tickAllBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[1]/span[1]/span[1]/label[1]/span[2]");

    private By total = By.xpath("//span[contains(text(),'Tổng cộng:')]");




    public AccountPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        homePage = new HomePage(driver);
    }





    public void ViewFavoriteProduct(){
        homePage.goToFavoriteProductPage();
        homePage.ScrollToEnd();
    }


    public void ViewOrderHistory(){
        homePage.ScrollToEnd();
    }

    public void goToChangePasswordPopup() throws InterruptedException {
        validateHelper.scrollToElement(profileTile);
        Thread.sleep((3000));
        validateHelper.clickElement(changePassBtn);
    }

    public boolean placeholderToPass(String textToMatch) {
        String placeholderOldPass = driver.findElement(oldPassInput).getAttribute("placeholder");
        String placeholderNewPass = driver.findElement(newPassInput).getAttribute("placeholder");
        String placeholderConPass = driver.findElement(confirmPassInput).getAttribute("placeholder");

        return placeholderOldPass.equals(textToMatch) ||
                placeholderNewPass.equals(textToMatch) ||
                placeholderConPass.equals(textToMatch);

    }

    public void ChangePassword(String oldPass, String newPass, String confirmPass, String placeholderText){
        validateHelper.waitForPageLoaded();
        validateHelper.setText(oldPassInput, oldPass);
        validateHelper.setText(newPassInput, newPass);
        validateHelper.setText(confirmPassInput, confirmPass);
        validateHelper.clickElement(confirmBtn);
        placeholderToPass(placeholderText);

    }
}

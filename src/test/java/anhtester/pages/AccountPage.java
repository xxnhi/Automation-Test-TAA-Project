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

    // ========= danh gia san pham

    private By successText = By.xpath("/html[1]/body[1]/div[1]/div[10]/div[1]/p[1]");

    private By fifthStarProductQuality = By.xpath("/html[1]/body[1]/div[1]/div[11]/div[1]/div[3]/div[1]/span[5]");

    private By fifthStarShippingService = By.xpath("/html[1]/body[1]/div[1]/div[11]/div[1]/div[4]/div[1]/span[5]");

    private By reviewInput = By.xpath("/html[1]/body[1]/div[1]/div[11]/div[1]/div[5]/div[1]/textarea[1]");

    private By doneBtn = By.xpath("/html[1]/body[1]/div[1]/div[11]/div[1]/div[7]/button[2]");

    private By reviewBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[4]/div[1]/div[1]/button[1]");

    private By scrollBeforeReviewBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/section[2]/div[3]/div[1]/div[1]/p[1]");


    public AccountPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        homePage = new HomePage(driver);
    }

    public void ProductReview() {
        goToReviewPopup();
        // test data 1
        validateHelper.clickElement(fifthStarProductQuality);
        validateHelper.clickElement(doneBtn);
        validateHelper.isAlertTitleMatching("Vui lòng nhập đánh giá sản phẩm.");
        // test data 2
        validateHelper.clickElement(fifthStarShippingService);
        validateHelper.clickElement(doneBtn);
        validateHelper.isAlertTitleMatching("Vui lòng nhập đánh giá sản phẩm.");
        // test data 3
        validateHelper.setText(reviewInput,"Sản phẩm như mong đợi");
        validateHelper.clickElement(doneBtn);
        validateHelper.verifyElementText(successText,"Bạn đã thực hiện thành công!");

    }

    public void goToReviewPopup(){
        homePage.goToOrderPage();
        validateHelper.scrollToElement(scrollBeforeReviewBtn);
        validateHelper.clickElement(reviewBtn);
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

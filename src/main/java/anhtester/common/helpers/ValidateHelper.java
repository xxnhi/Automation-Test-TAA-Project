package anhtester.common.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ValidateHelper {


    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions action;

    private Select select;


    public ValidateHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public void setText(By element, String value){
        waitForPageLoaded();
        WebElement elementWaited = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        elementWaited.click();
        elementWaited.clear();
        elementWaited.sendKeys(value);
    }

    public void clickElement(By element){
        //click vào 1 phần tử element truyền vào
        waitForPageLoaded();
        WebElement elementWaited = wait.until(ExpectedConditions.elementToBeClickable(element));
        elementWaited.click();

    }

    public void clickElementByJS(By element){
        waitForPageLoaded();
        //doi den khi element do ton tai
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        // scroll to element voi js
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
        //Click voi js
        js.executeScript("arguments[0].click();",driver.findElement(element));
    }

    public void rightClickElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.contextClick().build().perform();

    }

    //Ham handle dropdown select option
    public void selectOptionByText(By element, String text){
        //Chuyeenr tu doi tuong By sang doi tuong WebElement thi them driver.findElement
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    public void selectOptionByValue(By element, String value){
        //Chuyeenr tu doi tuong By sang doi tuong WebElement thi them driver.findElement
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
    }

    public void selectOptionByIndex(By element, int index){
        //Chuyeenr tu doi tuong By sang doi tuong WebElement thi them driver.findElement
        Select select = new Select(driver.findElement(element));
        select.selectByIndex(index);
    }

    public void verifyOptionTotal(By element, int total){
        Select select = new Select(driver.findElement(element));
        Assert.assertEquals(total, select.getOptions().size());
    }

    public boolean verifySelectedByText(By by, String Text){
        Select select = new Select(driver.findElement(by));
        System.out.println("Option selected: "+ select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText().equals(Text);
    }

    public boolean verifySelectedByValue(By by, String Text){
        Select select = new Select(driver.findElement(by));
        System.out.println("Option selected: "+ select.getFirstSelectedOption().getAttribute("value"));
        return select.getFirstSelectedOption().getAttribute("value").equals(Text);
    }

    public boolean verifySelectedByIndex(By by, int index){
        Select select = new Select(driver.findElement(by));
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Option selected: " + selectedOption.getText());
        return select.getOptions().indexOf(selectedOption)== index;
    }

    public boolean isRadioBtnSelected(By radioBtn){
        WebElement radioButton = driver.findElement(radioBtn);
        return radioButton.isSelected();
    }

    public boolean isRadioBtnEnabled(By radioBtn){
        WebElement radioButton = driver.findElement(radioBtn);
        return radioButton.isEnabled();
    }

    public boolean verifyURL(String url){
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url);
    }


    public boolean verifyElementText(By element, String text){
        return driver.findElement(element).getText().equals(text);
    }

    public String getPageTitle(){
        waitForPageLoaded();
        String title  = driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle(String title){
        System.out.println("Current URL is: " + driver.getTitle());
        System.out.println(title);

        return driver.getTitle().equals(title);
    }

    public boolean verifyElementExist(By element){
        //Tao list luu tat ca doi tuong cua WebElement
        List<WebElement> listElement = driver.findElements(element);

        int total = listElement.size();
        if (total>0){
            return true;
        }
        return false;
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        } catch(NoAlertPresentException e){
            return false;
        }
    }

    public boolean isAlertTitleMatching(String expectedTitle) {
        if (isAlertPresent()) {
            try {
                Alert alert = driver.switchTo().alert();
                String actualTitle = alert.getText();
                System.out.println(actualTitle);
                if(actualTitle != null && !actualTitle.isEmpty() && actualTitle.contains(expectedTitle)){
                    alert.accept(); // Đóng cửa sổ cảnh báo sau khi lấy tiêu đề
                    Thread.sleep(2000);
                    return true;
                } else {
                    System.out.print("Truong hop alert sai vs thuc te");
                    return false;
                }

            } catch (NoAlertPresentException e) {
                // Trường hợp cửa sổ cảnh báo không còn tồn tại
                System.out.print("Trường hợp cửa sổ cảnh báo không còn tồn tại");
                return false;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.print("Không có cửa sổ cảnh báo nào xuất hiện");
            return false; // Không có cửa sổ cảnh báo nào xuất hiện

        }
    }
    public void handleAlert() {
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text ne: " + alert.getText());
            alert.accept();

        }
    }


    public void scrollToElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }


    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
//            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}

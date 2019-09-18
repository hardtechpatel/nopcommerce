package nopcom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.IO;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage{

    private static IO FileUtils;

    public static void waitForElementVisible(By by, long time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public static void waitForClickable(By by, long time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitForAlertPresence(long time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public static String selectByVisibleText(By dateOfBirthDay, String s){
        DateFormat format = new SimpleDateFormat("ddMMyy");
        return format.format(new Date());

    }
    public static String randomdate() {
        DateFormat format = new SimpleDateFormat("ddMMyy");
        return format.format(new Date());
    }
    public void entertext(By by,String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clickelements(By by) {
        driver.findElement(by).click();
    }
    public String getTextFromElelements(By by) {

        return driver.findElement(by).getText();
    }
    public void clearlocator(By by){

        driver.findElement(by).clear();
    }
    public void clearlocatorandentertext(By by, String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    public void selectbyvalue(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
        select.getFirstSelectedOption();
    }
    public void selectbyvisibletext(By by, String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    public String generatemail(){

        return "testtest1" + randomdate() + "test.com";
    }
    public void dropdownprence(By by, String text){
        Select select = new Select(driver.findElement(by));
        select.getOptions();
    }
    public String getattribute(By by, String text){
        return driver.findElement(by).getAttribute(text);
    }
    public boolean isElementVisible(By by){
        return driver.findElement(by).isDisplayed();
    }
    public static Date formatDate(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth, 0, 0, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    public boolean ifwebelementisenableornot(By by) {
        return driver.findElement(by).isEnabled();
    }
    public void selectfromvisibletext(By by, String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    public static void takeSnapShot(WebDriver webDriver, String fileWithPath) throws Exception{
        TakesScreenshot scrShot = ((TakesScreenshot)webDriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
    public boolean getLocation(By by){
        Point location = driver.findElement(by).getLocation();
        return false;
    }
    public void getcssvalue(By by, String text){

        driver.findElement(by).getCssValue(text);
    }
    public void implicitwait(long time){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }
}

package nopcom;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Formatter;

public class Registration extends Utils {
    LoadProps loadProps = new LoadProps();
    private Formatter format;

    @BeforeMethod
    public void openbrowser1() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");
        //open the browser
        driver = new ChromeDriver();
        //maximise the browser window screen
        driver.manage().window().fullscreen();
        //set implicity wait for driver object
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        implicitwait(20);
        driver.get(loadProps.getproperty("URL"));
        clickelements(By.xpath("//a[@class = 'ico-register']"));
        //enter firstname
        entertext(By.id("FirstName"), loadProps.getproperty("FirstName"));
        //enter lastname
        //driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("patel");
        entertext(By.xpath("//input[@name='LastName']"), loadProps.getproperty("LastName"));
        //enter date of birth
        // Select select = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //select.selectByVisibleText("18");
        selectByVisibleText(By.name("DateOfBirthDay"),"29");
        //Enter date of month
        // Select select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        // select.selectByVisibleText("May");
        selectByVisibleText(By.name("DateOfBirthMonth"),"Augest");
        // Enter year of birth
        // Select select = new Select(driver.findElement(By.name("DateOfBirthYear")));
        // select.selectByVisibleText("1984");
        selectByVisibleText(By.name("DateOfBirthYear"),"1984");
        //enter email
        entertext(By.name("Email"), "testtest1" + randomdate() + "test.com");
        //enter password
        //driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abcd1234");
        entertext(By.xpath("//input[@id='Password']"), loadProps.getproperty("Password"));
        //enter confirm password
        //driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("abcd1234");
        entertext(By.xpath("//input[@name='ConfirmPassword']"), loadProps.getproperty("ConfirmPassword"));
        //driver.findElement(By.xpath("//input[@id='register-button']")).click();
        //clickelements(By.xpath("//input[@id='register-button']"));

    }
    @AfterMethod
    public void closebrowaer() {
        driver.quit();
    }

    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        //click on register button
        clickelements(By.xpath("//input[@id='register-button']"));
        //click on countinue
        clickelements(By.xpath("//input[@value=\"Continue\"]"));
    }

    @Test
    public void userShouldBeAbleToReferAProductToFriend() {
        clickelements(By.xpath("//input[@id='register-button']"));
        //click on continue
        clickelements(By.xpath("//input[@value=\"Continue\"]"));
        //click on macbook page
        clickelements(By.xpath("//h2//a[@href=\"/apple-macbook-pro-13-inch\"]"));
        //click on enter friend
        clickelements(By.xpath("//input[@value='Email a friend']"));
        //enter friend email
        entertext(By.xpath("//input[@id='FriendEmail']"), loadProps.getproperty("FriendEmail"));
        //enter your email
        //driver.findElement(By.xpath("//input[@id='YourEmailAddress']")).click();
        //entertext(By.xpath("//input[@id='YourEmailAddress']"));
        //clickelements(By.xpath("//input[@id='YourEmailAddress']"));
        //enter persnol massage
        entertext(By.xpath("//textarea[@placeholder='Enter personal message (optional).']"), loadProps.getproperty("Enter personal message"));
        //click on send email
        clickelements(By.xpath("//input[@value=\"Send email\"]"));
    }
        @Test
        public void userShouldBeAbleToNavigateCameraAndPhotoPage () {

            //click on register button
            clickelements(By.xpath("//input[@id='register-button']"));
            //click on continue
            clickelements(By.xpath("//input[@name='register-continue']"));
            //click on electronics
            clickelements(By.xpath("//h2/a[@title=\"Show products in category Electronics\"] "));
            //click on camera and photo button
            clickelements(By.xpath("//h2/a[@title=\"Show products in category Camera & photo\"]"));
            String ActualMassage = "Camera & photo";
            String ExpectedMassage = driver.findElement(By.xpath("//h1")).getText();
            Assert.assertEquals(ExpectedMassage, ActualMassage);
        }

    @Test
    public void userShouldBeAbleAddProductFromBookCategory() {
        //click on register button
        clickelements(By.xpath("//input[@id='register-button']"));
        //click on countinue
        clickelements(By.xpath("//input[@value=\"Continue\"]"));
        //click on books catagory
        clickelements(By.linkText("Books"));
        //add to cart
        clickelements(By.xpath("//input[contains(@onclick,'37/1/1')]"));
        //click on books catagory
        clickelements(By.linkText("Books"));
        //click on another book
        clickelements(By.xpath("//input[contains(@onclick,'38/1/1')]"));
        //click on shopping cart
        clickelements(By.xpath("//span[@class=\"cart-label\"]"));
        String ActualMassage = "Shopping cart";
        String ExpectedMassage = driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).getText();
        Assert.assertEquals(ExpectedMassage, ActualMassage);
    }
    @Test
    public void userShouldBeAbleToSelectTheJewelleryProduct() {
        //click on register button
        clickelements(By.xpath("//input[@id='register-button']"));
        //click on continue
        clickelements(By.xpath("//input[@name='register-continue']"));
        //Navigate to jewelry
        clickelements(By.linkText("Jewelry"));
        //select price limit
        clickelements(By.xpath("//a[contains(@href,\"700-3000\")]"));
        //check the Expected result
        String Expectedresult = "$700.00 - $3,000.00";
        //check the Actual result
        String Actualresult = driver.findElement(By.xpath("//span[@class='item']")).getText();
        //compare the result
        Assert.assertEquals(Actualresult, Expectedresult);
        String Productprice = driver.findElement(By.xpath("//span[@class='price actual-price']")).getText();
        String price1 = String.valueOf(Productprice.replace("$", ""));
        String price2 = String.valueOf(price1.replace(",", ""));
        double price = Double.valueOf(price2);
        //check the result
        Assert.assertTrue(price >= 700 && price <= 3000);

    }

}

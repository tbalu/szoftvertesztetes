package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("The home page is clicked")
    public void theHomePageIsClicked() {
        driver.get("https://phptravels.org/clientarea.php");
    }

    @Given("The Login button is clicked")
    public void theLoginButtonIsClicked() {
        driver.findElement(By.id("login")).click();
    }

    @Then("An {string} error is shown on login page")
    public void anMsgErrorIsShown(String msg) {
        hasMeassage(msg,"//*[@id=\"main-body\"]/div/div/div[1]/div/div[2]");
 }

    private void hasMeassage(String msg, String xPath){

        List<WebElement> elements = driver.findElements(By.xpath(xPath));
        Assert.assertNotEquals(0, elements.size());
        Assert.assertEquals(msg, elements.get(0).getText());

    }

    @Given("The {string} is filled with {string}")
    public void theFieldIsFilledWithValue(String field, String value) {

        driver.findElement(By.id(field)).sendKeys(value);
    }


    @And("Submit button is clicked")
    public void submitButtonIsClicked() {
        driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/div/div[1]/div/form/div[3]/button")).click();
    }

    @Given("Click Store menu")
    public void clickStoreMenu() {
        driver.findElement(By.xpath("//*[@id=\"Primary_Navbar-Store\"]/a")).click();
    }

    @And("Choose year {string}")
    public void chooseYearYear(String year) {
        driver.findElement(By.xpath("//*[@id=\"Primary_Navbar-Store-"+year+"\"]/a")).click();
    }

    @Then("An {string} error is shown on products page")
    public void anMsgErrorIsShownOnProductsPage(String msg) {
        hasMeassage(msg,"//*[@id=\"order-standard_cart\"]/div/div[1]/div[2]");
    }

    @And("Order Web Application")
    public void orderWebApplication() {
        driver.findElement(By.xpath("//*[@id=\"product1-order-button\"]")).click();
    }

    @Then("Total due today is {string}")
    public void totalDueTodayIsPrice(String price) {
        driver.findElement(By.xpath("//*[@id=\"order-boxes\"]/form/table/tbody/tr[4]/td[2]")).getText().equals(price);
    }

    @Given("Forgot password is clicked")
    public void navigateToForgotPassword() {
        driver.findElement(By.xpath("/html/body/section[3]/div/div/div[1]/div/div[3]/div[1]/form/div[5]/a")).click();
    }

    @Then("An {string} error is shown on forget password page")
    public void anMsgErrorIsShownOnForgetPasswordPage(String msg) {
        hasMeassage(msg,"//*[@id=\"main-body\"]/div/div/div[1]/div/div[2]/li");
    }
}



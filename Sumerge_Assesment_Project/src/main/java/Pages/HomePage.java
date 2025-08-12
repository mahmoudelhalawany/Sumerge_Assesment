package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchField = By.id(":rh:");
    By datesField = By.xpath("//button[@data-testid=\"searchbox-dates-container\"]");
    By nextButtonDatesList = By.xpath("//button[@aria-label=\"Next month\"]");
    By searchButton = By.xpath("//button[@type=\"submit\"]");
    String selectedDate = "//span[@data-date='%s']";


    public void navigateToBaseURL(String URL){
        driver.get(URL);
    }

    public WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void enterLocation (String location){
        waitForElementPresence(driver,searchField,40);
        driver.findElement(searchField).sendKeys(location);
    }

    public void clickOnCheckInAndCheckOutDatesButton (){
        driver.findElement(datesField).click();
    }

    public void clickOnSearch(){
        driver.findElement(searchButton).click();
    }

    public void clickOnNext (){
        driver.findElement(nextButtonDatesList).click();
    }

    public void selectCheckInDate (String checkIn){
        String element = String.format(selectedDate,checkIn);
        driver.findElement(By.xpath(element)).click();
    }
    public void selectCheckOutDate (String checkOut){
        String element = String.format(selectedDate,checkOut);
        driver.findElement(By.xpath(element)).click();
    }

}

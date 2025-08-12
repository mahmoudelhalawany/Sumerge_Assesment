package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage  {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }


    By tolipSearchResultName = By.partialLinkText("Tolip Hotel Alexandria");
    By loadMoreResultsButton = By.xpath("//button[@class=\"de576f5064 b46cd7aad7 d0a01e3d83 dda427e6b5 bbf83acb81 a0ddd706cc\"]");



    public void goToReservationPage(){
        driver.findElement(tolipSearchResultName).click();
    }


    public void scrollToSpecificElement(){
        for (int i=0 ; i<7 ; i++) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            boolean isTolipVisible = driver.findElements(tolipSearchResultName)
                    .stream()
                    .anyMatch(WebElement::isDisplayed);

            boolean isLoadMoreVisible = driver.findElements(loadMoreResultsButton)
                    .stream()
                    .anyMatch(WebElement::isDisplayed);
            if (!isTolipVisible){
                scrollDown();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            }

            if(isTolipVisible){
                break;
            }

            if (isLoadMoreVisible){
                driver.findElement(loadMoreResultsButton).click();
            }

        }
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }




    public void switchToTab(int tabIndex) {

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));

    }
}

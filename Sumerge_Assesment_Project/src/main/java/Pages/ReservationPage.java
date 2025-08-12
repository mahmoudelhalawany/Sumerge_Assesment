package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ReservationPage  {

    private WebDriver driver;

    public ReservationPage(WebDriver driver) {
        this.driver = driver;
    }

    By queenBedSelect = By.xpath("//input[@name=\"bedPreference_78883120\" and @value=\"2\"]");
    By bedAmountSelect = By.xpath("//select[@id=\"hprt_nos_select_78883120_386871369_0_33_0_131741\"]");
    By iWillReserveButton = By.xpath("//button[@class=\"txp-bui-main-pp bui-button bui-button--primary  hp_rt_input px--fw-cta js-reservation-button\"]");
    By reservationStartDate = By.xpath("//button[@data-testid=\"date-display-field-start\"]");
    By reservationEndDate = By.xpath("//button[@data-testid=\"date-display-field-end\"]");
    By hotelName = By.xpath("//h2[@class=\"ddb12f4f86 pp-header__title\"]");
    String bedAmount = "//option[@value='%s']";

    public void selectQueenBed (){
        driver.findElement(queenBedSelect).click();
    }



    public void selectAmountOfBeds(String numOfBeds){
        driver.findElement(bedAmountSelect).click();
        By selectedBedAmount = By.xpath(String.format(bedAmount,numOfBeds));
        driver.findElement(selectedBedAmount).click();
    }

    public void clickOnIWillReserve() {
        driver.findElement(iWillReserveButton).click();
    }

    public String getReservationStartDate (){
        return driver.findElement(reservationStartDate).getText();
    }

    public String getReservationEndDate (){
        return driver.findElement(reservationEndDate).getText();
    }

    public String getHotelName (){
        return driver.findElement(hotelName).getText();
    }

}

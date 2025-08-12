import Pages.HomePage;
import Pages.ReservationPage;
import Pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tests {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ReservationPage reservationPage;
    private String URL = "https://www.booking.com";

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        reservationPage = new ReservationPage(driver);
        searchResultPage = new SearchResultPage(driver);
        homePage.navigateToBaseURL(URL);
    }

    @Test (dataProvider = "excelData", dataProviderClass = TestData.class)
    public void test(String location, String checkInDate, String checkOutDate,
                     String hotelName, String checkInAssertion, String checkOutAssertion){
        SoftAssert softAssert = new SoftAssert();
        homePage.enterLocation(location);
        homePage.clickOnCheckInAndCheckOutDatesButton();
        homePage.clickOnNext();
        homePage.selectCheckInDate(checkInDate);
        homePage.selectCheckOutDate(checkOutDate);
        homePage.clickOnSearch();
        searchResultPage.scrollToSpecificElement();
        searchResultPage.goToReservationPage();
        searchResultPage.switchToTab(1);
        softAssert.assertTrue(reservationPage.getHotelName().contains(hotelName), "hotel name is wrong");
        softAssert.assertTrue(reservationPage.getReservationStartDate().contains(checkInAssertion),"Checkin date is wrong");
        softAssert.assertTrue(reservationPage.getReservationEndDate().contains(checkOutAssertion),"Checkout date is wrong");
        reservationPage.selectQueenBed();
        reservationPage.selectAmountOfBeds("1");
        reservationPage.clickOnIWillReserve();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

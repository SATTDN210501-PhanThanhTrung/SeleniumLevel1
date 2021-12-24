import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test(description = "User can book many tickets at a time")
    public void TC14() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        System.out.println("1.Go to RailWay web");
        homePage.open();
        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();
        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("5.Go to Book ticket Page");
        homePage.gotoBookticet();
        System.out.println("6.Select a Depart date from the list");
        System.out.println("7.Select Sài Gòn for Depart from and Đà Nẵng for Arrive at");
        System.out.println("8.Select Hard Seat for Seat type");
        System.out.println("9.Select 1 for Ticket amount");
        bookticketPage.BookTicket();
        String expectedDepartStation = bookticketPage.getTextOfDataListlDepartStation();
        String expectedArStation = bookticketPage.getTextOfDataListArrStation();
        String expectedSeatType = bookticketPage.getTextOfDataListSeatType();
        String expectedDepartDate = bookticketPage.getTextOfDataListDepartDate();
        String expectedAmout = bookticketPage.getTextOfDataListAmount();
        String expectedMsg = "Ticket Booked Successfully!";
        System.out.println("10.Click on Book ticket button");
        bookticketPage.clickBtnBookTicket();
        String actualMsg = bookticketPage.getBookSucessfullyTitle();
        String actualDepartStation = bookticketPage.getDepartStationDataOfTicket();
        String actualArStation = bookticketPage.getArrStationDataOfTicket();
        String actualSeatType = bookticketPage.getSeatTypeDataOfTicket();
        String actualDepartDate = bookticketPage.getDepartDateDataOfTicket();
        String actualAmout = bookticketPage.getAmountDataOfTicket();
        Assert.assertEquals(actualMsg, expectedMsg, "Book tickets failed");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "DepartStation is not same");
        Assert.assertEquals(actualArStation, expectedArStation, "ArriveStaion is not same");
        Assert.assertEquals(actualSeatType, expectedSeatType, "SeatType is not same");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "DepartDate is not same");
        Assert.assertEquals(actualAmout, expectedAmout, "Amount is not same");
    }
}

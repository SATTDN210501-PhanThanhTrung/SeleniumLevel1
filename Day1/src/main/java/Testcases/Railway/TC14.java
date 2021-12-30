import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

public class TC14 extends TestBase {
    @Test(description = "User can book many tickets at a time", dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void TC14(HashMap<String, String> hashMap) {
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
        bookticketPage.selectDepartDate(hashMap.get("DepartDate"));

        System.out.println("7.Select Sài Gòn for Depart from");
        bookticketPage.selectDepartFrom(hashMap.get("DepartFrom"));

        System.out.println("8. Select Đà Nẵng for Arrive at");
        bookticketPage.selectArriveAt(hashMap.get("ArriveAt"));

        System.out.println("8.Select Hard Seat for Seat type");
        bookticketPage.selectSeatType(hashMap.get("SeatType"));

        System.out.println("9.Select 1 for Ticket amount");
        bookticketPage.selectTicketAmount(hashMap.get("TicketAmount"));

        System.out.println("10.Click on Book ticket button");
        bookticketPage.clickBtnBookTicket();

        String expectedDepartStation = hashMap.get("DepartFrom");
        String expectedArStation = hashMap.get("ArriveAt");
        String expectedSeatType = hashMap.get("SeatType");
        String expectedDepartDate = hashMap.get("DepartDate");
        String expectedAmout = hashMap.get("TicketAmount");
        String expectedMsg = "Ticket Booked Successfully!";

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

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test(description = "User can book many tickets at a time", dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void TC14(String data) throws InterruptedException {
        String[] formInfor=data.split(",");
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
        bookticketPage.selectDepartDate(formInfor[0]);

        System.out.println("7.Select Depart from");
        bookticketPage.selectDepartFrom(formInfor[1]);
        Thread.sleep(1000);

        System.out.println("8. Select Arrive at");
        bookticketPage.selectArriveAt(formInfor[2]);

        System.out.println("8.Select Seat type");
        bookticketPage.selectSeatType(formInfor[3]);

        System.out.println("9.Select Ticket amount");
        bookticketPage.selectTicketAmount(formInfor[4]);

        System.out.println("10.Click on Book ticket button");
        bookticketPage.clickBtnBookTicket();

        String actualMsg = bookticketPage.getBookSucessfullyTitle();
        String expectedMsg = "Ticket Booked Successfully!";

        String actualDepartStation = bookticketPage.getDepartStationDataOfTicket();
        String expectedDepartStation = formInfor[1];

        String actualArStation = bookticketPage.getArrStationDataOfTicket();
        String expectedArStation = formInfor[2];

        String actualSeatType = bookticketPage.getSeatTypeDataOfTicket();
        String expectedSeatType = formInfor[3];

        String actualDepartDate = bookticketPage.getDepartDateDataOfTicket();
        String expectedDepartDate = formInfor[0];

        String actualAmout = bookticketPage.getAmountDataOfTicket();
        String expectedAmout = formInfor[4];

        Assert.assertEquals(actualMsg, expectedMsg, "Book tickets failed");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "DepartStation is not same");
        Assert.assertEquals(actualArStation, expectedArStation, "ArriveStaion is not same");
        Assert.assertEquals(actualSeatType, expectedSeatType, "SeatType is not same");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "DepartDate is not same");
        Assert.assertEquals(actualAmout, expectedAmout, "Amount is not same");
    }
}

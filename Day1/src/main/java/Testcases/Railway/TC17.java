import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

public class TC17 extends TestBase{
    @Test(description = "User can't book more than 10 tickets", dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void TC17(HashMap<String, String> hashMap) throws InterruptedException {
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

        System.out.println("7.Select Depart from");
        bookticketPage.selectDepartFrom(hashMap.get("DepartFrom"));
        Thread.sleep(1500);

        System.out.println("8. Select Arrive at");
        bookticketPage.selectArriveAt(hashMap.get("ArriveAt"));

        System.out.println("8.Select Seat type");
        bookticketPage.selectSeatType(hashMap.get("SeatType"));

        System.out.println("9.Select Ticket amount");
        bookticketPage.selectTicketAmount(hashMap.get("TicketAmount"));

        System.out.println("10.Click on Book ticket button");
        bookticketPage.clickBtnBookTicket();

        System.out.println("11.Back to Book ticket Page");
        bookticketPage.gotoBookticet();

        System.out.println("11.Select all infotmation again");
        bookticketPage.selectDepartDate(hashMap.get("DepartDate"));
        bookticketPage.selectDepartFrom(hashMap.get("DepartFrom"));
        Thread.sleep(1000);
        bookticketPage.selectArriveAt(hashMap.get("ArriveAt"));
        bookticketPage.selectTicketAmount(hashMap.get("TicketAmount"));
        bookticketPage.clickBtnBookTicket();

        String actualMsg = bookticketPage.getTextErrorBookTicketMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        String actualMsg2 = bookticketPage.getTextErrorTicketAmountMsg();
        String expectedMsg2 = "You have booked 10 tickets. You can book no more.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message is not displayed as expected");

    }
}

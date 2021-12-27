import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class TC15 extends TestBase {
    @Test(description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page")
    public void TC15() {
        HomePage homePage = new HomePage();
        TimeTable timeTable=new TimeTable();
        LoginPage loginPage=new LoginPage();
        TicketPrice ticketPrice = new TicketPrice();
        System.out.println("1.Go to RailWay web");
        homePage.open();
        homePage.gotoLoginPage();
        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("5.Go to TimeTable Page");
        homePage.gotoTimeTable();
        String expectedMsg = "Ticket price from " + timeTable.getDepartSationOnTT() + " to " + timeTable.getArriveSationOnTT();
        System.out.println("6.Click checkprice link Sài Gòn to Phan Thiết");
        timeTable.clickCheckPriceLink();
        String actualMsg = ticketPrice.getInforTicketPrice();
        System.out.println("verify all information of the ticket");
        String[] expectedTicketPrice = {"HS : 90000", "SS : 115000", "SSC : 140000", "HB : 190000", "SB : 240000", "SBC : 290000"};
        String[] actualTicketPrice=ticketPrice.verifyAllInforOfTicket();
        Assert.assertTrue(Arrays.equals(expectedTicketPrice,actualTicketPrice),"Information of ticket incorrect");
        Assert.assertEquals(actualMsg, expectedMsg, "The ticket information is incorrect");

    }
}

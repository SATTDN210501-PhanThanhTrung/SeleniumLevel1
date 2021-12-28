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
        MyTicket myTicket=new MyTicket();
        System.out.println("1.Go to RailWay web");
        homePage.open();
        System.out.println("2.Go to Login Page");
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
        String[] expectedTicketPrice = {"HS : 310000", "SS : 335000", "SSC : 360000", "HB : 410000", "SB : 460000", "SBC : 510000"};
        String[] actualTicketPrice=ticketPrice.verifyAllInforOfTicket();
        Assert.assertEquals(actualMsg, expectedMsg, "The ticket information is incorrect");
        Assert.assertTrue(Arrays.equals(expectedTicketPrice,actualTicketPrice),"Information of ticket incorrect");


    }
}

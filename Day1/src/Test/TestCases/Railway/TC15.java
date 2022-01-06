package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TicketPrice;
import PageObjects.TimeTable;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TC15 extends TestBase {

    HomePage homePage = new HomePage();
    TimeTable timeTable = new TimeTable();
    LoginPage loginPage = new LoginPage();
    TicketPrice ticketPrice = new TicketPrice();

    @Test(description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page",dataProvider = "dataProvider")
    public void TC15(String departFrom,String arriveAt,String seatTypeHS,String seatTypeSS,String seatTypeSSC,String seatTypeHB,String seatTypeSB,String seatTypeSBC) {

        System.out.println("1.Go to RailWay web");
        homePage.open();

        System.out.println("2.Go to Login Page");
        homePage.gotoLoginPage();

        System.out.println("3.Enters valid Email and Password");
        System.out.println("4.Click on Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("5.Go to PageObjects.TimeTable Page");
        homePage.gotoTimeTable();

        System.out.println("6.Click checkprice link ");
        timeTable.clickCheckPriceLink(departFrom, arriveAt);

        String actualMsg = ticketPrice.getTitleTicketPrice();
        String expectedMsg = "Ticket price from " + departFrom + " to " + arriveAt;

        String[] actualTicketPrice = ticketPrice.getAllInforOfTicket();
        String[] expectedTicketPrice = {seatTypeHS,seatTypeSS,seatTypeSSC,seatTypeHB,seatTypeSB,seatTypeSBC};

        Assert.assertEquals(actualMsg, expectedMsg, "The ticket information is incorrect");
        Assert.assertTrue(Arrays.equals(expectedTicketPrice, actualTicketPrice), "Information of ticket incorrect");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\src\\main\\java\\DataObject\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonObject.getAsJsonObject("TC15");
        String departStation1 = dataTC15.get("DepartFrom").getAsString();
        String arriveStation1 = dataTC15.get("ArriveAt").getAsString();
        String seatTypeHS = dataTC15.get("SeatTypeHS").getAsString();
        String seatTypeSS = dataTC15.get("SeatTypeSS").getAsString();
        String seatTypeSSC = dataTC15.get("SeatTypeSSC").getAsString();
        String seatTypeHB  = dataTC15.get("SeatTypeHB").getAsString();
        String seatTypeSB = dataTC15.get("SeatTypeSB").getAsString();
        String seatTypeSBC = dataTC15.get("SeatTypeSBC").getAsString();

        Object[][] object = new Object[][]{
                {departStation1, arriveStation1, seatTypeHS,seatTypeSS,seatTypeSSC,seatTypeHB,seatTypeSB,seatTypeSBC}
        };

        return object;
    }
}
